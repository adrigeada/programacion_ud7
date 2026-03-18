package org.example.comparables;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@ToString
public class Invitado implements Comparable<Invitado>{ //implements Comparable<Invitado>

    private LocalTime hora;
    private Integer edad;
    private String nombre;

    public Invitado(int edad, String nombre) {
        this.hora = LocalTime.now();
        this.edad = edad;
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Invitado o) {
        //compare to devuelve numero positivo si hora es mas grande que o.getHora. Numero negativo al reves


        int comparar = edad.compareTo(o.getEdad());

        if (comparar != 0){
            return comparar;
        }

        comparar = nombre.compareTo(o.getNombre()); //TIENE QUE SER DATO NO PRIMITIVO

        if (comparar != 0){
            return comparar;
        }


        return hora.compareTo(o.getHora());
    }
}
