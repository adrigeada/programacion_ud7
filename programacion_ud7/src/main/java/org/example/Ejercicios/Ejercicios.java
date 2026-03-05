package org.example.Ejercicios;

import java.util.Scanner;
import java.util.Stack;

public class Ejercicios {
    static void main() {
        Scanner teclado = new Scanner(System.in);

//        Stack<Character> pilaLetras = new Stack<>();
//
//        pilaLetras.add('a');
//        pilaLetras.add('b');
//        pilaLetras.add('c');
//        pilaLetras.add('d');
//        pilaLetras.add('e');
//
//        System.out.println("La pila está vacía? : "+pilaLetras.isEmpty());
//        System.out.println("Hay "+pilaLetras.size()+" caracteres.");
//        System.out.println("El último elemento es: "+pilaLetras.peek());
//
//        do {
//            System.out.println(pilaLetras.pop());
//        }while (!pilaLetras.isEmpty());
//
//        Stack<Integer> pilaNum = new Stack<>();
//
//        System.out.print("Introduce el primer número:");
//        pilaNum.push(teclado.nextInt());
//        System.out.print("Segundo:");
//        pilaNum.push(teclado.nextInt());
//        System.out.print("Tercero:");
//        pilaNum.push(teclado.nextInt());
//        System.out.println("\nNúmeros en orden inverso:");
//
//        do {
//            System.out.println(pilaNum.pop());
//        }while (!pilaNum.isEmpty());

        if (esBalanceada(")")){
            System.out.println("BIen");
        }else {
            System.out.println("Mal");
        }



    }

    public static boolean esBalanceada(String cadena){

        Stack<Character> pilaChar = new Stack<>();
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(') {
                pilaChar.push(cadena.charAt(i));


            }else if (cadena.charAt(i) == ')'){

                if (pilaChar.contains('(')){
                    pilaChar.pop();
                }else {
                    return false;
                }
            }

        }

        if (pilaChar.isEmpty()){
            return true;
        }else {
            return false;
        }


    }
}
