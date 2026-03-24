package org.example.preExamen;

public enum metodoPago {
    PAYPAL(0.5),
    BIZUM(1),
    APPLEPAY(1.5);

    private double precio;

    metodoPago(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
