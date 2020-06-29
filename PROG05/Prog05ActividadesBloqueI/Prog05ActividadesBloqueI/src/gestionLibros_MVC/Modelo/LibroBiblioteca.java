package gestionLibros_MVC.Modelo;

public class LibroBiblioteca {

    private Libro libro;
    private int prestados;
    private int totalEjemplares;
    
        //constructor con parámetros
    public LibroBiblioteca(String titulo, String autor, int totalEjemplares) {
        libro = new Libro(titulo, autor);
        this.totalEjemplares = totalEjemplares;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    
     public int getTotalEjemplares() {
        return totalEjemplares;
    }

    public void setTotalEjemplares(int totalEjemplares) {
        this.totalEjemplares = totalEjemplares;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }
    
    //método para realizar el prestamo de un libro
    public boolean prestamo() {
        boolean prestado = true;
        if (prestados < totalEjemplares) {
           prestados++;
        } else {
            prestado = false;
        }
        return prestado;
    }

    //método para realizar la devolución de un libro
    public boolean devolucion() {
        boolean devuelto = true;
        if (prestados== 0) {
            devuelto = false;
        } else {
            prestados--;
        }
        return devuelto;
    }

    @Override
    public String toString() {
        return "LibroBiblioteca{" + "libro=" + libro + ", Total de ejemplares=" + totalEjemplares + ", prestados=" + prestados + '}';
    }

    
    
}
