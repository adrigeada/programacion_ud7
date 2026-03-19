package org.example.PracticaMercadona;

import java.util.HashMap;

public class Pedido {
    private HashMap<Producto,Integer> pedidoMapa;
    private double importeTotal;

    public Pedido() {
        pedidoMapa = new HashMap<>();
        importeTotal = 0;
    }

    public void actualizarImporteTotal(double importe){
        importeTotal+=importe;
        System.out.println("Importe total del pedido: "+importeTotal+"€");
    }

    public void aplicarPromo3x2(){

    }

    public void aplicarPromo10(){

    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public HashMap<Producto, Integer> getPedidoMapa() {
        return pedidoMapa;
    }

    public void setPedidoMapa(HashMap<Producto, Integer> pedidoMapa) {
        this.pedidoMapa = pedidoMapa;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "pedido=" + pedidoMapa +
                ", importeTotal=" + importeTotal +
                '}';
    }
}
