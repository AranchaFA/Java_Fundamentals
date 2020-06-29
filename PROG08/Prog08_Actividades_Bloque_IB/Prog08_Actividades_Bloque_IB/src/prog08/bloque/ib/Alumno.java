
package prog08.bloque.ib;

public class Alumno extends Persona {
       private float nota;
    
    public Alumno(String nombre){
        super(nombre);
        this.nota=(float)Math.random()*11;
        //comprobamos su disponibilidad
        disponibilidad();  //se asigna al atributo asistencia en el padre
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    public void disponibilidad()   {
        
        int probabilidadAsistencia=0;
        
        probabilidadAsistencia = (int)(Math.random()*101);
        if (probabilidadAsistencia>50)
            super.setAsistencia(true);
        else 
            super.setAsistencia(false);
 
    }

    @Override
    public String toString() {
        return super.toString()+" Alumno{" + "nota=" + nota + '}';
    }   
    
 
}
