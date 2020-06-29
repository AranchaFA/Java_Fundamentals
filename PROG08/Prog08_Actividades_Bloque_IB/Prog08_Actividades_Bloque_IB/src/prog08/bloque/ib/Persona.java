
package prog08.bloque.ib;

public class Persona {
       /*Atributos*/
    private String nombre;
    private boolean sexoHombre;
    private int edad;
    private boolean asistencia;

    /*Constructores*/
    public Persona(String nombre) {
        this.nombre = nombre;
        this.edad = (int) (18 + (Math.random() * 80));
        //entre 0 y 1
        int determinar_sexo = (int) (Math.random() * 2);
        //Si es 0 es un chico
        if (determinar_sexo == 0) {
            this.sexoHombre = true;
        } else {
            this.sexoHombre = false;
        }

        this.asistencia = false;

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSexoHombre() {
        return sexoHombre;
    }

    public void setSexoHombre(boolean sexoHombre) {
        this.sexoHombre = sexoHombre;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    //metodo para conocer su disponibilidad
    //dependerá de la probabilidad de cada tipo de usuario hijo
    public void disponibilidad() {
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", sexoHombre=" + sexoHombre + ", edad=" + edad + ", asistencia=" + asistencia + '}';
    }
 
}
