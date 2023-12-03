package org.mano;

import java.util.Random;
import java.util.Scanner;

public class MasterMind2 {

    public static void main(String[] args) {

        //Variables otorgadas para diseñar proyecto
        final byte MAX_INTENTOS = 10;
        final byte LARGO_CODIGO = 4;
        final char PRIMERA_LETRA = 'A';
        final char ULTIMA_LETRA = 'H';

        // ----------------------------------------------------------------
        //Variables propias que considero necesarias para el proyecto
        char[] codigo = new char[LARGO_CODIGO];
        String codgoIngresado;
        int contador = 0;
        int acierto;
        int regular;
        boolean[] comparado = new boolean[LARGO_CODIGO];

        Scanner sc = new Scanner(System.in);

        //Generar código aleatorio
        //Empieza el bloque que genera y llena el arreglo deck con letras aleatorias sin repetir
        Random rand = new Random();
        int numeroGenerado;
        for (int i = 0; i < LARGO_CODIGO; i++) {
            numeroGenerado = rand.nextInt(((int) ULTIMA_LETRA - (int) PRIMERA_LETRA) + 1) + (int) (PRIMERA_LETRA);
            codigo[i] = (char) numeroGenerado;
        }

        //Termina el bloque de generación y llenado de letras aleatorias
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            MasterMind V1.0");
        System.out.println("    Dispones de 10 intentos para adivinar el código.");
        System.out.println("    Debe ingresar un código de 4 letras mayúsculas");
        System.out.println("                            Ejemplo: ABCD");
        System.out.println("----------------------------------------------------------------\n");

        do {
            System.out.println(codigo);
            System.out.println("Intento: " + (contador + 1) + " de 10 intentos para adivinar el código.");
            System.out.print("Codigo >>> ");
            codgoIngresado = sc.nextLine();
            regular = 0;
            acierto = 0;
            for (boolean b : comparado) {
                b=false;
            }
            //bucle comparador de código con la entrada del usuario
            for (int i = 0; i < LARGO_CODIGO; i++) {
                for (int j = 0; j < LARGO_CODIGO; j++) {
                    if (!comparado[j] && codgoIngresado.charAt(j) == codigo[i]) {
                        if (j == i) {
                            acierto++;
                        } else {
                            regular++;
                        }
                        comparado[j] = true;// bandera que evita que una letra sea comparada más de una vez
                        break;  // Rompe el bucle interno una vez que se encuentra una coincidencia
                    }
                }
            }

            System.out.println("B: " + acierto + "  R: " + regular);//Impression de acierto y casi aciertos

            contador++;
        } while (contador < MAX_INTENTOS);

        System.out.println("!Oh no, Perdiste  el Codigo era: " + codigo[0] + codigo[1] + codigo[2] + codigo[3]);

    }

}