
package pe.edu.pucp.softprogmodel.getPedido;

import java.time.LocalDateTime;
import java.util.Date;
import pe.edu.pucp.softprogmodel.getUsuario.Direccion;

public class Envio {
    private int idEnvio;
    private Pedido pedido;
    private Direccion direccion;
    private String estado_envio;//(PENDIENTE, ENTREGADO)
    private Date fecha_entrega;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;

    public Envio() {
    }

    public Envio(Pedido pedido, Direccion direccion, String estado_envio, Date fecha_entrega) {
        this.pedido = pedido;
        this.direccion = direccion;
        this.estado_envio = estado_envio;
        this.fecha_entrega = fecha_entrega;
    }

    public Envio(Pedido pedido, Direccion direccion, String estado_envio, Date fecha_entrega, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.pedido = pedido;
        this.direccion = direccion;
        this.estado_envio = estado_envio;
        this.fecha_entrega = fecha_entrega;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEstado_envio() {
        return estado_envio;
    }

    public void setEstado_envio(String estado_envio) {
        this.estado_envio = estado_envio;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
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
