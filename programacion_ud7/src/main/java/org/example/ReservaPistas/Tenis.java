package org.example.ReservaPistas;

public class Tenis extends Pista {
    private String superficie;

    public Tenis(String tipo, int id) {
        super(tipo, id);
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }


    @Override
    public String toString() {
        return "Tenis{" +
                "superficie='" + superficie + '\'' +
                "} " + super.toString();
    }
}
