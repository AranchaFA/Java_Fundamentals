package ejer1.Modelo;

public class Ascensor {

    private Persona p1, p2, p3, p4;
    private AlarmaAscensor alarma;
    private String nombre;
    private float pesoMax;

    public Persona getP1() {
        return p1;
    }

    public void setP1(Persona p1) {
        this.p1 = p1;
    }

    public Persona getP2() {
        return p2;
    }

    public void setP2(Persona p2) {
        this.p2 = p2;
    }

    public Persona getP3() {
        return p3;
    }

    public void setP3(Persona p3) {
        this.p3 = p3;
    }

    public Persona getP4() {
        return p4;
    }

    public void setP4(Persona p4) {
        this.p4 = p4;
    }

    public AlarmaAscensor getAlarma() {
        return alarma;
    }

    public void setAlarma(AlarmaAscensor alarma) {
        this.alarma = alarma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(float pesoMax) {
        this.pesoMax = pesoMax;
    }

    @Override
    public String toString() {
        return "Ascensor{" + "p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + ", alarma=" + alarma + ", nombre=" + nombre + ", pesoMax=" + pesoMax + '}';
    }

    public Ascensor(String nombre, float pesoMax) {
        this.nombre = nombre;
        this.pesoMax = pesoMax;
        this.alarma = new AlarmaAscensor("alarmaAScensor", pesoMax);
    }

    // Devuelve el peso de las personas que se intentan subir o que ya están subidas
    // Meto comentarios porque no puedo sacar true o false para comprobar en el main
    public float subirPersonas() {
        float pesoPersonas;
        if (this.p1 == null) {
            this.p1 = new Persona("p1");
            this.p2 = new Persona("p2");
            this.p3 = new Persona("p3");
            this.p4 = new Persona("p4");
            pesoPersonas = this.p1.getPeso() + this.p2.getPeso() + this.p3.getPeso() + this.p4.getPeso();
            if (!this.alarma.activar(pesoPersonas)) {
                System.out.println("Se han podido subir");
            } else {
                this.p1 = null;
                this.p2 = null;
                this.p3 = null;
                this.p4 = null;
                System.out.println("Peso excesivo!"+'\n'+"Peso total de las personas "+pesoPersonas);
            }
        } else {
            pesoPersonas = this.p1.getPeso() + this.p2.getPeso() + this.p3.getPeso() + this.p4.getPeso();
            System.out.println("Ascensor ocupado");
        }

        return pesoPersonas;
    }
    // Devuelve si el ascensor estaba lleno o no
    public boolean bajarPersonas(){
        boolean auxReturn;
        if(this.p1==null){
            auxReturn=false;
            this.alarma.desactivar();
        }
        else {
            auxReturn=true;
            this.alarma.desactivar();
            this.p1=null;
            this.p2=null;
            this.p3=null;
            this.p4=null;
        }
        return auxReturn;
    }
}
