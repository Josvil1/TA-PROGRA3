
package pe.edu.pucp.softProg.gestUsuario.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import pe.edu.pucp.softProg.db.DBManager;
import pe.edu.pucp.softProg.gestUsuario.dao.NaturalDAO;
import pe.edu.pucp.softprog.getUsuario.model.Natural;

public class NaturalMYSQL implements NaturalDAO {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;

    @Override
    public int insertar(Natural natural) {
        int resultado = 0;

        try {
            con = DBManager.getInstance().getConnection();
            con.setAutoCommit(false);

            String sqlPersona = "INSERT INTO persona(nombres, apellidos, email, telefono, contrasena, activo) VALUES (?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, natural.getNombres());
            pst.setString(2, natural.getApellidos());
            pst.setString(3, natural.getEmail());
            pst.setString(4, natural.getTelefono());
            pst.setString(5, natural.getContrasena());
            pst.setInt(6, natural.getActivo());
            pst.executeUpdate();

            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                natural.setId(idGenerado);

                String sqlNatural = "INSERT INTO p_natural(id, fecha_nacimiento, genero) VALUES (?, ?, ?)";
                pst = con.prepareStatement(sqlNatural);
                pst.setInt(1, idGenerado);
                pst.setDate(2, new java.sql.Date(natural.getFechaNacimiento().getTime()));
                pst.setString(3, natural.getGenero());

                resultado = pst.executeUpdate();
            }

            con.commit();
            System.out.println("Persona natural insertada correctamente.");
        } catch (Exception e) {
            try { if (con != null) con.rollback(); } catch (Exception ex) { ex.printStackTrace(); }
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pst != null) pst.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }

        return resultado;
    }

    @Override
    public int modificar(Natural natural) {
       int resultado = 0;
    try {
        con = DBManager.getInstance().getConnection();
        String sql = "UPDATE p_natural SET fecha_nacimiento = ? WHERE id = ?";
        pst = con.prepareStatement(sql);
        pst.setDate(1, new java.sql.Date(natural.getFechaNacimiento().getTime()));
        pst.setInt(2, natural.getId());

        resultado = pst.executeUpdate();
        if (resultado > 0) {
            System.out.println("Fecha de nacimiento actualizada correctamente.");
        } else {
            System.out.println("No se encontró persona natural con ese ID.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (pst != null) pst.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }

    return resultado;
    }
//
    @Override
    public int eliminar(int idNat) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "UPDATE persona SET activo = 0 WHERE id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idNat);
            resultado = pst.executeUpdate();
            if (resultado > 0) System.out.println("Persona natural desactivada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (pst != null) pst.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return resultado;
    }
//
    @Override
    public ArrayList<Natural> listarTodas() {
         ArrayList<Natural> lista = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, "
                       + "n.genero, n.fecha_nacimiento "
                       + "FROM persona p INNER JOIN p_natural n ON p.id = n.id";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Natural nat = new Natural();
                nat.setId(rs.getInt("id"));
                nat.setNombres(rs.getString("nombres"));
                nat.setApellidos(rs.getString("apellidos"));
                nat.setEmail(rs.getString("email"));
                nat.setTelefono(rs.getString("telefono"));
                nat.setContrasena(rs.getString("contrasena"));
                nat.setActivo(rs.getInt("activo"));
                nat.setGenero(rs.getString("genero"));
                nat.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                lista.add(nat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (st != null) st.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return lista;
    }
    
    @Override
    public Natural obtenerPorId(int id) {
        Natural natural = null;
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT p.id, p.nombres, p.apellidos, p.email, p.telefono, p.contrasena, p.activo, "
                       + "n.genero, n.fecha_nacimiento "
                       + "FROM persona p INNER JOIN p_natural n ON p.id = n.id "
                       + "WHERE p.id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                natural = new Natural();
                natural.setId(rs.getInt("id"));
                natural.setNombres(rs.getString("nombres"));
                natural.setApellidos(rs.getString("apellidos"));
                natural.setEmail(rs.getString("email"));
                natural.setTelefono(rs.getString("telefono"));
                natural.setContrasena(rs.getString("contrasena"));
                natural.setActivo(rs.getInt("activo"));
                natural.setGenero(rs.getString("genero"));
                natural.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pst != null) pst.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return natural;
}
    
    
}
