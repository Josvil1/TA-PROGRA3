package pe.edu.pucp.softProg.gestPedido.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softProg.db.DBManager;
import pe.edu.pucp.softProg.gestPedido.dao.EnvioDAO;
import pe.edu.pucp.softprog.getPedido.model.Envio;

public class EnvioMYSQL implements EnvioDAO{
    private Connection conexion;
    private CallableStatement statement;
    private ResultSet resultSet;  
    
    public EnvioMYSQL(){
        this.conexion = null;
        this.statement = null;
    }

    @Override
    public Integer insertar(Envio envio) {
        Integer retorno = null;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "INSERT INTO envio(pedido_id, direccion_id, estado_envio) VALUES (?, ?, ?)";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, envio.getPedido().getId());
            this.statement.setInt(2, envio.getDireccion().getId());
            this.statement.setString(3, envio.getEstado());
            this.statement.executeUpdate();
            retorno = this.retornarUltimoAutoGenerado();
            this.conexion.commit();
        } catch (SQLException ex) {
            if (this.conexion != null) {
                try {
                    this.conexion.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(EnvioMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(EnvioMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (this.conexion != null) {
                try {
                    this.conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EnvioMYSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retorno;
    }

    @Override
    public Envio obtenerPorId(Integer envioId) {
        Envio envio = null;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT id, pedido_id, direccion_id, estado_envio FROM envio WHERE ida = ?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, envioId);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()) {
                envio = new Envio();
                envio.setId(this.resultSet.getInt("id"));
//                pedido = new Pedido(this.resultSet.getString("pedido_id"));
//                envio.setPedido(pedido);
//                envio.setAlmacen_central(this.resultSet.getInt("direccion_id") == 1);
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
        return envio;
    }

    @Override
    public ArrayList<Envio> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(Envio almacen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(Envio almacen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Integer retornarUltimoAutoGenerado() {
        Integer resultado = null;
        String sql = "select @@last_insert_id as id";
        try {
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()){
                resultado = this.resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnvioMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
}
