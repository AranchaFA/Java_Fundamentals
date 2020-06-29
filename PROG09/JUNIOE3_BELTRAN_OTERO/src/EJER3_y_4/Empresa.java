
package EJER3_y_4;


public class Empresa {
    private String cif;
    private String nombre_empresa;
    private String direccion_empresa;
    private String telefono;

    public Empresa(String cif, String nombre_empresa, String direccion_empresa, String telefono) {
        this.cif = cif;
        this.nombre_empresa = nombre_empresa;
        this.direccion_empresa = direccion_empresa;
        this.telefono = telefono;
    }
    
    
    
    
    

    @Override
    public String toString() {
        return "Empresa{" + "cif=" + cif + ", nombre_empresa=" + nombre_empresa + ", direccion_empresa=" + direccion_empresa + ", telefono=" + telefono + '}';
    }
    
    
    
}
