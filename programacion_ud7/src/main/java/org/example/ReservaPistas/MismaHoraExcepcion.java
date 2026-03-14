package org.example.ReservaPistas;

public class MismaHoraExcepcion extends RuntimeException {

    public MismaHoraExcepcion() {
        super("No se pueden reservar dos pistas a la misma hora");
    }
}
