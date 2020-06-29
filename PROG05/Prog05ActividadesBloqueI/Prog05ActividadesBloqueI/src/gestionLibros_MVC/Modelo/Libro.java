package gestionLibros_MVC.Modelo;

 public class Libro {
    private String titulo;
    private String autor;


    //constructor por defecto
    public Libro() {
    }

    //constructor con parámetros
    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    //getters y setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
  

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    //método toString sobrescrito para mostrar los datos de la clase Libro

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + '}';
    }
  
   
}