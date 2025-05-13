
package pe.edu.pucp.softprogmodel.getUsuario;

import java.time.LocalDateTime;

public class Direccion {
    private int id;
    private Persona personaId;
    private String alias;
    private String direccion;
    private String ciudad;
    private String referencia;
    private int activo;
    private int usuario_creacion;
    private LocalDateTime fecha_creacion;
    private int usuario_actualizacion;
    private LocalDateTime fecha_actualizacion;

    public Direccion() {
    }

    public Direccion(Persona personaId, String direccion, String ciudad, int usuario_creacion, LocalDateTime fecha_creacion) {
        this.personaId = personaId;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
    }

    public Direccion(Persona personaId, String direccion, String ciudad, String referencia) {
        this.personaId = personaId;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.referencia = referencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Persona personaId) {
        this.personaId = personaId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
