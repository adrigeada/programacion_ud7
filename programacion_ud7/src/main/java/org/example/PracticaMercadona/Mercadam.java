package org.example.PracticaMercadona;

import java.util.*;

public class Mercadam {
    static Random aleatorio = new Random();
    static String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private Set<Cliente> listaClientes;

    public Mercadam(){
        listaClientes = new TreeSet<>();
    }

    /**
     * Se genera un usuario y contraseña de 8 caracteres de forma aleatoria. Con esto se crea un cliente y se añade a la listaClientes
     */
    public void generarClientes(){
        String usuario = "";
        String pass = "";

        for (int i = 0; i < 8; i++) {
            usuario+=caracteres.charAt(aleatorio.nextInt(caracteres.length()));
        }

        for (int i = 0; i < 8; i++) {
            pass+=caracteres.charAt(aleatorio.nextInt(caracteres.length()));
        }

        Cliente cliente = new Cliente(usuario,pass);
        listaClientes.add(cliente);
    }


    /**
     * @return la listaClientes a la que se le han añadido los clientes, la devuelve de forma inmodificable.
     */
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
