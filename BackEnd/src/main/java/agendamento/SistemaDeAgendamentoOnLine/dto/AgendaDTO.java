package agendamento.SistemaDeAgendamentoOnLine.dto;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agenda;

public class AgendaDTO {

	
	private Long id;

    private String diasDisponiveis; 

    private Long profissionalId;
    
    public AgendaDTO() {
    }
    
    public AgendaDTO(Long id, String diasDisponiveis, Long profissionalId) {
		super();
		this.id = id;
		this.diasDisponiveis = diasDisponiveis;
		this.profissionalId = profissionalId;
	}
    
    public AgendaDTO(Agenda entity) {
 		this.id = entity.getId();
 		this.diasDisponiveis = entity.getDiasDisponiveis();
 		 this.profissionalId = (entity.getProfissional() != null) 
 	            ? entity.getProfissional().getId() 
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

}
