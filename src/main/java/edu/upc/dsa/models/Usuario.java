package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellido;
    private int edad;
    private int id;
    private List<Pedido> listadoPedidos;

    public Usuario(String nombre, String apellido, int edad, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id=id;
        this.listadoPedidos= new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Pedido> getListadoPedidos() {
        return listadoPedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setListadoPedidos(List<Pedido> listadoPedidos) {
        this.listadoPedidos = listadoPedidos;
    }

    public void añadirPedido(Pedido pedido){
        this.listadoPedidos.add(pedido);
    }
}
