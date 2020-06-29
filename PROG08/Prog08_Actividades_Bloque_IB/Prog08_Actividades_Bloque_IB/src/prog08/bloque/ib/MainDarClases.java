package prog08.bloque.ib;

public class MainDarClases {

    public static void main(String[] args) {
        int numAula = 20;
        String materia = "Matematicas";
        int numAlumnos = 20;

        Aula aula = new Aula(numAula, materia, numAlumnos);
        aula.crearAlumnos();

        System.out.println(aula.toString());
        aula.darClase();
    }

}
