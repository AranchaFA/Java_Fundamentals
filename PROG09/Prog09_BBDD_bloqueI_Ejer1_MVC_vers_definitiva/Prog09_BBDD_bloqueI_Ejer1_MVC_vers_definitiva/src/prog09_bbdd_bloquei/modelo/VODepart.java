
package prog09_bbdd_bloquei.modelo;

public class VODepart {
    private int dept_no;
    private String nomDepart;
    private String localidad;

    public VODepart() {
    }

    public VODepart(int dept_no, String nomDepart, String localidad) {
        this.dept_no = dept_no;
        this.nomDepart = nomDepart;
        this.localidad = localidad;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "VODepart{" + "dept_no=" + dept_no + ", nomDepart=" + nomDepart + ", localidad=" + localidad + '}';
    }
}
