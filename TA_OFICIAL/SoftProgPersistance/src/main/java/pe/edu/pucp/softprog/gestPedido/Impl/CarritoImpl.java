package pe.edu.pucp.softprog.gestPedido.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.bd.DBManager;
import pe.edu.pucp.softprog.gestPedido.DAO.CarritoDAO;
import pe.edu.pucp.softprogmodel.getPedido.Carrito;
import pe.edu.pucp.softprogmodel.getUsuario.Persona;

public class CarritoImpl implements CarritoDAO{

    @Override
    public int insertar(Carrito carrito) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_persona_id", carrito.getPersona().getId());
        parametrosEntrada.put("p_total", carrito.getTotal());
        parametrosEntrada.put("p_usuario_creacion", carrito.getUsuario_creacion());

        Map<String, Object> parametrosSalida = new HashMap<>();
        parametrosSalida.put("p_id", Types.INTEGER);

        DBManager.getInstance().ejecutarProcedimiento("insertarCarrito", parametrosEntrada, parametrosSalida);

        int id = (int) parametrosSalida.get("p_id");
        carrito.setIdCarrito(id);
        return id;
    }

    @Override
    public int modificar(Carrito carrito) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", carrito.getIdCarrito());
        parametrosEntrada.put("p_total", carrito.getTotal());
        parametrosEntrada.put("p_usuario_actualizacion", carrito.getUsuario_actualizacion());

        return DBManager.getInstance().ejecutarProcedimiento("modificarCarrito", parametrosEntrada, null);

    }

    @Override
    public int eliminar(int id, int usuarioActualizacion) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id_carrito", id);
        parametrosEntrada.put("p_usuario_actualizacion", usuarioActualizacion);

        return DBManager.getInstance().ejecutarProcedimiento("eliminarCarrito", parametrosEntrada, null);

    }

    @Override
    public ArrayList<Carrito> listarTodos() {
        ArrayList<Carrito> lista = new ArrayList<>();
        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarCarritos", null);

        try {
            while (rs.next()) {
                Carrito carrito = new Carrito();
                Persona persona = new Persona();
                persona.setId(rs.getInt("persona_id"));
                carrito.setIdCarrito(rs.getInt("id"));
                carrito.setPersona(persona);
                carrito.setTotal(rs.getDouble("total"));
                lista.add(carrito);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    @Override
    public Carrito obtenerPorId(int id) {
        Map<String, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put("p_id", id);

        ResultSet rs = DBManager.getInstance().ejecutarProcedimientoLectura("obtenerCarritoPorId", parametrosEntrada);

        try {
            if (rs.next()) {
                Carrito carrito = new Carrito();
                Persona persona = new Persona();
                persona.setId(rs.getInt("persona_id"));
                carrito.setIdCarrito(rs.getInt("id"));
                carrito.setPersona(persona);
                carrito.setTotal(rs.getDouble("total"));
                return carrito;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
    
}
