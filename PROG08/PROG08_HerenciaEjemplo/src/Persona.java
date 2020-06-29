
public class Persona implements Cloneable{
    
    // ATIBUTOS
    private String nombre;
    private String apellidos;
    private int anhoNacimiento;
    
    // MÉTODOS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAnhoNacimiento() {
        return anhoNacimiento;
    }

    public void setAnhoNacimiento(int anhoNacimiento) {
        this.anhoNacimiento = anhoNacimiento;
    }

   
    // Constructores
    public Persona(String nombre, String apellidos, int anhoNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.anhoNacimiento = anhoNacimiento;
    }

    public Persona() {
    }
    
    // Clone
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void imprime(){
        System.out.println("Datos personales: "+nombre+" "+apellidos+" nació en el año "+anhoNacimiento);
    }
}
