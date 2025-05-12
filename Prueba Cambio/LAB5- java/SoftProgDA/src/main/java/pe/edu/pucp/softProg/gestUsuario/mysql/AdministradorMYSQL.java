
package pe.edu.pucp.softProg.gestUsuario.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import pe.edu.pucp.softProg.db.DBManager;
import pe.edu.pucp.softProg.gestUsuario.dao.AdministradorDAO;
import pe.edu.pucp.softprog.getUsuario.model.Administrador;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class AdministradorMYSQL implements AdministradorDAO {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Administrador admin) {
        //PARA ESTO NECESITO LOS PARAMETROS DEL BDMANAGER
        
        Map<String,Object>parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_nombres",admin.getNombres());
        parametrosEntrada.put("p_apellidos",admin.getApellidos());
        parametrosEntrada.put("p_email",admin.getEmail());
        parametrosEntrada.put("p_telefono",admin.getTelefono());
        parametrosEntrada.put("p_contrasena",admin.getContrasena());
        parametrosEntrada.put("p_activo",admin.getActivo());
        parametrosEntrada.put("p_nombre_usuario", admin.getNombreUsuario());
        parametrosEntrada.put("p_ultimo_ingreso", java.sql.Timestamp.valueOf(admin.getUltimoIngreso()));
        parametrosEntrada.put("p_cargo",admin.getCargo());
        
        Map<String,Object>parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id_admi", Types.INTEGER);
        DBManager.getInstance().ejecutarProcedimiento("INSERTA_ADMI", parametrosEntrada, parametrosSalida);
        admin.setId((int)parametrosSalida.get("p_id_admi"));
        System.out.println("Se ha realizado el registro de administrador");
        return admin.getId();
        
        
        
        
        
        
        
        //sin parametros:
        
//        int resultado = 0;
//        try {
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call INSERTA_ADMI(?,?,?,?,?,?,?,?,?,?)}");
//            //parametro de salida el out del BD
//            cs.registerOutParameter("p_id_admi", Types.INTEGER);
//            cs.setString("p_nombres",admin.getNombres());
//            cs.setString("p_apellidos",admin.getApellidos());
//            cs.setString("p_email",admin.getEmail());
//            cs.setString("p_telefono",admin.getTelefono());
//            cs.setString("p_contrasena",admin.getContrasena());
//            cs.setInt("p_activo",1);
//            cs.setString("p_nombre_usuario", admin.getNombreUsuario());
//            //esto es para cuando estas en DATETIME 
//            cs.setTimestamp("p_ultimo_ingreso", java.sql.Timestamp.valueOf(admin.getUltimoIngreso()));
//            cs.setString("p_cargo",admin.getCargo() );
//            cs.executeUpdate();
//            
//            admin.setId(cs.getInt("p_id_admi"));
//            resultado = admin.getId();
//            ///
//            ///////            // 1. Insertar en persona (A LA ANTIGUA))
//////            String sqlPersona = "INSERT INTO persona(nombres, apellidos, email, telefono, contrasena, activo) VALUES (?, ?, ?, ?, ?, ?)";
//////
//////            pst = con.prepareStatement(sqlPersona);
//////            pst.setString(1, admin.getNombres());
//////            pst.setString(2, admin.getApellidos());
//////            pst.setString(3, admin.getEmail());
//////            pst.setString(4, admin.getTelefono());
//////            pst.setString(5, admin.getContrasena());
//////            pst.setInt(6, admin.getActivo());
//////            //si queremos colocar una fecha tipo DATE:
//////            //pst.setDate(6, new java.sql.Date( empleado.getFechaNacimiento().getTime()));
//////            pst.executeUpdate();
//////            
//////            sqlPersona = "SELECT @@last_insert_id AS id";
//////            pst = con.prepareStatement(sqlPersona);
//////            rs = pst.executeQuery();
//////            rs.next();
//////            admin.setId(rs.getInt("id"));
//////            
//////            sqlPersona = "INSERT INTO p_administrador(id, nombre_usuario, ultimo_ingreso, cargo) VALUES (?, ?, ?, ?)";
//////            pst = con.prepareStatement(sqlPersona);
//////            pst.setInt(1, admin.getId());
//////            pst.setString(2, admin.getNombreUsuario());
//////            pst.setTimestamp(3, java.sql.Timestamp.valueOf(admin.getUltimoIngreso()));
//////            pst.setString(4, admin.getCargo());
//////            pst.executeUpdate();
//////            resultado = admin.getId();
//            
//            System.out.println("Administrador insertado correctamente.");
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//            try {
//                if (con != null && !con.isClosed()) con.close();
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//        return resultado;
    }

    @Override
    public int modificar(Administrador admin) {
             
        
        //AHORRA CON PARAMETROS:
        Map<String,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_admi", admin.getId());
        parametrosEntrada.put("p_nombres", admin.getNombres());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("MODIFICAR_ADMI",parametrosEntrada , null);
        if (resultado > 0) {
            System.out.println("Nombre del administrador con ID " + admin.getId() + " actualizado.");
        } else {
            System.out.println("No se encontró administrador con ese ID.");
        }
        return resultado;
        
//        //ESTO ES PARA SIN PARAMETROS :)
//        int resultado = 0;
//        try {
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call MODIFICAR_ADMI(?,?)}");
//            cs.setInt("p_id_admi", admin.getId());
//            cs.setString("p_nombres", admin.getNombres());
//            cs.executeUpdate();
//            resultado = admin.getId();
////            String sql = "UPDATE persona SET nombres = ? WHERE id = ?";
////            pst = con.prepareStatement(sql);
////            pst.setString(1, admin.getNombres());
////            pst.setInt(2, admin.getId());
//            //resultado = pst.executeUpdate();
//
//            if (resultado > 0) {
//                System.out.println("Nombre del administrador con ID " + admin.getId() + " actualizado.");
//            } else {
//                System.out.println("No se encontró administrador con ese ID.");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } finally {
//            try {
//                if (con != null && !con.isClosed()) con.close();
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//        return resultado;

    }

    @Override
    public int eliminar(int idAdmi) {
        Map<String,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_admi", idAdmi);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("ELIMINAR_ADMI", parametrosEntrada, null);
        if (resultado > 0) {
            System.out.println("Administrador con ID " + idAdmi + " desactivado correctamente.");
        } else {
            System.out.println("No se encontró el administrador con ese ID.");
        }
        
        return resultado;
        
        //ESTO ES A LA ANTIGUA SIN PARAMETROS:
////        int resultado = 0;
////        try {
////            con = DBManager.getInstance().getConnection();
////            cs = con.prepareCall("{call ELIMINAR_ADMI(?)}");
////            
////            cs.setInt("p_id_admi", idAdmi);
////            resultado = cs.executeUpdate();
////             
//////            String sql = "UPDATE persona SET activo = 0 WHERE id = ?";
//////            pst = con.prepareStatement(sql);
//////            pst.setInt(1, idAdmi);
//////
//////            resultado = pst.executeUpdate();
////            if (resultado > 0) {
////                System.out.println("Administrador con ID " + idAdmi + " desactivado correctamente.");
////            } else {
////                System.out.println("No se encontró el administrador con ese ID.");
////            }
////
////        } catch (SQLException ex) {
////            System.out.println(ex.getMessage());
////        } finally {
////            try {
////                if (con != null && !con.isClosed()) con.close();
////            } catch (SQLException ex) {
////                System.out.println(ex.getMessage());
////            }
////        }
////        return resultado;
    }
