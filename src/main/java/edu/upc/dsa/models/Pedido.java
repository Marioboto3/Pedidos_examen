package edu.upc.dsa.models;

import java.util.List;

public class Pedido {

    List<ProductoPedido> listaProductos;
    int id;
    int contador=0;
    int idUsuario;

    public Pedido(List<ProductoPedido> lista, int idUsuario) {

        this.listaProductos = lista;
        this.id=contador++;
        this.idUsuario=idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<ProductoPedido> getListaProductos() {
        return listaProductos;
    }

    public int getId() {
        return id;
    }

    public void setListaProductos(List<ProductoPedido> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setId(int id) {
        this.id = id;
    }
}
