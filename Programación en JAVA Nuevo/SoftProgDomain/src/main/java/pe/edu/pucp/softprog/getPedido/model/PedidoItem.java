package pe.edu.pucp.softprog.getPedido.model;

import pe.edu.pucp.softprog.getProducto.model.Producto;

public class PedidoItem {
    private Producto producto;
    private int cantidad;
    
    public PedidoItem(){
        
    }

    public PedidoItem(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
