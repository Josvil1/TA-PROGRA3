package pe.edu.pucp.softprog.getUsuario.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pe.edu.pucp.softprog.getPedido.model.Carrito;
import pe.edu.pucp.softprog.getPedido.model.Pedido;

public class Administrador extends Persona{
    private String nombreUsuario;
    private LocalDateTime ultimoIngreso;
    private String cargo;
    private Carrito carroCompra;
    private ArrayList<Pedido> pedidos;
    
    public Administrador(){
        
    }

    public Administrador(String nombres, String apellidos, String email, String contrasena, String telefono, int activo, String nombreUsuario, LocalDateTime ultimoIngreso, String cargo) {
        super(nombres, apellidos, email, contrasena, telefono, activo);
        this.nombreUsuario = nombreUsuario;
        this.ultimoIngreso = ultimoIngreso;
        this.cargo = cargo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDateTime getUltimoIngreso() {
        return ultimoIngreso;
    }

    public void setUltimoIngreso(LocalDateTime ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
    

    @Override
    public String toString() {
        return "ID: " + super.getId()+"\n Nombre: "+super.getNombres()+"\n Apellidos: "+super.getApellidos()+"\n Cargo: "+getCargo() + "\n Hora de ingreso: "+getUltimoIngreso();
    }

 
    
    
}
