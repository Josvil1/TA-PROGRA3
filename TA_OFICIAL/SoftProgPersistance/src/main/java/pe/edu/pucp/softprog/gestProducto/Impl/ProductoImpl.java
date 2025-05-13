
package pe.edu.pucp.softprog.gestProducto.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestProducto.DAO.ProductoDAO;
import pe.edu.pucp.softprogmodel.getProducto.Producto;

public class ProductoImpl implements ProductoDAO {

    @Override
    public int insertar(Producto p) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_nombre", p.getNombre());
        parametrosEntrada.put("p_descripcion", p.getDescripcion());
        parametrosEntrada.put("p_precio", p.getPrecio());
        parametrosEntrada.put("p_stock", p.getStock());
        parametrosEntrada.put("p_categoria", p.getCategoria());
        parametrosEntrada.put("p_usuario_creacion", p.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarProducto", parametrosEntrada, parametrosSalida);

        int idProducto = (int) parametrosSalida.get("p_id");
        p.setIdProducto(idProducto);
        return idProducto;
    }

    @Override
    public int modificar(Producto p) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", p.getIdProducto());
        parametrosEntrada.put("p_nombre", p.getNombre());
        parametrosEntrada.put("p_descripcion", p.getDescripcion());
        parametrosEntrada.put("p_precio", p.getPrecio());
        parametrosEntrada.put("p_stock", p.getStock());
        parametrosEntrada.put("p_categoria", p.getCategoria());
        parametrosEntrada.put("p_usuario_actualizacion", p.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarProducto", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarProducto", parametrosEntrada, null);
    }

    @Override
    public ArrayList<Producto> listarTodos() {
        ArrayList<Producto> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarProductos", null);

        try {
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setCategoria(rs.getString("categoria"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Producto obtenerPorId(int id) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerProductoPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setCategoria(rs.getString("categoria"));
                return p;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
