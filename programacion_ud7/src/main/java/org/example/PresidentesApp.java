package org.example;

public class PresidentesApp {
    static void main() {

        Presidente trump = new Presidente("Donald Tump","USA");
        System.out.println(trump.hashCode());

        Presidente milei = new Presidente("Javier","Argentina");
        System.out.println(milei.hashCode());



    }
}
