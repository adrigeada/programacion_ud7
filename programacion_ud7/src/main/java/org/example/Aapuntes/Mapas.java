package org.example.Aapuntes;

import java.util.HashMap;
import java.util.Map;

public class Mapas {
    static void main() {

        HashMap<String,String> concejales = new HashMap<>();
        //clave , valor
//        TreeMap<>
//        LinkedHashMap

        //METODOS

        concejales.put("clave","valor");
        concejales.get("clave");//das clave, devuelve valor
        concejales.remove("clave");//borrar por clave, tambien se puede usar clave y valor
        concejales.containsKey("clave");
        concejales.containsValue("valor");
        concejales.keySet();//Devuelve una lista Set con las claves
        concejales.values();//Devuelve una coleccion de los valores

        concejales.entrySet();//devuelve una coleccion tipo Entry con las claves y valores

        //recorrer un mapa

        for (Map.Entry<String,String> mapita : concejales.entrySet()){
            mapita.getKey();
            mapita.getValue();
        }

    }
}
