package org.example.Lambdas;

import java.util.Arrays;
import java.util.List;

public class AppStream {

    static void main(String[] args) {

        List<String> nombres = Arrays.asList("Ana", "Luis", "Pedro");

        //a
        nombres.stream()
                .filter(nombre -> nombre.length()>4)
                .forEach(System.out::println);

        //b
        List<String> nombresMinusculas = nombres.stream()
                                            .map(nombre -> nombre.toLowerCase())
                                            .toList();

        System.out.println(nombresMinusculas);

        //c

        long cantidad = nombres.stream()
                .filter(nombre -> nombre.startsWith("A"))
                .count();

        System.out.println("Cantidad de nombres que empiezan con A: "+cantidad);
    }
}
