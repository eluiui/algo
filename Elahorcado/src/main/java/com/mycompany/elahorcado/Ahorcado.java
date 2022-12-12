package com.mycompany.elahorcado;

import java.util.ArrayList;
import java.util.Scanner;

public class Ahorcado {

//aqui ponemos los atributos de la clase
    ArrayList<Character> letras = new ArrayList<>();
    private String palabra;
    private int errores;

//aqui nos pedira que introduzcamos una palabra antes de iniciuar el juego
    private void pedirPalabra() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce la palabra: ");
        palabra = scan.nextLine();
    }

//aqui utilizamos un bucle para crear arrays con el mismo numero de letras que tenga la palabra
    private void crearArray() {
        for (int y = 0; y < palabra.length(); y++) {
            letras.add('_');
        }
    }

//aqui mostramos el array creado y en el mismo en el lugar de cada letra se pone un _
    private void mostrarArray() {
        for (int y = 0; y < letras.size(); y++) {
            System.out.print(letras.get(y) + " ");
        }
        System.out.print("\n\n");
    }

//aqui pediremos la letra 
    private void pedirLetra() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce una letra: ");
        char letra = scan.nextLine().charAt(0);
        if (!comprobar(letra)) {
            errores++;
        }
    }

//comprueba si la letra escrita esta en la palabra
    private boolean comprobar(char letra) {
        boolean estar = false;
        for (int y = 0; y < letras.size(); y++) {
            if (palabra.charAt(y) == letra) {
                letras.set(y, letra);
                estar = true;
            }

        }
        return estar;
    }

//aqui llamamos a los metrodos anteriores para que podamos empezar a correr el juego
    public void jugar() {
        pedirPalabra();
        crearArray();
        mostrarArray();
        while (errores < 5 && letras.contains('_')) {
            pedirLetra();
            mostrarArray();
        }
        if (!letras.contains('_')) {
            System.out.println("Has ganado");
        } else if (errores == 5) {
            System.out.println("Has perdido");
        }
    }
}
