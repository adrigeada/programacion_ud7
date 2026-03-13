package org.example;

import java.util.ArrayList;
import java.util.ListIterator;

public class reto144 {

    static java.util.Scanner in;

    public static void main(String[] args) {
        in = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main


    public static boolean casoDePrueba() {
        if (!in.hasNext())
            return false;
        else {

            ArrayList<Character> lista = new ArrayList<>();
            ListIterator<Character> it = lista.listIterator();

            String palabra = in.nextLine();

            for (Character caracter : palabra.toCharArray()){
                switch (caracter){
                    case '-':
                        while(it.hasPrevious()){
                            it.previous();
                        }
                        break;
                    case '+':
                        while (it.hasNext()){
                            it.next();
                        }
                        break;
                    case '*':
                        if (it.hasNext()){
                            it.next();
                        }
                        break;
                    case '3':
                        if (it.hasNext()){
                            it.next();
                            it.remove();
                        }
                        break;
                    default:
                    it.add(caracter);

                }


            }

            for (Character letra : lista){
                System.out.print(letra);
            }
            System.out.println();


            return true;
        }
    } // casoDePrueba


}