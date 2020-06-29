
package Modelo;

public class VOEmple {
    //aquí irian atributos básicos de cualquier empleado genérico
    private int emp_no;
    private String apellido;

    public VOEmple() {
    }

    public VOEmple(int emp_no, String apellido) {
        this.emp_no = emp_no;
        this.apellido = apellido;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "VOEmple{" + "emp_no=" + emp_no + ", apellido=" + apellido + '}';
    }
      
}
