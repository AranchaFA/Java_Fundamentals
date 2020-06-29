
public class Metodos {
    
    Integer[][] arrayIntegers = new Integer[3][3];

    
    public static boolean comprobarIntegerEnArray(Integer[][] arrayIntegers,int numero){
         for (Integer[] fila : arrayIntegers) {
                for (Integer integer : fila) {
                    if (integer == integerGenerado) {
                        yaExiste = true;
                    }
                }
            }
    }
        boolean yaExiste = false;
        while (arrayIntegers[2][2] == null) {
            // Generamos un Integer aleatorio entre 0 y 8
            int intGenerado = (int) (Math.random() * 9);
            Integer integerGenerado = Integer.valueOf(intGenerado);
            // Comprobamos si ya está en el array
            for (Integer[] fila : arrayIntegers) {
                for (Integer integer : fila) {
                    if (integer == integerGenerado) {
                        yaExiste = true;
                    }
                }
            }
            // Si no está en el array lo guardamos en la primera posición vacía
            if (!yaExiste) {
                int fila = 0;
                int columna = 0;
                boolean grabado = false;
                while (fila < 3 && grabado == false) {
                    while (columna < 3 && grabado == false) {
                        if (arrayIntegers[fila][columna] == null) {
                            arrayIntegers[fila][columna] = integerGenerado;
                            grabado = true;
                        }
                        columna++;
                    }
                    fila++;
                }
            }
            // Mostramos el array para ver que se añadió
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(arrayIntegers[i][j].toString()+" ");
                }
            }
            
        }
    
}
