package org.example.PracticaMercadona;

import java.util.*;

public class AppZonaClientes {
   static Random aleatorio = new Random();
   static Scanner teclado = new Scanner(System.in);
    static Cliente cliente;

    /**
     * Se crea un objeto mercadam que se usa para generar clientes y meterlos en la lista dentro de Mercadam. Después se recibe la lista inmodificable. Esta lista es la que se pasa
     * como parámetro al método autentication.
     */
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

    /**
     * Recibe una lista de clientes. Se pide usuario y contraseña para acceder. Estos datos se buscan en la lista, si no coinciden con los datos de ningun cliente se vuelven a pedir y se resta un intento.
     * Tras 3 intentos fallidos el programa acaba con un return. Si coinciden, se usan para crear el cliente estático que hay en esta clase. Es el que vamos a usar para el resto del programa.
     * Se llama a iniciarCompra().
     * @param listaClientes
     */
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

    /**
     * Se crea un pedido usando el cliente estático y se llama a imprimirProductos().
     */
    public static void iniciarCompra(){

        System.out.println("Creando un nuevo pedido...");

        cliente.crearPedido();
        imprimirProductos();

    }

    /**
     * Se imprimen por pantalla los productos que hay en el Enum Producto.
     * Se pide elegir un producto para añadir al pedido. Si no coincide con los Enums válidos se vuelve a pedir que se elija un producto válido.
     * Si el producto es válido, se inserta el producto al pedido con insertarProducto().
     * Finalmente se pregunta si queremos añadir mas productos al pedido. S para repetir, N para salir. Si sales, se llama a imprimirResumen()
     */
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

    /**
     * Usando un for each al mapa del pedido se enseñan los productos y las cantidades que hay en el pedido. Se llama a mostrarOpciones().
     */
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

    /**
     * Se imprimen las posibles opciones que hay al final del pedido. Con la respuesta se hace un switch-case
     */
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

    /**
     * Acaba el programa con una despedida.
     */
    public static void imprimirDespedida(){
        System.out.println("\n=== GRACIAS POR SU PEDIDO ===");
        System.out.println("Lo recibirá en unos días en la dirección "+cliente.getDireccion());
    }

    /**
     * Se comprueba si el atributo booleano de cliente, promociones es true o false. Si es true no se hace nada. Si es false se aplican ambos métodos de promoción,.
     */
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

    /**
     * Se crea una lista Map.Entry a partir del mapa del pedido. Esta lista se ordena usando Map.Entry.comparingByValue(Comparator.reverseOrder()) para ordenar por value.
     * Luego uso esta lista ordenada para volver a imprimir el mapa.
     */
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

    /**
     * Se crea un Iterator tipo Map.Entry a partir del mapa del pedido. Se pide que producto queremos borrar.
     * Recorremos el iterator con un hasNext(), guardamos un prodUd con next(). Si la key de este prodUd es igual al producto que hemos escrito entramos al if.
     * Si hay mas de una unidad de el producto elegido, actualizamos el valor a -1. Si hay uno, lo eliminamos con remove().
     */
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
