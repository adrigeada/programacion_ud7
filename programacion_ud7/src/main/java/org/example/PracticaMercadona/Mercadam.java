package org.example.PracticaMercadona;

import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Mercadam {
    static Random aleatorio = new Random();
    static String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private Set<Cliente> listaClientes; //hacer comparable a cliente

    public Mercadam(){
        listaClientes = new TreeSet<>();
    }

    public void generarClientes(){
        String usuario = "";
        String pass = "";

        for (int i = 0; i < 8; i++) {
            usuario+=caracteres.charAt(aleatorio.nextInt(62));
        }

        for (int i = 0; i < 8; i++) {
            pass+=caracteres.charAt(aleatorio.nextInt(62));
        }

        Cliente cliente = new Cliente(usuario,pass,null,false);
        listaClientes.add(cliente);
    }


    public Set<Cliente> getListaClientes() {
        return Collections.unmodifiableSet(listaClientes);
    }

    public void setListaClientes(Set<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public String toString() {
        return "Mercadam{" +
                "clientes=" + listaClientes +
                '}';
    }
}
