package agendamento.SistemaDeAgendamentoOnLine.Entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import agendamento.SistemaDeAgendamentoOnLine.Enums.StatusAgendamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("PROFISSIONAL")
public class Profissional extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Transient
	@Column(name = "tipo", insertable = false, updatable = false)
	private String tipo;
	private String especialidade;
	private BigDecimal valorHora;

	@OneToOne(mappedBy = "profissional", cascade = CascadeType.ALL)
	private Agenda agenda;

	@OneToMany(mappedBy = "profissional")
	private List<Agendamento> agendamento = new ArrayList<>();

	@OneToMany(mappedBy = "profissional")
	private List<Servico> servico = new ArrayList<>();

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
		// 1. Verifica se está dentro do horário comercial (com tolerância padrão de 30
		// minutos)
		Duration toleranciaPadrao = Duration.ofMinutes(30);
		if (!agenda.isHorarioDisponivel(dataHora, toleranciaPadrao)) {
			return false;
		}

		// 2. Verifica conflitos com agendamentos existentes
		return agendamento.stream() // Corrigido para "agendamentos" (nome do campo)
				.filter(ag -> ag.getStatus() != StatusAgendamento.CANCELADO).noneMatch(ag -> {
					LocalDateTime dataAgendamento = ag.getDataHora(); // Certifique-se que este método existe
					Duration diferenca = Duration.between(dataAgendamento, dataHora).abs();
					return diferenca.compareTo(toleranciaPadrao) < 0;
				});
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
