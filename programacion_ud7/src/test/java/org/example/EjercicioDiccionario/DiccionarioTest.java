package org.example.EjercicioDiccionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

class DiccionarioTest {
    static HashMap<String,String> mapa = Diccionario.mapaDiccionario;
    static String palabra1 = "Colegio";
    static String palabra2 = "School";

    @BeforeEach
    public void empezarTest(){
        mapa.put(palabra1,palabra2);
    }

    @Test
    void nuevoPar() {
        String espanyol = "Hola";
        String ingles = "Hello";
        Diccionario.nuevoPar(espanyol,ingles);

        assertAll(() ->  assertTrue(mapa.containsKey(espanyol)),
                () -> assertTrue(mapa.containsValue(ingles))
        );

    }

    @Test
    void traduce() {
        assertTrue(Diccionario.traduce(palabra1).equals(palabra2));
        assertTrue(Diccionario.traduce("palabraNoExistente")== null);
    }

    @Test
    void palabraAleatoria() {
        String palabra = Diccionario.palabraAleatoria();

        assertTrue(mapa.containsKey(palabra));
    }

    @Test
    void primeraLetraTraduccion() {

        assertTrue(Diccionario.primeraLetraTraduccion(palabra1)==palabra2.charAt(0));
    }
}