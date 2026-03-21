package org.example.Aapuntes.comparables;

import java.util.*;

public class PruebaIndestructible {
    static List<Integer> lista = new ArrayList<>();

    static void main() {

        lista.add(321);
        lista.add(2);



    }

    public static List<Integer> getLista(){
        return Collections.unmodifiableList(lista);
    }
}
