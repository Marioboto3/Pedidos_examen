package edu.upc.dsa.models;

public class Producto implements Comparable<Producto> {

    String nombre;
    double precio;
    int ventas;
    String id;

    public Producto(String nombre, double precio, String id) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getVentas() {
        return ventas;
    }

    public String getId() {
        return this.id;
    }

    public int compareTo(Producto o) {
        /*return this.precio.compareTo(o.getPrecio()) ;*/
        return 0;
    }

    @Override
    public String toString() {
        return "Product [id="+id+", price=" + this.precio + ", sells=" + this.ventas +"]";
    }
}
