package org.example.comparables;

import java.util.*;

public class CumpleApp {

    static void main() {

        List<Invitado> listaInvitados = new ArrayList<>();

        listaInvitados.add(new Invitado(15,"Jacobo"));
        listaInvitados.add(new Invitado(12,"David"));
        listaInvitados.add(new Invitado(12,"Joaquin"));


//        Collections.sort(listaInvitados); usando el comparable en la propia clase
//        Collections.sort(listaInvitados,Collections.reverseOrder());

        Collections.sort(listaInvitados,new OrdenarPorEdadNombreHora()); //usando una clase comparator
//        Collections.sort(listaInvitados,new OrdenarPorEdadNombreHora().reversed());

        System.out.println(listaInvitados);

        TreeMap<Invitado,String> mapa = new TreeMap<>(Collections.reverseOrder());

    }
}
