
package pe.edu.pucp.softprogmodel.getPedido;

import java.time.LocalDateTime;

public class Pago {
    private int idPago;
    private Pedido pedido;
    private String metodo;
    private double monto;
    private String estado;
    private LocalDateTime fechaPago;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;

    public Pago() {
    }

    public Pago(Pedido pedido, String metodo, double monto, String estado, LocalDateTime fechaPago) {
        this.pedido = pedido;
        this.metodo = metodo;
        this.monto = monto;
        this.estado = estado;
        this.fechaPago = fechaPago;
    }

    public Pago(Pedido pedido, String metodo, double monto, String estado, LocalDateTime fechaPago, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.pedido = pedido;
        this.metodo = metodo;
        this.monto = monto;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
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
