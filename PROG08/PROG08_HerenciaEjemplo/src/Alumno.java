
import java.util.Calendar;


public class Alumno extends Persona{
    
    // ATRIBUTOS
    protected String grupo;
    protected HORARIO horario;

    

    // MÉTODOS
    // Getters + Setters
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public HORARIO getHorario() {
        return horario;
    }

    public void setHorario(HORARIO horario) {
        this.horario = horario;
    }
    
    // Constructor
    public Alumno(String nombre, String apellidos, int anhoNacimiento) {
        super(nombre, apellidos, anhoNacimiento);
    }
    public Alumno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // toString
    @Override
    public String toString() {
        // Para mostrar los datos del padre Persona hay que usar su método toString
        // Para usar métodos de clases superiores usamos super.metodo
        return super.toString()+" Alumno{" + "grupo=" + grupo + ", horario=" + horario + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
