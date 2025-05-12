
package pe.edu.pucp.softprog.getUsuario.model;

public class Direccion {
    private int id;
    private int personaId;
    private String alias;
    private String direccion;
    private String ciudad;
    private String referencia;
    
    public Direccion() {
    
    }

    public Direccion(int personaId, String alias, String ciudad) {
        this.personaId = personaId;
        this.alias = alias;
        this.ciudad = ciudad;
    }
    
    
    public Direccion(int personaId, String alias, String direccion, String ciudad, String referencia) {
        this.personaId = personaId;
        this.alias = alias;
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

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
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
    
    @Override
    public String toString() {
        return "Cod: " + id + "\n Alias: "+ alias +
                "\n Direccion: "+direccion +"\n Ciudad: "+ciudad; 
    }
}
