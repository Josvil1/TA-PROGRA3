
package pe.edu.pucp.softprog.gestProducto.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestProducto.DAO.Precio_presentacionDAO;
import pe.edu.pucp.softprogmodel.getProducto.Precio_presentacion;
import pe.edu.pucp.softprogmodel.getProducto.Producto;
import pe.edu.pucp.softprogmodel.getProducto.TipoMedida;

public class Precio_presentacionImpl implements Precio_presentacionDAO{

    @Override
    public int insertar(Precio_presentacion pp) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_producto_id", pp.getProducto().getIdProducto());
        parametrosEntrada.put("p_tipo_medida", pp.getTipoMedida().name());
        parametrosEntrada.put("p_cantidad", pp.getCantidad());
        parametrosEntrada.put("p_precio", pp.getPrecio());
        parametrosEntrada.put("p_usuario_creacion", pp.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id_presentacion", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarPrecioPresentacion", parametrosEntrada, parametrosSalida);

        int id = (int) parametrosSalida.get("p_id_presentacion");
        pp.setIdPrecio_Presentacion(id);
        return id;
    }

    @Override
    public int modificar(Precio_presentacion pp) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", pp.getIdPrecio_Presentacion());
        parametrosEntrada.put("p_cantidad", pp.getCantidad());
        parametrosEntrada.put("p_precio", pp.getPrecio());
        parametrosEntrada.put("p_usuario_actualizacion", pp.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarPrecioPresentacion", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_presentacion", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarPrecioPresentacion", parametrosEntrada, null);

    }

    @Override
    public ArrayList<Precio_presentacion> listarTodos() {
        ArrayList<Precio_presentacion> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarPrecioPresentacion", null);

        try {
            while (rs.next()) {
                Precio_presentacion pp = new Precio_presentacion();
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("producto_id"));
                pp.setIdPrecio_Presentacion(rs.getInt("id"));
                pp.setProducto(producto);
                pp.setTipoMedida(TipoMedida.valueOf(rs.getString("tipo_medida")));
                pp.setCantidad(rs.getInt("cantidad"));
                pp.setPrecio(rs.getDouble("precio"));
                lista.add(pp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Precio_presentacion obtenerPorId(int id) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerPrecioPresentacionPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Precio_presentacion pp = new Precio_presentacion();
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("producto_id"));
                pp.setIdPrecio_Presentacion(rs.getInt("id"));
                pp.setProducto(producto);
                pp.setTipoMedida(TipoMedida.valueOf(rs.getString("tipo_medida")));
                pp.setCantidad(rs.getInt("cantidad"));
                pp.setPrecio(rs.getDouble("precio"));
                return pp;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
