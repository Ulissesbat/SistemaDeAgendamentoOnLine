package agendamento.SistemaDeAgendamentoOnLine.dto;

import java.util.List;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Usuario;

public class UsuarioDTO {

	    private Long id;

	    private String nome;
	    private String email;
	    private String telefone;


		@SuppressWarnings("unused")
		private List<AgendamentoDTO> agendamentos;

		public UsuarioDTO() {
		}

		public UsuarioDTO(Long id, String nome, String email, String telefone) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.telefone = telefone;
		}
		
		public UsuarioDTO(Usuario entity) {
			id = entity.getId();
			nome = entity.getNome();
			email = entity.getEmail();
			telefone = entity.getTelefone();
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public void setAgendamentos(List<AgendamentoDTO> agendamentos) {
			this.agendamentos = agendamentos;
		}

		
	}

