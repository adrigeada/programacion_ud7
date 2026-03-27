package org.example.Lambdas;

import org.example.Lambdas.clasesLambdas.Persona;
import org.example.Lambdas.clasesLambdas.Producto;
import org.example.Lambdas.interfacesLambdas.Ejecutor;
import org.example.Lambdas.interfacesLambdas.FiltroProducto;
import org.example.Lambdas.interfacesLambdas.VerificadorObjeto;
import org.example.Lambdas.interfacesLambdas.VerificadorVoto;

import java.util.ArrayList;
import java.util.List;

public class AppLambdas {


    static void main(String[] args) {

        //1
        Ejecutor lambda = (num) -> {
            //se pone lo que quieres que sobrescriba en el metodo que tiene la interfaz
            System.out.println("Comparando para "+num);

            if (num > 10){
                return true;
            }else {
                return false;
            }
        };

        System.out.println(lambda.ejecutar(15));
        System.out.println(lambda.ejecutar(5));
        System.out.println();

        //2

        VerificadorVoto voto = (nombre, edad) -> {
            System.out.println("Probando "+nombre+" con "+edad+" años...");
            if (edad >= 18){
                return true;
            }else {
                return false;
            }


        };

        System.out.println(voto.puedeVotar("María",14));
        System.out.println(voto.puedeVotar("Juan",20));


        List<String> personasQuePuedenVotar = new ArrayList<>();
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Juan",16));
        listaPersonas.add(new Persona("Ana", 18));
        listaPersonas.add(new Persona("Pedro", 25));
        listaPersonas.add(new Persona("María", 17));
        listaPersonas.add(new Persona("Luis", 30));

        VerificadorObjeto verificador = (persona) -> persona.getEdad() >= 18;

        for (Persona persona : listaPersonas){
            if (verificador.puedeVotar(persona)){
                personasQuePuedenVotar.add(persona.getNombre());
            }
        }

        System.out.println("\nPersonas que pueden votar:");
        for (String nombre : personasQuePuedenVotar){
            System.out.println(nombre);
        }


        //3

        List<Producto> listaProductos = new ArrayList<>();

        listaProductos.add(new Producto("Smartphone",200,"Electronica"));
        listaProductos.add(new Producto("Laptop",500,"Electronica"));
        listaProductos.add(new Producto("Tablet",300,"Electronica"));
        listaProductos.add(new Producto("Silla",50,"Muebles"));
        listaProductos.add(new Producto("Mesa",150,"Muebles"));
        listaProductos.add(new Producto("Lámpara",20,"Muebles"));

        List<Producto> productosFiltrados = new ArrayList<>();

        FiltroProducto lambdita = (producto) -> {
            if (producto.getCategoria().equals("Electronica") && producto.getPrecio() > 100){
                return true;
            }else{
                return false;
            }
        };

        for (Producto producto : listaProductos){

            if (lambdita.filtrar(producto)){
                productosFiltrados.add(producto);
            }

        }

        System.out.println("\nProductos filtrados (Electrónica y precio > 100)");
        for (Producto producto : productosFiltrados){
            System.out.println("Nombre: "+producto.getNombre()+", Precio: "+producto.getPrecio());
        }


    }//main
}
