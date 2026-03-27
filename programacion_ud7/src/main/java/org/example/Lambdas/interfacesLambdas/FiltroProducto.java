package org.example.Lambdas.interfacesLambdas;

import org.example.Lambdas.clasesLambdas.Producto;

@FunctionalInterface
public interface FiltroProducto {
    boolean filtrar(Producto productos);
}
