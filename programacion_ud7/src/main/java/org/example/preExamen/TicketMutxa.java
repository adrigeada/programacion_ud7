package org.example.preExamen;

import java.time.LocalDate;
import java.util.*;

public class TicketMutxa {
    static Set<Usuario> usuariosRegistrados = new HashSet<>();
    static Set<Evento> listaEventos = new TreeSet<>();
    static Scanner teclado = new Scanner(System.in);
    static String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static Random aleatorio = new Random();

    public static void insertarEvento(String nombre, LocalDate fecha, double precio,String tipo){
        String artista = "";
        Set<String> listaArtistas = new HashSet<>();

        if (tipo.equalsIgnoreCase("concierto")){
            System.out.println("Creando concierto...");
            System.out.println("Artista:");
            artista = teclado.nextLine();
            Concierto concierto = new Concierto(nombre,fecha,precio,artista);
            listaEventos.add(concierto);

        } else if (tipo.equalsIgnoreCase("festival")) {
            System.out.println("Creando festival...");
            System.out.println("Introduce artistas: ");

            while (true){
                artista = teclado.nextLine();

                if (artista.equals("salir")){
                    break;
                }

                listaArtistas.add(artista);
            }

            Festival festival = new Festival(nombre, fecha, precio,listaArtistas);
            listaEventos.add(festival);

        }else {
            System.out.println("No existe el tipo de evento");
        }
    }

    public static void generarUsuarios(int cantidad){

        for (int i = 0; i < cantidad; i++) {
            String usuario = "";
            String contrasenya = "";

            for (int j = 0; j < 8; j++) {

                usuario+=caracteres.charAt(aleatorio.nextInt(caracteres.length()));

            }

            for (int j = 0; j < 8; j++) {

                contrasenya+=caracteres.charAt(aleatorio.nextInt(caracteres.length()));

            }

            System.out.println("Chivato de usuarios generados -- "+usuario+" "+contrasenya);

            Usuario objeto = new Usuario(usuario,contrasenya);
            usuariosRegistrados.add(objeto);


        }



    }

    public static Set<Usuario> getUsuariosRegistrados(){
        return Collections.unmodifiableSet(usuariosRegistrados);
    }

    public static void verEventos(){

        for (Evento eventito : listaEventos){
            System.out.println(eventito.getNombre()+" "+eventito.getFecha());
        }

    }

    public static Evento getEvento(int posicion){
        ArrayList<Evento> lista = new ArrayList<>(listaEventos);

        return lista.get(posicion-1);

    }
}
