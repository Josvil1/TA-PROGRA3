package pe.edu.pucp.softprog.getUsuario.model;
import java.util.ArrayList;

public class Persona {
    private int id;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String contrasena;
    private int activo;
    private ArrayList<Direccion> direcciones;
    
    public Persona(){
        this.direcciones = new ArrayList<>();// QUE NUNCA SEA NULL
    }

    public Persona(int id, String nombres, String apellidos, String email, String telefono) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }
    
    
    public Persona(String nombres,String apellidos, String email, String contrasena,
            String telefono,int activo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.email = email;
        this.telefono = telefono;
        this.activo=activo;
        this.direcciones = new ArrayList<>();
//        this.direcciones = (direcciones != null) ? direcciones : new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    
    
    
    
}
