package org.example.Ejercicios;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio4 {
    static LinkedList<String> listaCompra = new LinkedList<>();
    static Scanner teclado = new Scanner(System.in);
    static void main() {

        imprimirMenu();
    }

    public static void imprimirMenu(){
        System.out.println("\n--- LISTA DE LA COMPRA ---");
        System.out.println("1. Añadir producto al final");
        System.out.println("2. Eliminar primer producto");
        System.out.println("3. Eliminar producto por nombre");
        System.out.println("4. Ver primer producto");
        System.out.println("5. Buscar producto");
        System.out.println("6. Mostrar lista actual");
        System.out.println("X. Salir");
        eleccion();

    }

    public static void eleccion(){
        System.out.print("\nSeleccione una opción: ");
        String opcion = teclado.nextLine();
        System.out.println("\n------------------------------");

        String producto = "";


        switch (opcion){
            case "1":
                System.out.print("Producto a añadir:");
                producto = teclado.nextLine();
                listaCompra.offerLast(producto);
                imprimirMenu();
                break;
            case "2":
                if (listaCompra.isEmpty()){
                    System.out.println("No hay productos en la lista");
                }else {
                    System.out.println("Borrando primer producto: "+listaCompra.pollFirst());
                }
                imprimirMenu();
                break;
            case "3":
                if (listaCompra.isEmpty()){
                    System.out.println("No hay productos en la lista");
                }else {
                    System.out.print("Producto a borrar: ");
                    producto = teclado.nextLine();

                    if (listaCompra.contains(producto)){
                        System.out.println("Borrando "+producto);
                        listaCompra.remove(producto);
                    }else {
                        System.out.println("No hay "+producto+" en la lista.");
                    }
                }
                imprimirMenu();
                break;
            case "4":
                if (!listaCompra.isEmpty()){
                    System.out.println("El primer producto es: "+listaCompra.peek());
                }else {
                    System.out.println("No hay productos en la lista.");
                }

                imprimirMenu();
                break;
            case "5":

                if (listaCompra.isEmpty()){
                    System.out.println("No hay productos en la lista");
                }else {
                    System.out.print("Producto a buscar: ");
                    producto = teclado.nextLine();
                    if (listaCompra.contains(producto)){
                        System.out.println("El producto "+producto+" está en la posicion "+(listaCompra.indexOf(producto)+1));
                    }
                }

                imprimirMenu();
                break;

            case "6":

                if (listaCompra.isEmpty()){
                    System.out.println("Lista de compra vacía");
                }else {
                    for (String cosa : listaCompra){
                        System.out.println((listaCompra.indexOf(cosa)+1)+"- "+cosa);
                    }
                }
                imprimirMenu();
                break;

            default:
                System.out.println("Saliendo...");




        }
    }
}
