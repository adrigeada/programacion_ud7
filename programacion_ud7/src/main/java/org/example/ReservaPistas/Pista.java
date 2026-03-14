package org.example.ReservaPistas;

public abstract class Pista {

    private String tipo;
    private int id;

    public Pista(String tipo, int id){
        this.tipo = tipo;
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pista{" +
                "tipo='" + tipo + '\'' +
                ", id=" + id +
                '}';
    }
}
