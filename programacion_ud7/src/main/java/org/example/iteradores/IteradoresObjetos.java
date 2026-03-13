package org.example.iteradores;

import org.example.Presidente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteradoresObjetos {

    static void main() {

        ArrayList<Presidente> listaPresidente = new ArrayList<>(Arrays.asList(
                new Presidente("Pedro Sanchez","España"),
                new Presidente("Donald","USA"),
                new Presidente("Macron","Francia")));

        Iterator<Presidente> it = listaPresidente.iterator();

        while (it.hasNext()){

            Presidente presi = it.next();

            if (presi.getNombre().equals("Macron")){
                it.remove();
            }

        }

        System.out.println(listaPresidente);

    }
}
