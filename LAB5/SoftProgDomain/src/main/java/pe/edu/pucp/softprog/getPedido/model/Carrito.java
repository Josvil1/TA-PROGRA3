
package pe.edu.pucp.softprog.getPedido.model;

import java.util.ArrayList;
import pe.edu.pucp.softprog.getUsuario.model.Persona;

public class Carrito {
    private int id;
    private Persona usuario;
    private ArrayList<ItemCarrito>items;

    public Carrito() {
    }

    public Carrito(int id, Persona usuario) {
        this.id = id;
        this.usuario = usuario;
        this.items = new ArrayList<>();
    }

    public Carrito(int id, Persona usuario, ArrayList<ItemCarrito> items) {
        this.id = id;
        this.usuario = usuario;
        this.items = items;
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

    public ArrayList<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemCarrito> items) {
        this.items = items;
    }
    
    
    
}
