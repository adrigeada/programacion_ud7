package org.example.EjercicioDiccionario;

import java.util.Map;

public class Precarga {
    static void main() {

        String[] esp = {
                "Persona", "Año", "Camino", "Día", "Hombre", "Estado", "Lugar", "Parte", "Semana", "Mundo",
                "Mujer", "Vida", "Niño", "Ojo", "Trabajo", "Mano", "Gobierno", "Caso", "Punto", "Empresa",
                "Número", "Grupo", "Problema", "Hecho", "Fuerza", "Mes", "Familia", "Cambio", "Escuela", "Libro",
                "Agua", "Idea", "Padre", "Lado", "Ciudad", "Noche", "Cuerpo", "Poder", "Nombre", "Cara",
                "Amigo", "Casa", "Hora", "Guerra", "Línea", "Fin", "Mañana", "Ley", "Coche", "Ciudadano",
                "Pueblo", "Momento", "Causa", "Nivel", "Equipo", "País", "Proyecto", "Servicio", "Hijo", "Madre",
                "Voz", "Relación", "Papel", "Especie", "Cuidado", "Situación", "Muerte", "Sentido", "Duda", "Vista",
                "Clase", "Campo", "Aire", "Fuego", "Tierra", "Cielo", "Mar", "Sol", "Luna", "Flor",
                "Árbol", "Perro", "Gato", "Pájaro", "Pez", "Comida", "Bebida", "Ropa", "Zapato", "Calle",
                "Puerta", "Ventana", "Mesa", "Silla", "Cama", "Cocina", "Baño", "Reloj", "Dinero", "Bolsa",
                "Cine", "Música", "Arte", "Historia", "Ciencia", "Salud", "Dolor", "Paz", "Miedo", "Amor",
                "Ser", "Haber", "Estar", "Tener", "Hacer", "Decir", "Ir", "Ver", "Dar", "Saber",
                "Querer", "Llegar", "Pasar", "Deber", "Poner", "Parecer", "Quedar", "Creer", "Hablar", "Llevar",
                "Grande", "Pequeño", "Bueno", "Malo", "Nuevo", "Viejo", "Alto", "Bajo", "Largo", "Corto",
                "Fácil", "Difícil", "Rápido", "Lento", "Caliente", "Frío", "Fuerte", "Débil", "Rico", "Pobre",
                "Blanco", "Negro", "Rojo", "Azul", "Verde", "Amarillo", "Gris", "Naranja", "Rosa", "Marrón",
                "Primero", "Último", "Próximo", "Anterior", "Mejor", "Peor", "Derecha", "Izquierda", "Centro", "Fuera",
                "Dentro", "Arriba", "Abajo", "Cerca", "Lejos", "Temprano", "Tarde", "Siempre", "Nunca", "Quizás",
                "Todo", "Nada", "Algo", "Poco", "Mucho", "Bastante", "Igual", "Diferente", "Joven", "Adulto"
        };

        String[] ing = {
                "Person", "Year", "Way", "Day", "Man", "State", "Place", "Part", "Week", "World",
                "Woman", "Life", "Child", "Eye", "Work", "Hand", "Government", "Case", "Point", "Company",
                "Number", "Group", "Problem", "Fact", "Force", "Month", "Family", "Change", "School", "Book",
                "Water", "Idea", "Father", "Side", "City", "Night", "Body", "Power", "Name", "Face",
                "Friend", "House", "Hour", "War", "Line", "End", "Morning", "Law", "Car", "Citizen",
                "Town", "Moment", "Cause", "Level", "Team", "Country", "Project", "Service", "Son", "Mother",
                "Voice", "Relation", "Paper", "Species", "Care", "Situation", "Death", "Sense", "Doubt", "View",
                "Class", "Field", "Air", "Fire", "Earth", "Sky", "Sea", "Sun", "Moon", "Flower",
                "Tree", "Dog", "Cat", "Bird", "Fish", "Food", "Drink", "Clothes", "Shoe", "Street",
                "Door", "Window", "Table", "Chair", "Bed", "Kitchen", "Bathroom", "Watch", "Money", "Bag",
                "Cinema", "Music", "Art", "History", "Science", "Health", "Pain", "Peace", "Fear", "Love",
                "To be", "To have", "To be", "To have", "To do", "To say", "To go", "To see", "To give", "To know",
                "To want", "To arrive", "To pass", "To owe", "To put", "To seem", "To stay", "To believe", "To speak", "To carry",
                "Big", "Small", "Good", "Bad", "New", "Old", "Tall", "Short", "Long", "Short",
                "Easy", "Difficult", "Fast", "Slow", "Hot", "Cold", "Strong", "Weak", "Rich", "Poor",
                "White", "Black", "Red", "Blue", "Green", "Yellow", "Gray", "Orange", "Pink", "Brown",
                "First", "Last", "Next", "Previous", "Better", "Worse", "Right", "Left", "Center", "Outside",
                "Inside", "Up", "Down", "Near", "Far", "Early", "Late", "Always", "Never", "Maybe",
                "All", "Nothing", "Something", "Little", "Much", "Enough", "Equal", "Different", "Young", "Adult"
        };

        for (int i = 0; i < esp.length; i++) {
            nuevoPar(esp[i], ing[i]);
        }


    }

    public static void nuevoPar(String espanyol,String ingles){
        Diccionario.mapaDiccionario.put(espanyol,ingles);

//        for (Map.Entry<String,String> mapita : Diccionario.mapaDiccionario.entrySet()){
//            System.out.println(mapita.getKey()+" : "+mapita.getValue());
//        }

    }
}
