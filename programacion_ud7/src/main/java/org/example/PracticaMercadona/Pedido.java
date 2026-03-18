package org.example.PracticaMercadona;

import java.util.HashMap;

public class Pedido {
    private HashMap<Producto,Integer> pedido;
    private double importeTotal;

    public Pedido(HashMap<Producto, Integer> pedido, double importeTotal) {
        this.pedido = pedido;
        this.importeTotal = importeTotal;
    }

    public Pedido(){

    }

    public void actualizarImporteTotal(double importe){

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

    public HashMap<Producto, Integer> getPedido() {
        return pedido;
    }

    public void setPedido(HashMap<Producto, Integer> pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "pedido=" + pedido +
                ", importeTotal=" + importeTotal +
                '}';
    }
}
