package agendamento.SistemaDeAgendamentoOnLine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
