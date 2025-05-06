package agendamento.SistemaDeAgendamentoOnLine.Entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import agendamento.SistemaDeAgendamentoOnLine.Enums.StatusAgendamento;
import agendamento.SistemaDeAgendamentoOnLine.Enums.TipoUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_profissional")
@DiscriminatorValue("PROFISSIONAL")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Profissional extends Usuario {

	@Column(nullable = false)
	private String especialidade;

	private BigDecimal valorHora;

	@OneToOne(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private Agenda agenda;

	@OneToMany(mappedBy = "profissional")
	private List<Agendamento> agendamentos = new ArrayList<>();

	@OneToMany(mappedBy = "profissional")
	private List<Servico> servicos = new ArrayList<>();

	public Profissional() {
	}

	public Profissional(String especialidade, BigDecimal valorHora, Agenda agenda) {
		super();
		this.especialidade = especialidade;
		this.valorHora = valorHora;
		this.agenda = agenda;
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

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	@Override
	public TipoUsuario getTipo() {
		return TipoUsuario.PROFISSIONAL;
	}

	public boolean isDisponivel(LocalDateTime dataHora) {
		// 1. Verifica se está dentro do horário comercial (com tolerância padrão de 30
		// minutos)
		Duration toleranciaPadrao = Duration.ofMinutes(30);
		if (!agenda.isHorarioDisponivel(dataHora, toleranciaPadrao)) {
			return false;
		}

		// 2. Verifica conflitos com agendamentos existentes
		return agendamentos.stream() // Corrigido para "agendamentos" (nome do campo)
				.filter(ag -> ag.getStatus() != StatusAgendamento.CANCELADO).noneMatch(ag -> {
					LocalDateTime dataAgendamento = ag.getDataHora(); // Certifique-se que este método existe
					Duration diferenca = Duration.between(dataAgendamento, dataHora).abs();
					return diferenca.compareTo(toleranciaPadrao) < 0;
				});
	}

}
