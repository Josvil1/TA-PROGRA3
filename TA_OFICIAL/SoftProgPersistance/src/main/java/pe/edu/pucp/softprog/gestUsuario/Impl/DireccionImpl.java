
package pe.edu.pucp.softprog.gestUsuario.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestUsuario.DAO.DireccionDAO;
import pe.edu.pucp.softprogmodel.getUsuario.Direccion;

public class DireccionImpl implements DireccionDAO{

    @Override
    public int insertar(Direccion dir) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_persona_id", dir.getPersonaId().getId());
        parametrosEntrada.put("p_alias", dir.getAlias());
        parametrosEntrada.put("p_direccion", dir.getDireccion());
        parametrosEntrada.put("p_ciudad", dir.getCiudad());
        parametrosEntrada.put("p_referencia", dir.getReferencia());
        parametrosEntrada.put("p_usuario_creacion", dir.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarDireccion", parametrosEntrada, parametrosSalida);
        int idDireccion = (int) parametrosSalida.get("p_id");
        dir.setId(idDireccion);
        return idDireccion;
    }

    @Override
    public int modificar(Direccion dir) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", dir.getId());
        parametrosEntrada.put("p_alias", dir.getAlias());
        parametrosEntrada.put("p_direccion", dir.getDireccion());
        parametrosEntrada.put("p_ciudad", dir.getCiudad());
        parametrosEntrada.put("p_referencia", dir.getReferencia());
        parametrosEntrada.put("p_usuario_actualizacion", dir.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarDireccion", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarDireccion", parametrosEntrada, null);

    }

    @Override
    public ArrayList<Direccion> listarTodos() {
        ArrayList<Direccion> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarDirecciones", null);

        try {
            while (rs.next()) {
                Direccion dir = new Direccion();
                dir.setId(rs.getInt("id"));
                // Se asume que la persona ya fue seteada antes, se puede incluir más adelante
                dir.setAlias(rs.getString("alias"));
                dir.setDireccion(rs.getString("direccion"));
                dir.setCiudad(rs.getString("ciudad"));
                dir.setReferencia(rs.getString("referencia"));
                lista.add(dir);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Direccion obtenerPorId(int id) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerDireccionPorId", parametrosEntrada);
        try {
            if (rs.next()) {
                Direccion dir = new Direccion();
                dir.setId(rs.getInt("id"));
                dir.setAlias(rs.getString("alias"));
                dir.setDireccion(rs.getString("direccion"));
                dir.setCiudad(rs.getString("ciudad"));
                dir.setReferencia(rs.getString("referencia"));
                return dir;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
