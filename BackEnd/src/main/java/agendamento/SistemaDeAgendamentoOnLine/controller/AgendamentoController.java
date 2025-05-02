package agendamento.SistemaDeAgendamentoOnLine.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import agendamento.SistemaDeAgendamentoOnLine.dto.AgendamentoDTO;
import agendamento.SistemaDeAgendamentoOnLine.dto.AgendamentoDetalhadoDTO;
import agendamento.SistemaDeAgendamentoOnLine.services.AgendamentoService;

	@RestController
	@RequestMapping("/agendamentos")
	public class AgendamentoController {

		@Autowired
		private AgendamentoService agendamentoService;

		@PostMapping
	    public ResponseEntity<AgendamentoDTO> insert(@RequestBody AgendamentoDTO agendamentoDTO) {
	       agendamentoDTO = agendamentoService.insert(agendamentoDTO);
	       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(agendamentoDTO.getId()).toUri();
	       return ResponseEntity.created(uri).body(agendamentoDTO);
	    }

		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id){
			agendamentoService.cancelarAgendamento(id);
			return ResponseEntity.noContent().build();
		}
		
		@GetMapping
		public ResponseEntity <Page<AgendamentoDTO>>findAll(Pageable pageable){
			Page<AgendamentoDTO> list = agendamentoService.findAll(pageable);
			return ResponseEntity.ok().body(list);
		
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<AgendamentoDTO> findById(@PathVariable Long id){
			AgendamentoDTO dto =  agendamentoService.findById(id);
			return ResponseEntity.ok().body(dto);
		}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<AgendamentoDetalhadoDTO>> findAgendamentosByNomeUsuario(
		        @PathVariable String nome) {
		    List<AgendamentoDetalhadoDTO> result = agendamentoService.findAgendamentosDetalhadosByNome(nome);
		    return ResponseEntity.ok(result);
		}
		
	}

