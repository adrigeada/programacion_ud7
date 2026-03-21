package org.example.Aapuntes;

import java.util.*;

public class Iteradores {
    static void main() {
        //hasnext,next,remove
        //para hacer remove siempre hay que guardarse el objeto primero usando el next


        TreeSet<String> lista = new TreeSet<>();

        lista.add("Pikachu");
        lista.add("Charmander");
        lista.add("Squirtle");
        lista.add("Bulbasur");
        lista.add("Magikarp");



        Iterator<String> it = lista.iterator(); //para cuando quieres borrar algo especifico en una lista,pila,cola

//        lista.add("Onix"); si añades o remove a la lista, después de crear el iterador, ConcurrentModificationException. Se deben borrar y añadir al iterador no a la lista.

        while (it.hasNext()){

            String pokemon = it.next();//guardar

            if (pokemon.equals("Pikachu")){
                it.remove();

            }

            System.out.println(pokemon);
        }

        System.out.println(lista);

//===================================================================================================================================================
        //listIterator tiene tambien, hasPrevious,previous,add,nextIndex y previousIndex

        ArrayList<String> ias = new ArrayList<>(Arrays.asList("Gemini","ChatGPT","Deepseek","Copilot","Perplexity"));

        ListIterator<String> itguay = ias.listIterator(); //lo que le pones en el () de listIterator(), es el indice desde el que empieza

        while (it.hasNext()){//el indice se queda donde acaba este while

            System.out.println(itguay.nextIndex());

            String ia = it.next();

            System.out.println(itguay.nextIndex());

            System.out.println(ia);

        }

        while (itguay.hasPrevious()){//el indice empieza donde se quedó en el anterior bucle

            System.out.println(itguay.previousIndex());

            String ia = itguay.previous();

            if (ia.equals("Deepseek")){
                itguay.add("Claude");
            }

            System.out.println(itguay.previousIndex());

            System.out.println(ia);
        }


//===================================================================================================================================================

        //mapas se hace usando la lista Map.Entry

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
