
package Exceptions;

public class MyException extends Exception {

    // MÉTODOS
    // Constructores (con / sin message)
    public MyException() {
    }

    public MyException(String myMessage) {
        super(myMessage);
    }

}
