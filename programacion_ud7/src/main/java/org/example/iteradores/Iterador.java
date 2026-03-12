package org.example.iteradores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Iterador {

    static void main() {

        TreeSet<String> lista = new TreeSet<>();
        lista.add("Pikachu");
        lista.add("Charmander");
        lista.add("Squirtle");
        lista.add("Bulbasur");
        lista.add("Magikarp");



        Iterator<String> it = lista.iterator(); //para cuando quieres borrar algo especifico en una lista,pila,cola

//        lista.add("Onix"); si añades o remove, después de crear el iterador, ConcurrentModificationException

        while (it.hasNext()){

            String pokemon = it.next();//guardar

            if (pokemon.equals("Pikachu")){
                it.remove();
            }

            System.out.println(pokemon);
        }

        System.out.println(lista);


        HashMap<String,Integer> mapa = new HashMap<>();

        mapa.put("Nicky Nicole",4);
        mapa.put("Hermione",7);

        Iterator<Map.Entry<String,Integer>> itmapita = mapa.entrySet().iterator();

        while (itmapita.hasNext()){

            Map.Entry<String,Integer> novias = itmapita.next(); //guardar
            System.out.println(novias.getKey() + " ha durado "+ novias.getValue()+" meses con Joaquin. ");

            if (novias.getKey().equals("Hermione")){
                itmapita.remove();
            }

        }



    }
}