//
    @Override
    public ArrayList<Administrador> listarTodos() {
        ArrayList<Administrador> lista = new ArrayList<>();
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_ADMI_TODOS", null);
        System.out.println("Lectura de empleados...");
        try {
            
            
            
            //ESTO ES PARA SIN PARAMETROS:
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call LISTAR_ADMI_TODOS()}");
//            rs = cs.executeQuery();
//            
////            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, " +
////                         "a.nombre_usuario, a.ultimo_ingreso, a.cargo " +
////                         "FROM persona p INNER JOIN p_administrador a ON p.id = a.id " +
////                         "WHERE p.activo = 1";  // Opcional: solo los activos
//
//            //pst = con.prepareStatement(sql);
////            rs = pst.executeQuery();

            while (rs.next()) {
                Administrador admin = new Administrador();
                admin.setId(rs.getInt("id"));
                admin.setNombres(rs.getString("nombres"));
                admin.setApellidos(rs.getString("apellidos"));
                admin.setEmail(rs.getString("email"));
                admin.setTelefono(rs.getString("telefono"));
                admin.setContrasena(rs.getString("contrasena"));
                admin.setActivo(rs.getInt("activo"));
                admin.setNombreUsuario(rs.getString("nombre_usuario"));
                admin.setUltimoIngreso(rs.getTimestamp("ultimo_ingreso").toLocalDateTime());
                admin.setCargo(rs.getString("cargo"));
                lista.add(admin);
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
    public Administrador obtenerPorId(int id) {
        Administrador admin = null;
        try {
            Map<String,Object> parametrosEntrada = new HashMap<>();
            parametrosEntrada.put("p_id_admi",id);
            rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_ADMI_POR_ID", parametrosEntrada);
            
            
            //ESTO ES SIN PARAMTEROS
//            con = DBManager.getInstance().getConnection();
//            cs = con.prepareCall("{call OBTENER_ADMI_POR_ID(?)}");
//            cs.setInt("p_id_admi",id );
//            rs = cs.executeQuery();
//            
////            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, " +
////                         "a.nombre_usuario, a.ultimo_ingreso, a.cargo " +
////                         "FROM persona p INNER JOIN p_administrador a ON p.id = a.id " +
////                         "WHERE p.id = ?";
////            pst = con.prepareCall(sql);
////            pst.setInt(1, id);
////            rs = pst.executeQuery();

            if (rs.next()) {
                admin = new Administrador();
                admin.setId(rs.getInt("id"));
                admin.setNombres(rs.getString("nombres"));
                admin.setApellidos(rs.getString("apellidos"));
                admin.setEmail(rs.getString("email"));
                admin.setTelefono(rs.getString("telefono"));
                admin.setContrasena(rs.getString("contrasena"));
                admin.setActivo(rs.getInt("activo"));
                admin.setNombreUsuario(rs.getString("nombre_usuario"));
                admin.setUltimoIngreso(rs.getTimestamp("ultimo_ingreso").toLocalDateTime());
                admin.setCargo(rs.getString("cargo"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            //try { if (cs != null) cs.close(); } catch (SQLException e) {}
            //try { if (con != null && !con.isClosed()) con.close(); } catch (SQLException e) {}
        }
        return admin;
    }

    
}

