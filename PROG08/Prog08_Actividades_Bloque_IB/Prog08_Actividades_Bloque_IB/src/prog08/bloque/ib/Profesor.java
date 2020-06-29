
package prog08.bloque.ib;

public class Profesor extends Persona{
        private String materia;
    private static final String[] MATERIAS = {"Matematicas", "Filosofia", "Fisica"};

    
    public Profesor(String nombre) {
        super(nombre); //asigna nombre al atributo del padre Persona
        
        int numMateria; //generamos la materia
        
        numMateria = (int) (Math.random()*3);
        materia = MATERIAS[numMateria];
        
        //comprobamos su disponibilidad
        disponibilidad();
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    public void disponibilidad(){
        int probabilidadAsistencia= (int)(Math.random()*101);
        if (probabilidadAsistencia>20)
            super.setAsistencia(true);
        else 
            super.setAsistencia(false);
    }

    @Override
    public String toString() {
        return " Profesor{" + "materia=" + materia +' ' + super.toString()+'}';
    }

}
