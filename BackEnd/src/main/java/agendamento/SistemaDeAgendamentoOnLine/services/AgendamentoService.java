package agendamento.SistemaDeAgendamentoOnLine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agendamento;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Profissional;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Servico;
import agendamento.SistemaDeAgendamentoOnLine.Entity.Usuario;
import agendamento.SistemaDeAgendamentoOnLine.Enums.StatusAgendamento;
import agendamento.SistemaDeAgendamentoOnLine.dto.AgendamentoDTO;
import agendamento.SistemaDeAgendamentoOnLine.repositories.AgendamentoRepository;
import agendamento.SistemaDeAgendamentoOnLine.repositories.ProfissionalRepository;
import agendamento.SistemaDeAgendamentoOnLine.repositories.ServicoRepository;
import agendamento.SistemaDeAgendamentoOnLine.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;

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
}
