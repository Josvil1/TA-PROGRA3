
package pe.edu.pucp.softProg.gestUsuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.getUsuario.model.Direccion;

public interface DireccionDAO {
    int insertar(Direccion dir);
    int modificar(Direccion dir);
    int eliminar(int idDir);
    ArrayList<Direccion>listarTodas(); 
    Direccion obtenerPorId(int id);
}
