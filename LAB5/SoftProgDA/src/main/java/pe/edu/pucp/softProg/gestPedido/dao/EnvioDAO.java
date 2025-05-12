
package pe.edu.pucp.softProg.gestPedido.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.getPedido.model.Envio;

public interface EnvioDAO {
    public Integer insertar(Envio almacen);
    
    public Envio obtenerPorId(Integer almacenId);
    
    public ArrayList<Envio> listarTodos();
    
    public Integer modificar(Envio almacen);
    
    public Integer eliminar(Envio almacen);
}
