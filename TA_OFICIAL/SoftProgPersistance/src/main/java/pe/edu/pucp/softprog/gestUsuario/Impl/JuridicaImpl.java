
package pe.edu.pucp.softprog.gestUsuario.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestUsuario.DAO.JuridicaDAO;
import pe.edu.pucp.softprogmodel.getUsuario.Juridica;

public class JuridicaImpl implements JuridicaDAO{

    @Override
    public int insertar(Juridica pj) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_email", pj.getUsuario().getEmail());
        parametrosEntrada.put("p_contrasena", pj.getUsuario().getContraseña());
        parametrosEntrada.put("p_nombres", pj.getNombres());
        parametrosEntrada.put("p_apellidos", pj.getApellidos());
        parametrosEntrada.put("p_telefono", pj.getTelefono());
        parametrosEntrada.put("p_ruc", pj.getRuc());
        parametrosEntrada.put("p_razon_social", pj.getRazonSocial());
        parametrosEntrada.put("p_representante_legal", pj.getRepresentanteLegal());
        parametrosEntrada.put("p_usuario_creacion", pj.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id_persona", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarPersonaJuridica", parametrosEntrada, parametrosSalida);

        int idPersona = (int) parametrosSalida.get("p_id_persona");
        pj.setId(idPersona);
        return idPersona;
    }

    @Override
    public int modificar(Juridica pj) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_persona", pj.getId());
        parametrosEntrada.put("p_nombres", pj.getNombres());
        parametrosEntrada.put("p_apellidos", pj.getApellidos());
        parametrosEntrada.put("p_telefono", pj.getTelefono());
        parametrosEntrada.put("p_ruc", pj.getRuc());
        parametrosEntrada.put("p_razon_social", pj.getRazonSocial());
        parametrosEntrada.put("p_representante_legal", pj.getRepresentanteLegal());
        parametrosEntrada.put("p_usuario_actualizacion", pj.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarPersonaJuridica", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int idPersona, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_persona", idPersona);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarPersonaJuridica", parametrosEntrada, null);
    }

    @Override
    public ArrayList<Juridica> listarTodos() {
        ArrayList<Juridica> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarPersonasJuridicas", null);

        try {
            while (rs.next()) {
                Juridica pj = new Juridica();
                pj.setId(rs.getInt("id"));
                pj.setNombres(rs.getString("nombres"));
                pj.setApellidos(rs.getString("apellidos"));
                pj.setTelefono(rs.getString("telefono"));
                pj.setRuc(rs.getString("ruc"));
                pj.setRazonSocial(rs.getString("razon_social"));
                pj.setRepresentanteLegal(rs.getString("representante_legal"));
                lista.add(pj);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Juridica obtenerPorId(int idPersona) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_persona", idPersona);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPersonaJuridicaPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Juridica pj = new Juridica();
                pj.setId(rs.getInt("id"));
                pj.setNombres(rs.getString("nombres"));
                pj.setApellidos(rs.getString("apellidos"));
                pj.setTelefono(rs.getString("telefono"));
                pj.setRuc(rs.getString("ruc"));
                pj.setRazonSocial(rs.getString("razon_social"));
                pj.setRepresentanteLegal(rs.getString("representante_legal"));
                return pj;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
