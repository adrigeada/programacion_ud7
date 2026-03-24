package org.example.preExamen;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Festival extends Evento{

    private Set<String> listaArtistas;

    public Festival(String nombre, LocalDate fecha, double precio,Set<String> listaArtistas) {
        super(nombre, fecha, precio);
        this.listaArtistas = listaArtistas;
    }

    public void setArtistas(){

    }

    public Set<String> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(Set<String> listaArtistas) {
        this.listaArtistas = listaArtistas;
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
