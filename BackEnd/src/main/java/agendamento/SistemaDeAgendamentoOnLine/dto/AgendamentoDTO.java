package agendamento.SistemaDeAgendamentoOnLine.dto;

import java.time.LocalDateTime;

import agendamento.SistemaDeAgendamentoOnLine.Entity.Agendamento;
import agendamento.SistemaDeAgendamentoOnLine.Enums.StatusAgendamento;

public class AgendamentoDTO {

    private Long id;
    private LocalDateTime dataHora;
    private StatusAgendamento status;
    private Long usuarioId;
    private Long profissionalId;
    private Long servicoId;

    public AgendamentoDTO() {}

    public AgendamentoDTO(Long id, LocalDateTime dataHora, StatusAgendamento status, Long usuarioId,
                          Long profissionalId, Long servicoId) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.usuarioId = usuarioId;
        this.profissionalId = profissionalId;
        this.servicoId = servicoId;
    }

    public AgendamentoDTO(Agendamento entity) {
        this.id = entity.getId();
        this.dataHora = entity.getDataHora();
        this.status = entity.getStatus();
        this.usuarioId = (entity.getUsuario() != null) ? entity.getUsuario().getId() : null;
        this.profissionalId = (entity.getProfissional() != null) ? entity.getProfissional().getId() : null;
        this.servicoId = (entity.getServico() != null) ? entity.getServico().getId() : null;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }
}
