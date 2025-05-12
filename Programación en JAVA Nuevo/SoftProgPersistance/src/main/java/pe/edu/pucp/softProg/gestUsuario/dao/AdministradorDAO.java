
package pe.edu.pucp.softProg.gestUsuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.getUsuario.model.Administrador;

public interface AdministradorDAO {
    int insertar(Administrador admin);
    int modificar(Administrador admin);
    int eliminar(int idAdmi);
    ArrayList<Administrador>listarTodas();
    Administrador obtenerPorId(int id);
}
