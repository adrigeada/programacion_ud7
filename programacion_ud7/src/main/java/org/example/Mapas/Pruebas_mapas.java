package org.example.Mapas;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pruebas_mapas {
    static void main() {

        HashMap<String,String> concejales = new HashMap<>();
                //clave , valor
//        TreeMap<>
//        LinkedHashMap

        concejales.put("Enrique Pastor","Juventud y tiempo libre");
        concejales.put("Mónica Gil","Familia y fiestas");

        System.out.println(concejales.keySet()); //para ver las claves en un array. Si los usas para un for each solo sacas claves
        System.out.println(concejales.values()); //para ver los valores en un array
        System.out.println(concejales.get("Enrique Pastor")); //para buscar por clave. Te devuelve el valor
        //concejales.remove("clave")

        for (Map.Entry<String,String> mapita : concejales.entrySet()){ //para coger claves y valores

            System.out.println("El concejal "+mapita.getKey()+ " tiene el cargo: "+mapita.getValue());

        }

    }
}
