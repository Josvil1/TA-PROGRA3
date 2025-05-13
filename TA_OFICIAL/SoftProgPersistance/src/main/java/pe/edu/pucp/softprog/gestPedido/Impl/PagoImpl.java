
package pe.edu.pucp.softprog.gestPedido.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestPedido.DAO.PagoDAO;
import pe.edu.pucp.softprogmodel.getPedido.Pago;
import pe.edu.pucp.softprogmodel.getPedido.Pedido;

public class PagoImpl implements PagoDAO{

    @Override
    public int insertar(Pago pago) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_pedido_id", pago.getPedido().getIdPedido());
        parametrosEntrada.put("p_metodo", pago.getMetodo());
        parametrosEntrada.put("p_monto", pago.getMonto());
        parametrosEntrada.put("p_estado", pago.getEstado());
        parametrosEntrada.put("p_fecha_pago", java.sql.Timestamp.valueOf(pago.getFechaPago()));
        parametrosEntrada.put("p_usuario_creacion", pago.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id_pago", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarPago", parametrosEntrada, parametrosSalida);
        int id = (int) parametrosSalida.get("p_id_pago");
        pago.setIdPago(id);
        return id;
    }

    @Override
    public int modificar(Pago pago) {
         Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", pago.getIdPago());
        parametrosEntrada.put("p_estado", pago.getEstado());
        parametrosEntrada.put("p_usuario_actualizacion", pago.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarPago", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_pago", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarPago", parametrosEntrada, null);

    }

    @Override
    public ArrayList<Pago> listarTodos() {
        ArrayList<Pago> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarPago", null);

        try {
            while (rs.next()) {
                Pago pago = new Pago();
                Pedido pedido = new Pedido();

                pago.setIdPago(rs.getInt("id"));
                pedido.setIdPedido(rs.getInt("pedido_id"));
                pago.setPedido(pedido);
                pago.setMetodo(rs.getString("metodo"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setEstado(rs.getString("estado"));
                pago.setFechaPago(rs.getTimestamp("fecha_pago").toLocalDateTime());

                lista.add(pago);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Pago obtenerPorId(int id) {
         Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPagoPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Pago pago = new Pago();
                Pedido pedido = new Pedido();

                pago.setIdPago(rs.getInt("id"));
                pedido.setIdPedido(rs.getInt("pedido_id"));
                pago.setPedido(pedido);
                pago.setMetodo(rs.getString("metodo"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setEstado(rs.getString("estado"));
                pago.setFechaPago(rs.getTimestamp("fecha_pago").toLocalDateTime());

                return pago;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
