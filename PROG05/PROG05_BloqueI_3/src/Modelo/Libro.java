package Modelo;

public class Libro {

    // ATRIBTOS
    private String titulo;
    private String autor;
    private int numEjemplares;
    private int numEjemplaresPrestados;
    // Ej 5 (con menú)
    private MenuLibro menu;

    // MÉTODOS
    // Getters + Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public int getNumEjemplaresPrestados() {
        return numEjemplaresPrestados;
    }

    public void setNumEjemplaresPrestados(int numEjemplaresPrestados) {
        this.numEjemplaresPrestados = numEjemplaresPrestados;
    }

    public MenuLibro getMenu() {
        return menu;
    }

    public void setMenu(MenuLibro menu) {
        this.menu = menu;
    }

    // toString
    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", numEjemplares=" + numEjemplares + ", numEjemplaresPrestados=" + numEjemplaresPrestados + '}';
    }

    // Constructores
    // Por defecto
    public Libro() {
        this.menu = new MenuLibro();
    }

    // Con parámetros
    public Libro(String titulo, String autor, int numEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = numEjemplares;
        this.menu = new MenuLibro();
    }

    // Método para prestar un libro
    public boolean prestamo() {
        boolean prestado = false;
        if (this.getNumEjemplaresPrestados() < this.numEjemplares) {
            this.numEjemplaresPrestados++;
            prestado = true;
        } else {
            prestado = false;
        }
        return prestado;
    }

    // Método para devolver un libro
    public boolean devolucion() {
        boolean devuelto = false;
        if (this.getNumEjemplaresPrestados() > 0) {
            this.numEjemplaresPrestados--;
            devuelto = true;
        } else {
            devuelto = false;
        }
        return devuelto;
    }

}
