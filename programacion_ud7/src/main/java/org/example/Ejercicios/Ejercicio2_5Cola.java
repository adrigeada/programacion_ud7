package org.example.Ejercicios;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio2_5Cola {
    static void main() {
        Scanner teclado = new Scanner(System.in);

        Queue<String> colaTareas = new LinkedList<>();

        colaTareas.offer("Imprimir documento 1");
        colaTareas.offer("Imprimir documento 2");
        colaTareas.offer("Imprimir documento 3");
        colaTareas.offer("Imprimir documento 4");
        colaTareas.offer("Imprimir documento 5");


        System.out.println("Estado inicial de la cola de impresión : "+colaTareas);
        while (!colaTareas.isEmpty()){

            System.out.println("Procesando "+colaTareas.poll()+". Quedan "+colaTareas.size()+" trabajos por procesar.");
            if (colaTareas.isEmpty()){
                System.out.println("No hay mas trabajos");
                break;
            }
            System.out.println("Estado de la cola despues de procesar el trabajo: "+colaTareas);


        }


        System.out.print("Escribe una palabra: ");
        String palabra = teclado.nextLine();

        Deque<Character> colaLetras = new LinkedList<>();


        for (int i = 0; i < palabra.length(); i++) {
            colaLetras.offer(palabra.charAt(i));
        }

        System.out.println(colaLetras);

        while (!colaLetras.isEmpty()){
            if (colaLetras.peekFirst() == colaLetras.peekLast()){
                colaLetras.pollFirst();
                colaLetras.pollLast();
            }else {
                break;
            }
        }

        if (colaLetras.isEmpty()){
            System.out.println("Palindromo");
        }else {
            System.out.println("No palindromo");
        }

    }
}
