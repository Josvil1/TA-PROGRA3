
package pe.edu.pucp.softprog.gestPedido.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestPedido.DAO.ComprobanteDAO;
import pe.edu.pucp.softprogmodel.getPedido.Comprobante;
import pe.edu.pucp.softprogmodel.getPedido.Pedido;

public class ComprobanteImpl implements ComprobanteDAO{

    @Override
    public int insertar(Comprobante comprobante) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_pedido_id", comprobante.getPedido().getIdPedido());
        parametrosEntrada.put("p_tipo", comprobante.getTipo());
        parametrosEntrada.put("p_numero_serie", comprobante.getNumero_serie());
        parametrosEntrada.put("p_fecha_emision", java.sql.Timestamp.valueOf(comprobante.getFecha_emision()));
        parametrosEntrada.put("p_total", comprobante.getTotal());
        parametrosEntrada.put("p_usuario_creacion", comprobante.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id_comprobante", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarComprobante", parametrosEntrada, parametrosSalida);

        int id = (int) parametrosSalida.get("p_id_comprobante");
        comprobante.setIdComprobante(id);
        return id;
    }

    @Override
    public int modificar(Comprobante comprobante) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", comprobante.getIdComprobante());
        parametrosEntrada.put("p_tipo", comprobante.getTipo());
        parametrosEntrada.put("p_numero_serie", comprobante.getNumero_serie());
        parametrosEntrada.put("p_usuario_actualizacion", comprobante.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarComprobante", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_comprobante", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarComprobante", parametrosEntrada, null);

    }

    @Override
    public ArrayList<Comprobante> listarTodos() {
        ArrayList<Comprobante> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarComprobante", null);

        try {
            while (rs.next()) {
                Comprobante comp = new Comprobante();
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("pedido_id"));

                comp.setIdComprobante(rs.getInt("id"));
                comp.setPedido(pedido);
                comp.setTipo(rs.getString("tipo"));
                comp.setNumero_serie(rs.getString("numero_serie"));
                comp.setFecha_emision(rs.getTimestamp("fecha_emision").toLocalDateTime());
                comp.setTotal(rs.getDouble("total"));
                lista.add(comp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Comprobante obtenerPorId(int id) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerComprobantePorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Comprobante comp = new Comprobante();
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("pedido_id"));

                comp.setIdComprobante(rs.getInt("id"));
                comp.setPedido(pedido);
                comp.setTipo(rs.getString("tipo"));
                comp.setNumero_serie(rs.getString("numero_serie"));
                comp.setFecha_emision(rs.getTimestamp("fecha_emision").toLocalDateTime());
                comp.setTotal(rs.getDouble("total"));
                return comp;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
