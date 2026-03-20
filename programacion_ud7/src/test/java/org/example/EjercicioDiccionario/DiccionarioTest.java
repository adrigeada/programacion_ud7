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
    void nuevoParTest() {
        String espanyol = "Hola";
        String ingles = "Hello";
        Diccionario.nuevoPar(espanyol,ingles);

        assertAll(() ->  assertTrue(mapa.containsKey(espanyol)),
                () -> assertTrue(mapa.containsValue(ingles))
        );

    }

    @Test
    void traducePalabraExistente() {
        assertEquals(Diccionario.traduce(palabra1), palabra2);
    }

    @Test
    void traducePalabraNoExistente(){
        assertNull(Diccionario.traduce("palabraNoExistente"));
    }

    @Test
    void palabraAleatoriaTest() {
        String palabra = Diccionario.palabraAleatoria();

        assertTrue(mapa.containsKey(palabra));
    }

    @Test
    void primeraLetraTraduccionTest() {

        assertEquals(Diccionario.primeraLetraTraduccion(palabra1), palabra2.charAt(0));
    }
}