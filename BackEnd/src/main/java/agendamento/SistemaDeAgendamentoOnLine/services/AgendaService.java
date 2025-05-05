package agendamento.SistemaDeAgendamentoOnLine.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agenda;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Profissional;
import agendamento.SistemaDeAgendamentoOnLine.dto.AgendaDTO;
import agendamento.SistemaDeAgendamentoOnLine.repositories.AgendaRepository;
import agendamento.SistemaDeAgendamentoOnLine.repositories.ProfissionalRepository;
import jakarta.transaction.Transactional;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	
	@Transactional
	public AgendaDTO insert(AgendaDTO dto) {
	    Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
	        .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
	    
	    Optional.ofNullable(profissional.getAgenda())
	        .ifPresent(agenda -> {
	            profissional.setAgenda(null);
	            profissionalRepository.saveAndFlush(profissional);
	            agendaRepository.delete(agenda);
	            agendaRepository.flush();
	        });
	    
	    Agenda novaAgenda = new Agenda();
	    novaAgenda.setDiasDisponiveis(dto.getDiasDisponiveis());
	    novaAgenda.setProfissional(profissional);
	    
	    novaAgenda = agendaRepository.save(novaAgenda);
	    profissional.setAgenda(novaAgenda);
	    
	    return new AgendaDTO(novaAgenda);
	}

}
