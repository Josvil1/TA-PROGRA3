package pe.edu.pucp.softprog.getUsuario.model;

import java.util.Date;

public class Natural extends Persona {
    private String genero;
    private Date fechaNacimiento;
    
    public Natural(){
        
    }
    public Natural(String nombres, String apellidos, String email, String contrasena, 
            String telefono, int activo,String genero,Date fechaNacimiento) {
        super(nombres, apellidos, email, contrasena, telefono, activo);
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "ID: " + getId()+ 
            "\n Nombre: " + getNombres() + " " + getApellidos()+
            "\n Email: " + getEmail()+
            "\n Teléfono: " + getTelefono()+
            "\n Género: " + getGenero()+
            "\n Fecha de Nacimiento: " + getFechaNacimiento()+
            "\n Estado: " + (getActivo() == 1 ? "Activo" : "Inactivo")+
            "\n ------------------------------------";
    }
    
    
}
