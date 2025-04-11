package agendamento.SistemaDeAgendamentoOnLine.dto;

import java.time.LocalDateTime;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Notificacao;

public class NotificacaoDTO {
	
	private Long id;
	private String mensagem;
	private LocalDateTime  dataHora;

	private AgendamentoDTO agendamentos;

	public NotificacaoDTO() {
	}

	public NotificacaoDTO(Long id, String mensagem, LocalDateTime  dataHora) {
		this.id = id;
		this.mensagem = mensagem;
		this.dataHora = dataHora;
	}
	
	public NotificacaoDTO(Notificacao entity) {
		this.id = entity.getId();
		this.mensagem = entity.getMensagem();
		this.dataHora = entity.getDataHora();
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

	public LocalDateTime  getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime  dataHora) {
		this.dataHora = dataHora;
	}

	public AgendamentoDTO getAgendamento() {
		return agendamentos;
	}

	public void setAgendamento(AgendamentoDTO agendamento) {
		this.agendamentos = agendamento;
	}

}
