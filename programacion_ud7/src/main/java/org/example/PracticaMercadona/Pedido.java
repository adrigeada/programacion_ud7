package org.example.PracticaMercadona;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    static final double DESCUENTO =0.90;

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

        for (Map.Entry<Producto,Integer> mapita : pedidoMapa.entrySet()){
            if (mapita.getValue() % 3 == 0 ){
                importeTotal = importeTotal-mapita.getKey().getPrecio()*(mapita.getValue())/3;
            } else if (mapita.getValue() > 3) {
                int resta = mapita.getValue()/3;
                System.out.println(resta);
                double restaTotal = mapita.getKey().getPrecio()*resta;

                importeTotal = importeTotal-restaTotal;

            }
        }

    }

    public void aplicarPromo10(){
        importeTotal = importeTotal*DESCUENTO;

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
