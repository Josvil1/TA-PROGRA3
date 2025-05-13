
package pe.edu.pucp.softprog.gestPedido.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestPedido.DAO.PedidoItemDAO;
import pe.edu.pucp.softprogmodel.getPedido.Pedido;
import pe.edu.pucp.softprogmodel.getPedido.PedidoItem;
import pe.edu.pucp.softprogmodel.getProducto.Producto;

public class PedidoItemImpl implements PedidoItemDAO{

    @Override
    public int insertar(PedidoItem item) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_pedido_id", item.getPedido().getIdPedido());
        parametrosEntrada.put("p_producto_id", item.getProducto().getIdProducto());
        parametrosEntrada.put("p_cantidad", item.getCantidad());
        parametrosEntrada.put("p_precio", item.getPrecio());
        parametrosEntrada.put("p_usuario_creacion", item.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id_item", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarPedidoItem", parametrosEntrada, parametrosSalida);
        int id = (int) parametrosSalida.get("p_id_item");
        item.setIdItemPedido(id);
        return id;
    }

    @Override
    public int modificar(PedidoItem item) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", item.getIdItemPedido());
        parametrosEntrada.put("p_cantidad", item.getCantidad());
        parametrosEntrada.put("p_precio", item.getPrecio());
        parametrosEntrada.put("p_usuario_actualizacion", item.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarPedidoItem", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_item", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarPedidoItem", parametrosEntrada, null);

    }

    @Override
    public ArrayList<PedidoItem> listarTodos() {
        ArrayList<PedidoItem> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarPedidoItem", null);

        try {
            while (rs.next()) {
                PedidoItem item = new PedidoItem();
                Pedido pedido = new Pedido();
                Producto producto = new Producto();

                item.setIdItemPedido(rs.getInt("id"));
                pedido.setIdPedido(rs.getInt("pedido_id"));
                producto.setIdProducto(rs.getInt("producto_id"));
                item.setPedido(pedido);
                item.setProducto(producto);
                item.setCantidad(rs.getInt("cantidad"));
                item.setPrecio(rs.getDouble("precio"));

                lista.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public PedidoItem obtenerPorId(int id) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPedidoItemPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                PedidoItem item = new PedidoItem();
                Pedido pedido = new Pedido();
                Producto producto = new Producto();

                item.setIdItemPedido(rs.getInt("id"));
                pedido.setIdPedido(rs.getInt("pedido_id"));
                producto.setIdProducto(rs.getInt("producto_id"));
                item.setPedido(pedido);
                item.setProducto(producto);
                item.setCantidad(rs.getInt("cantidad"));
                item.setPrecio(rs.getDouble("precio"));

                return item;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
