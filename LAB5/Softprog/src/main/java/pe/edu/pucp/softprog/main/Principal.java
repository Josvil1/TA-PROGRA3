
package pe.edu.pucp.softprog.main;
import pe.edu.pucp.softProg.gestUsuario.dao.DireccionDAO;
import pe.edu.pucp.softProg.gestUsuario.mysql.DireccionMYSQL;
import pe.edu.pucp.softprog.getUsuario.model.Direccion;
import pe.edu.pucp.softprog.getUsuario.model.Persona;
import pe.edu.pucp.softProg.gestUsuario.dao.PersonaDAO;
import pe.edu.pucp.softProg.gestUsuario.mysql.PersonaMYSQL;
public class Principal {
    public static void main(String[] args){
        //ingresar datos a BD en la tabla persona
        Persona persona = new Persona(4, "Yordi", "Antaurco", "yordin@gmail.com", "a9396553681");
        PersonaDAO daoPersona = new PersonaMYSQL();
        daoPersona.insertar(persona);
//        //isertar datos en la tabla direccion
//        Direccion dir=new Direccion(2, "MIGUEL", "Villa el salvador", "LIMA", "AVENIDA");
//        DireccionDAO daoDireccion = new DireccionMYSQL();
//        daoDireccion.insertar(dir);
        
//        //modificar los datos de una persona ejemplo 
//        Persona persona = new Persona();
//        persona.setId(3); // ID de la persona que queremos modificar
//
//        // Solo cambiamos los campos que queremos actualizar
//        persona.setEmail("karolyn.nueva@mail.com");
//        persona.setTelefono("987654321");
//
//        // También se deben setear los demás campos si tu método modificar los actualiza
//        persona.setNombres("Karolyn Nayumi");
//        persona.setApellidos("Aquiño");
//        persona.setActivo(1);
//
//        PersonaDAO daoPersona = new PersonaMYSQL();
//        int resultado = daoPersona.modificar(persona);
//
//        if (resultado > 0) {
//            System.out.println("Correo y teléfono actualizados correctamente.");
//        } else {
//            System.out.println("No se encontró persona con ese ID.");
//
//        }
        //desactivar una el estado activo a 0
        Persona per = new Persona();
        per.setActivo(0);
        per.setId(4);
                
        PersonaMYSQL dao = new PersonaMYSQL();
        int resultado = dao.modificar(per); // ← ID de la persona que querés desactivar
        if (resultado > 0) {
            System.out.println("Persona desactivada correctamente.");
        } else {
            System.out.println("No se encontró persona con ese ID.");
        }
        
        
        
        
        
    }
}