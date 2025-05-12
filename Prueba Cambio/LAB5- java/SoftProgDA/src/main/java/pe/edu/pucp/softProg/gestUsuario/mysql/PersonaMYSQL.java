
package pe.edu.pucp.softProg.gestUsuario.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.softProg.db.DBManager;
import pe.edu.pucp.softProg.gestUsuario.dao.PersonaDAO;
import pe.edu.pucp.softprog.getUsuario.model.Persona;

public class PersonaMYSQL implements PersonaDAO {
    
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
    
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

    @Override
    public int eliminar(int idPer) {
       int resultado = 0;
        try{
            //Establecer una conexion con la BD
            con = DBManager.getInstance().getConnection();
            //Ejecutamos alguna sentencia SQL
            String sql = "UPDATE persona SET activo = 0 WHERE" + " id = " + idPer;
            st = con.createStatement();
            resultado = st.executeUpdate(sql);
            System.out.println("Se ha eliminado la persona "+idPer+"...");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    
    @Override
    public ArrayList<Persona> listarTodos() {

        ArrayList<Persona> lista = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM persona";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt("id"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setEmail(rs.getString("email"));
                p.setTelefono(rs.getString("telefono"));
                p.setContrasena(rs.getString("contrasena"));
                p.setActivo(rs.getInt("activo"));
                lista.add(p);
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
        return lista;
        
    }
    
}
