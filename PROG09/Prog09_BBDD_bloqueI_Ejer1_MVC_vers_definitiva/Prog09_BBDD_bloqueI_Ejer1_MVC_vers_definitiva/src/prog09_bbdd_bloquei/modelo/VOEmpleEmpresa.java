package prog09_bbdd_bloquei.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class VOEmpleEmpresa {

    private VOEmple emple;
    private VODepart depart;
    private String oficio;
    // Si jefe fuera VOEmpleEmpresa habría recursividad:
    // el jefe tendría a su vez otro atributo jefe, que tendría otro jefe...
    // Entraríamos en un "bucle infinito".
    private VOEmple jefe; 
    private GregorianCalendar fecha_alta;
    private int salario;
    private int comision;

    public VOEmpleEmpresa() {
    }

    public VOEmpleEmpresa(VOEmple emple, VODepart depart, VOEmple jefe) {
        this.emple = emple;
        this.depart = depart;
        this.jefe = jefe;
    }

    public VOEmpleEmpresa(VOEmple emple, VODepart depart, String oficio, VOEmple jefe, GregorianCalendar fecha_alta, int salario, int comision) {
        this.emple = emple;
        this.depart = depart;
        this.oficio = oficio;
        this.jefe = jefe;
        this.fecha_alta = fecha_alta;
        this.salario = salario;
        this.comision = comision;
    }

    public VOEmple getEmple() {
        return emple;
    }

    public void setEmple(VOEmple emple) {
        this.emple = emple;
    }

    public VODepart getDepart() {
        return depart;
    }

    public void setDepart(VODepart depart) {
        this.depart = depart;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public VOEmple getJefe() {
        return jefe;
    }

    public void setJefe(VOEmple jefe) {
        this.jefe = jefe;
    }

    public GregorianCalendar getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(GregorianCalendar fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    // Para mostrarla bonita, sin toda a información del objeto GregorianCalendar
    public String verFecha() {
        return fecha_alta.get(Calendar.DATE) + "/" + fecha_alta.get(Calendar.MONTH) + "/" + fecha_alta.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return "VOEmpleEmpresa{" + "emple=" + emple + ", depart=" + depart + ", oficio=" + oficio + ", jefe=" + jefe + ", fecha_alta=" + verFecha() + ", salario=" + salario + ", comision=" + comision + '}';
    }

}
