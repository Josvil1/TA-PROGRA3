
package pe.edu.pucp.softProg.gestUsuario.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softProg.db.DBManager;
import pe.edu.pucp.softProg.gestUsuario.dao.DireccionDAO;
import pe.edu.pucp.softprog.getUsuario.model.Direccion;

public class DireccionMYSQL implements DireccionDAO {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public int insertar(Direccion dir) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            String sql = "INSERT INTO direccion(persona_id,alias,direccion,ciudad) VALUES(?,?,?,?)";
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, dir.getPersonaId());
            pst.setString(2, dir.getAlias());
            pst.setString(3, dir.getDireccion());
            pst.setString(4, dir.getCiudad());
            pst.executeUpdate();
            
            // 2. Obtener el idBiblioteca recién insertado
//            sql = "SELECT LAST_INSERT_ID() AS persona_id";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//            if (rs.next()) {
//                int idPersona = rs.getInt("persona_id");
//                dir.setPersonaId(idPersona);  // Asignamos el idPersona al objeto Direccion
//            }
            System.out.println("Se ha registrado en tabla Direccion...");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

//    @Override
//    public int modifcar(Direccion dir) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public int eliminar(int idDir) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public ArrayList<Direccion> listarTodas() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    
}
