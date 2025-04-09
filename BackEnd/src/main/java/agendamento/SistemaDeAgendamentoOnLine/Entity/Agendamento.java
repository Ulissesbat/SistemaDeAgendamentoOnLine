package agendamento.SistemaDeAgendamentoOnLine.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import agendamento.SistemaDeAgendamentoOnLine.Enums.StatusAgendamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_agendamentos")
@EntityListeners(AuditingEntityListener.class)
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataHora;
	
	@Enumerated(EnumType.STRING)
	private StatusAgendamento status;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;

	@OneToOne(mappedBy = "agendamentos", cascade = CascadeType.ALL)
	private Notificacao notificacao;

	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;

	public Agendamento() {
	}

	public Agendamento(Long id, LocalDateTime datahora, StatusAgendamento status) {
		super();
		this.id = id;
		this.dataHora = datahora;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() { // 'H' maiúsculo!
		return dataHora;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.dataHora = datahora;
	}

	public StatusAgendamento getStatus() {
		return status;
	}

	public void setStatus(StatusAgendamento status) {
		this.status = status;
	}

	public Usuario getCliente() {
		return usuario;
	}

	public void setCliente(Usuario cliente) {
		this.usuario = cliente;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Notificacao getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void cancelar() {
		if (this.status != StatusAgendamento.CONFIRMADO) {
			throw new IllegalStateException("Agendamento não pode ser cancelado (status atual: " + this.status + ")");
		}
		this.status = StatusAgendamento.CANCELADO;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		return Objects.equals(id, other.id);
	}

}
