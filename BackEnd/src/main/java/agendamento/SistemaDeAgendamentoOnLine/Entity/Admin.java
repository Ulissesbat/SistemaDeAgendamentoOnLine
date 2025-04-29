package agendamento.SistemaDeAgendamentoOnLine.Entity;

import agendamento.SistemaDeAgendamentoOnLine.Enums.TipoUsuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
@DiscriminatorValue("ADMIN")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Admin extends Usuario{
	
	@Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMIN;
    }

}
