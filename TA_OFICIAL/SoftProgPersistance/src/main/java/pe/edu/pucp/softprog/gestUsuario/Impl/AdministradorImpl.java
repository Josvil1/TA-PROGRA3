
package pe.edu.pucp.softprog.gestUsuario.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestUsuario.DAO.AdministradorDAO;
import pe.edu.pucp.softprogmodel.getUsuario.Administrador;

public class AdministradorImpl implements AdministradorDAO{

    @Override
    public int insertar(Administrador admin) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_usuario_id", admin.getUsuario().getId());
        parametrosEntrada.put("p_nombre_usuario", admin.getNombre_usuario());
        parametrosEntrada.put("p_ultimo_ingreso", Timestamp.valueOf(admin.getUltimoIngreso()));
        parametrosEntrada.put("p_cargo", admin.getCargo());
        parametrosEntrada.put("p_usuario_creacion", admin.getUsuario_creacion());
        parametrosEntrada.put("p_activo", admin.getActivo());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarAdministrador", parametrosEntrada, parametrosSalida);
        int id = (int) parametrosSalida.get("p_id");
        admin.setId(id);
        return id;
    }

    @Override
    public int modificar(Administrador admin) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", admin.getId());
        parametrosEntrada.put("p_nombre_usuario", admin.getNombre_usuario());
        parametrosEntrada.put("p_ultimo_ingreso", admin.getUltimoIngreso());
        parametrosEntrada.put("p_cargo", admin.getCargo());
        parametrosEntrada.put("p_usuario_actualizacion", admin.getUsuario_actualizacion());
        parametrosEntrada.put("p_activo", admin.getActivo());

        return DBManager.getInstance().ejecutarProcedimiento("modificarAdministrador", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarAdministrador", parametrosEntrada, null);

    }

    @Override
    public ArrayList<Administrador> listarTodos() {
        ArrayList<Administrador> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarAdministradores", null);

        try {
            while (rs.next()) {
                Administrador admin = new Administrador();
                admin.setId(rs.getInt("id"));
                admin.setNombre_usuario(rs.getString("nombre_usuario"));
                admin.setCargo(rs.getString("cargo"));
                admin.setUltimoIngreso(rs.getTimestamp("ultimo_ingreso").toLocalDateTime());
                lista.add(admin);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar administradores: " + ex.getMessage());
        }

        return lista;
    }

    @Override
    public Administrador obtenerPorId(int id) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerAdministradorPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Administrador admin = new Administrador();
                admin.setId(rs.getInt("id"));
                admin.setNombre_usuario(rs.getString("nombre_usuario"));
                admin.setCargo(rs.getString("cargo"));
                admin.setUltimoIngreso(rs.getTimestamp("ultimo_ingreso").toLocalDateTime());
                return admin;
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener administrador por ID: " + ex.getMessage());
        }

        return null;
    }
    
}
