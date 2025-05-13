
package pe.edu.pucp.softprogmodel.getPedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pe.edu.pucp.softprogmodel.getUsuario.Persona;

public class Carrito {
    private int idCarrito;
    private Persona persona;
    private double total;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;
    private ArrayList<ItemCarrito>items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    public Carrito(Persona persona, double total) {
        this.persona = persona;
        this.total = total;
    }

    public Carrito(Persona persona, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.persona = persona;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(int usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getUsuario_actualizacion() {
        return usuario_actualizacion;
    }

    public void setUsuario_actualizacion(int usuario_actualizacion) {
        this.usuario_actualizacion = usuario_actualizacion;
    }

    public LocalDateTime getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(LocalDateTime fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public ArrayList<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemCarrito> items) {
        this.items = items;
    }

    
    
}
