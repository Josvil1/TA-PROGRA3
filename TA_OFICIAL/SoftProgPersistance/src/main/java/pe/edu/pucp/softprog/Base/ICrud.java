
package pe.edu.pucp.softprog.Base;

import java.util.ArrayList;

public interface ICrud<T> {
    int insertar(T modelo);
    int modificar(T modelo);
    int eliminar(int idModelo,int idUsuarioActualizacion);
    ArrayList<T> listarTodos();
    T obtenerPorId(int id);
}
