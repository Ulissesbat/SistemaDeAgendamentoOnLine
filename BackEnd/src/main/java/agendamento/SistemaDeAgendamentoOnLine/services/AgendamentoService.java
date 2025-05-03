package agendamento.SistemaDeAgendamentoOnLine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agendamento;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Profissional;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Servico;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Usuario;
import agendamento.SistemaDeAgendamentoOnLine.Enums.StatusAgendamento;
import agendamento.SistemaDeAgendamentoOnLine.dto.AgendamentoDTO;
import agendamento.SistemaDeAgendamentoOnLine.dto.AgendamentoDetalhadoDTO;
import agendamento.SistemaDeAgendamentoOnLine.repositories.AgendamentoRepository;
import agendamento.SistemaDeAgendamentoOnLine.repositories.ProfissionalRepository;
import agendamento.SistemaDeAgendamentoOnLine.repositories.ServicoRepository;
import agendamento.SistemaDeAgendamentoOnLine.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProfissionalRepository profissionalRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private NotificacaoService notificacaoService;

	@Transactional
	public AgendamentoDTO insert(AgendamentoDTO dto) {
		Agendamento agendamento = new Agendamento();
		agendamento.setDatahora(dto.getDataHora());
		agendamento.setStatus(StatusAgendamento.CONFIRMADO);

		Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		agendamento.setUsuario(usuario);

		Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
				.orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
		agendamento.setProfissional(profissional);

		Servico servico = servicoRepository.findById(dto.getServicoId())
				.orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
		agendamento.setServico(servico);

		agendamento = agendamentoRepository.save(agendamento);
		
		/* notificacaoService.enviar(agendamento.getUsuario().getTelefone(), "Seu agendamento para " +
				  agendamento.getDataHora() + " foi concluido"); */
		return new AgendamentoDTO(agendamento);
	}
	
	@Transactional
	public AgendamentoDTO update(Long id, AgendamentoDTO dto) {
	    Agendamento agendamento = agendamentoRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado"));

	    agendamento.setDatahora(dto.getDataHora());

	    if (dto.getStatus() != null) {
	        agendamento.setStatus((dto.getStatus()));
	    }

	    if (!agendamento.getUsuario().getId().equals(dto.getUsuarioId())) {
	        Usuario usuario = usuarioRepository.getReferenceById(dto.getUsuarioId());
	        agendamento.setUsuario(usuario);
	    }
	    
	    if (!agendamento.getProfissional().getId().equals(dto.getProfissionalId())) {
	        Profissional profissional = profissionalRepository.getReferenceById(dto.getProfissionalId());
	        agendamento.setProfissional(profissional);
	    }
	    
	    if (!agendamento.getServico().getId().equals(dto.getServicoId())) {
	        Servico servico = servicoRepository.getReferenceById(dto.getServicoId());
	        agendamento.setServico(servico);
	    }

	    agendamento = agendamentoRepository.save(agendamento);
	    
	    return new AgendamentoDTO(agendamento);
	}
	
	
	@Transactional 
	 public void cancelarAgendamento(Long agendamentoId) { 
		Agendamento agendamento = agendamentoRepository.findById(agendamentoId) 
				.orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
	 
	 agendamento.cancelar(); 
	 agendamentoRepository.save(agendamento);
	 
	 /*
	 notificacaoService.enviar(agendamento.getUsuario().getTelefone(), "Seu agendamento para " +
	  agendamento.getDataHora() + " foi cancelado"); 
	  }*/
	
	}
	
	@Transactional(readOnly = true)
	public Page<AgendamentoDTO>findAll(Pageable pageable){
		Page<Agendamento>list = agendamentoRepository.findAll(pageable);
		return list.map(x -> new AgendamentoDTO(x));
		
	}
	
	@Transactional(readOnly = true)
	public AgendamentoDTO findById(Long id) {
		Agendamento agendamento = agendamentoRepository.findById(id).get();
		return new AgendamentoDTO(agendamento);
	}
	
	@Transactional(readOnly = true)
    public List<AgendamentoDetalhadoDTO> findAgendamentosDetalhadosByNomeUsuario(String nome) {
        List<Agendamento> agendamentos = agendamentoRepository.findAgendamentosCompletosByUsuarioNome(nome);
        
        return agendamentos.stream()
                .map(agendamento -> new AgendamentoDetalhadoDTO(agendamento))
                .toList();
    }
	
	@Transactional(readOnly = true)
    public List<AgendamentoDetalhadoDTO> findAgendamentosDetalhadosByNomeProfissional(String nome) {
        List<Agendamento> agendamentos = agendamentoRepository.findAgendamentosByProfissionalNome(nome);
        
        return agendamentos.stream()
                .map(agendamento -> new AgendamentoDetalhadoDTO(agendamento))
                .toList();
    }
	
}
