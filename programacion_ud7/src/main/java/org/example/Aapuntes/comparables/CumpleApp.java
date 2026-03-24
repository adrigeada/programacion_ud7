package org.example.Aapuntes.comparables;

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

//        TreeMap<Invitado,String> mapaInvitados = new TreeMap<>(Comparator.reverseOrder()); //para ordenar al reves por key
        TreeMap<Invitado,String> mapaInvitados = new TreeMap<>();

        mapaInvitados.put(new Invitado(15,"Jacobo"),"Raqueta");
        mapaInvitados.put(new Invitado(12,"David"),"500€");
        mapaInvitados.put(new Invitado(12,"Joaquin"),"Charla con Milei");



        List<Map.Entry<Invitado,String>> listaMapa = new ArrayList<>(mapaInvitados.entrySet()); //creamos una lista arraylist con el entrySet del mapa

        listaMapa.sort(Map.Entry.comparingByValue()); //para ordenar por valor
//        listaMapa.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Invitado,String> mapita : listaMapa){
            System.out.println(mapita.getKey().getNombre() + " "+mapita.getValue());
        }



    }
}
