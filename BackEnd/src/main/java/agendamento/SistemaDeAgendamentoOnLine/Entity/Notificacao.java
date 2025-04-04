package agendamento.SistemaDeAgendamentoOnLine.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

import agendamento.SistemaDeAgendamentoOnLine.Enums.CanalNotificacao;

public class Notificacao {
	
	private Long id;
	private String mensagem;
	private LocalDateTime dataHora;
	
	private CanalNotificacao canal;

	public Notificacao() {
	}

	public Notificacao(Long id, String mensagem, LocalDateTime dataHora, CanalNotificacao canal) {
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

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
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
