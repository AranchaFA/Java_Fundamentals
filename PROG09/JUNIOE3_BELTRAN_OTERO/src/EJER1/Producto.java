
package EJER1;


public class Producto {
    //atributos
    protected String tipo;
    protected double precio;
    
    //constructor

    public Producto() {
    }
    
    
    public Producto(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }
    
    //get y set
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    public  double retorna_cambio(double dinero){
        double vuelta;
           if(dinero>=precio){
                vuelta=dinero-precio;
           }else{
               System.out.println("DINERO INSUFICIENTE introduzca mas dinero");
               vuelta=0;
           }
          return vuelta;     
               
    }
    
    
    
    
   //to string
    @Override
    public String toString() {
        return "Bebida{" + "tipo=" + tipo + ", precio=" + precio + '}';
    }
    
    
    
    
}
