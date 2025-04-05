package agendamento.SistemaDeAgendamentoOnLine.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import agendamento.SistemaDeAgendamentoOnLine.Enums.StatusAgendamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("PROFISSIONAL") // Valor que identifica registros de profissionais na tabela
public class Profissional extends Usuario{

	private Long id;
	private String especialidade;
	private BigDecimal valorHora;
	
	@OneToOne(mappedBy = "profissional", cascade = CascadeType.ALL)
	private Agenda agenda;
	
	@OneToMany(mappedBy = "profissional")
	private List <Agendamento> agendamento = new ArrayList<>();
	
	@OneToMany(mappedBy = "profissional")
	private List <Servico> servico = new ArrayList<>();
	
	public Profissional() {
	}

	public Profissional(Long id, String especialidade, BigDecimal valorHora, Agenda agenda) {
		super();
		this.id = id;
		this.especialidade = especialidade;
		this.valorHora = valorHora;
		this.agenda = agenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public List<Agendamento> getAgendamento() {
		return agendamento;
	}
	
	 public List<Servico> getServico() {
		return servico;
	}

	public boolean isDisponivel(LocalDateTime dataHora) {
	        // 1. Verifica se a data/hora está dentro da agenda do profissional
	        if (!agenda.isHorarioDisponivel(dataHora)) {
	            return false;
	        }

	        // 2. Verifica se já existe agendamento no mesmo horário
	        return agendamento.stream()
	            .noneMatch(ag -> ag.getDataHora().equals(dataHora) 
	                && ag.getStatus() != StatusAgendamento.CANCELADO);
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
		Profissional other = (Profissional) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
