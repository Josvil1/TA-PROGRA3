
package pe.edu.pucp.softprog.gestUsuario.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestUsuario.DAO.NaturalDAO;
import pe.edu.pucp.softprogmodel.getUsuario.Natural;

public class NaturalImpl implements NaturalDAO{

    @Override
    public int insertar(Natural pn) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_email", pn.getUsuario().getEmail());
        parametrosEntrada.put("p_contrasena", pn.getUsuario().getContraseña());
        parametrosEntrada.put("p_nombres", pn.getNombres());
        parametrosEntrada.put("p_apellidos", pn.getApellidos());
        parametrosEntrada.put("p_telefono", pn.getTelefono());
        parametrosEntrada.put("p_dni", pn.getDni());
        parametrosEntrada.put("p_fecha_nacimiento", pn.getFechaNacimiento());
        parametrosEntrada.put("p_genero", pn.getGenero());
        parametrosEntrada.put("p_usuario_creacion", pn.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id_persona", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarPersonaNatural", parametrosEntrada, parametrosSalida);

        int idPersona = (int) parametrosSalida.get("p_id_persona");
        pn.setId(idPersona);
        return idPersona;
    }

    @Override
    public int modificar(Natural pn) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_persona", pn.getId());
        parametrosEntrada.put("p_nombres", pn.getNombres());
        parametrosEntrada.put("p_apellidos", pn.getApellidos());
        parametrosEntrada.put("p_telefono", pn.getTelefono());
        parametrosEntrada.put("p_dni", pn.getDni());
        parametrosEntrada.put("p_fecha_nacimiento", new java.sql.Date(pn.getFechaNacimiento().getTime()));
        parametrosEntrada.put("p_genero", pn.getGenero());
        parametrosEntrada.put("p_usuario_actualizacion", pn.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarPersonaNatural", parametrosEntrada, null);
    }

    @Override
    public int eliminar(int idPersona,int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_persona", idPersona);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarPersonaNatural", parametrosEntrada, null);

    }

    @Override
    public ArrayList<Natural> listarTodos() {
        ArrayList<Natural> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarPersonasNaturales", null);

        try {
            while (rs.next()) {
                Natural pn = new Natural();
                pn.setId(rs.getInt("id"));
                pn.setNombres(rs.getString("nombres"));
                pn.setApellidos(rs.getString("apellidos"));
                pn.setTelefono(rs.getString("telefono"));
                pn.setDni(rs.getInt("dni"));
                pn.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                pn.setGenero(rs.getString("genero"));
                lista.add(pn);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Natural obtenerPorId(int idPersona) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_persona", idPersona);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPersonaNaturalPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Natural pn = new Natural();
                pn.setId(rs.getInt("id"));
                pn.setNombres(rs.getString("nombres"));
                pn.setApellidos(rs.getString("apellidos"));
                pn.setTelefono(rs.getString("telefono"));
                pn.setDni(rs.getInt("dni"));
                pn.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                pn.setGenero(rs.getString("genero"));
                return pn;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
