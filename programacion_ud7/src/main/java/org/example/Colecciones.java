package org.example;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Colecciones {

    static void main() {

//        ArrayList<Integer> listaNums = new ArrayList<>();
//
//        Stack<Integer> pilaNum = new Stack<>(); //pilas
//        pilaNum.push(2);
//        pilaNum.push(9);
//        pilaNum.push(12);
//
//        System.out.println(pilaNum.peek()); //enseña el mas arriba
//        pilaNum.pop();//quita el de mas arriba
//        System.out.println(pilaNum.peek());


        Deque<String> cola = new LinkedList<>(); //la cola deque permite añadir y borrar el primero y el ultimo (pollLast, offerFirst). La queue sol deja controlar el primero de la cola.

        cola.offer("Blessd");
        cola.offer("Yatra");
        cola.offer("Shakira");

        System.out.println(cola.poll());

        System.out.println(cola.peek());

        cola.offerFirst("Pirlo");
        System.out.println(cola.peek());
        System.out.println(cola.pollLast());

        Queue<String> cola2 = new ArrayBlockingQueue<>(2);

        cola2.offer("Juan");
        cola2.offer("Jorge");
        cola2.offer("Adrián");

        System.out.println(cola2);



    }
}
