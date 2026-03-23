package org.example.preExamen;

import java.util.HashMap;
import java.util.Scanner;

public class Chatbot {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        String pregunta = "";

        HashMap<String,String> mapaChat = new HashMap<>();

        mapaChat.put("hola","Hola,en que te puedo ayudar.");
        mapaChat.put("como estas","Estoy listo para ayudarte");
        mapaChat.put("adios","Hasta luego");
        mapaChat.put("gracias","De nada, que tengas buen dia.");

        System.out.println("Bienvenido al chatbot");

        while (true){

            System.out.print("Tú:");
            pregunta= teclado.nextLine().toLowerCase();

            if (pregunta.equalsIgnoreCase("salir")){
                System.out.println("Chatbot: Adiós");
                break;
            }

            if (mapaChat.containsKey(pregunta)){

                System.out.println("Chatbot: "+mapaChat.get(pregunta));

            }else {
                System.out.println("Chatbot: no te entiendo :(");
            }

        }




    }
}
