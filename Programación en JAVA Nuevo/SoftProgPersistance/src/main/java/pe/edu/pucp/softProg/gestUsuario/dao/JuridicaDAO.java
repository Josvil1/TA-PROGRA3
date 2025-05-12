package pe.edu.pucp.softProg.gestUsuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.getUsuario.model.Juridica;

public interface JuridicaDAO {
    int insertar(Juridica jur);
    int modificar(Juridica jur);
    int eliminar(int idJur);
    ArrayList<Juridica>listarTodas(); 
    Juridica obtenerPorId(int id);
}
