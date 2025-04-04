package agendamento.SistemaDeAgendamentoOnLine.Entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Servico {
	
	private Long id;
	private String nome;
	private Integer duracao;
	private BigDecimal valor;
	
	public Servico() {
	}

	public Servico(Long id, String nome, Integer duracao, BigDecimal valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
		this.valor = valor;
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

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}	

}
