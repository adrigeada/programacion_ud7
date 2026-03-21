package org.example.Aapuntes;

import java.util.List;
import java.util.Stack;

public class Pilas {
    static void main() {

        Stack<Integer> pilaNum = new Stack<>(); //pilas
        //push,pop,peek,isEmpty


        pilaNum.push(2); //pone arriba del todo
        pilaNum.push(9);
        pilaNum.push(12);

        System.out.println(pilaNum.peek()); //enseña el mas arriba
        pilaNum.pop();//quita el de mas arriba
        System.out.println(pilaNum.peek());


    }
}
