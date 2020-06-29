package adivinaNumero;

public class NumeroAdivinar {

    private int num;

    public NumeroAdivinar() {
        num = (int) (Math.random() * 100 + 1);
    }

    public int getNum() {
        return num;
    }
    public int comparar(int num){
        //devuelve un 0 si es =, 1 si es mayor y -1 si es menor
        if (this.num==num){
            return 0;
        }
        else if (this.num>num){
            return 1;
        } else
            return -1;
            
    } 

    @Override
    public String toString() {
        return "NumeroAdivinar{" + "num=" + num + '}';
    }    
}
