
package pe.edu.pucp.softProg.gestUsuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.getUsuario.model.Natural;

public interface NaturalDAO {
   int insertar(Natural natural);
    int modificar(Natural natural);
    int eliminar(int idNat);
    ArrayList<Natural>listarTodas();
    Natural obtenerPorId(int id);
}
