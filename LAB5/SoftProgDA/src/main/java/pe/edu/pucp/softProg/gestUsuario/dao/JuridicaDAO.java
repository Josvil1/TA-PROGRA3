package pe.edu.pucp.softProg.gestUsuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.getUsuario.model.Juridica;

public interface JuridicaDAO {
    public Integer insertar(Juridica juridica);
    
    public Juridica obtenerPorId(Integer juridicaId);
    
    public ArrayList<Juridica> listarTodos();
    
    public Integer modificar(Juridica juridica);
    
    public Integer eliminar(Juridica juridica);
}
