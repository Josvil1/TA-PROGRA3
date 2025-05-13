
package pe.edu.pucp.softprog.gestUsuario.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestUsuario.DAO.UsuarioDAO;
import pe.edu.pucp.softprogmodel.getUsuario.Rol;
import pe.edu.pucp.softprogmodel.getUsuario.Usuario;

public class UsuarioImpl implements UsuarioDAO {

    @Override
    public int insertar(Usuario usuario) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_email", usuario.getEmail());
        parametrosEntrada.put("p_contrasena", usuario.getContraseña());
        parametrosEntrada.put("p_rol_id", usuario.getRol().getId());
        parametrosEntrada.put("p_activo", usuario.getActivo());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarUsuario", parametrosEntrada, parametrosSalida);
        int idGenerado = (int) parametrosSalida.get("p_id");
        usuario.setId(idGenerado);

        return idGenerado;
    }

    @Override
    public int modificar(Usuario usuario) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", usuario.getId());
        parametrosEntrada.put("p_email", usuario.getEmail());
        parametrosEntrada.put("p_contrasena", usuario.getContraseña());
        parametrosEntrada.put("p_rol_id", usuario.getRol().getId());
        parametrosEntrada.put("p_activo", usuario.getActivo());

        return DBManager.getInstance().ejecutarProcedimiento("modificarUsuario", parametrosEntrada, null);
    }

    @Override
    public int eliminar(int idUsuario) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", idUsuario);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarUsuario", parametrosEntrada, null);
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        ArrayList<Usuario> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarUsuarios", null);

        try {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setActivo(rs.getInt("activo"));

                Rol rol = new Rol();
                rol.setId(rs.getInt("rol_id"));
                usuario.setRol(rol);

                lista.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar usuarios: " + ex.getMessage());
        }

        return lista;
    }

    @Override
    public Usuario obtenerPorId(int idUsuario) {
        Usuario usuario = null;
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", idUsuario);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerUsuarioPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setActivo(rs.getInt("activo"));

                Rol rol = new Rol();
                rol.setId(rs.getInt("rol_id"));
                usuario.setRol(rol);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener usuario: " + ex.getMessage());
        }

        return usuario;
    }

    @Override
    public int eliminar(int idModelo, int idUsuarioActualizacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
