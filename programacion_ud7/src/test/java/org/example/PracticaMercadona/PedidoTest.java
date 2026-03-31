package org.example.PracticaMercadona;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {


    static Pedido pedido;
    static final double IMPORTE_INICIAL = 100;
    static HashMap<Producto,Integer> mapa;

    @BeforeEach
    void empezarTest(){
        pedido = new Pedido();
        mapa = pedido.getPedidoMapa();
        pedido.setImporteTotal(IMPORTE_INICIAL);

    }

    @Test
    void actualizarImporteTotal() {

        //Se prueba que actualizarImporte suma la cantidad pasada por parámetro
        double importeAgregado = 50;
        pedido.actualizarImporteTotal(importeAgregado);
        double importeActualizado = pedido.getImporteTotal();

            assertEquals(IMPORTE_INICIAL+importeAgregado, importeActualizado);

    }

    @Test
    void aplicarPromo3x2() {

        //Se meten 3 panes en el pedido para hacer la prueba. Y se prueba que se está restando el precio de un pan al importe total
        mapa.put(Producto.PAN,3);
        double precioPan = Producto.PAN.getPrecio();

        pedido.aplicarPromo3x2();
        double importeActualizado = pedido.getImporteTotal();

        assertEquals(IMPORTE_INICIAL-precioPan*(mapa.get(Producto.PAN))/3,importeActualizado);


    }

    @Test
    void aplicarPromo10() {

        //Se comprueba que el método le está quitando un 10% al importe total del pedido.
        pedido.aplicarPromo10();
        double importeActualizado = pedido.getImporteTotal();

        assertEquals(IMPORTE_INICIAL*0.9,importeActualizado);


    }

    @Test
    void promocionesCombinadas(){

        mapa.put(Producto.PAN,3);
        double precioPan = Producto.PAN.getPrecio();

        pedido.aplicarPromo3x2();
        pedido.aplicarPromo10();

        double importeActualizado = pedido.getImporteTotal();

        double importeSupuesto = (IMPORTE_INICIAL-precioPan*(mapa.get(Producto.PAN))/3) * 0.9;

        assertEquals(importeSupuesto,importeActualizado);


    }
}