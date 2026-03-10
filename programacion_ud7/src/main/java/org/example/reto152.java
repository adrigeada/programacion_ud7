package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class reto152 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        while (casoDePrueba()) {
        }
    } // main

    public static boolean casoDePrueba() {
        int vueltas = teclado.nextInt();
        teclado.nextLine();
      if (vueltas == 0){
          return false;
      } else {

          HashMap<Integer,Integer> mapa = new HashMap<>();
          for (int i = 0; i < vueltas; i++) {
              int clave = teclado.nextInt();

            if (mapa.containsKey(clave)){
                mapa.put(clave, mapa.get(clave)+1);
            }else {
                mapa.put(clave, 1);
            }

          }
          teclado.nextLine();
          Integer clavetop =0;
          Integer valorTop = 0;
          for (Map.Entry<Integer,Integer> mapita : mapa.entrySet()){
              if (mapita.getValue() > valorTop){
                  valorTop = mapita.getValue();
                  clavetop = mapita.getKey();
              }
          }

          System.out.println(clavetop);

            return true;
        }
    }





} // class solution