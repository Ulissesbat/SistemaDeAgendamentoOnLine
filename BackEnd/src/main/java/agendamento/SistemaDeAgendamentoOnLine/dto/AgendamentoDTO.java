package agendamento.SistemaDeAgendamentoOnLine.dto;

import java.time.LocalDateTime;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agendamento;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Notificacao;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Profissional;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Servico;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Usuario;

public class AgendamentoDTO {
	
	private Long id;
	private LocalDateTime dataHora;

	private Usuario usuario;

	private Profissional profissional;

	private Notificacao notificacao;
	
	private Servico servico;


	public AgendamentoDTO() {
	}


	public AgendamentoDTO(Long id, LocalDateTime dataHora, Usuario usuario, Profissional profissional,
			Notificacao notificacao, Servico servico) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.usuario = usuario;
		this.profissional = profissional;
		this.notificacao = notificacao;
		this.servico = servico;
	}

	public AgendamentoDTO(Agendamento entity) {
		this.id = entity.getId();
		this.dataHora = entity.getDataHora();
		this.usuario = entity.getCliente();
		this.profissional = entity.getProfissional();
		this.notificacao = entity.getNotificacao();
		this.servico = entity.getServico();
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


}
