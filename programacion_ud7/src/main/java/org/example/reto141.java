package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class reto141 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        teclado = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

    public static boolean casoDePrueba() {
        if (!teclado.hasNext())
            return false;
        else {

            Character[] caracteresAbiertos = {'(','[','{'};
            Character[] caracteresCerrados = {')',']','}'};

            String expresion = teclado.nextLine();
            Stack<Character> pila = new Stack<>();

            for (int i = 0; i < expresion.length(); i++) {
                int indiceAbierto = 4;
                int indiceCerrado = 5;

                if (Arrays.asList(caracteresAbiertos).contains(expresion.charAt(i))){
                    pila.push(expresion.charAt(i));
                }

                if (Arrays.asList(caracteresCerrados).contains(expresion.charAt(i))){

                    if (pila.isEmpty()){
                        System.out.println("NO");
                        return true;
                    }else {
                        indiceAbierto = Arrays.asList(caracteresAbiertos).indexOf(pila.peek());
                        indiceCerrado = Arrays.asList(caracteresCerrados).indexOf(expresion.charAt(i));

                        if (indiceAbierto == indiceCerrado){
                            pila.pop();
                        }else {
                            System.out.println("NO");
                            return true;
                        }

                    }

                }


            }

            if (pila.isEmpty()){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

            return true;
        }
    } // casoDePrueba



} // class solution