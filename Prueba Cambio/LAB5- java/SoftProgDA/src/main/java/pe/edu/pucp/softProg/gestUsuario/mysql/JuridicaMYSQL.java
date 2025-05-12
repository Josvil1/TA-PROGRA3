
package pe.edu.pucp.softProg.gestUsuario.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.softProg.db.DBManager;
import pe.edu.pucp.softProg.gestUsuario.dao.JuridicaDAO;
import pe.edu.pucp.softprog.getUsuario.model.Juridica;

public class JuridicaMYSQL implements JuridicaDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
    
    @Override
    public int insertar(Juridica juridica) {
        int resultado = 0;

        try {
            con = DBManager.getInstance().getConnection();
            con.setAutoCommit(false); // Para transacción

            // 1. Insertar en persona
            String sqlPersona = "INSERT INTO persona(nombres, apellidos, email, telefono, contrasena, activo) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, juridica.getNombres());
            pst.setString(2, juridica.getApellidos());
            pst.setString(3, juridica.getEmail());
            pst.setString(4, juridica.getTelefono());
            pst.setString(5, juridica.getContrasena());
            pst.setInt(6, juridica.getActivo());
            pst.executeUpdate();

            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                juridica.setId(idGenerado);

                // 2. Insertar en p_juridica
                String sqlJuridica = "INSERT INTO p_juridica(id, ruc, razon_social, representante_legal) VALUES (?, ?, ?, ?)";
                pst = con.prepareStatement(sqlJuridica);
                pst.setInt(1, juridica.getId());
                pst.setString(2, juridica.getRuc());
                pst.setString(3, juridica.getRazonSocial());
                pst.setString(4, juridica.getRepresentanteLegal());

                resultado = pst.executeUpdate();
            }

            con.commit();
            System.out.println("Persona jurídica insertada correctamente.");

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                if (con != null) con.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (con != null && !con.isClosed()) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return resultado;
    }

    @Override
    public int modificar(Juridica juridica) {
         int resultado = 0;

        try {
            con = DBManager.getInstance().getConnection();
            String sql = "UPDATE p_juridica SET representante_legal = ? WHERE id = ?";

            pst = con.prepareStatement(sql);
            pst.setString(1, juridica.getRepresentanteLegal());  // Obtenemos el nuevo representante
            pst.setInt(2, juridica.getId());  // Usamos el id del objeto juridica

            resultado = pst.executeUpdate();

            if (resultado > 0) {
                System.out.println("Representante legal actualizado correctamente.");
            } else {
                System.out.println("No se encontró persona jurídica con ese ID.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null && !con.isClosed()) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return resultado;
    }
//
    @Override
    public int eliminar(int idJur) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "UPDATE persona SET activo = 0 WHERE id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idJur);

            resultado = pst.executeUpdate();
            System.out.println(resultado > 0
                ? "Persona jurídica con ID " + idJur + " desactivada (activo=0)."
                : "No se encontró persona jurídica con ID " + idJur);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try { if (pst != null) pst.close(); if (con != null && !con.isClosed()) con.close(); }
            catch (SQLException ex) { ex.printStackTrace(); }
        }
        return resultado;
    }
//
    @Override
    public ArrayList<Juridica> listarTodas() {
        ArrayList<Juridica> juridicas = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, "
                       + "j.ruc, j.razon_social, j.representante_legal "
                       + "FROM persona p INNER JOIN p_juridica j ON p.id = j.id WHERE p.activo = 1";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Juridica j = new Juridica();
                j.setId(rs.getInt("id"));
                j.setNombres(rs.getString("nombres"));
                j.setApellidos(rs.getString("apellidos"));
                j.setEmail(rs.getString("email"));
                j.setTelefono(rs.getString("telefono"));
                j.setContrasena(rs.getString("contrasena"));
                j.setActivo(rs.getInt("activo"));
                j.setRuc(rs.getString("ruc"));
                j.setRazonSocial(rs.getString("razon_social"));
                j.setRepresentanteLegal(rs.getString("representante_legal"));
                juridicas.add(j);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) { System.out.println(ex.getMessage()); }
            try { if (st != null) st.close(); } catch (SQLException ex) { System.out.println(ex.getMessage()); }
            try { if (con != null) con.close(); } catch (SQLException ex) { System.out.println(ex.getMessage()); }
        }
        return juridicas;
    }
    
    
    @Override
    public Juridica obtenerPorId(int id) {
        Juridica juridica = null;
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, " +
                         "j.ruc, j.razon_social, j.representante_legal " +
                         "FROM persona p INNER JOIN p_juridica j ON p.id = j.id " +
                         "WHERE p.id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                juridica = new Juridica();
                juridica.setId(rs.getInt("id"));
                juridica.setNombres(rs.getString("nombres"));
                juridica.setApellidos(rs.getString("apellidos"));
                juridica.setEmail(rs.getString("email"));
                juridica.setTelefono(rs.getString("telefono"));
                juridica.setContrasena(rs.getString("contrasena"));
                juridica.setActivo(rs.getInt("activo"));
                juridica.setRuc(rs.getString("ruc"));
                juridica.setRazonSocial(rs.getString("razon_social"));
                juridica.setRepresentanteLegal(rs.getString("representante_legal"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) {}
            try { if (pst != null) pst.close(); } catch (SQLException ex) {}
            try { if (con != null && !con.isClosed()) con.close(); } catch (SQLException ex) {}
        }
        return juridica;
    }
    
}
