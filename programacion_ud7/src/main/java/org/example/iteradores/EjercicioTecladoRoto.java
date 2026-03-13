package org.example.iteradores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class EjercicioTecladoRoto {
static Scanner teclado = new Scanner(System.in);
    static void main() {

        ArrayList<Character> lista = new ArrayList<>();
        ListIterator<Character> it = lista.listIterator();

        String palabra = teclado.nextLine();

        for (Character caracter : palabra.toCharArray()){
            switch (caracter){
                case '<':
                    if (it.hasPrevious()){
                        it.previous();
                    }
                    break;
                case '>':
                    if (it.hasNext()){
                        it.next();
                    }
                    break;
                case '#':
                    if (it.hasPrevious()){
                        it.previous();
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


    }
}
