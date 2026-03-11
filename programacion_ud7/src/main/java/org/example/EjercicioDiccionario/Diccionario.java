package org.example.EjercicioDiccionario;

import java.util.*;

public class Diccionario {
    public static HashMap<String,String> mapaDiccionario = new HashMap<>();
    static Scanner teclado = new Scanner(System.in);
    static Random aleatorio = new Random();

    static void main() {
        Precarga.main();

        while (true){
            String palabra = palabraAleatoria();
            System.out.println(palabra+": "+primeraLetraTraduccion(palabra));
            System.out.print("Indique la respuesta:");

            String respuesta = teclado.nextLine();
            if (respuesta.equals("fin")){
                break;
            }




        }


    }



    public static String traduce(String palabra){

        if (mapaDiccionario.containsKey(palabra)){
            return mapaDiccionario.get(palabra);

        }else {
            System.out.println("Palabra no encontrada en diccionario");
            return null;
        }

    }

    public static String palabraAleatoria(){

        Set<String> listaPalabras = mapaDiccionario.keySet();


        return listaPalabras[aleatorio.nextInt(200)];
    }

    public static char primeraLetraTraduccion(String palabra){

        return mapaDiccionario.get(palabra).charAt(0);
    }

}
