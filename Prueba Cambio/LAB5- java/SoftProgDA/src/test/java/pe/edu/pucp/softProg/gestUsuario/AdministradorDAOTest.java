
package pe.edu.pucp.softProg.gestUsuario;

import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pe.edu.pucp.softProg.gestUsuario.dao.AdministradorDAO;
import pe.edu.pucp.softProg.gestUsuario.mysql.AdministradorMYSQL;
import pe.edu.pucp.softprog.getUsuario.model.Administrador;

/**
 *
 * @author JOHAR
 */
public class AdministradorDAOTest {
    
    private int resultado;
    private AdministradorDAO daoAdmin;
    
    
    public AdministradorDAOTest() {
    }
    
    
    @BeforeAll
    public static void setUpClass(){
    }
    
    @AfterAll
    public static void tearDownClass(){    
    }
    
    @BeforeEach
    public void setUp(){
        daoAdmin = new AdministradorMYSQL();
    }
    
    @AfterEach
    public void tearDown(){
    }
    
    
     @Test
     public void verificarRegistro() {
        Administrador admin = new Administrador(
        "Kantoná", "Erick Soza", "cantona@gmail.com", "polar536", "99358846", 1,
        "admiCantona", LocalDateTime.now(), "Jefe");
        
        //AdministradorDAO daoAdmin = new AdministradorMYSQL();
        resultado = daoAdmin.insertar(admin);
         assertTrue(resultado!=0);
     }
     @Test
     public void verificarEliminar(){
        //AdministradorDAO daoAdmin = new AdministradorMYSQL();
        resultado = daoAdmin.eliminar(27);
        assertTrue(resultado!=0); 
     }
     
}
