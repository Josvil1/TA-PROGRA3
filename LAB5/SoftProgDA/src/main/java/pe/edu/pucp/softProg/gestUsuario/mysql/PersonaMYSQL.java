
package pe.edu.pucp.softProg.gestUsuario.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softProg.db.DBManager;
import pe.edu.pucp.softProg.gestUsuario.dao.PersonaDAO;
import pe.edu.pucp.softprog.getUsuario.model.Persona;

public class PersonaMYSQL implements PersonaDAO {
    
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
        
    @Override
    public int insertar(Persona per) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            String sql = "INSERT INTO persona(id,nombres,apellidos,email,telefono) VALUES(?,?,?,?,?)";
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, per.getId());
            pst.setString(2, per.getNombres());
            pst.setString(3, per.getApellidos());
            pst.setString(4, per.getEmail());
            pst.setString(5, per.getTelefono());
            resultado=pst.executeUpdate();

            System.out.println("Se ha registrado en tabla Persona...");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int modificar(Persona per) {
        int resultado = 0;
        try {
                con = DBManager.getInstance().getConnection();
                String sql = "UPDATE persona SET activo = ? WHERE id = ?";

                pst = con.prepareStatement(sql);
                pst.setInt(1, per.getActivo());
                pst.setInt(2, per.getId());

                resultado = pst.executeUpdate();

                if (resultado > 0) {
                    System.out.println("Se ha actualizado la persona con ID: " + per.getId());
                } else {
                    System.out.println("No se encontró persona con ID: " + per.getId());
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
//    @Override
//    public int eliminar(int idPer) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public ArrayList<Persona> listarTodas() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
}
