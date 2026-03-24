package org.example.preExamen;

import java.time.LocalDate;

public class Concierto extends Evento{

    private String artista;

    public Concierto(String nombre, LocalDate fecha, double precio,String artista) {
        super(nombre, fecha, precio);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Concierto{" +
                "artista='" + artista + '\'' +
                "} " + super.toString();
    }

    @Override
    public int compareTo(Evento o) {
        int comparar = getFecha().compareTo(o.getFecha());

        if (comparar!=0){
            return comparar;
        }

        return 0;
    }
}
