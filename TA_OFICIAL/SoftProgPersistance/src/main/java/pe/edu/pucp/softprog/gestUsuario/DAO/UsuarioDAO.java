
package pe.edu.pucp.softprog.gestUsuario.DAO;

import pe.edu.pucp.softprog.Base.ICrud;
import pe.edu.pucp.softprogmodel.getUsuario.Usuario;

public interface UsuarioDAO extends ICrud<Usuario> {
    int eliminar(int idUsuario);
}
