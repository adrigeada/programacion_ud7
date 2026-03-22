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

    /**
     * Recibe un importe y lo suma al importeTotal
     * @param importe
     */
    public void actualizarImporteTotal(double importe){
        importeTotal+=importe;
        System.out.println("Importe total del pedido: "+importeTotal+"€");
    }

    /**
     * Comprueba si en el pedido hay productos mayores de 3 y/o divisibles entre 3. Si los hay, aplica el descuento de 3x2 al importe total
     */
    public void aplicarPromo3x2(){

        for (Map.Entry<Producto,Integer> mapita : pedidoMapa.entrySet()){
            if (mapita.getValue() % 3 == 0 ){
                importeTotal = importeTotal-mapita.getKey().getPrecio()*(mapita.getValue())/3;
            } else if (mapita.getValue() > 3) {
                int resta = mapita.getValue()/3;
                double restaTotal = mapita.getKey().getPrecio()*resta;

                importeTotal = importeTotal-restaTotal;

            }
        }

    }

    /**
     * Le aplica un 10% de descuento al importe total
     */
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
