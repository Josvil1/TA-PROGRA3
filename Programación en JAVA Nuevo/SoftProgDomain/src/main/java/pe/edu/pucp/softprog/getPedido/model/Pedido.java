
package pe.edu.pucp.softprog.getPedido.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import pe.edu.pucp.softprog.getUsuario.model.Persona;

public class Pedido {
    private int id;
    private Persona usuario;
    private LocalDateTime fechaPedido;
    private LocalDate fechaEntrega;
    private ArrayList<PedidoItem>items;
    private double total; // falta agregar a la BD    
    private EstadoPedido estado;
    private Envio envio;
    private Pago pago;
    
    public Pedido(){
        
    }

    public Pedido(int id, Persona usuario, LocalDateTime fechaPedido, LocalDate fechaEntrega, double total, EstadoPedido estado, Envio envio, Pago pago) {
        this.id = id;
        this.usuario = usuario;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
        this.estado = estado;
        this.envio = envio;
        this.pago = pago;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public ArrayList<PedidoItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<PedidoItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
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
    
    
    
}
