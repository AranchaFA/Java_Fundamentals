
public class Dado {
    
    private int resultado;

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public Dado() {
    }
    
    public int lanzarDado (){
        resultado=(int) (Math.random()*6+1);
        return resultado;
    }
}
