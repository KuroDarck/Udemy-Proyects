package org.mano;

import java.util.Random;
import java.util.Scanner;

public class Truco_de_las_21_Cartas {

    public static void main(String[] args) {
        //Constantes para estandarizar los valores del programa
        final short MAX_TARJETAS_GRUPO = 7; //Tarjetas por grupo
        final short MAX_GRUPOS = 3; //Cantidad de grupos
        final short MAX_TARJETAS = MAX_TARJETAS_GRUPO * MAX_GRUPOS; //Total de tarjetas.
        final short MIN_TARJETA_VALOR = 'A'; //Tarjeta incial, en este caso letra A.
        final short MAX_TARJETA_VALOR = (char) (MAX_TARJETAS + (int) ('A') - 1); //Tarjeta final.
        //Variables que deben usarse para resolver el problema.
        char[] grupo1 = new char[MAX_TARJETAS_GRUPO],
                grupo2 = new char[MAX_TARJETAS_GRUPO],
                grupo3 = new char[MAX_TARJETAS_GRUPO];
        char[] deck = new char[MAX_TARJETAS];

        //Empieza el bloque que genera y llena el arreglo deck con letras aleatorias sin repetir
        Random rand = new Random();
        int numeroGenerado;
        for (int i = 0; i < MAX_TARJETAS; i++) {
            numeroGenerado = rand.nextInt(((int) MAX_TARJETA_VALOR - (int) MIN_TARJETA_VALOR) + 1) + (int) (MIN_TARJETA_VALOR);
            int j = 0;
            while (j < i) {
                if (deck[j] == numeroGenerado) {
                    j = 0;
                    numeroGenerado = rand.nextInt(((int) MAX_TARJETA_VALOR - (int) MIN_TARJETA_VALOR) + 1) + (int) (MIN_TARJETA_VALOR);
                } else {
                    j++;
                }
            }
            deck[i] = (char) numeroGenerado;
        }
        //Termina el bloque de generación y llenado de letras aleatorias

        // comienzo del bloque de llenado de las tres columnas de cartas
        for (int i = 0; i < MAX_TARJETAS; i++) {
            if (i < MAX_TARJETAS_GRUPO) {
                grupo1[i] = deck[i];
            } else if ((i - 7) < MAX_TARJETAS_GRUPO) {
                grupo2[i - 7] = deck[i];
            } else {
                grupo3[i - 14] = deck[i];
            }
        }
        // fin del rellenado de  los 3 bloques

        //comienzo del bucle de repetición en el que el usuario elige su carta, en uno de los 3 bloques
        int contador = 0;// contador del while de repetición
        System.out.println("------------------------------------------------");
        System.out.println("Haremos 3 secuencias. Empecemos ...");
        System.out.println("------------------------------------------------");
        System.out.println("Secuencia: " + contador + 1);
        System.out.println("------------------------------------------------\n");
        for (int i = 0; i < MAX_TARJETAS_GRUPO; i++) { //imprecion de las 3 colunnas
            System.out.printf("     %-10c%-10c%-10c\n", grupo1[i], grupo2[i], grupo3[i]);
        }
        do {
            System.out.println("\n------------------------------------------------");
            System.out.println("En que grupo esta tu carta [1, 2, 3]:   ");
            System.out.println("------------------------------------------------");
            Scanner scanner = new Scanner(System.in);
            int tuElexion = scanner.nextInt();
            while ((tuElexion > 3) || (tuElexion < 1)) {//comprobando que la seleccion de colunnas este en el rango permitido de 1 a 3
                System.out.println("En que grupo esta tu carta [1, 2, 3]");
                tuElexion = scanner.nextInt();
            }
//devolviendo todos los maso de 7 cartas al deck
            for (int i = 0; i < MAX_TARJETAS_GRUPO; i++) {
                if (tuElexion == 1) {
                    deck[i] = grupo2[i];
                    deck[i + 7] = grupo1[i];
                    deck[i + 14] = grupo3[i];
                }
            }
            for (int i = 0; i < MAX_TARJETAS_GRUPO; i++) {
                if (tuElexion == 3) {
                    deck[i] = grupo1[i];
                    deck[i + 7] = grupo3[i];
                    deck[i + 14] = grupo2[i];
                }
            }

            for (int i = 0; i < MAX_TARJETAS_GRUPO; i++) {
                if (tuElexion == 2) {
                    deck[i] = grupo1[i];
                    deck[i + 7] = grupo2[i];
                    deck[i + 14] = grupo3[i];
                }
            }
            for (int i = 0; i < MAX_TARJETAS_GRUPO; i++) {
                if (contador == 1) {
                    deck[i + 14] = grupo3[i];
                } else {
                    deck[i + 14] = grupo2[i];
                }
            }
            //fin del llenado del deck

            //comienso del varajeo de cartas
            int j = 0, r = 0;
            while (j < MAX_TARJETAS && r < MAX_TARJETAS_GRUPO) {
                grupo1[r] = deck[j];
                grupo2[r] = deck[j + 1];
                grupo3[r] = deck[j + 2];
                r++;
                j += 3;
            }
            contador++;

            if (contador < 3) {
                System.out.println("------------------------------------------------");
                System.out.println("Secuencia: " + (contador + 1));
                System.out.println("------------------------------------------------\n");
                for (int i = 0; i < MAX_TARJETAS_GRUPO; i++) { //imprecion de las 3 colunnas
                    System.out.printf("     %-10c%-10c%-10c\n", grupo1[i], grupo2[i], grupo3[i]);
                }
            }
        } while (contador < 3);
        //devolviendo todos los maso de 7 cartas al deck

        System.out.println("Tu letra elegida es la:  " + deck[21 / 2]);
    }


}