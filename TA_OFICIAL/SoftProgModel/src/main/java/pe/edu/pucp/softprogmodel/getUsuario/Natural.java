
package pe.edu.pucp.softprogmodel.getUsuario;

import java.time.LocalDateTime;
import java.util.Date;

public class Natural extends Persona{
    private int id_natural;
    private int dni;
    private Date fechaNacimiento;
    private String genero;

    public Natural() {
    }

    public Natural( Usuario usuario, String nombres, String apellidos, String telefono, int usuario_creacion, LocalDateTime fecha_creacion,int dni, Date fechaNacimiento, String genero) {
        super(usuario, nombres, apellidos, telefono, usuario_creacion, fecha_creacion);
        this.id_natural = super.getId();
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;        
    }

    public Natural(int dni, Date fechaNacimiento, String genero) {
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Natural(Usuario usuario, String nombres, String apellidos, String telefono,int dni, Date fechaNacimiento, String genero) {
        super(usuario, nombres, apellidos, telefono);
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public int getId_natural() {
        return id_natural;
    }

    public void setId_natural(int id_natural) {
        this.id_natural = id_natural;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
