
package pe.edu.pucp.softprog.gestUsuario.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestUsuario.DAO.RolDAO;
import pe.edu.pucp.softprogmodel.getUsuario.Rol;

public class RolImpl implements RolDAO {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Rol rol) {
        Map<String,Object>parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_nombre",rol.getNombre());        
        Map<String,Object>parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id", Types.INTEGER);
        DBManager.getInstance().ejecutarProcedimiento("insertarRol", parametrosEntrada, parametrosSalida);
        rol.setId((int)parametrosSalida.get("p_id"));
        System.out.println("Se ha realizado el registro del rol");
        return rol.getId();
    }

    @Override
    public int modificar(Rol rol) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", rol.getId());
        parametrosEntrada.put("p_nuevo_nombre", rol.getNombre());
        
        DBManager.getInstance().ejecutarProcedimiento("modificarRol", parametrosEntrada, null);
        System.out.println("Se ha realizado la modificacion del ID: "+rol.getId());
        return rol.getId();
    }

    @Override
    public int eliminar(int idModelo,int usuarioActualizacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Rol> listarTodos() {
        ArrayList<Rol> lista = new ArrayList<>();
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarRoles", null);
        System.out.println("Lectura de Roles...");
        try {
           while (rs.next()) {
                Rol rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setNombre(rs.getString("nombre"));
                
                lista.add(rol);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (con != null && !con.isClosed()) con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return lista; 
            
        
    }

    @Override
    public Rol obtenerPorId(int id) {
        Rol rol = null;
        try {
            Map<String,Object> parametrosEntrada = new HashMap<>();
            parametrosEntrada.put("p_id",id);
            rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerRolPorId", parametrosEntrada);
            if (rs.next()) {
                rol = new Rol();
                rol.setId(rs.getInt("id")); //nombre de la tabla
                rol.setNombre(rs.getString("nombre"));
                //cuando es un char
//                rol.setTorre(rs.getString("torre").charAt(0));
//                rol.setPiso(rs.getInt("piso"));
//                rol.setNombre(rs.getString("nombre"));
//                //cuando es un enum:
//                rol.setTipoSala(TipoSala.valueOf(rs.getString("tipo_sala")));
//                rol.setPosee_equipamiento(rs.getInt("posee_equipamiento_imagenologia"));
                
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            //try { if (cs != null) cs.close(); } catch (SQLException e) {}
            //try { if (con != null && !con.isClosed()) con.close(); } catch (SQLException e) {}
        }
        return rol;
    }
    
}
