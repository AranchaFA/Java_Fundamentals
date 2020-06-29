
package rectangulo;

public class MainRectangulo {

    public static void main(String[] args) {
        
        Rectangulo rect1 = new Rectangulo(4,10,false);
        rect1.pintarRectangulo();
        System.out.println("\n\n");
        Rectangulo rect2 = new Rectangulo(4,10,true);
        rect2.pintarRectangulo();
    }
    
}
