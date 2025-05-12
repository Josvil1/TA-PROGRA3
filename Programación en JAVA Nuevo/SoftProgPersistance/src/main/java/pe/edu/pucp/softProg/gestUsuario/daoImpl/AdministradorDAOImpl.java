
package pe.edu.pucp.softProg.gestUsuario.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.softProg.db.DBManager;
import pe.edu.pucp.softProg.gestUsuario.dao.AdministradorDAO;
import pe.edu.pucp.softprog.getUsuario.model.Administrador;

public class AdministradorDAOImpl implements AdministradorDAO {
    
    private Connection conexion;
    private CallableStatement statement;
    protected ResultSet resultSet;
//    private PreparedStatement pst;

    @Override
    public int insertar(Administrador admin) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "INSERT INTO persona (nombres, apellidos, email, telefono, contrasena, activo) VALUES (?, ?, ?, ?, ?, ?)";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setString(1, admin.getNombres());
            this.statement.setString(2, admin.getApellidos());
            this.statement.setString(3, admin.getEmail());
            this.statement.setString(4, admin.getTelefono());
            this.statement.setString(5, admin.getContrasena());
            this.statement.setInt(6, admin.getActivo());
            this.statement.executeUpdate();
            this.resultSet=statement.getGeneratedKeys();
            if(resultSet.next()){
                int idGenerado=resultSet.getInt(1);
                admin.setId(idGenerado);
                String sqlAdmin = "INSERT INTO p_administrador(id, nombre_usuario, ultimo_ingreso, cargo) VALUES (?, ?, ?, ?)";
                this.statement=this.conexion.prepareCall(sqlAdmin);
                this.statement.setInt(1, admin.getId());
                this.statement.setString(2, admin.getNombreUsuario());
                this.statement.setTimestamp(3, java.sql.Timestamp.valueOf(admin.getUltimoIngreso()));
                this.statement.setString(4, admin.getCargo());
                resultado = this.retornarUltimoAutoGenerado();
            }
//            pst.executeUpdate();
//
//            rs = pst.getGeneratedKeys();
//            if (rs.next()) {
//                int idGenerado = rs.getInt(1);
//                admin.setId(idGenerado);
//
//                // 2. Insertar en p_administrador
//                String sqlAdmin = "INSERT INTO p_administrador(id, nombre_usuario, ultimo_ingreso, cargo) VALUES (?, ?, ?, ?)";
//                pst = con.prepareStatement(sqlAdmin);
//                pst.setInt(1, admin.getId());
//                pst.setString(2, admin.getNombreUsuario());
//                pst.setTimestamp(3, java.sql.Timestamp.valueOf(admin.getUltimoIngreso()));
//                pst.setString(4, admin.getCargo());
//                resultado = pst.executeUpdate();
//            }
//
//            con.commit();
//            System.out.println("Administrador insertado correctamente.");

            //resultado = this.statement.executeUpdate();
            
