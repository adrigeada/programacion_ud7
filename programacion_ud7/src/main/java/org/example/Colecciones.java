package org.example;

import java.util.ArrayList;
import java.util.Stack;

public class Colecciones {

    static void main() {

        ArrayList<Integer> listaNums = new ArrayList<>();

        Stack<Integer> pilaNum = new Stack<>();
        pilaNum.push(2);
        pilaNum.push(9);
        pilaNum.push(12);

        System.out.println(pilaNum.peek()); //enseña el mas arriba
        pilaNum.pop();//quita el de mas arriba
        System.out.println(pilaNum.peek());



    }
}
