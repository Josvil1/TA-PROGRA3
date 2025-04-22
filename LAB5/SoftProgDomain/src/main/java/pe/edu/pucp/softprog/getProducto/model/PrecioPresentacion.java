
package pe.edu.pucp.softprog.getProducto.model;

public class PrecioPresentacion {
    private TipoMedida tipoMedida;
    private int cantidad;
    private double precio;
    
    public PrecioPresentacion(){
        
    }
    
    public PrecioPresentacion(TipoMedida tipoMedida, int cantidad, double precio) {
        this.tipoMedida = tipoMedida;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public TipoMedida getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(TipoMedida tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
