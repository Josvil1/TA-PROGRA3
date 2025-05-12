
package pe.edu.pucp.softprog.getProducto.model;

import java.util.ArrayList;
import pe.edu.pucp.softprog.getUsuario.model.Administrador;

public class Producto {
    private int sku;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;
    private Administrador actualizadoPorAdminId;
    private ArrayList<PrecioPresentacion> preciosPorPresentaciones;
    
    public Producto(){
        
    }

    public Producto(int sku, String nombre, String descripcion, double precio, int stock, String categoria, Administrador actualizadoPorAdminId) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.actualizadoPorAdminId = actualizadoPorAdminId;
        this.preciosPorPresentaciones = new ArrayList<>();
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
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

    public Administrador getActualizadoPorAdminId() {
        return actualizadoPorAdminId;
    }

    public void setActualizadoPorAdminId(Administrador actualizadoPorAdminId) {
        this.actualizadoPorAdminId = actualizadoPorAdminId;
    }

    public ArrayList<PrecioPresentacion> getPreciosPorPresentaciones() {
        return preciosPorPresentaciones;
    }

    public void setPreciosPorPresentaciones(ArrayList<PrecioPresentacion> preciosPorPresentaciones) {
        this.preciosPorPresentaciones = preciosPorPresentaciones;
    }
    
    
    
    
    
}
