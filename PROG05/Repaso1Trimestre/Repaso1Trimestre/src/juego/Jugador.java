package juego;

public class Jugador {
    private String nombre;
    private int vidas;
    private int tirada;

    public Jugador(String nombre) {
        this.nombre = nombre;
        vidas=3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getTirada() {       
        return tirada;
    }
    
    public void tirar(){
        tirada = (int)(Math.random()*10+1);
    }



    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", vidas=" + vidas + ", jugada=" + tirada + '}';
    }   
}
