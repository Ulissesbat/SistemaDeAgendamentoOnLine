package agendamento.SistemaDeAgendamentoOnLine.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	   

	@Query("SELECT a FROM Agenda a WHERE a.profissional.id = :profissionalId")
	List<Agenda> findAgendasByProfissional(@Param("profissionalId") Long profissionalId);








}
