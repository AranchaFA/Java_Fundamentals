
package prog08.bloque.ib;

public class Aula {
        /*Atributos*/
    private int id;
    private Profesor profesor;
    private Alumno[] alumnos;
    private String materia;

    private final int MAX_ALUM;
    public Aula(int id, String materia, int numAlumnosAula) {
        this.id = id;
        this.materia = materia;
        MAX_ALUM = numAlumnosAula;
        alumnos = new Alumno[MAX_ALUM];
        profesor = new Profesor("prof");
        System.out.println("numAlumnos " + MAX_ALUM);
 
    }

    public void crearAlumnos() {
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i] = new Alumno("alum" + i);
            System.out.println(alumnos[i].toString());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public boolean minAsistenciaAlumnos() {
        int cuentaAsistencias = 0;

        //contamos las asistencias
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].isAsistencia()) {
                cuentaAsistencias++;
            }
        }

        //Muestro la asistencia total
        System.out.println("Hay " + cuentaAsistencias + " alumnos");

        return (cuentaAsistencias >= ((int) (alumnos.length / 2)));  //true si > 50%

    }
    
 public void darClase() {
        if (!minAsistenciaAlumnos()) {
            System.out.println("No hay el número de alumnos suficientes, NO HAY CLASES");
        } else if (!(profesor.isAsistencia())) {
            System.out.println("NO HAY CLASES, el profesor no esta disponible");
        } else if (!(profesor.getMateria().equals(this.materia))) {
            System.out.println("NO HAY CLASES, aula de: " + materia + " no coincide con el "
                    + "profesor de " + profesor.getMateria());
        } else {
            System.out.println("SI HAY CLASES, todos los mínimos se cumplen");
        }
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", profesor=" + profesor.toString() + ", Aula materia=" + materia + ", MAX_ALUM=" + MAX_ALUM + " Asistencia de alumnos: " + minAsistenciaAlumnos() + '}';
    }

}
