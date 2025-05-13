
package pe.edu.pucp.softprogmodel.getPedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import pe.edu.pucp.softprogmodel.getUsuario.Persona;

public class Pedido {
    private int idPedido;
    private Persona usuario;
    private LocalDateTime fechaPedido;
    private double total;
    private String estado;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;
    private Envio envio;
    private Pago pago;
    private ArrayList<PedidoItem>items;  

    public Pedido() {
    }

    public Pedido(Persona usuario, LocalDateTime fechaPedido, double total, String estado) {
        this.usuario = usuario;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
    }

    public Pedido(Persona usuario, LocalDateTime fechaPedido, double total, String estado, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.usuario = usuario;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Persona getUsuario() {
        return usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public ArrayList<PedidoItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<PedidoItem> items) {
        this.items = items;
    }
    
    
    
}
