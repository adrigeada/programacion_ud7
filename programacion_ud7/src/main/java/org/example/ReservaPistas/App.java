package org.example.ReservaPistas;

import java.time.LocalDateTime;
import java.util.*;

public class App {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Reserva> listaReservas = new ArrayList<>();

    static HashMap<Usuario,ArrayList<Reserva>> mapaReservas = new HashMap<>();

    static void main() {

//        Usuario u1 = new Usuario("Adri");
//        Usuario u2 = new Usuario("Ruben");
//        Usuario u3 = new Usuario("Carlos");
//        Usuario u4 = new Usuario("Raquel");
//
//        Padel padel = new Padel("Cristal",1);
//        Tenis tenis = new Tenis("Hierba",2);

//        LocalDateTime fechita = LocalDateTime.of(2026,3,14,19,30);
//
//        Reserva r1 = new Reserva(u1,padel,fechita);
//        Reserva r2 = new Reserva(u1,padel,2026,3,15,18,0);
//        Reserva r3 = new Reserva(u1,padel,2026,5,8,14,30);
//        Reserva r4 = new Reserva(u2,tenis,2026,4,18,17,25);
//        Reserva r5 = new Reserva(u2,padel,2026,9,30,15,45);

//        ArrayList<Reserva> listaTonta = new ArrayList<>();
//        listaTonta.add(r1);
//        listaTonta.add(r2);
//        listaTonta.add(r3);
//
//        mapaReservas.put(u1,listaTonta);


        while (true){

            try {
                generacionReserva();
            }catch (MismaHoraExcepcion e){
                System.out.println("No se puede hacer dos reservas a la misma hora");
            }
            System.out.println("Quieres hacer más reservas? S/N");
            if (teclado.nextLine().equalsIgnoreCase("n")){
                break;
            }
        }


        try {

            for (Reserva res : busquedaReserva()){
                System.out.println("- "+res);
            }

        } catch (NombreInexistente e) {
            System.out.println("Nombre no encontrado");
        }



    }

    public static void borrarReservas(){


        String respuesta = "";

        while (true){
            System.out.println("Quieres borrar las reservas de padel o tenis?");
            respuesta = teclado.nextLine();

            if ((respuesta.equals("tenis"))){
                Iterator<Reserva> it = listaReservas.iterator();

                while (it.hasNext()){
                    Reserva reserva = it.next();

                    if (reserva.getPista() instanceof Tenis){
                        it.remove();
                    }
                }
                break;
            } else if (respuesta.equals("padel")) {
                Iterator<Reserva> it = listaReservas.iterator();

                while (it.hasNext()){

                    if (it.next().getPista() instanceof Padel){
                        it.remove();
                    }
                }
                break;
            }else {
                System.out.println("Escribe tenis o padel");
            }
        }

    }

    public static ArrayList<Reserva> busquedaReserva(){

        System.out.println("De que usuario quieres buscar las reservas?");

        for (Map.Entry<Usuario,ArrayList<Reserva>> mapita : mapaReservas.entrySet()){
            System.out.println("- "+mapita.getKey());
        }

        String nombre = teclado.nextLine();

        //Si en el mapa hay un usuario con el nombre escrito, se devuelve su lista de reservas.
        //Si no, se lanza una excepción
        for (Map.Entry<Usuario,ArrayList<Reserva>> mapita : mapaReservas.entrySet()){

            if (mapita.getKey().getNombre().equals(nombre)){
                System.out.println("Reservas de "+mapita.getKey()+":");
                return mapita.getValue();
            }
        }
        throw new NombreInexistente();

    }


    public static void generacionReserva(){
        System.out.println("A nombre de quien es la reserva?");
        String nombre = teclado.nextLine();
        System.out.println("Numero de identificacion:");
        int id = teclado.nextInt();
        teclado.nextLine();

        Usuario usuario = new Usuario(nombre,id);
        Pista pistaObjeto = null;

        while (true){

            System.out.println("Tenis o Padel?");
            String pista = teclado.nextLine().toLowerCase();

            if (pista.equals("tenis")){
                System.out.println("tierra batida, cemento o hierba?");
                String tipoPista = teclado.nextLine();
                pistaObjeto = new Tenis(tipoPista,1);
                break;
            } else if (pista.equals("padel")) {
                System.out.println("Paredes de cristal o cemento?");
                String tipoPista = teclado.nextLine();
                pistaObjeto = new Padel(tipoPista,2);
                break;
            }else {
                System.out.println("Escribe bien");
            }

        }

        System.out.println("Fecha y hora de la reserva [aaaa,mm,dd,hh,mm]");
        String fechaString[] = teclado.nextLine().split(",");

        LocalDateTime fecha = LocalDateTime.of(Integer.parseInt(fechaString[0]),Integer.parseInt(fechaString[1]),Integer.parseInt(fechaString[2]),Integer.parseInt(fechaString[3]),Integer.parseInt(fechaString[4]));

        Reserva reserva = new Reserva(usuario,pistaObjeto,fecha);

        insertarReservaMapa(reserva,usuario);


    }

    public static void insertarReservaMapa(Reserva reserva,Usuario usuario){

        //Recorres el mapa. Coges las listas de reservas. Te recorres la lista de reservas. Si hay dos iguales salta excepción
        //Dos reservas son iguales si tienen la misma fecha. (equals/hashcode)
        for (Map.Entry<Usuario,ArrayList<Reserva>> mapita : mapaReservas.entrySet()){

            for (Reserva reservaTest : mapita.getValue()){

                if (reservaTest.equals(reserva)){
                    throw new MismaHoraExcepcion();
                }

            }

        }

        //Si en el mapa existe el usuario, coges la lista de ese usuario y le haces un add de la reserva
        if (mapaReservas.containsKey(usuario)){

            for (Map.Entry<Usuario,ArrayList<Reserva>> mapita : mapaReservas.entrySet()){
                if (mapita.getKey().equals(usuario)){

                    mapita.getValue().add(reserva);
                }

            }
        //Si en el mapa no existe el usuario, creas una lista tonta para poder hacer un put en el mapa.
        }else {
            ArrayList<Reserva> listaTonta = new ArrayList<>();
            listaTonta.add(reserva);
            mapaReservas.put(usuario,listaTonta);
        }

    }


}
