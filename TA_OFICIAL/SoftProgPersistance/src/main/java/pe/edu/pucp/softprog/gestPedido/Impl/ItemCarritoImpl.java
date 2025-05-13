
package pe.edu.pucp.softprog.gestPedido.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestPedido.DAO.ItemCarritoDAO;
import pe.edu.pucp.softprogmodel.getPedido.Carrito;
import pe.edu.pucp.softprogmodel.getPedido.ItemCarrito;
import pe.edu.pucp.softprogmodel.getProducto.Producto;

public class ItemCarritoImpl implements ItemCarritoDAO{

    @Override
    public int insertar(ItemCarrito item) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_carrito_id", item.getCarrito().getIdCarrito());
        parametrosEntrada.put("p_producto_id", item.getProducto().getIdProducto());
        parametrosEntrada.put("p_cantidad", item.getCantidad());
        parametrosEntrada.put("p_subtotal", item.getSubtotal());
        parametrosEntrada.put("p_usuario_creacion", item.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id_item", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarItemCarrito", parametrosEntrada, parametrosSalida);
        int id = (int) parametrosSalida.get("p_id_item");
        item.setIdItemCarrito(id);
        return id;
    }

    @Override
    public int modificar(ItemCarrito item) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", item.getIdItemCarrito());
        parametrosEntrada.put("p_cantidad", item.getCantidad());
        parametrosEntrada.put("p_subtotal", item.getSubtotal());
        parametrosEntrada.put("p_usuario_actualizacion", item.getUsuario_actualizacion());
        
        return DBManager.getInstance().ejecutarProcedimiento("modificarItemCarrito", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_item", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarItemCarrito", parametrosEntrada, null);

    }

    @Override
    public ArrayList<ItemCarrito> listarTodos() {
        ArrayList<ItemCarrito> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarItemCarrito", null);

        try {
            while (rs.next()) {
                ItemCarrito item = new ItemCarrito();
                Carrito carrito = new Carrito();
                Producto producto = new Producto();

                item.setIdItemCarrito(rs.getInt("id"));
                carrito.setIdCarrito(rs.getInt("carrito_id"));
                producto.setIdProducto(rs.getInt("producto_id"));

                item.setCarrito(carrito);
                item.setProducto(producto);
                item.setCantidad(rs.getInt("cantidad"));
                item.setSubtotal(rs.getDouble("subtotal"));

                lista.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public ItemCarrito obtenerPorId(int id) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerItemCarritoPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                ItemCarrito item = new ItemCarrito();
                Carrito carrito = new Carrito();
                Producto producto = new Producto();

                item.setIdItemCarrito(rs.getInt("id"));
                carrito.setIdCarrito(rs.getInt("carrito_id"));
                producto.setIdProducto(rs.getInt("producto_id"));

                item.setCarrito(carrito);
                item.setProducto(producto);
                item.setCantidad(rs.getInt("cantidad"));
                item.setSubtotal(rs.getDouble("subtotal"));

                return item;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
