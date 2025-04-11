package agendamento.SistemaDeAgendamentoOnLine.dto;

import java.math.BigDecimal;
import java.util.List;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agendamento;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Servico;

public class ServicoDTO {
	
	private Long id;
	private String nome;
	private String duracao;
	private BigDecimal valor;

	private ProfissionalDTO profissional;

	private List<Agendamento> agendamentos;

	public ServicoDTO() {
	}

	public ServicoDTO(Long id, String nome, String duracao, BigDecimal valor, ProfissionalDTO profissional) {
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
		this.valor = valor;
		this.profissional = profissional;
	}
	
	public ServicoDTO(Servico entity) {
		id = entity.getId();
		nome = entity.getNome();
		duracao = entity.getDuracao();
		valor = entity.getValor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public ProfissionalDTO getProfissional() {
		return profissional;
	}

	public void setProfissional(ProfissionalDTO profissional) {
		this.profissional = profissional;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

}
