package agendamento.SistemaDeAgendamentoOnLine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
