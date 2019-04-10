package edu.upc.dsa.services;

import edu.upc.dsa.ProductManager;
import edu.upc.dsa.ProductManagerImpl;
import edu.upc.dsa.TracksManager;
import edu.upc.dsa.TracksManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Api(value = "/pedido", description = "Endpoint to Pedido Service")
@Path("/pedido")
public class PedidoService {

    private ProductManager pm;

    public PedidoService() throws QueueFullException {

        this.pm = ProductManagerImpl.getInstance();
        if (pm.sizeProductos()==0) {

            Producto p = pm.addProducto("Cbo", 5, "cbo");
            Producto q = pm.addProducto("Patatas", 2, "patatas");
            Producto r = pm.addProducto("Bebida", 1, "bebidas");

            ProductoPedido a = new ProductoPedido("cbo",1);

            Usuario u = pm.addUsuario("Mario", "Sanchez", 21, 1);
            Usuario v = pm.addUsuario("Carlo","Gattuso",20, 2);

            List<ProductoPedido> lista = new ArrayList<>();
            lista.add(a);

            Pedido f = pm.crearPedido(lista,1);
            }
        }

    @POST
    @ApiOperation(value = "crea un Pedido", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= PedidoTO.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPedido(PedidoTO pedidoTO) throws QueueFullException {

        if(pedidoTO==null) return Response.status(500).build();

        Pedido p = pm.crearPedido(pedidoTO.getListaProductos(),pedidoTO.getIdUsuario());

        GenericEntity<Pedido> entity = new GenericEntity<Pedido>(p) {};

        return Response.status(201).entity(entity).build();

    }
    @GET
    @ApiOperation(value = "get a Pedido", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = PedidoTO.class),
            @ApiResponse(code = 404, message = "Pedido not found")
    })
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPedido() throws QueueEmptyException {
        Pedido p = pm.sacarPedido();
        PedidoTO pTO = new PedidoTO(p.getListaProductos(), p.getIdUsuario());
        if (p == null) {
            return Response.status(404).build();
        }
        GenericEntity<PedidoTO> entity = new GenericEntity<PedidoTO>(pTO) {
        };
        return Response.status(201).entity(entity).build();
    }

}
