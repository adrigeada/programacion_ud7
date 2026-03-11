package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EjMapa3 {
    static HashMap<String,Double> ciudadTemperatura = new HashMap<>();
    static Scanner teclado = new Scanner(System.in);
    static void main() {

        System.out.println("*** REGISTRO DE TEMPERATURAS ***");

        while (true){
            System.out.println("Elige una opción [insertar,actualizar,consultar,ver todas,salir]");

            String opcion = teclado.nextLine().toLowerCase();

            switch (opcion){

                case "insertar":
                    insertar();
                    break;
                case "actualizar":
                    actualizar();
                    break;
                case "consultar":
                    consultar();
                    break;
                case "ver todas":
                    mostrar();
                    break;
                case "salir":
                    return;
                default:
                    System.out.println("No existe");

            }

        }




    }

    public static void insertar(){

        System.out.println("Introduce los datos (ciudad/temperatura)");
        String ciudad[] = teclado.nextLine().split("/");

        ciudadTemperatura.put(ciudad[0],Double.valueOf(ciudad[1]));

    }

    public static void actualizar(){
        System.out.println("Que ciudad quieres actualizar?");
        String ciudad = teclado.nextLine();

        if (ciudadTemperatura.containsKey(ciudad)){
            System.out.println("Nueva temperatura: ");
            Double nueva = teclado.nextDouble();

            ciudadTemperatura.put(ciudad,nueva);
            teclado.nextLine();
        }else {
            System.out.println(ciudad+" no está en la base de datos");
        }

    }

    public static void consultar(){
        System.out.println("Qué ciudad quieres consultar: ");
        String ciudad = teclado.nextLine();

        if (ciudadTemperatura.containsKey(ciudad)){
            System.out.println("La temperatura de "+ciudad+" es: "+ciudadTemperatura.get(ciudad));
        }else {
            System.out.println(ciudad+" no se encuentra en la base");
        }

    }

    public static void mostrar(){

        for (Map.Entry<String,Double> mapita : ciudadTemperatura.entrySet()){
            System.out.println(mapita.getKey()+ ": "+mapita.getValue()+"º");
        }

    }
}
