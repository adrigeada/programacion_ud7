package org.example.EjercicioCine;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CineApp {

    static Queue<Espectador> cola = new LinkedList<>();
    static Random aleatorio = new Random();

    static void main() {


        generarCola();

        System.out.println("Hay "+cola.size() + " personas en la cola. "+cola);

        double recaudacion = 0;
        while (!cola.isEmpty()){

            if (cola.poll().getEdad() >= 18){
                recaudacion += 3.5;
            } else if (cola.poll().getEdad() >= 11) {
                recaudacion += 2.5;
            }else {
                recaudacion += 1;
            }


        }

        System.out.println("La recaudación ha sido de "+recaudacion+"€");


    }

    public static void generarCola(){

        int num_personas = aleatorio.nextInt(251);

        for (int i = 0; i < num_personas; i++) {

            cola.offer(new Espectador(aleatorio.nextInt(97)+3));

        }





    }
}
