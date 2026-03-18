package org.example.EjercicioDiccionario;

import java.util.*;

public class Diccionario {
    public static HashMap<String,String> mapaDiccionario = new HashMap<>();
    static Scanner teclado = new Scanner(System.in);
    static Random aleatorio = new Random();

    static void main() {
        Precarga.main();

        int contador = 0;
        int aciertos = 0;
        int fallos = 0;


        while (true){

            String palabra = palabraAleatoria();
            String palabraCorrecta = traduce(palabra);
            System.out.println("\n"+palabra+": "+primeraLetraTraduccion(palabra)+"...");
            System.out.print("Indique la respuesta:");
            String respuesta = teclado.nextLine();

            if (respuesta.equals("fin")){
                break;
            }

            contador++;

            if (respuesta.equals(palabraCorrecta.toLowerCase())){
                System.out.println("CORRECTO");
                aciertos++;
            }else {
                System.out.println("NO. La respuesta correcta es "+palabraCorrecta);
                fallos++;
            }

        }

        System.out.println("\nFIN DEL PROGRAMA");
        System.out.println("Total preguntas: "+contador);
        System.out.println("Total aciertos: "+aciertos);
        System.out.println("Total errores: "+fallos);
        System.out.println("Aciertos: "+(aciertos*100)/contador + "%");

    }

    public static void nuevoPar(String espanyol, String ingles){
        mapaDiccionario.put(espanyol,ingles);
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
        String[] listaVector = listaPalabras.toArray(new String[0]);

        return listaVector[aleatorio.nextInt(listaVector.length)];
    }

    public static char primeraLetraTraduccion(String palabra){

        return mapaDiccionario.get(palabra).charAt(0);
    }

}
