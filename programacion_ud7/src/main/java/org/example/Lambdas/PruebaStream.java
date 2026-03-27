package org.example.Lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PruebaStream {

    static void main(String[] args) {

        Stream<String> pruebaStream = Stream.of("Ibai","IlloJuan","Falete","Kevin")
                .filter(youtuber -> youtuber.startsWith("I"))
                .filter(youtuber -> youtuber.contains("o"));

        List<String> lista = pruebaStream.toList();
        System.out.println(lista);

        List<String> lista2 = Arrays.asList("Jijona","Yema","Piedra","Duro");

         lista2 = lista2.stream().filter(turron -> turron.contains("o")).toList();

        System.out.println(lista2);



    }
}
