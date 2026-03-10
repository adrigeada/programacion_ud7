package org.example.Mapas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {
    static Scanner teclado = new Scanner(System.in);
    static void main() {

        System.out.println("Escribe palabra:");
        String palabra = teclado.nextLine();
        HashMap<Character,Integer> mapa = new HashMap<>();

        for (Character letra : palabra.toCharArray()){

//            if (mapa.containsKey(letra)){
//                mapa.put(letra, mapa.get(letra)+1);
//            }else {
//                mapa.put(letra,1);
//            }

            mapa.put(letra,mapa.getOrDefault(letra,0)+1);

        }

        for (Map.Entry<Character,Integer> mapita : mapa.entrySet()){
            System.out.println(mapita.getKey() + " : "+ mapita.getValue());
        }


    }
}
