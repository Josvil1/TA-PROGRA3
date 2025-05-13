
package pe.edu.pucp.softprogmodel.getUsuario;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.sql.Date;

public class Persona {
    private int id;
    private Usuario usuario;
    private String nombres;
    private String apellidos;
    private String telefono;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;
    private ArrayList<Direccion> direcciones;
    //private ArrayList<Pedido> pedidos;
    //private Carrito carro ;
    
    public Persona(){
        
    }

    public Persona(Usuario usuario, String nombres, String apellidos, String telefono) {
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public Persona(Usuario usuario, String nombres, String apellidos, String telefono, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }
    
    
    
}
