/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Arancha
 */
public class Depart {

    // ATRIBUTOS
    private int dept_no;
    private String dept_nombre;
    private String dept_loc;

    // MÉTODOS
    // Getters + Setters
    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDept_nombre() {
        return dept_nombre;
    }

    public void setDept_nombre(String dept_nombre) {
        this.dept_nombre = dept_nombre;
    }

    public String getDept_loc() {
        return dept_loc;
    }

    public void setDept_loc(String dept_loc) {
        this.dept_loc = dept_loc;
    }

    // toString
    @Override
    public String toString() {
        return "Depart{" + "dept_no=" + dept_no + ", dept_nombre=" + dept_nombre + ", dept_loc=" + dept_loc + '}';
    }

    // Constructor
    public Depart(int dept_no, String dept_nombre, String dept_loc) {
        this.dept_no = dept_no;
        this.dept_nombre = dept_nombre;
        this.dept_loc = dept_loc;
    }

}
