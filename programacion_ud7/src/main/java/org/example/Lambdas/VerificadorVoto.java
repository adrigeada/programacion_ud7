package org.example.Lambdas;

@FunctionalInterface
public interface VerificadorVoto {
    boolean puedeVotar(String nombre,int edad);
}
