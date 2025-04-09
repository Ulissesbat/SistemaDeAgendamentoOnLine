package agendamento.SistemaDeAgendamentoOnLine.Entity;

import java.time.LocalTime;
import java.util.Objects;

import agendamento.SistemaDeAgendamentoOnLine.Enums.CanalNotificacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_notificacao")
public class Notificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;
	private LocalTime dataHora;
	
	private CanalNotificacao canal;
	
	@OneToOne
	@MapsId
	private Agendamento agendamentos;

	public Agendamento getAgendamento() {
		return agendamentos;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamentos = agendamento;
	}

	public Notificacao() {
	}

	public Notificacao(Long id, String mensagem, LocalTime dataHora, CanalNotificacao canal) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.dataHora = dataHora;
		this.canal = canal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalTime dataHora) {
		this.dataHora = dataHora;
	}

	public CanalNotificacao getCanal() {
		return canal;
	}

	public void setCanal(CanalNotificacao canal) {
		this.canal = canal;
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
		Notificacao other = (Notificacao) obj;
		return Objects.equals(id, other.id);
	}

}
