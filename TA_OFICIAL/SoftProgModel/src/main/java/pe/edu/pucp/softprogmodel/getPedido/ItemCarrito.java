
package pe.edu.pucp.softprogmodel.getPedido;

import java.time.LocalDateTime;
import pe.edu.pucp.softprogmodel.getProducto.Producto;

public class ItemCarrito {
    private int idItemCarrito;
    private Carrito carrito;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;

    public ItemCarrito() {
    }

    public ItemCarrito(Carrito carrito, Producto producto, int cantidad, double subtotal) {
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public ItemCarrito(Carrito carrito, Producto producto, int cantidad, double subtotal, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdItemCarrito() {
        return idItemCarrito;
    }

    public void setIdItemCarrito(int idItemCarrito) {
        this.idItemCarrito = idItemCarrito;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
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
    
    
    
    
}
