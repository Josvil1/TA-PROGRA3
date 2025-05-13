
package pe.edu.pucp.softprogmodel.getProducto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;
    private ArrayList<Precio_presentacion> preciosPorPresentaciones;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto(String nombre, String descripcion, double precio, int stock, String categoria, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public Producto(int activo, int usuario_actualizacion, LocalDateTime fecha_actualizacion) {
        this.activo = activo;
        this.usuario_actualizacion = usuario_actualizacion;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public ArrayList<Precio_presentacion> getPreciosPorPresentaciones() {
        return preciosPorPresentaciones;
    }

    public void setPreciosPorPresentaciones(ArrayList<Precio_presentacion> preciosPorPresentaciones) {
        this.preciosPorPresentaciones = preciosPorPresentaciones;
    }
    
    
    
}
