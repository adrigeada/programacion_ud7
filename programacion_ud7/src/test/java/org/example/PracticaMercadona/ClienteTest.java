package org.example.PracticaMercadona;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void insertarProducto() {
        //Creo los objetos que necesito para probar el método. Y uso crear pedido para inicializar el pedido del cliente y el mapa de pedido.
        Cliente cliente = new Cliente(null,null);
        cliente.crearPedido();
        HashMap<Producto,Integer> mapa = cliente.getPedido().getPedidoMapa();
        //TESTS

        //Pruebo que el mapa del pedido está vacío al principio. Luego uso el metodo insertarProducto
        // y compruebo que ya no está vacío y que contiene el producto que le hemos insertado.

        assertTrue(mapa.isEmpty());

        cliente.insertarProducto(Producto.PAN);

        assertAll(() -> assertFalse(mapa.isEmpty()),
                () -> assertTrue(mapa.containsKey(Producto.PAN))
        );

    }


}