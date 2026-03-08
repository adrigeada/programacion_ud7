package org.example.EjercicioFuncionario;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class AppFuncionario {
    static Scanner teclado = new Scanner(System.in);
    static Stack<Informe> pilaInformes = new Stack<>();
    static void main() {


        Informe informe1 = new Informe(1,"poner notas",TipoInforme.ADMINISTRATIVO);
        Informe informe2 = new Informe(2,"charla personal",TipoInforme.PERSONAL);
        Informe informe3 = new Informe(3,"hacer cuentas",TipoInforme.EMPRESARIAL);
        Informe informe4 = new Informe(2,"charla personal",TipoInforme.PERSONAL);
        Informe informe5 = new Informe(1,"poner notas",TipoInforme.ADMINISTRATIVO);

        pilaInformes.push(informe1);
        pilaInformes.push(informe2);
        pilaInformes.push(informe3);
        pilaInformes.push(informe4);
        pilaInformes.push(informe5);

        System.out.println("INFORMES PENDIENTES");
        System.out.println("======================");
        for (Informe informe : pilaInformes){
            System.out.println("- "+informe);
        }
        System.out.println("");

        while (!pilaInformes.isEmpty()){
            System.out.println("- Despachando "+pilaInformes.pop());
        }

        imprimirMenu();
    }

    public static void imprimirMenu(){
        System.out.println("\n=== ADMINISTRADOR DE INFORMES ===");
        System.out.println("[1]. Crear informes");
        System.out.println("[2]. Eliminar informes");
        System.out.println("[3]. Ver informes");
        System.out.println("[4]. Buscar tareas");
        System.out.println("[X]. Salir");
        accion();
    }

    public static void accion(){
        String eleccion = teclado.nextLine();

        switch (eleccion){
            case "1":
                crearInformes();
                imprimirMenu();
                break;
            case "2":
                System.out.println("Eliminando el último informe de la pila...");
                pilaInformes.pop();
                imprimirMenu();
                break;
            case "3":
                for (Informe informe : pilaInformes){
                    System.out.println("- "+informe);
                }
                imprimirMenu();
                break;
            case "4":
                buscarInforme();
                imprimirMenu();
                break;

            default:
                System.out.println("Saliendo...");
        }
    }

    public static void crearInformes(){

        do {
            System.out.println("Codigo de informe:");
            int codigo = teclado.nextInt();
            teclado.nextLine();

            System.out.println("\n¿Qué tarea tienes que crear?");
            String descripcion = teclado.nextLine();
            System.out.println("\n¿Qué tipo de informe es ["+ Arrays.toString(TipoInforme.values())+"]?");
            TipoInforme tipo = TipoInforme.valueOf(teclado.nextLine().toUpperCase());

            Informe informe  = new Informe(codigo,descripcion,tipo);
            pilaInformes.push(informe);

            System.out.println("\nQuieres crear otro informe? S/N");
            String repetir = teclado.nextLine();
            if (!repetir.equalsIgnoreCase("S")){
                break;
            }

        }while (true);

    }

    public static void buscarInforme(){
        System.out.print("Código de tarea a buscar:");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Tipo de tarea ["+ Arrays.toString(TipoInforme.values()) +"]");
        TipoInforme tipo = TipoInforme.valueOf(teclado.nextLine().toUpperCase());

        System.out.println("\nBuscando tarea con código "+codigo+" o tipo "+tipo);

        for (Informe informe : pilaInformes){
            if (informe.getCodigo() == codigo || informe.getTipo() == tipo){
                System.out.println("- "+informe);
            }
        }

    }
}
