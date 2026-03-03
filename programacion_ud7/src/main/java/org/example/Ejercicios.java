package org.example;

import java.util.Scanner;
import java.util.Stack;

public class Ejercicios {
    static void main() {
        Scanner teclado = new Scanner(System.in);

        Stack<Character> pilaLetras = new Stack<>();

        pilaLetras.add('a');
        pilaLetras.add('b');
        pilaLetras.add('c');
        pilaLetras.add('d');
        pilaLetras.add('e');

        System.out.println("La pila está vacía? : "+pilaLetras.isEmpty());
        System.out.println("Hay "+pilaLetras.size()+" caracteres.");
        System.out.println("El último elemento es: "+pilaLetras.peek());

        do {
            System.out.println(pilaLetras.pop());
        }while (!pilaLetras.isEmpty());

        Stack<Integer> pilaNum = new Stack<>();

        System.out.print("Introduce el primer número:");
        pilaNum.push(teclado.nextInt());
        System.out.print("Segundo:");
        pilaNum.push(teclado.nextInt());
        System.out.print("Tercero:");
        pilaNum.push(teclado.nextInt());
        System.out.println("\nNúmeros en orden inverso:");

        do {
            System.out.println(pilaNum.pop());
        }while (!pilaNum.isEmpty());



    }
}
