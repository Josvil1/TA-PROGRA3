
package pe.edu.pucp.softprog.gestPedido.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestPedido.DAO.PedidoDAO;
import pe.edu.pucp.softprogmodel.getPedido.Pedido;
import pe.edu.pucp.softprogmodel.getUsuario.Persona;

public class PedidoImpl implements PedidoDAO{

    @Override
    public int insertar(Pedido pedido) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_persona_id", pedido.getUsuario().getId());
        parametrosEntrada.put("p_fecha_pedido", java.sql.Timestamp.valueOf(pedido.getFechaPedido()));
        parametrosEntrada.put("p_total", pedido.getTotal());
        parametrosEntrada.put("p_estado", pedido.getEstado());
        parametrosEntrada.put("p_usuario_creacion", pedido.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarPedido", parametrosEntrada, parametrosSalida);
        int id = (int) parametrosSalida.get("p_id");
        pedido.setIdPedido(id);
        return id;
    }

    @Override
    public int modificar(Pedido pedido) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", pedido.getIdPedido());
        parametrosEntrada.put("p_estado", pedido.getEstado());
        parametrosEntrada.put("p_total", pedido.getTotal());
        parametrosEntrada.put("p_usuario_actualizacion", pedido.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarPedido", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_pedido", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarPedido", parametrosEntrada, null);

    }

    @Override
    public ArrayList<Pedido> listarTodos() {
        ArrayList<Pedido> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarPedidos", null);

        try {
            while (rs.next()) {
                Pedido pedido = new Pedido();
                Persona persona = new Persona();

                pedido.setIdPedido(rs.getInt("id"));
                persona.setId(rs.getInt("persona_id"));
                pedido.setUsuario(persona);
                pedido.setFechaPedido(rs.getTimestamp("fecha_pedido").toLocalDateTime());
                pedido.setTotal(rs.getDouble("total"));
                pedido.setEstado(rs.getString("estado"));

                lista.add(pedido);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Pedido obtenerPorId(int id) {
         Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPedidoPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Pedido pedido = new Pedido();
                Persona persona = new Persona();

                pedido.setIdPedido(rs.getInt("id"));
                persona.setId(rs.getInt("persona_id"));
                pedido.setUsuario(persona);
                pedido.setFechaPedido(rs.getTimestamp("fecha_pedido").toLocalDateTime());
                pedido.setTotal(rs.getDouble("total"));
                pedido.setEstado(rs.getString("estado"));

                return pedido;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
