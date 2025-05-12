package pe.edu.pucp.softprog.getPedido.model;

import pe.edu.pucp.softprog.getUsuario.model.Direccion;

public class Envio {
    private int id;
    private String estado;//(PENDIENTE, ENTREGADO)
    private Direccion direccion;
    private Pedido pedido;

    public Envio() {
        this.estado=null;
        this.direccion=null;
        this.pedido=null;
    }

    public Envio(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
    
    
    
    
}
