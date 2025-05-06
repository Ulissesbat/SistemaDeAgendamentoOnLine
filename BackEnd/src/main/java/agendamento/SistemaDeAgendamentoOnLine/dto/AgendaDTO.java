package agendamento.SistemaDeAgendamentoOnLine.dto;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agenda;

public class AgendaDTO {

	
	private Long id;

    private String diasDisponiveis; 

    private Long profissionalId;
    
    private String nomeProfissional;
    
    public AgendaDTO() {
    }
    
    public AgendaDTO(Long id, String diasDisponiveis, Long profissionalId, String nomeProfissional) {
        super();
        this.id = id;
        this.diasDisponiveis = diasDisponiveis;
        this.profissionalId = profissionalId;
        this.nomeProfissional = nomeProfissional;
    }
    
    public AgendaDTO(Agenda entity) {
        this.id = entity.getId();
        this.diasDisponiveis = entity.getDiasDisponiveis();
        this.profissionalId = (entity.getProfissional() != null) 
            ? entity.getProfissional().getId() 
            : null;
        this.nomeProfissional = (entity.getProfissional() != null)
            ? entity.getProfissional().getNome()
            : null;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiasDisponiveis() {
		return diasDisponiveis;
	}

	public void setDiasDisponiveis(String diasDisponiveis) {
		this.diasDisponiveis = diasDisponiveis;
	}

	public Long getProfissionalId() {
		return profissionalId;
	}

	public void setProfissionalId(Long profissionalId) {
		this.profissionalId = profissionalId;
	}

	 public String getNomeProfissional() {
	        return nomeProfissional;
	    }

	    public void setNomeProfissional(String nomeProfissional) {
	        this.nomeProfissional = nomeProfissional;
	    }
}
