package org.example.pruebas_StringBuilder;

public class prueba_stringBuilder {

    static void main() {

        StringBuilder sb = new StringBuilder();

        sb.append("Calleu ");
        sb.append("mantecao ").append("Joaquín!! ").append("adiós ");

        sb.insert(16, "de limón ");
        sb.replace(25,35,"Jacobo ");
        sb.delete(25,32);

        System.out.println(sb);

        System.out.println(sb.reverse());




    }

}
