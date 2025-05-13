
package pe.edu.pucp.softprogmodel.getProducto;

import java.time.LocalDateTime;


public class Precio_presentacion {
    private int idPrecio_Presentacion; 
    private Producto producto;
    private TipoMedida tipoMedida;
    private int cantidad;
    private double precio;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;

    public Precio_presentacion() {
    }

    public Precio_presentacion(Producto producto, TipoMedida tipoMedida, int cantidad, double precio) {
        this.producto = producto;
        this.tipoMedida = tipoMedida;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Precio_presentacion(Producto producto, TipoMedida tipoMedida, int cantidad, double precio, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.producto = producto;
        this.tipoMedida = tipoMedida;
        this.cantidad = cantidad;
        this.precio = precio;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdPrecio_Presentacion() {
        return idPrecio_Presentacion;
    }

    public void setIdPrecio_Presentacion(int idPrecio_Presentacion) {
        this.idPrecio_Presentacion = idPrecio_Presentacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TipoMedida getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(TipoMedida tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
