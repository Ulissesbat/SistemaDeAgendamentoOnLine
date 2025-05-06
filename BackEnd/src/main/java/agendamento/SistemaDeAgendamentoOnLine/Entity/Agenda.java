package agendamento.SistemaDeAgendamentoOnLine.Entity;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String diasDisponiveis; 
    
    @OneToOne
    @JoinColumn(name = "profissional_usuario_id")
    @JsonBackReference
    private Profissional profissional;
    
    public Agenda() {
    }
    
    public Agenda(Long id, String diasDisponiveis, Profissional profissional) {
		super();
		this.id = id;
		this.diasDisponiveis = diasDisponiveis;
		this.profissional = profissional;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiasDisponiveis() {
		return diasDisponiveis;
	}

	public void setDiasDisponiveis(String diasDisponiveis) {
		this.diasDisponiveis = diasDisponiveis;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	// --- Método para verificar disponibilidade considerando almoço e tolerância ---
    public boolean isHorarioDisponivel(LocalDateTime dataHora, Duration tolerancia) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Map<String, String>> horarios = mapper.readValue(
                diasDisponiveis, 
                new TypeReference<Map<String, Map<String, String>>>() {}
            );

            DayOfWeek diaSemana = dataHora.getDayOfWeek();
            String diaKey = diaSemana.name().substring(0, 3).toLowerCase(); // "seg", "ter", etc.

            if (!horarios.containsKey(diaKey)) return false;

            Map<String, String> horarioDia = horarios.get(diaKey);
            LocalTime horaAtual = dataHora.toLocalTime();
            LocalTime inicio = LocalTime.parse(horarioDia.get("inicio"));
            LocalTime fim = LocalTime.parse(horarioDia.get("fim"));
            
            // 1. Verifica se está fora do horário comercial
            if (horaAtual.isBefore(inicio) || horaAtual.isAfter(fim)) {
                return false;
            }

            // 2. Verifica horário de almoço (se configurado)
            if (horarioDia.containsKey("almocoInicio")) {
                LocalTime almocoInicio = LocalTime.parse(horarioDia.get("almocoInicio"));
                LocalTime almocoFim = LocalTime.parse(horarioDia.get("almocoFim"));
                if (horaAtual.isAfter(almocoInicio) && horaAtual.isBefore(almocoFim)) {
                    return false;
                }
            }

            return true;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler agenda", e);
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(id, other.id);
	}
    
    
}