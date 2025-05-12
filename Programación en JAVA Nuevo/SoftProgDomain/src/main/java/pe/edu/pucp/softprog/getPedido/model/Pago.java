package pe.edu.pucp.softprog.getPedido.model;

import java.time.LocalDateTime;

public class Pago {
    private int id;
    private String metodo;
    private EstadoPago estado;
    private double monto;//
    private LocalDateTime fechaPago;

    public Pago() {
    }

    public Pago(int id, String metodo, EstadoPago estado, double monto, LocalDateTime fechaPago) {
        this.id = id;
        this.metodo = metodo;
        this.estado = estado;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    
}
