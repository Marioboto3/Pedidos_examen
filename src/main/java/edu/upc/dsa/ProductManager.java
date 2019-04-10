package edu.upc.dsa;

import edu.upc.dsa.models.*;

import java.util.List;

public interface ProductManager {

    public Producto addProducto(String nombre, int precio, String id);

    public Pedido crearPedido(List<ProductoPedido> lista, int idUsuario) throws QueueFullException;

    public Pedido sacarPedido() throws QueueEmptyException;

    public Usuario addUsuario(String nombre, String apellido, int edad, int id);

    public List<Producto> precioAscendente();

    public List<Pedido> pedidosRealizados(int idUsuario);

    public List<Producto> ventasDescendente();

    public Producto findByIdProducto(String id);

    public Usuario findByIdUsuario(int id);

    public int sizeProductos();

    public int sizeUsuarios();

    public int sizeQueue();

}
