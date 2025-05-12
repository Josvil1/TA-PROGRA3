
package pe.edu.pucp.softProg.gestUsuario.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softProg.db.DBManager;
import pe.edu.pucp.softProg.gestUsuario.dao.DireccionDAO;
import pe.edu.pucp.softprog.getUsuario.model.Direccion;

public class DireccionDAOImpl implements DireccionDAO {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public int insertar(Direccion dir) {
         int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "INSERT INTO direccion(persona_id, alias, direccion, ciudad, referencia) VALUES (?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, dir.getPersonaId());
            pst.setString(2, dir.getAlias());
            pst.setString(3, dir.getDireccion());
            pst.setString(4, dir.getCiudad());
            pst.setString(5, dir.getReferencia());
            resultado = pst.executeUpdate();
            System.out.println("Dirección registrada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (pst != null) pst.close(); if (con != null) con.close(); } catch (Exception e) {}
        }
        return resultado;
    }

    @Override
    public int modificar(Direccion dir) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "UPDATE direccion SET alias = ?, direccion = ?, ciudad = ?, referencia = ? WHERE persona_id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, dir.getAlias());
            pst.setString(2, dir.getDireccion());
            pst.setString(3, dir.getCiudad());
            pst.setString(4, dir.getReferencia());
            pst.setInt(5, dir.getPersonaId());
            resultado = pst.executeUpdate();
            System.out.println("Dirección modificada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (pst != null) pst.close(); if (con != null) con.close(); } catch (Exception e) {}
        }
        return resultado;
    }
//
    @Override
    public int eliminar(int idDir) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "DELETE FROM direccion WHERE persona_id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, idDir);
            resultado = pst.executeUpdate();
            System.out.println("Dirección eliminada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (pst != null) pst.close(); if (con != null) con.close(); } catch (Exception e) {}
        }
        return resultado;
    }

    @Override
    public ArrayList<Direccion> listarTodas() {
        ArrayList<Direccion> lista = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM direccion";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Direccion dir = new Direccion();
                dir.setId(rs.getInt("id"));
                dir.setPersonaId(rs.getInt("persona_id"));
                dir.setAlias(rs.getString("alias"));
                dir.setDireccion(rs.getString("direccion"));
                dir.setCiudad(rs.getString("ciudad"));
                dir.setReferencia(rs.getString("referencia"));
                lista.add(dir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); if (pst != null) pst.close(); if (con != null) con.close(); } catch (Exception e) {}
        }
        return lista;
    }
    
    @Override
    public Direccion obtenerPorId(int id) {
        Direccion dir = null;
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM direccion WHERE id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                dir = new Direccion();
                dir.setId(rs.getInt("id"));
                dir.setPersonaId(rs.getInt("persona_id"));
                dir.setAlias(rs.getString("alias"));
                dir.setDireccion(rs.getString("direccion"));
                dir.setCiudad(rs.getString("ciudad"));
                dir.setReferencia(rs.getString("referencia"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pst != null) pst.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
        return dir;
    }
    
    
}
