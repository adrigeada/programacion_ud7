package org.example.Ejercicios;

import java.util.*;

public class pruebas_sets {
    static void main() {
        Scanner teclado = new Scanner(System.in);

        String esquiroles[] = {"Joaquín","Christian","Christian","Carlos","Carlos","Ángel","Kevin","Eric","DavidG"};


        HashSet<String> normal = new HashSet<>(Arrays.asList(esquiroles));
        LinkedHashSet<String> respeta_add = new LinkedHashSet<>(Arrays.asList(esquiroles));
        TreeSet<String> ordenada = new TreeSet<>(Arrays.asList(esquiroles));

        System.out.println(normal);
        System.out.println(respeta_add);
        System.out.println(ordenada);



        System.out.print("Escribe una frase: ");
        String frase = teclado.nextLine().toLowerCase();

        String[] fraseVector = frase.split(" ");

        LinkedHashSet<String> fraseSinRepetidos = new LinkedHashSet<>(Arrays.asList(fraseVector));

        System.out.println(fraseSinRepetidos);

        LinkedHashSet<String> paginasWeb = new LinkedHashSet<>();
        String pag = "";
        do {
            System.out.print("Escribe una URL visitada (o salir para terminar): ");
            pag= teclado.nextLine();

            if (!pag.equals("salir")){
                paginasWeb.add(pag);
            }

        }while(!pag.equals("salir"));

        System.out.println("\nHistorial de navegación: ");
        for (String paginas : paginasWeb){
            System.out.println("- "+paginas);
        }

        Integer[] lista1 = {9,6,3,1};
        Integer[] lista2 = {8,7,6,4};

        System.out.println(mezclados(lista1,lista2));




    }

    public static TreeSet<Integer> mezclados(Integer[] lista1 , Integer[] lista2){

        TreeSet<Integer> ordenado = new TreeSet<>();

        ordenado.addAll(Arrays.asList(lista1));
        ordenado.addAll(Arrays.asList(lista2));

        return ordenado;

    }
}
