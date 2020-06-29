
package Ejercicio03.modelo;

/**
 *
 * @author Shaila
 */
public class Programas {
    
    private String cod_prod;
    private String nombre;
    private String version;

    public Programas() {
    }
    
    public Programas(String cod_prod, String nombre,String version) {
        this.cod_prod = cod_prod;
        this.nombre = nombre;
        this.version = version;
    }

    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Programas{" + "cod_prod=" + cod_prod + ", nombre=" + nombre + ", version=" + version + '}';
    }

     
}
