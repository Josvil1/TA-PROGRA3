
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
import pe.edu.pucp.softProg.gestUsuario.daoImpl.DireccionDAOImpl;
import pe.edu.pucp.softprog.getUsuario.model.Direccion;

import pe.edu.pucp.softProg.gestUsuario.daoImpl.AdministradorDAOImpl;
import pe.edu.pucp.softProg.gestUsuario.daoImpl.JuridicaDAOImpl;
import pe.edu.pucp.softProg.gestUsuario.daoImpl.NaturalDAOImpl;
import pe.edu.pucp.softprog.getUsuario.model.Administrador;
import pe.edu.pucp.softprog.getUsuario.model.Juridica;
import pe.edu.pucp.softprog.getUsuario.model.Natural;
import pe.edu.pucp.softProg.db.util.Cifrado;

public class Principal {
    public static void main(String[] args) throws ParseException{

//    INSERTAR ADMINSTRADOR--------------
    Administrador admin = new Administrador(
        "Administrador3", "ApeAdministrador3", "Administrador3@gmail.com", "Administrador33333", "933333451", 1,
        "Administrador3", LocalDateTime.now(), "Gerente"
    );
//
    AdministradorDAOImpl daoAdmin = new AdministradorDAOImpl();
    daoAdmin.insertar(admin);
//     

//    //MODIFICAR NOMBRE DE ADMIN----------
//    Administrador admin = new Administrador();
//    admin.setId(7); // ID del administrador a modificar
//    admin.setNombres("Carlos Eduardo"); // Nuevo nombre
//
//    AdministradorDAOImpl daoAdmin = new AdministradorDAOImpl();
//    daoAdmin.modificar(admin);
    
    //ELIMINAR UN ADMIN:---------------
//    AdministradorDAOImpl daoAdmin = new AdministradorDAOImpl();
//    daoAdmin.eliminar(7);
    
    //Listar Lista-----------------
//    AdministradorDAOImpl daoAdmin = new AdministradorDAOImpl();
//    ArrayList<Administrador> admins = daoAdmin.listarTodas();
//
//    for (Administrador a : admins) {
//        System.out.println(a);
//    }
    //obtener por ID 
//    AdministradorDAO dao = new AdministradorDAOImpl();
//    Administrador admin = dao.obtenerPorId(8); // ID del administrador a consultar
//    if (admin != null) {
//        System.out.println("Nombre completo: " + admin.getNombres() + " " + admin.getApellidos());
//        System.out.println("Usuario: " + admin.getNombreUsuario());
//        System.out.println("Último ingreso: " + admin.getUltimoIngreso());
//        System.out.println("Cargo: " + admin.getCargo());
//    } else {
//        System.out.println("No se encontró administrador con ese ID.");
//    }
    

//------JURIDICA
    //INSERTAR
//        Juridica empresa = new Juridica(
//        "Inversiones", "Hiraoka SAC", "hiraoka@lima.com", "empresa568", "999888777", 1,
//        "202020256258", "Inversiones SAC", "Carlos Lluya");
//
//    JuridicaDAO daoJuridica = new JuridicaDAOImpl();
//    daoJuridica.insertar(empresa);

    //MODIFICAR nombre del representante
//    Juridica juridica = new Juridica();
//    juridica.setId(9);  // ID de la persona jurídica que quieres modificar
//    juridica.setRepresentanteLegal("Carlos Enrique");  // Nuevo representante legal
//
//    JuridicaDAO daoJuridica = new JuridicaDAOImpl();
//    daoJuridica.modificar(juridica);
    
    //ELIMINAR
//    JuridicaDAOImpl daoJuridica = new JuridicaDAOImpl();
//    daoJuridica.eliminar(9); 
    
    //LISTAR
//        JuridicaDAOImpl dao = new JuridicaDAOImpl();
//        ArrayList<Juridica> lista = dao.listarTodas();
//        for (Juridica j : lista) {
//            System.out.println(j);
//        }

    //Obterner por ID
//    JuridicaDAO dao = new JuridicaDAOImpl();
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
//        NaturalDAOImpl dao = new NaturalDAOImpl();
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
//    NaturalDAO dao = new NaturalDAOImpl();
//    dao.modificar(nat);


    //eliminar una persona natural
//     int idNatural = 11;  // ID de la persona natural a desactivar
//        NaturalDAO dao = new NaturalDAOImpl();
//        dao.eliminar(idNatural);
    
    
    //Listar listas de personas naturales
//    NaturalDAOImpl dao = new NaturalDAOImpl();
//    ArrayList<Natural> lista = dao.listarTodas();
//     for (Natural nat : lista) {
//         System.out.println(nat);
//     }
    //obtener por ID
//    NaturalDAOImpl daoNatural = new NaturalDAOImpl();
        
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
//    DireccionDAO daoDireccion = new DireccionDAOImpl();
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
//    DireccionDAO daoDireccion = new DireccionDAOImpl();
//    daoDireccion.modificar(dir);
    
    //ELIMINAR una direccion de acuerdo al id_persona
//    DireccionDAO daoDireccion = new DireccionDAOImpl();
//    daoDireccion.eliminar(11);
    
    
//    LISTAR
//    DireccionDAO daoDireccion = new DireccionDAOImpl();
//    ArrayList<Direccion> direcciones = daoDireccion.listarTodas();
//
//    for (Direccion d : direcciones) {
//        System.out.println(d); 
//    }
//    
    //Obtener por ID de direccion:
//    DireccionDAO daoDireccion = new DireccionDAOImpl();
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