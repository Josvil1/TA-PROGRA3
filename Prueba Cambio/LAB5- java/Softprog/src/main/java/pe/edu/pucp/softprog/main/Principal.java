
package pe.edu.pucp.softprog.main;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import pe.edu.pucp.softProg.gestUsuario.dao.AdministradorDAO;
import pe.edu.pucp.softProg.gestUsuario.dao.DireccionDAO;
import pe.edu.pucp.softProg.gestUsuario.dao.JuridicaDAO;
import pe.edu.pucp.softProg.gestUsuario.dao.NaturalDAO;
import pe.edu.pucp.softProg.gestUsuario.mysql.DireccionMYSQL;
import pe.edu.pucp.softprog.getUsuario.model.Direccion;

import pe.edu.pucp.softProg.gestUsuario.mysql.AdministradorMYSQL;
import pe.edu.pucp.softProg.gestUsuario.mysql.JuridicaMYSQL;
import pe.edu.pucp.softProg.gestUsuario.mysql.NaturalMYSQL;
import pe.edu.pucp.softprog.getUsuario.model.Administrador;
import pe.edu.pucp.softprog.getUsuario.model.Juridica;
import pe.edu.pucp.softprog.getUsuario.model.Natural;

public class Principal {
    public static void main(String[] args) throws ParseException{

    //INSERTAR ADMINSTRADOR--------------
//    Administrador admin = new Administrador(
//        "Monica", "Pucallpa", "MonicPul@gmail.com", "Caos456", "99356846", 1,
//        "adminMon", LocalDateTime.now(), "CoLider"
//    );
//
//    AdministradorMYSQL daoAdmin = new AdministradorMYSQL();
//    daoAdmin.insertar(admin);
     

//    //MODIFICAR NOMBRE DE ADMIN----------
//    Administrador admin = new Administrador();
//    admin.setId(8); // ID del administrador a modificar
//    admin.setNombres("Julio Cesar"); // Nuevo nombre
//
//    AdministradorDAO daoAdmin = new AdministradorMYSQL();
//    daoAdmin.modificar(admin);
////    
    //ELIMINAR UN ADMIN:---------------
//    AdministradorMYSQL daoAdmin = new AdministradorMYSQL();
//    daoAdmin.eliminar(25);
//    
    //Listar Lista-----------------
    AdministradorDAO daoAdmin = new AdministradorMYSQL();
    ArrayList<Administrador> admins = daoAdmin.listarTodos();
    for (Administrador a : admins) {
        System.out.println(a);
    }
    //obtener por ID 
//    AdministradorDAO dao = new AdministradorMYSQL();
//    Administrador admin = dao.obtenerPorId(8); // ID del administrador a consultar
//    if (admin != null) {
//        System.out.println(admin);   
//    } else {
//        System.out.println("No se encontró administrador con ese ID.");
//    }
//    

//------JURIDICA
    //INSERTAR
//        Juridica empresa = new Juridica(
//        "Inversiones", "Hiraoka SAC", "hiraoka@lima.com", "empresa568", "999888777", 1,
//        "202020256258", "Inversiones SAC", "Carlos Lluya");
//
//    JuridicaDAO daoJuridica = new JuridicaMYSQL();
//    daoJuridica.insertar(empresa);

    //MODIFICAR nombre del representante
//    Juridica juridica = new Juridica();
//    juridica.setId(9);  // ID de la persona jurídica que quieres modificar
//    juridica.setRepresentanteLegal("Carlos Enrique");  // Nuevo representante legal
//
//    JuridicaDAO daoJuridica = new JuridicaMYSQL();
//    daoJuridica.modificar(juridica);
    
    //ELIMINAR
//    JuridicaMYSQL daoJuridica = new JuridicaMYSQL();
//    daoJuridica.eliminar(9); 
    
    //LISTAR
//        JuridicaMYSQL dao = new JuridicaMYSQL();
//        ArrayList<Juridica> lista = dao.listarTodas();
//        for (Juridica j : lista) {
//            System.out.println(j);
//        }

    //Obterner por ID
//    JuridicaDAO dao = new JuridicaMYSQL();
//    Juridica j = dao.obtenerPorId(9); // por ejemplo
//    if (j != null) {
//        System.out.println(j);
//    } else {
//        System.out.println("No se encontró persona jurídica con ese ID.");
//    }

//--------Insertar Persona Ntural
//    Natural natural = new Natural(
//            "Raul", "Nasario", "rau@gmail.com", "clave486", "949888777", 1,
//            "Masculino", new Date() // fecha actual
//        );
//
//        NaturalMYSQL dao = new NaturalMYSQL();
//        dao.insertar(natural);
    //Modificar LA FECHA DE NACIMIENTO
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    Date nuevaFecha = sdf.parse("1995-08-25");
//
//    // Creamos el objeto Natural con el ID existente y la nueva fecha
//    Natural nat = new Natural();
//    nat.setId(11);                      // ID de la persona natural en BD
//    nat.setFechaNacimiento(nuevaFecha);
//
//    // Llamamos al DAO para que actualice solo la fecha de nacimiento
//    NaturalDAO dao = new NaturalMYSQL();
//    dao.modificar(nat);


    //eliminar una persona natural
//     int idNatural = 11;  // ID de la persona natural a desactivar
//        NaturalDAO dao = new NaturalMYSQL();
//        dao.eliminar(idNatural);
    
    
    //Listar listas de personas naturales
//    NaturalMYSQL dao = new NaturalMYSQL();
//    ArrayList<Natural> lista = dao.listarTodas();
//     for (Natural nat : lista) {
//         System.out.println(nat);
//     }
    //obtener por ID
//    NaturalMYSQL daoNatural = new NaturalMYSQL();
        
        // Suponemos que queremos buscar al usuario con ID = 13
//        int idBuscado = 13;
//        Natural natural = daoNatural.obtenerPorId(idBuscado);
//
//        if (natural != null) {
//            System.out.println("Datos de Persona Natural con ID " + idBuscado + ":");
//            System.out.println(natural);
//        } else {
//            System.out.println("No se encontró una persona natural con ID " + idBuscado);
//        }
    
//--------INSERTAR DIRECCION    
//    Direccion dir = new Direccion(11, "Mansion", "Av. Los Junin 789", "Lima", "Cerca al loza");
//    DireccionDAO daoDireccion = new DireccionMYSQL();
//    daoDireccion.insertar(dir);
//        
    //MODIFICAR DIRECCION:de acuerdo al id de la persona
//    Direccion dir = new Direccion();
//    dir.setPersonaId(11); // ID de la persona cuya dirección a modificar
//    dir.setAlias("Mansion");
//    dir.setDireccion("Jr. Junin 147");
//    dir.setCiudad("Ancash");
//    dir.setReferencia("Frente al Parque");
////
//    DireccionDAO daoDireccion = new DireccionMYSQL();
//    daoDireccion.modificar(dir);
    
    //ELIMINAR una direccion de acuerdo al id_persona
//    DireccionDAO daoDireccion = new DireccionMYSQL();
//    daoDireccion.eliminar(11);
    
    
//    LISTAR
//    DireccionDAO daoDireccion = new DireccionMYSQL();
//    ArrayList<Direccion> direcciones = daoDireccion.listarTodas();
//
//    for (Direccion d : direcciones) {
//        System.out.println(d); 
//    }
//    
    //Obtener por ID de direccion:
//    DireccionDAO daoDireccion = new DireccionMYSQL();
//    Direccion direccion = daoDireccion.obtenerPorId(2); // por ejemplo, id = 2
//    if (direccion != null) {
//        System.out.println("Alias: " + direccion.getAlias());
//        System.out.println("Ciudad: " + direccion.getCiudad());
//        System.out.println("Dirección completa: " + direccion.getDireccion());
//    } else {
//        System.out.println("No se encontró dirección con ese ID.");
//    }

    
    }
}