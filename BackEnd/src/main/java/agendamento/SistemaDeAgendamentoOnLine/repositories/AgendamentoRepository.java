package agendamento.SistemaDeAgendamentoOnLine.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

        @Query("SELECT a FROM Agendamento a " +
               "JOIN FETCH a.usuario u " +
               "JOIN FETCH a.profissional p " +
               "JOIN FETCH a.servico s " +
               "WHERE LOWER(u.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
        List<Agendamento> findAgendamentosCompletosByUsuarioNome(@Param("nome") String nome);
   
}
	
