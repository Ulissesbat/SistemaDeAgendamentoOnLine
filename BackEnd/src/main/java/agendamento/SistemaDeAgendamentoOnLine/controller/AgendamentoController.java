package agendamento.SistemaDeAgendamentoOnLine.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import agendamento.SistemaDeAgendamentoOnLine.dto.AgendamentoDTO;
	import agendamento.SistemaDeAgendamentoOnLine.services.AgendamentoService;

	@RestController
	@RequestMapping("/agendamentos")
	public class AgendamentoController {

		@Autowired
		private AgendamentoService agendamentoService;

		@PostMapping
	    public ResponseEntity<?> insert(@RequestBody AgendamentoDTO agendamentoDTO) {
	        try {
	            AgendamentoDTO novoAgendamento = agendamentoService.insert(agendamentoDTO);
	            return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
	        } catch (RuntimeException e) {
	         
	            return ResponseEntity.badRequest().body(e.getMessage()); 
	        }
	    }

	}

