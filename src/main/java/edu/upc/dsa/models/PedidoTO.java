package edu.upc.dsa.models;

import java.util.List;

public class PedidoTO {

    List<ProductoPedido> listaProductos;
    int idUsuario;

    public PedidoTO(List<ProductoPedido> lista, int idUsuario) {

        this.listaProductos = lista;
        this.idUsuario=idUsuario;
    }

    public List<ProductoPedido> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoPedido> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
