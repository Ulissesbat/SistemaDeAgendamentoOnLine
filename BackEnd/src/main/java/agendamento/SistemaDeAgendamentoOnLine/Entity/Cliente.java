package agendamento.SistemaDeAgendamentoOnLine.Entity;

import agendamento.SistemaDeAgendamentoOnLine.Enums.TipoUsuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
@DiscriminatorValue("CLIENTE")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Cliente extends Usuario {
	
	@Override
    public TipoUsuario getTipo() {
        return TipoUsuario.CLIENTE;
    }
}
