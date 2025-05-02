package agendamento.SistemaDeAgendamentoOnLine.dto;

import java.time.LocalDateTime;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agendamento;

public class AgendamentoDetalhadoDTO {

	private Long id;
	private LocalDateTime dataHora;
	private String status;
	private String nomeUsuario;
	private String nomeProfissional;
	private String nomeServico;

	public AgendamentoDetalhadoDTO() {

	}

	public AgendamentoDetalhadoDTO(Long id, LocalDateTime dataHora, String status, String nomeUsuario,
			String nomeProfissional, String nomeServico) {

		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
		this.nomeUsuario = nomeUsuario;
		this.nomeProfissional = nomeProfissional;
		this.nomeServico = nomeServico;
	}

	public AgendamentoDetalhadoDTO(Agendamento agendamento) {
		this.id = agendamento.getId();
		this.dataHora = agendamento.getDataHora();
		this.status = agendamento.getStatus().toString();
		this.nomeUsuario = agendamento.getUsuario().getNome();
		this.nomeProfissional = agendamento.getProfissional().getNome();
		this.nomeServico = agendamento.getServico().getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeProfissional() {
		return nomeProfissional;
	}

	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

}
