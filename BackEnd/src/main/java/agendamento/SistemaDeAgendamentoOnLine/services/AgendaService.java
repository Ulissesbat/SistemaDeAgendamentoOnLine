package agendamento.SistemaDeAgendamentoOnLine.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agenda;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Profissional;
import agendamento.SistemaDeAgendamentoOnLine.dto.AgendaDTO;
import agendamento.SistemaDeAgendamentoOnLine.repositories.AgendaRepository;
import agendamento.SistemaDeAgendamentoOnLine.repositories.ProfissionalRepository;


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
	
	public List<AgendaDTO> getAgendasByProfissional(Long profissionalId) {
	    List<Agenda> agendas = agendaRepository.findAgendasByProfissional(profissionalId);
	    return agendas.stream()
	                  .map(AgendaDTO::new)  // Mapeando cada Agenda para AgendaDTO
	                  .collect(Collectors.toList());
	}
}
