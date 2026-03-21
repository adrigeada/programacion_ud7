package org.example.Aapuntes.comparables;

import java.util.Comparator;

public class OrdenarPorEdadNombreHora implements Comparator<Invitado> {

    @Override
    public int compare(Invitado o1, Invitado o2) {
        int comparar = o1.getEdad().compareTo(o2.getEdad());

        if (comparar != 0){
            return comparar;
        }

        return o1.getNombre().compareTo(o2.getNombre());
    }
}
