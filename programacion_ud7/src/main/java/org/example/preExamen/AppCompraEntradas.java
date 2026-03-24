package org.example.preExamen;

import java.time.LocalDate;
import java.util.Scanner;

public class AppCompraEntradas {
    static Scanner teclado = new Scanner(System.in);

    static void main() {
        TicketMutxa.insertarEvento("Paellas", LocalDate.of(2025,4,16),20,"festival");
        TicketMutxa.insertarEvento("Concierto Estopa",LocalDate.of(2025,4,21),40,"concierto");

        TicketMutxa.generarUsuarios(4);

        Usuario comprador = new Usuario(null,null);

        comprador.autenticarse(TicketMutxa.getUsuariosRegistrados());


        TicketMutxa.verEventos();

        Evento evento = null;

        while (true){
            int posicion = teclado.nextInt();
            teclado.nextLine();

            if (posicion> TicketMutxa.getUsuariosRegistrados().size()){
                System.out.println("Error elige una opcion correcta");
            }else {
                evento = TicketMutxa.getEvento(posicion);
                break;
            }
        }

        System.out.println("Estas comprando entradas para "+evento.getNombre());




    }
}
