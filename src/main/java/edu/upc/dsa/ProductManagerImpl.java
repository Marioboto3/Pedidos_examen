package edu.upc.dsa;

import edu.upc.dsa.models.*;

import java.util.HashMap;
import java.util.List;

public class ProductManagerImpl implements ProductManager {

    private static ProductManager instance;
    Queue<Pedido> queuePedidos = new QueueImpl<>(20);
    HashMap<String, Producto> listadoProductos;
    HashMap<Integer, Usuario> listadoUsuarios;

    private ProductManagerImpl(){
        this.listadoProductos=new HashMap<>();
        this.listadoUsuarios=new HashMap<>();
    }

    public static ProductManager getInstance(){
        if (instance==null) instance = new ProductManagerImpl();
        return instance;
    }

    @Override
    public Producto addProducto(String nombre, int precio, String id) {

        Producto p = this.findByIdProducto(id);

        if (p!=null)
        {
        }

        p = new Producto(nombre, precio, id);
        this.listadoProductos.put(id,p);

        return p;
    }

    @Override
    public Pedido crearPedido(List<ProductoPedido> listaProductos, int idUsuario) throws QueueFullException {

        Pedido pedido = new Pedido(listaProductos, idUsuario);
        this.queuePedidos.push(pedido);
        Usuario u = findByIdUsuario(idUsuario);
        u.añadirPedido(pedido);
        return pedido;

    }

    @Override
    public Pedido sacarPedido() throws QueueEmptyException {

        Pedido pedido = this.queuePedidos.pop();
        return pedido;
    }

    @Override
    public Usuario addUsuario(String nombre, String apellido, int edad, int id) {

        Usuario u = findByIdUsuario(id);

        if( u == null)
        {
            u = new Usuario(nombre, apellido, edad, id);
            this.listadoUsuarios.put(id,u);
        }
        return u;
    }

    @Override
    public List<Producto> precioAscendente() {
        return null;
    }

    @Override
    public List<Pedido> pedidosRealizados(int idUsuario) {
        return null;
    }

    @Override
    public List<Producto> ventasDescendente() {
        return null;
    }

    @Override
    public Producto findByIdProducto(String id) {

        Producto p = this.listadoProductos.get(id);

        if (p!= null)
        {
            return p;
        }
        return null;
    }

    @Override
    public Usuario findByIdUsuario(int id) {

        Usuario u = this.listadoUsuarios.get(id);

        if(u != null)
        {
            return u;
        }
        return null;
    }

    @Override
    public int sizeProductos() {
        return this.listadoProductos.size();
    }

    @Override
    public int sizeUsuarios() {
        return this.listadoUsuarios.size();
    }

    @Override
    public int sizeQueue() {
        return this.queuePedidos.size();
    }
}
