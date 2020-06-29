package Modelo;

public class Asignatura {
    
    // ATRIBUTOS
    private String nomAsignatura;
    private float eval1,eval2,eval3;
    private float notaMedia;
    
    
    // MÉTODOS
    
    // Getters + Setters
    public String getNomAsignatura() {
        return nomAsignatura;
    }

    public void setNomAsignatura(String nomAsignatura) {
        this.nomAsignatura = nomAsignatura;
    }

    public float getEval1() {
        return eval1;
    }

    public void setEval1(float eval1) {
        this.eval1 = eval1;
    }

    public float getEval2() {
        return eval2;
    }

    public void setEval2(float eval2) {
        this.eval2 = eval2;
    }

    public float getEval3() {
        return eval3;
    }

    public void setEval3(float eval3) {
        this.eval3 = eval3;
    }
    
    // Constructor pasando el nombre
    public Asignatura(String nomAsignatura) {
        this.nomAsignatura = nomAsignatura;
    }
    
    // toString
    @Override
    public String toString() {
        return "Asignatura{" + "nomAsignatura=" + nomAsignatura + ", eval1=" + eval1 + ", eval2=" + eval2 + ", eval3=" + eval3 + ", notaMedia=" + notaMedia + '}';
    }
    
    
    // Método para calcular la nota media de una asignatura
    public float notaMedia(){
        return this.notaMedia=(eval1+eval2+eval3)/3;
    }
    
    
}