            this.conexion.commit();
            System.out.println("Administrador insertado correctamente.");
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }

    public Integer retornarUltimoAutoGenerado() {
        Integer resultado = null;
        try {
            String sql = "select @@last_insert_id as id";
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()) {
                resultado = this.resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar retornarUltimoAutoGenerado - " + ex);
        }
        return resultado;
    }

    @Override
    public Administrador obtenerPorId(int id) {
        Administrador admin = null;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, " +
                         "a.nombre_usuario, a.ultimo_ingreso, a.cargo " +
                         "FROM persona p INNER JOIN p_administrador a ON p.id = a.id " +
                         "WHERE p.id = ?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, id);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()) {
                admin = new Administrador();
                admin.setId(this.resultSet.getInt("id"));
                admin.setNombres(this.resultSet.getString("nombres"));
                admin.setApellidos(this.resultSet.getString("apellidos"));
                admin.setEmail(this.resultSet.getString("email"));
                admin.setTelefono(this.resultSet.getString("telefono"));
                admin.setContrasena(this.resultSet.getString("contrasena"));
                admin.setActivo(this.resultSet.getInt("activo"));
                admin.setNombreUsuario(this.resultSet.getString("nombre_usuario"));
                admin.setUltimoIngreso(this.resultSet.getTimestamp("ultimo_ingreso").toLocalDateTime());
                admin.setCargo(this.resultSet.getString("cargo"));
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar obtenerPorId - " + ex);
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return admin;
    }

    @Override
    public ArrayList<Administrador>listarTodas() {
        ArrayList<Administrador> listaAdministradores = new ArrayList<>();
        try {
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, " +
                         "a.nombre_usuario, a.ultimo_ingreso, a.cargo " +
                         "FROM persona p INNER JOIN p_administrador a ON p.id = a.id " +
                         "WHERE p.activo = 1";
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            while (this.resultSet.next()) {
                Administrador admin = new Administrador();
                admin.setId(this.resultSet.getInt("id"));
                admin.setNombres(this.resultSet.getString("nombres"));
                admin.setApellidos(this.resultSet.getString("apellidos"));
                admin.setEmail(this.resultSet.getString("email"));
                admin.setTelefono(this.resultSet.getString("telefono"));
                admin.setContrasena(this.resultSet.getString("contrasena"));
                admin.setActivo(this.resultSet.getInt("activo"));
                admin.setNombreUsuario(this.resultSet.getString("nombre_usuario"));
                admin.setUltimoIngreso(this.resultSet.getTimestamp("ultimo_ingreso").toLocalDateTime());
                admin.setCargo(this.resultSet.getString("cargo"));
                listaAdministradores.add(admin);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listarTodos - " + ex);
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return listaAdministradores;
    }

    @Override
    public int modificar(Administrador admin) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "UPDATE persona SET nombres = ? WHERE id = ?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setString(1, admin.getNombres());
            this.statement.setInt(2, admin.getId());
            resultado = this.statement.executeUpdate();
            this.conexion.commit();
            if (resultado > 0) {
                System.out.println("Nombre del administrador con ID " + admin.getId() + " actualizado.");
            } else {
                System.out.println("No se encontró administrador con ese ID.");
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar modificar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }

    @Override
    public int eliminar(int idAdmi) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "DELETE FROM persona WHERE id=?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, idAdmi);
            resultado = this.statement.executeUpdate();
            this.conexion.commit();
        } catch (SQLException ex) {
            System.err.println("Error al intentar eliminar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }
    
//    private Connection con;
//    private PreparedStatement pst;
//    private ResultSet rs;
//    private Statement st;
//    @Override
//    public int insertar(Administrador admin) {
//        int resultado = 0;
//        try {
//            con = DBManager.getInstance().getConnection();
//            con.setAutoCommit(false); // Usamos transacción
//
//            // 1. Insertar en persona
//            String sqlPersona = "INSERT INTO persona(nombres, apellidos, email, telefono, contrasena, activo) VALUES (?, ?, ?, ?, ?, ?)";
//            pst = con.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
//            pst.setString(1, admin.getNombres());
//            pst.setString(2, admin.getApellidos());
//            pst.setString(3, admin.getEmail());
//            pst.setString(4, admin.getTelefono());
//            pst.setString(5, admin.getContrasena());
//            pst.setInt(6, admin.getActivo());
//            pst.executeUpdate();
//
//            rs = pst.getGeneratedKeys();
//            if (rs.next()) {
//                int idGenerado = rs.getInt(1);
//                admin.setId(idGenerado);
//
//                // 2. Insertar en p_administrador
//                String sqlAdmin = "INSERT INTO p_administrador(id, nombre_usuario, ultimo_ingreso, cargo) VALUES (?, ?, ?, ?)";
//                pst = con.prepareStatement(sqlAdmin);
//                pst.setInt(1, admin.getId());
//                pst.setString(2, admin.getNombreUsuario());
//                pst.setTimestamp(3, java.sql.Timestamp.valueOf(admin.getUltimoIngreso()));
//                pst.setString(4, admin.getCargo());
//                resultado = pst.executeUpdate();
//            }
//
//            con.commit();
//            System.out.println("Administrador insertado correctamente.");
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            try {
//                if (con != null) con.rollback();
//            } catch (SQLException rollbackEx) {
//                rollbackEx.printStackTrace();
//            }
//        } finally {
//            try {
//                if (con != null && !con.isClosed()) con.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return resultado;
//    }
    
//    @Override
//    public int modificar(Administrador admin) {
//        int resultado = 0;
//        try {
//            con = DBManager.getInstance().getConnection();
//            String sql = "UPDATE persona SET nombres = ? WHERE id = ?";
//            pst = con.prepareStatement(sql);
//            pst.setString(1, admin.getNombres());
//            pst.setInt(2, admin.getId());
//            resultado = pst.executeUpdate();
//
//            if (resultado > 0) {
//                System.out.println("Nombre del administrador con ID " + admin.getId() + " actualizado.");
//            } else {
//                System.out.println("No se encontró administrador con ese ID.");
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (con != null && !con.isClosed()) con.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return resultado;
//
//    }

//    @Override
//    public int eliminar(int idAdmi) {
//        int resultado = 0;
//        try {
//            con = DBManager.getInstance().getConnection();
//            String sql = "UPDATE persona SET activo = 0 WHERE id = ?";
//            pst = con.prepareStatement(sql);
//            pst.setInt(1, idAdmi);
//
//            resultado = pst.executeUpdate();
//            if (resultado > 0) {
//                System.out.println("Administrador con ID " + idAdmi + " desactivado correctamente.");
//            } else {
//                System.out.println("No se encontró el administrador con ese ID.");
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (con != null && !con.isClosed()) con.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return resultado;
//    }

//    @Override
//    public ArrayList<Administrador> listarTodas() {
//        ArrayList<Administrador> lista = new ArrayList<>();
//        try {
//            con = DBManager.getInstance().getConnection();
//
//            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, " +
//                         "a.nombre_usuario, a.ultimo_ingreso, a.cargo " +
//                         "FROM persona p INNER JOIN p_administrador a ON p.id = a.id " +
//                         "WHERE p.activo = 1";  // Opcional: solo los activos
//
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//                Administrador admin = new Administrador();
//                admin.setId(rs.getInt("id"));
//                admin.setNombres(rs.getString("nombres"));
//                admin.setApellidos(rs.getString("apellidos"));
//                admin.setEmail(rs.getString("email"));
//                admin.setTelefono(rs.getString("telefono"));
//                admin.setContrasena(rs.getString("contrasena"));
//                admin.setActivo(rs.getInt("activo"));
//                admin.setNombreUsuario(rs.getString("nombre_usuario"));
//                admin.setUltimoIngreso(rs.getTimestamp("ultimo_ingreso").toLocalDateTime());
//                admin.setCargo(rs.getString("cargo"));
//                lista.add(admin);
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                if (con != null && !con.isClosed()) con.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        return lista;
//    }
// ===========================================================================================================================================================
//    @Override
//    public Administrador obtenerPorId(int id) {
//        Administrador admin = null;
//        try {
//            con = DBManager.getInstance().getConnection();
//            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, " +
//                         "a.nombre_usuario, a.ultimo_ingreso, a.cargo " +
//                         "FROM persona p INNER JOIN p_administrador a ON p.id = a.id " +
//                         "WHERE p.id = ?";
//            pst = con.prepareStatement(sql);
//            pst.setInt(1, id);
//            rs = pst.executeQuery();
//
//            if (rs.next()) {
//                admin = new Administrador();
//                admin.setId(rs.getInt("id"));
//                admin.setNombres(rs.getString("nombres"));
//                admin.setApellidos(rs.getString("apellidos"));
//                admin.setEmail(rs.getString("email"));
//                admin.setTelefono(rs.getString("telefono"));
//                admin.setContrasena(rs.getString("contrasena"));
//                admin.setActivo(rs.getInt("activo"));
//                admin.setNombreUsuario(rs.getString("nombre_usuario"));
//                admin.setUltimoIngreso(rs.getTimestamp("ultimo_ingreso").toLocalDateTime());
//                admin.setCargo(rs.getString("cargo"));
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            try { if (rs != null) rs.close(); } catch (SQLException e) {}
//            try { if (pst != null) pst.close(); } catch (SQLException e) {}
//            try { if (con != null && !con.isClosed()) con.close(); } catch (SQLException e) {}
//        }
//        return admin;
//    }

    
}

