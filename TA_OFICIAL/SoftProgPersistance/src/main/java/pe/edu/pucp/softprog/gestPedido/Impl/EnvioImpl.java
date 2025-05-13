package pe.edu.pucp.softprog.gestPedido.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestPedido.DAO.EnvioDAO;
import pe.edu.pucp.softprogmodel.getPedido.Envio;
import pe.edu.pucp.softprogmodel.getPedido.Pedido;
import pe.edu.pucp.softprogmodel.getUsuario.Direccion;

public class EnvioImpl implements EnvioDAO{

    @Override
    public int insertar(Envio envio) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_pedido_id", envio.getPedido().getIdPedido());
        parametrosEntrada.put("p_direccion_id", envio.getDireccion().getId());
        parametrosEntrada.put("p_estado_envio", envio.getEstado_envio());
        parametrosEntrada.put("p_fecha_entrega", new java.sql.Date(envio.getFecha_entrega().getTime()));
        parametrosEntrada.put("p_usuario_creacion", envio.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id_envio", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarEnvio", parametrosEntrada, parametrosSalida);

        int id = (int) parametrosSalida.get("p_id_envio");
        envio.setIdEnvio(id);
        return id;
    }

    @Override
    public int modificar(Envio envio) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", envio.getIdEnvio());
        parametrosEntrada.put("p_estado_envio", envio.getEstado_envio());
        parametrosEntrada.put("p_usuario_actualizacion", envio.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarEnvio", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_envio", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarEnvio", parametrosEntrada, null);

    }

    @Override
    public ArrayList<Envio> listarTodos() {
        ArrayList<Envio> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarEnvio", null);

        try {
            while (rs.next()) {
                Envio envio = new Envio();
                Pedido pedido = new Pedido();
                Direccion direccion = new Direccion();

                envio.setIdEnvio(rs.getInt("id"));
                pedido.setIdPedido(rs.getInt("pedido_id"));
                direccion.setId(rs.getInt("direccion_id"));

                envio.setPedido(pedido);
                envio.setDireccion(direccion);
                envio.setEstado_envio(rs.getString("estado_envio"));
                envio.setFecha_entrega(rs.getDate("fecha_entrega"));

                lista.add(envio);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Envio obtenerPorId(int id) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerEnvioPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Envio envio = new Envio();
                Pedido pedido = new Pedido();
                Direccion direccion = new Direccion();

                envio.setIdEnvio(rs.getInt("id"));
                pedido.setIdPedido(rs.getInt("pedido_id"));
                direccion.setId(rs.getInt("direccion_id"));

                envio.setPedido(pedido);
                envio.setDireccion(direccion);
                envio.setEstado_envio(rs.getString("estado_envio"));
                envio.setFecha_entrega(rs.getDate("fecha_entrega"));

                return envio;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
