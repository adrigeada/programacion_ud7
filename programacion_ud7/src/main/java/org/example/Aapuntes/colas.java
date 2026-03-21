package org.example.Aapuntes;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class colas {
    static void main() {

        Queue<Integer> colita = new LinkedList<>(); //se crean como linkedList. Añades al final y quitas el primero
        //offer, poll, peek, isEmpty
        //Deque: lo mismo con first y last añadido


        Deque<String> cola = new LinkedList<>(); //la cola deque permite añadir y borrar el primero y el ultimo (pollLast, offerFirst). La queue sol deja controlar el primero de la cola.

        cola.offer("Blessd");
        cola.offer("Yatra");
        cola.offer("Shakira");


        System.out.println(cola.poll());//saca el primero de la lista

        System.out.println(cola.peek());//enseña al primero de la lista

        cola.offerFirst("Pirlo");
        System.out.println(cola.peek());
        System.out.println(cola.pollLast());

        Queue<String> cola2 = new ArrayBlockingQueue<>(2);//no te deja meter mas en la cola que su capacidad. Si ya está llena, el offer te devuelve false.

        cola2.offer("Juan");
        cola2.offer("Jorge");
        cola2.offer("Adrián");

        System.out.println(cola2);

    }
}
