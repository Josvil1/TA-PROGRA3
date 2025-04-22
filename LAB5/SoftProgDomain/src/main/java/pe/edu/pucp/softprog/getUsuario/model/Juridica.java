package pe.edu.pucp.softprog.getUsuario.model;

import pe.edu.pucp.softprog.getPedido.model.Carrito;
import pe.edu.pucp.softprog.getPedido.model.Pedido;

import java.util.ArrayList;


public class Juridica extends Persona {
    private String ruc;
    private String razonSocial;
    private String representanteLegal;
    private Carrito carroCompra;
    private ArrayList<Pedido> pedidos;
    
    public Juridica(){
        
    }

    public Juridica(String nombres, String apellidos, String email, String contrasena,
            String telefono, int activo,String ruc, String razonSocial, String representanteLegal) {
        super(nombres, apellidos, email, contrasena, telefono, activo);
        this.ruc = ruc;
        this.representanteLegal = representanteLegal;
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public Carrito getCarroCompra() {
        return carroCompra;
    }

    public void setCarroCompra(Carrito carroCompra) {
        this.carroCompra = carroCompra;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
}
