package agendamento.SistemaDeAgendamentoOnLine.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Profissional;

public class ProfissionalDTO {

	
	private String especialidade;
	private BigDecimal valorHora;
	private AgendaDTO agenda;
	
	private List<AgendamentoDTO> agendamentos = new ArrayList<>();

	private List<ServicoDTO> servicos = new ArrayList<>();

	public ProfissionalDTO() {
	}

	public ProfissionalDTO(String especialidade, BigDecimal valorHora, AgendaDTO agenda) {
		super();
		this.especialidade = especialidade;
		this.valorHora = valorHora;
		this.agenda = agenda;
	}

	
	public ProfissionalDTO(Profissional entity) {
		this.especialidade = entity.getEspecialidade();
		this.valorHora = entity.getValorHora();
		this.agenda = entity.getAgenda();
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

	public AgendaDTO getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaDTO agenda) {
		this.agenda = agenda;
	}

	public List<AgendamentoDTO> getAgendamentos() {
		return agendamentos;
	}

	public List<ServicoDTO> getServicos() {
		return servicos;
	}
}
