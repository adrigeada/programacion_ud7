package org.example.ReservaPistas;

public class Padel extends Pista{
    private String paredes;

    public Padel(String tipo, int id,String paredes) {
        super(tipo, id);
        this.paredes = paredes;
    }

    public String getParedes() {
        return paredes;
    }

    public void setParedes(String paredes) {
        this.paredes = paredes;
    }

    @Override
    public String toString() {
        return "Padel{" +
                "paredes='" + paredes + '\'' +
                "} " + super.toString();
    }
}
