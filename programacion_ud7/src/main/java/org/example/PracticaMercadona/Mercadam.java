package org.example.PracticaMercadona;

import java.util.*;

public class Mercadam {
    static Random aleatorio = new Random();
    static String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private Set<Cliente> listaClientes; //hacer comparable a cliente

    public Mercadam(){
        listaClientes = new HashSet<>();
    }

    public void generarClientes(){
        String usuario = "";
        String pass = "";

        for (int i = 0; i < 8; i++) {
            usuario+=caracteres.charAt(aleatorio.nextInt(caracteres.length()));
        }

        for (int i = 0; i < 8; i++) {
            pass+=caracteres.charAt(aleatorio.nextInt(caracteres.length()));
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
