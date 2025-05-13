
package pe.edu.pucp.softprogmodel.getUsuario;

public class Juridica extends Persona {
    private int id_juridica;
    private String ruc;
    private String razonSocial;
    private String representanteLegal;

    public Juridica() {
    }
    
    public Juridica(Usuario usuario, String nombres, String apellidos, String telefono
            ,String ruc, String razonSocial, String representanteLegal) {
        super(usuario, nombres, apellidos, telefono);
        this.id_juridica = super.getId();//probemos
        this.ruc = ruc;
        this.representanteLegal = representanteLegal;
        this.razonSocial = razonSocial;
    }
    
    public Juridica(String ruc, String razonSocial, String representanteLegal) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.representanteLegal = representanteLegal;
    }

    public int getId_juridica() {
        return id_juridica;
    }

    public void setId_juridica(int id_juridica) {
        this.id_juridica = id_juridica;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
    
    
    
}
