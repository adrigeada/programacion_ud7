package org.example.PracticaMercadona;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AppZonaClientesTest {

    @Test
    void autentication() {
        //Este método pide datos por teclado, no se como hacer test  de eso.
        Set<Cliente> listaClientes = new HashSet<>();
        listaClientes.add(new Cliente("adri","1234"));
        listaClientes.add(new Cliente("marina","4321"));

       AppZonaClientes.autentication(listaClientes);


    }
}