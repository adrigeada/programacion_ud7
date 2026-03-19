package org.example.PracticaMercadona;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class AppZonaClientes {
   static Random aleatorio = new Random();
   static Scanner teclado = new Scanner(System.in);
    static Cliente cliente;

    static void main() {

        Mercadam mercadam = new Mercadam();
        //Se genera una cantidad aleatoria de clientes
        int cantidadUsuarios = aleatorio.nextInt(9)+1;
        for (int i = 0; i < cantidadUsuarios; i++) {
            mercadam.generarClientes();
        }
        //Se recibe la lista de clientes inmodificable y la imprimimos para ver los usuarios y sus contraseñas
        Set<Cliente> listaClientes = mercadam.getListaClientes();
        System.out.println(cantidadUsuarios+" clientes generados: "+listaClientes);

        autentication(listaClientes);


    }

    public static void autentication(Set<Cliente> listaClientes){
        int intentos = 3;
        String usuario ="";
        String contrasenya = "";

        System.out.println("=== COMPRA ONLINE EN MERCADAM ===");

        fuera:
        while(intentos>=0){

            if (intentos == 0){
                System.out.println("ERROR DE AUTENTICACIÓN");
                return;
            }

            System.out.println("Usuario: ");
            usuario = teclado.nextLine();
            System.out.println("Contraseña: ");
            contrasenya = teclado.nextLine();

            for (Cliente cliente : listaClientes){

                if (!cliente.getUsuario().equalsIgnoreCase(usuario) || !cliente.getContrasenya().equalsIgnoreCase(contrasenya)){
                    intentos--;
                    System.out.println("Credenciales no válidas. Intentos: "+intentos);
                    continue fuera;
                }else {
                    System.out.println("Bienvenido, "+usuario);
                    break fuera;
                }

            }

        }
        cliente = new Cliente(usuario,contrasenya);
        iniciarCompra();

    }

    public static void iniciarCompra(){

        System.out.println("Creando un nuevo pedido...");

        cliente.crearPedido();
        imprimirProductos();

    }

    public static void imprimirProductos(){
        Producto producto = null;
        boolean repetir;
        String siNo = "";


        do {
            repetir = false;
            System.out.println("\nElige un prodcuto de la lista...");

            for (Producto productito : Producto.values()){
                System.out.println(productito+": "+productito.getPrecio()+"€");
            }
            System.out.println("========================================");
            System.out.println("Elige un producto: ");

            try {
                producto = Producto.valueOf(teclado.nextLine().toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Producto no reconocido, elige otro...");
                repetir = true;
                continue;
            }

            cliente.insertarProducto(producto);

            System.out.println("¿Quieres añadir más productos (S/N)?");
            siNo = teclado.nextLine();

            if (siNo.equalsIgnoreCase("s")){
                repetir = true;
            }

        }while (repetir);

        imprimirResumen();
    }

    public static void imprimirResumen(){

    }

}
