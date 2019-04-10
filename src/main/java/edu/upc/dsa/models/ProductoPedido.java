package edu.upc.dsa.models;

public class ProductoPedido {

    String id;
    int cantidad;

    public ProductoPedido(String id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
