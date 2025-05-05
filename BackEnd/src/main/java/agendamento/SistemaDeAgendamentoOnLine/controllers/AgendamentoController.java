package agendamento.SistemaDeAgendamentoOnLine.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import agendamento.SistemaDeAgendamentoOnLine.dto.AgendamentoDTO;
import agendamento.SistemaDeAgendamentoOnLine.dto.AgendamentoDetalhadoDTO;
import agendamento.SistemaDeAgendamentoOnLine.services.AgendamentoService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

	@Autowired
	private AgendamentoService agendamentoService;

	@PostMapping
	public ResponseEntity<AgendamentoDTO> insert(@RequestBody AgendamentoDTO agendamentoDTO) {
		agendamentoDTO = agendamentoService.insert(agendamentoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agendamentoDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(agendamentoDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AgendamentoDTO> update(@PathVariable Long id, @RequestBody AgendamentoDTO dto) {
		try {
			AgendamentoDTO updated = agendamentoService.update(id, dto);
			return ResponseEntity.ok(updated);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		agendamentoService.cancelarAgendamento(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<Page<AgendamentoDTO>> findAll(Pageable pageable) {
		Page<AgendamentoDTO> list = agendamentoService.findAll(pageable);
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AgendamentoDTO> findById(@PathVariable Long id) {
		AgendamentoDTO dto = agendamentoService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<AgendamentoDetalhadoDTO>> findAgendamentosByNomeUsuario(@PathVariable String nome) {
		List<AgendamentoDetalhadoDTO> result = agendamentoService.findAgendamentosDetalhadosByNomeUsuario(nome);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/profissional/{nome}")
	public ResponseEntity<List<AgendamentoDetalhadoDTO>> findAgendamentosByNomeProfissional(@PathVariable String nome) {
		List<AgendamentoDetalhadoDTO> result = agendamentoService.findAgendamentosDetalhadosByNomeProfissional(nome);
		return ResponseEntity.ok(result);
	}

}
