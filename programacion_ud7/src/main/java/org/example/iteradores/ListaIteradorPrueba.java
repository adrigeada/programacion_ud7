package org.example.iteradores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ListaIteradorPrueba {

    static void main() {

        ArrayList<String> ias = new ArrayList<>(Arrays.asList("Gemini","ChatGPT","Deepseek","Copilot","Perplexity"));

        ListIterator<String> it = ias.listIterator(); //lo que le pones en el () de listIterator(), es el indice desde el que empieza

        while (it.hasNext()){//el indice se queda donde acaba este while

            System.out.println(it.nextIndex());

            String ia = it.next();

            System.out.println(it.nextIndex());

            System.out.println(ia);

        }

        while (it.hasPrevious()){//el indice empieza donde se quedó en el anterior bucle

            System.out.println(it.previousIndex());

            String ia = it.previous();

            if (ia.equals("Deepseek")){
                it.add("Claude");
            }

            System.out.println(it.previousIndex());

            System.out.println(ia);
        }







    }
}
