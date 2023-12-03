package org.mano;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MasterMind_2_5 {

    //Variables otorgadas para diseñar proyecto
    public static final byte MAX_INTENTOS = 10;
    public static final byte LARGO_CODIGO = 4;
    public static final char PRIMERA_LETRA = 'A';
    public static final char ULTIMA_LETRA = 'H';
    //----------------------------------------------------------------

    public static void main(String[] args) {

        //Variables propias que considero necesarias para el proyecto
        char[] codigo = generarCodigo(); // creación y llenado del array código
        char[] codigoIngresado;
        int contador = 0;
        AtomicInteger acierto = new AtomicInteger();
        AtomicInteger regular = new AtomicInteger();


        //Utilización de la función y llenado de código a adivinar


        //Termina el bloque de generación y llenado de letras aleatorias
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            MasterMind V2.5");
        System.out.println("    Dispones de 10 intentos para adivinar el código.");
        System.out.println("    Debe ingresar un código de 4 letras mayúsculas");
        System.out.println("                            Ejemplo: ABCD");
        System.out.println("----------------------------------------------------------------\n");

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Intento: " + (contador + 1) + " de 10 intentos para adivinar el código.");
            boolean found;

                System.out.print("Codigo >>> ");
                codigoIngresado = sc.nextLine().toCharArray();
                found = leerCodigo(codigoIngresado);
            while (!found){
                System.out.println("ERROR: El código no es valido. ");
                System.out.print("Ingresa otro con "+LARGO_CODIGO+" letras entre "+PRIMERA_LETRA+" y "+ULTIMA_LETRA+" >>" );
                codigoIngresado = sc.nextLine().toCharArray();
                found = leerCodigo(codigoIngresado);
            }
            calcularNota(codigoIngresado, codigo, acierto, regular);
            System.out.println("\n----------------------------------------------------------------\n");
            contador++; //cuenta la cantidad de intentos gastados
        } while (contador < MAX_INTENTOS);

        System.out.print("!Oh no, Perdiste  el Codigo era: ");
        imprimirCodigo(codigo);


    }

    /**
     * Genera un código al azar y lo asigna a la variable codigo. El codigo generado
     * puede contener letras repetidas.
     *
     * @return Un código de LARGO_CODIGO caracteres generados aleatoriamente.
     */
    public static char[] generarCodigo() {
        Random rand = new Random();
        int numeroGenerado;
        char[] codigoGenerado = new char[LARGO_CODIGO];
        for (int i = 0; i < LARGO_CODIGO; i++) {
            numeroGenerado = rand.nextInt(((int) ULTIMA_LETRA - (int) PRIMERA_LETRA) + 1) + (int) (PRIMERA_LETRA); //Generar código aleatorio
            codigoGenerado[i] = (char) numeroGenerado;
        }
        return codigoGenerado;
    }

    /**
     * Lee el código de la entrada estandar y lo asigna a la variable codigo, Además
     * retorna el valor TRUE si el código leido es correcto, FALSE si no.
     * El código leido puede ser incorrecto si:
     * Contiene uno o más caracteres fuera del rango [PRIMERA_LETRA, ULTIMA_LETRA].
     * No contiene el largo LARGO_CODIGO
     *
     * @param codigo Contendrá el código leído desde la entrada. Si hay un error
     *               no se garantiza la consistencia del mismo. Verificar, para ello, el retorno
     *               de esta operación.
     * @return true si el código cumple con las condiciones, false en caso contrario.
     */
    public static boolean leerCodigo(char[] codigo) {
        for (char c : codigo) {
            if ((int) c > (int) ULTIMA_LETRA || (int) c < (int) PRIMERA_LETRA) {
                return false;
            }
        }
        return codigo.length == LARGO_CODIGO;
    }

    /**
     * Imprime en la salida estándar el código pasado como argumento. Deja el
     * cursor al final de la impresión si generar una nueva línea.
     *
     * @param codigo El código que se desea imprimir.
     */
    public static void imprimirCodigo(char[] codigo) {
        for (char c : codigo) {
            System.out.print(c);
        }
    }

    /**
     * Calcula las notas de codAdivinador en función de codPensador. Asigna los
     * buenos
     * y los regulares a los argumentos con el mismo nombre
     *
     * @param codAdivinador El código del adivinador. Se asume que es un código correcto.
     * @param codPensador   El código del pensador. Se asume que es un código correcto.
     * @param buenos        El cálculo de buenos será asignado a este parámetro.
     * @param regulares     El cálculo de regulares será asignado a este parámetro.
     */
    public static void calcularNota(char[] codAdivinador, char[] codPensador, AtomicInteger buenos, AtomicInteger regulares) {
        boolean[] comparado = new boolean[]{false,false,false,false};
        buenos.set(0);
        regulares.set(0);

        //Bucle comparador de código con la entrada del usuario
        for (int i = 0; i < LARGO_CODIGO; i++) {
            for (int j = 0; j < LARGO_CODIGO; j++) {
                if (!comparado[j] && codAdivinador[j] == codPensador[i]) {
                    if (j == i) {
                        buenos.set(buenos.get() +1);
                    } else {
                        regulares.set(regulares.get() +1);
                    }
                    comparado[j] = true;// Bandera que evita que una letra sea comparada más de una vez
                    break;  //Rompe el bucle interno una vez que se encuentra una coincidencia
                }
            }
        }
        System.out.println("B: " + buenos.get() + "  R: " + regulares.get());//Impression de acierto y casi aciertos
    }
}

