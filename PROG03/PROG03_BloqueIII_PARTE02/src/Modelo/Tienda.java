
package Modelo;

public class Tienda {
    
    // ATRIBUTOS
    private String nombre;
    private String cif;
    private String direccion;
    private Producto producto1,producto2,producto3;
    
    // MÉTODOS
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Producto getProducto2() {
        return producto2;
    }

    public void setProducto2(Producto producto2) {
        this.producto2 = producto2;
    }

    public Producto getProducto3() {
        return producto3;
    }

    public void setProducto3(Producto producto3) {    
        this.producto3 = producto3;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tienda{" + "nombre=" + nombre + ", cif=" + cif + '}';
    }

    public Tienda(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
    }
    
    public float venta(Producto producto){
        float importe=producto.getPeso()*producto.getPrecio();
        return importe;
    }
    
    public Producto masCaro(){
        if(this.producto1.getPrecio()>this.producto2.getPrecio()){
            if(this.producto1.getPrecio()>this.producto3.getPrecio()){
                return this.producto1;
            }
            else {
                return this.producto3;
            }
        }
        else {
            if(this.producto2.getPrecio()>this.producto3.getPrecio()) {
                return this.producto2;
            }
            else {
                return this.producto3;
            }
        }
    }
}
