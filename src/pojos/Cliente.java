package pojos;
// Generated 14-ene-2015 14:44:58 by Hibernate Tools 3.6.0



/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idcliente;
     private String dnicliente;
     private String nombre;
     private String apellido1;
     private String apellido2;
     private String fijo;
     private String movil;
     private String domicilio;

    public Cliente() {
    }

	
    public Cliente(String dnicliente) {
        this.dnicliente = dnicliente;
    }
    public Cliente(String dnicliente, String nombre, String apellido1, String apellido2, String fijo, String movil, String domicilio) {
       this.dnicliente = dnicliente;
       this.nombre = nombre;
       this.apellido1 = apellido1;
       this.apellido2 = apellido2;
       this.fijo = fijo;
       this.movil = movil;
       this.domicilio = domicilio;
    }
   
    public Integer getIdcliente() {
        return this.idcliente;
    }
    
    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }
    public String getDnicliente() {
        return this.dnicliente;
    }
    
    public void setDnicliente(String dnicliente) {
        this.dnicliente = dnicliente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return this.apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return this.apellido2;
    }
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getFijo() {
        return this.fijo;
    }
    
    public void setFijo(String fijo) {
        this.fijo = fijo;
    }
    public String getMovil() {
        return this.movil;
    }
    
    public void setMovil(String movil) {
        this.movil = movil;
    }
    public String getDomicilio() {
        return this.domicilio;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }




}

