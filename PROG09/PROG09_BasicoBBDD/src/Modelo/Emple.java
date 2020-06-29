/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Arancha
 */
public class Emple {

    // ATRIBUTOS
    private int emp_no;
    private String emp_nombre;
    private String emp_oficio;
    private int emp_mgr;
    private Date emp_fecalta;
    private int emp_sal;
    private int emp_com;
    private Depart emp_depart;

    // MÉTODOS
    // Getters + Setters
    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_nombre() {
        return emp_nombre;
    }

    public void setEmp_nombre(String emp_nombre) {
        this.emp_nombre = emp_nombre;
    }

    public String getEmp_oficio() {
        return emp_oficio;
    }

    public void setEmp_oficio(String emp_oficio) {
        this.emp_oficio = emp_oficio;
    }

    public int getEmp_mgr() {
        return emp_mgr;
    }

    public void setEmp_mgr(int emp_mgr) {
        this.emp_mgr = emp_mgr;
    }

    public Date getEmp_fecalta() {
        return emp_fecalta;
    }

    public void setEmp_fecalta(Date emp_fecalta) {
        this.emp_fecalta = emp_fecalta;
    }

    public int getEmp_sal() {
        return emp_sal;
    }

    public void setEmp_sal(int emp_sal) {
        this.emp_sal = emp_sal;
    }

    public int getEmp_com() {
        return emp_com;
    }

    public void setEmp_com(int emp_com) {
        this.emp_com = emp_com;
    }

    public Depart getEmp_depart() {
        return emp_depart;
    }

    public void setEmp_depart(Depart emp_depart) {
        this.emp_depart = emp_depart;
    }

    // toString
    @Override
    public String toString() {
        return "Emple{" + "emp_no=" + emp_no + ", emp_nombre=" + emp_nombre + ", emp_oficio=" + emp_oficio + ", emp_mgr=" + emp_mgr + ", emp_fecalta=" + emp_fecalta + ", emp_sal=" + emp_sal + ", emp_com=" + emp_com + ", emp_depart=" + emp_depart + '}';
    }

    // Constructor
    public Emple(int emp_no, String emp_nombre, String emp_oficio, int emp_mgr, Date emp_fecalta, int emp_sal, Depart emp_depart) {
        this.emp_no = emp_no;
        this.emp_nombre = emp_nombre;
        this.emp_oficio = emp_oficio;
        this.emp_mgr = emp_mgr;
        this.emp_fecalta = emp_fecalta;
        this.emp_sal = emp_sal;
        this.emp_depart = emp_depart;
    }

}
