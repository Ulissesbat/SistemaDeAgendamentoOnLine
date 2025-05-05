package agendamento.SistemaDeAgendamentoOnLine.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import agendamento.SistemaDeAgendamentoOnLine.dto.AgendaDTO;
import agendamento.SistemaDeAgendamentoOnLine.services.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	
	
	@Autowired
	private AgendaService agendaService;

	@PostMapping
	public ResponseEntity<AgendaDTO> insert(@RequestBody AgendaDTO agendaDTO) {
		agendaDTO = agendaService.insert(agendaDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agendaDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(agendaDTO);
	}

}
