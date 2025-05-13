
package pe.edu.pucp.softprogmodel.getUsuario;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Administrador {
    private int id;
    private Usuario usuario;
    private String nombre_usuario;
    private LocalDateTime ultimoIngreso;
    private String cargo;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;

    public Administrador() {
    }

    public Administrador(Usuario usuario, String nombre_usuario, String cargo, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.usuario = usuario;
        this.nombre_usuario = nombre_usuario;
        this.cargo = cargo;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public Administrador(Usuario usuario, String nombre_usuario, String cargo) {
        this.usuario = usuario;
        this.nombre_usuario = nombre_usuario;
        this.cargo = cargo;
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

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
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
