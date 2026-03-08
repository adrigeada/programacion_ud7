package org.example;

import java.util.*;

public class reto185 {

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
        }else {

            HashSet<String> ingredientesSI = new HashSet<>();
            HashSet<String> ingredientesNO = new HashSet<>();
            ArrayList<String> ingredientesMalos = new ArrayList<>();
            for (int i = 0; i < vueltas; i++) {
                String potito = teclado.nextLine();
                String[] vector_potito = potito.split(" ");

                if (vector_potito[0].equals("SI:")){

                    for (int j = 1; j < vector_potito.length-1; j++) {
                        ingredientesSI.add(vector_potito[j]);
                    }
                }else {
                    for (int j = 1; j < vector_potito.length-1; j++) {
                        ingredientesNO.add(vector_potito[j]);
                    }
                }



            }

            for (String ingrediente : ingredientesNO){
                if (!ingredientesSI.contains(ingrediente)){
                    ingredientesMalos.add(ingrediente);
                }
            }

            Collections.sort(ingredientesMalos);

            for (int i = 0; i < ingredientesMalos.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(ingredientesMalos.get(i));
            }
            System.out.println();


            return true;
        }
    }



}