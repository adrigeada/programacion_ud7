package org.example.PracticaMercadona;

import java.util.*;

public class AppZonaClientes {
   static Random aleatorio = new Random();
   static Scanner teclado = new Scanner(System.in);
    static Cliente cliente;

    static void main() {

        Mercadam mercadam = new Mercadam();
        //Se genera una cantidad aleatoria de clientes
        int cantidadUsuarios = aleatorio.nextInt(10)+1;
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

                if (!cliente.getUsuario().equals(usuario) || !cliente.getContrasenya().equals(contrasenya)){
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

            //si no hago el continue, intenta insertar producto sin que producto exista.ERROR
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
        System.out.println("\n=== RESUMEN DE TU CARRITO DE LA COMPRA ===");
        System.out.println("Productos:");

        HashMap<Producto,Integer> mapaPedido = cliente.getPedido().getPedidoMapa();

        for (Map.Entry<Producto,Integer> mapita : mapaPedido.entrySet()){
            System.out.println(mapita.getValue()+" "+mapita.getKey()+" "+mapita.getKey().getPrecio());
        }

        System.out.println("IMPORTE TOTAL: "+cliente.getPedido().getImporteTotal()+"€");

        mostrarOpciones();
    }

    public static void mostrarOpciones(){

        System.out.println("\n========================================");
        System.out.println("¿Qué desea hacer?");
        System.out.println("[1]. Aplicar promos.");
        System.out.println("[2]. Mostrar resumen ordenado por uds.");
        System.out.println("[3]. Eliminar productos del pedido");
        System.out.println("[4]. Terminar pedido.");
        String opcion = teclado.nextLine();

        switch (opcion){

            case "1":
                aplicarPromo();
                break;
            case "2":
                ordenarPedido();
                break;
            case "3":
                eliminarProductos();
                break;
            default:
                imprimirDespedida();

        }

    }

    public static void imprimirDespedida(){
        System.out.println("\n=== GRACIAS POR SU PEDIDO ===");
        System.out.println("Lo recibirá en unos días en la dirección "+cliente.getDireccion());
    }

    public static void aplicarPromo(){
        if (cliente.isPromociones()){
            System.out.println("Ya se han aplicado promociones");
        }else {
            cliente.getPedido().aplicarPromo3x2();
            cliente.getPedido().aplicarPromo10();
        }
        cliente.setPromociones(true);
        imprimirResumen();

    }

    public static void ordenarPedido(){
        System.out.println("\n=== RESUMEN DE TU CARRITO DE LA COMPRA ===");
        System.out.println("Productos ordenados por uds:");

        HashMap<Producto,Integer> mapaPedido = cliente.getPedido().getPedidoMapa();

        List<Map.Entry<Producto,Integer>> listaMapa = new ArrayList<>(mapaPedido.entrySet());

        listaMapa.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Producto,Integer> mapita : listaMapa){
            System.out.println(mapita.getValue()+" "+mapita.getKey()+" "+mapita.getKey().getPrecio()+"€");
        }

        System.out.println("\nIMPORTE TOTAL: "+cliente.getPedido().getImporteTotal()+"€");

        mostrarOpciones();

    }

    public static void eliminarProductos(){

        System.out.println("=== ELIMINAR PRODUCTOS ===");
        System.out.println("¿Qué producto quieres eliminar?");

        HashMap<Producto,Integer> mapaPedido = cliente.getPedido().getPedidoMapa();
        for (Map.Entry<Producto,Integer> mapita : mapaPedido.entrySet()){
            System.out.println(mapita.getValue()+" "+mapita.getKey()+" "+mapita.getKey().getPrecio());
        }
        Iterator<Map.Entry<Producto,Integer>> itmapa = mapaPedido.entrySet().iterator();

        Producto producto = Producto.valueOf(teclado.nextLine().toUpperCase());

        while (itmapa.hasNext()){
            Map.Entry<Producto,Integer> prodUd = itmapa.next();

            if (prodUd.getKey().equals(producto)){

                if (prodUd.getValue() > 1){
                    mapaPedido.put(producto, mapaPedido.get(producto)-1);
//                    prodUd.setValue(prodUd.getValue()-1);
                }else {
                    itmapa.remove();
                }
                break;

            }
        }

        imprimirResumen();

    }

}
