package Modelo;

public class Cosa {

    // ATRIBUTOS
    private int idCosa;
    private String nombreCosa;
    private int numeroTotal;
    private int numeroPrestados;

    // MÉTODOS
    // Getters + Setters
    public int getIdCosa() {
        return idCosa;
    }

    public void setIdCosa(int idCosa) {
        this.idCosa = idCosa;
    }

    public String getNombreCosa() {
        return nombreCosa;
    }

    public void setNombreCosa(String nombreCosa) {
        this.nombreCosa = nombreCosa;
    }

    // toString
    @Override
    public String toString() {
        return "Cosa{" + "idCosa=" + idCosa + ", nombreCosa=" + nombreCosa + ", numeroTotal=" + numeroTotal + ", numeroPrestados=" + numeroPrestados + '}';
    }

    // Constructor
    public Cosa(int idCosa, int numeroTotal) {
        this.idCosa = idCosa;
        this.numeroTotal = numeroTotal;
    }

    // Método para prestar una cosa
    public boolean prestarCosa() {
        boolean auxReturn;
        if (this.numeroPrestados < this.numeroTotal) {
            this.numeroPrestados++;
            auxReturn = true;
        } else {
            auxReturn = false;
        }
        return auxReturn;
    }

    // Método para devolver una cosa
    public boolean devolverCosa() {
        boolean auxReturn;
        if (this.numeroPrestados==0) {
            auxReturn=false;
        } else {
            this.numeroPrestados--;
            auxReturn=true;
        }

        return auxReturn;
    }

}
