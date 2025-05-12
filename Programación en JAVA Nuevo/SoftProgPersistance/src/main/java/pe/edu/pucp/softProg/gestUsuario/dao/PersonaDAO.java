
package pe.edu.pucp.softProg.gestUsuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.getUsuario.model.Persona;

public interface PersonaDAO {
    int insertar(Persona per);
    int modificar(Persona per);
    int eliminar(int idPer);
    ArrayList<Persona>listarTodas(); 
}
