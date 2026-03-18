package org.example.PracticaMercadona;

import java.util.Random;
import java.util.Set;

public class AppZonaClientes {
   static Random aleatorio = new Random();
    static Cliente cliente;

    static void main() {

        Mercadam mercadam = new Mercadam();

        for (int i = 0; i < aleatorio.nextInt(9)+1; i++) {
            mercadam.generarClientes();
        }

        Set<Cliente> listaClientes = mercadam.getListaClientes();

    }

}
