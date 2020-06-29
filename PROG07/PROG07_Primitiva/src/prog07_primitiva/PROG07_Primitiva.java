package prog07_primitiva;

public class PROG07_Primitiva {

    public static void main(String[] args) {

        int[] primitiva = new int[7];

        for (int i = 0; i < primitiva.length; i++) {
            if (i < primitiva.length-1) {
                primitiva[i] = (int) (Math.random() * 49 + 1);
            } else {
                primitiva[(primitiva.length)-1] = (int) (Math.random() * 10);
            }
        }

        for (int i = 0; i < primitiva.length; i++) {
            System.out.println("Números ganadores: ");
            if (i < primitiva.length - 1) {
                System.out.print(primitiva[i] + " ");
            } else {
                System.out.println("Reintegro: ");
                System.out.print(primitiva[i] + " ");
            }

        }
    }
}
