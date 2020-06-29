package Modelo;

public class ContadorDinero {

    private float cantidadDinero;

    private int billetes500;
    private int billetes200;
    private int billetes100;
    private int billetes50;
    private int billetes20;
    private int billetes10;
    private int billetes5;

    private int moneas2E;
    private int moneas1E;
    private int moneas50c;
    private int moneas20c;
    private int moneas10c;
    private int moneas5c;
    private int moneas2c;
    private int moneas1c;

    // GETTERS Y SETTERS
    public float getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(long cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public int getBilletes500() {
        return billetes500;
    }

    public void setBilletes500(int billetes500) {
        this.billetes500 = billetes500;
    }

    public int getBilletes200() {
        return billetes200;
    }

    public void setBilletes200(int billetes200) {
        this.billetes200 = billetes200;
    }

    public int getBilletes100() {
        return billetes100;
    }

    public void setBilletes100(int billetes100) {
        this.billetes100 = billetes100;
    }

    public int getBilletes50() {
        return billetes50;
    }

    public void setBilletes50(int billetes50) {
        this.billetes50 = billetes50;
    }

    public int getBilletes20() {
        return billetes20;
    }

    public void setBilletes20(int billetes20) {
        this.billetes20 = billetes20;
    }

    public int getBilletes5() {
        return billetes5;
    }

    public void setBilletes5(int billetes5) {
        this.billetes5 = billetes5;
    }

    public int getMoneas2E() {
        return moneas2E;
    }

    public void setMoneas2E(int moneas2E) {
        this.moneas2E = moneas2E;
    }

    public int getMoneas1E() {
        return moneas1E;
    }

    public void setMoneas1E(int moneas1E) {
        this.moneas1E = moneas1E;
    }

    public int getMoneas50c() {
        return moneas50c;
    }

    public void setMoneas50c(int moneas50c) {
        this.moneas50c = moneas50c;
    }

    public int getMoneas20c() {
        return moneas20c;
    }

    public void setMoneas20c(int moneas20c) {
        this.moneas20c = moneas20c;
    }

    public int getMoneas10c() {
        return moneas10c;
    }

    public void setMoneas10c(int moneas10c) {
        this.moneas10c = moneas10c;
    }

    public int getMoneas5c() {
        return moneas5c;
    }

    public void setMoneas5c(int moneas5c) {
        this.moneas5c = moneas5c;
    }

    public int getMoneas2c() {
        return moneas2c;
    }

    public void setMoneas2c(int moneas2c) {
        this.moneas2c = moneas2c;
    }

    public int getMoneas1c() {
        return moneas1c;
    }

    public void setMoneas1c(int moneas1c) {
        this.moneas1c = moneas1c;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "ContadorDinero{" + '\n' + "CantidadDinero=" + cantidadDinero + '\n' + "Billetes500=" + billetes500 + '\n' + "Billetes200=" + billetes200 + '\n' + "Billetes100=" + billetes100 + '\n' + "Billetes50=" + billetes50 + '\n' + "Billetes20=" + billetes20 + '\n' + "Billetes10=" + billetes10 + '\n' + "Billetes5=" + billetes5 + '\n' + "Moneas2E=" + moneas2E + '\n' + "Moneas1E=" + moneas1E + '\n' + "Moneas50c=" + moneas50c + '\n' + "Moneas20c=" + moneas20c + '\n' + "Moneas10c=" + moneas10c + '\n' + "Moneas5c=" + moneas5c + '\n' + "Moneas2c=" + moneas2c + '\n' + "Moneas1c=" + moneas1c + '\n' + '}';
    }

    // CONSTRUCTOR
    public ContadorDinero() {
    }

    /*   Método para verificar que la cantidad introducida está en un rango válido
         y asignarla al atributo cantidadDinero
     */
    public boolean introducirCantidadDinero(float cantidadDinero) {
        boolean auxReturn;
        // Comprobamos que no tiene más de dos decimales
        if ((cantidadDinero * 100) / ((int) (cantidadDinero * 100)) != 1) {
            auxReturn = false;
        } else {
            this.cantidadDinero = cantidadDinero;
            auxReturn = true;
        }
        return auxReturn;
    }

    /*  
    Método para desglosar la cantidad de dinero (está en céntimos!)
     */
    public void desglosarCantidadDinero() {
        // Pasamos la cantidad a céntimos para que quede un int como los atributos
        // Usamos un auxiliar para no modificar el valor del atributo en el proceso
        float auxCantidadDinero = this.cantidadDinero * 100;
        while (auxCantidadDinero - 50000 >= 0) {
            auxCantidadDinero -= 50000;
            this.billetes500++;
        }
        while (auxCantidadDinero - 20000 >= 0) {
            auxCantidadDinero -= 20000;
            this.billetes200++;
        }
        while (auxCantidadDinero - 10000 >= 0) {
            auxCantidadDinero -= 10000;
            this.billetes100++;
        }
        while (auxCantidadDinero - 5000 >= 0) {
            auxCantidadDinero -= 5000;
            this.billetes50++;
        }
        while (auxCantidadDinero - 2000 >= 0) {
            auxCantidadDinero -= 2000;
            this.billetes20++;
        }
        while (auxCantidadDinero - 1000 >= 0) {
            auxCantidadDinero -= 1000;
            this.billetes10++;
        }
        while (auxCantidadDinero - 500 >= 0) {
            auxCantidadDinero -= 500;
            this.billetes5++;
        }
        while (auxCantidadDinero - 200 >= 0) {
            auxCantidadDinero -= 200;
            this.moneas2E++;
        }
        while (auxCantidadDinero - 100 >= 0) {
            auxCantidadDinero -= 100;
            this.moneas1E++;
        }
        while (auxCantidadDinero - 50 >= 0) {
            auxCantidadDinero -= 50;
            this.moneas50c++;
        }
        while (auxCantidadDinero - 20 >= 0) {
            auxCantidadDinero -= 20;
            this.moneas20c++;
        }
        while (auxCantidadDinero - 10 >= 0) {
            auxCantidadDinero -= 10;
            this.moneas10c++;
        }
        while (auxCantidadDinero - 5 >= 0) {
            auxCantidadDinero -= 5;
            this.moneas5c++;
        }
        while (auxCantidadDinero - 2 >= 0) {
            auxCantidadDinero -= 2;
            this.moneas2c++;
        }
        while (auxCantidadDinero - 1 >= 0) {
            auxCantidadDinero -= 1;
            this.moneas1c++;
        }

    }

    /*
    Método para visualizar la cifra con asteriscos (Ej. 2)
     */
    public void resultadoConAsteriscos() {
        System.out.println("Cantidad: " + this.cantidadDinero);

        System.out.print("Billetes de 500: " + this.billetes500);
        for (int i = 0; i < this.billetes500; i++) {
            System.out.print("*");
            if (i == this.billetes500 - 1) {
                System.out.println("");
            }
        }
        System.out.print("Billetes de 200: " + this.billetes200);
        for (int i = 0; i < this.billetes200; i++) {
            System.out.print("*");
            if (i == this.billetes200 - 1) {
                System.out.println("");
            }
        }
        System.out.print("Billetes de 100: " + this.billetes100);
        for (int i = 0; i < this.billetes100; i++) {
            System.out.print("*");
            if (i == this.billetes100 - 1) {
                System.out.println("");
            }
        }
        System.out.print("Billetes de 50: " + this.billetes50);
        for (int i = 0; i < this.billetes50; i++) {
            System.out.print("*");
            if (i == this.billetes50 - 1) {
                System.out.println("");
            }
        }
        System.out.print("Billetes de 20: " + this.billetes20);
        for (int i = 0; i < this.billetes20; i++) {
            System.out.print("*");
            if (i == this.billetes20 - 1) {
                System.out.println("");
            }
        }
        System.out.print("Billetes de 10: " + this.billetes10);
        for (int i = 0; i < this.billetes10; i++) {
            System.out.print("*");
            if (i == this.billetes10 - 1) {
                System.out.println("");
            }
        }
        System.out.print("Billetes de 5: " + this.billetes5);
        for (int i = 0; i < this.billetes5; i++) {
            System.out.print("*");
            if (i == this.billetes5 - 1) {
                System.out.println("");
            }
        }
        System.out.print("Monedas de 2: " + this.moneas2E);
        for (int i = 0; i < this.moneas2E; i++) {
            System.out.print("*");
            if (i == this.moneas2E - 1) {
                System.out.println("");
            }
        }
        System.out.print("Monedas de 1: " + this.moneas1E);
        for (int i = 0; i < this.moneas1E; i++) {
            System.out.print("*");
            if (i == this.moneas1E - 1) {
                System.out.println("");
            }
        }
        System.out.print("Monedas de 0.50: " + this.moneas50c);
        for (int i = 0; i < this.moneas2E; i++) {
            System.out.print("*");
            if (i == this.moneas2E - 1) {
                System.out.println("");
            }
        }
        System.out.print("Monedas de 0.20: " + this.moneas20c);
        for (int i = 0; i < this.moneas20c; i++) {
            System.out.print("*");
            if (i == this.moneas20c - 1) {
                System.out.println("");
            }
        }
        System.out.print("Monedas de 0.10: " + this.moneas10c);
        for (int i = 0; i < this.moneas10c; i++) {
            System.out.print("*");
            if (i == this.moneas10c - 1) {
                System.out.println("");
            }
        }
        System.out.print("Monedas de 0.05: " + this.moneas5c);
        for (int i = 0; i < this.moneas5c; i++) {
            System.out.print("*");
            if (i == this.moneas5c - 1) {
                System.out.println("");
            }
        }
        System.out.print("Monedas de 0.02: " + this.moneas2c);
        for (int i = 0; i < this.moneas2c; i++) {
            System.out.print("*");
            if (i == this.moneas2c - 1) {
                System.out.println("");
            }
        }
        System.out.print("Monedas de 0.01: " + this.moneas1c);
        for (int i = 0; i < this.moneas1c; i++) {
            System.out.print("*");
            if (i == this.moneas1c - 1) {
                System.out.println("");
            }
        }
    }
}
