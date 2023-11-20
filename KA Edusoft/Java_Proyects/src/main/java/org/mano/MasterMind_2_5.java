package org.mano;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MasterMind_2_5 {
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




        //Utilización de la función y llenado de código a adivinar
        codigo=generarCodigo(LARGO_CODIGO,PRIMERA_LETRA,ULTIMA_LETRA);

        //Termina el bloque de generación y llenado de letras aleatorias
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            MasterMind V1.0");
        System.out.println("    Dispones de 10 intentos para adivinar el código.");
        System.out.println("    Debe ingresar un código de 4 letras mayúsculas");
        System.out.println("                            Ejemplo: ABCD");
        System.out.println("----------------------------------------------------------------\n");

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Intento: " + (contador + 1) + " de 10 intentos para adivinar el código.");
            System.out.print("Codigo >>> ");
            codgoIngresado = sc.nextLine();
            regular = 0;
            acierto = 0;
            for (int i = 0; i < LARGO_CODIGO; i++) {
                comparado[i] = false;
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
    /**
     * Genera un código al azar y lo asigna a la variable codigo. El codigo generado
     * puede contener letras repetidas.
     * @return Un código de LARGO_CODIGO caracteres generados aleatoriamente.
     */
    public static char[] generarCodigo(int largo,int primera,int ultima){
        Random rand = new Random();
        int numeroGenerado;
        char[] codigoGenerado = new char[largo];
        for (int i = 0; i <largo; i++) {
            numeroGenerado = rand.nextInt(( ultima - primera) + 1) +  (primera); //Generar código aleatorio
            codigoGenerado[i] = (char) numeroGenerado;
        }
        return codigoGenerado;
    }

    /** Lee el código de la entrada estandar y lo asigna a la variable codigo. Además
     * retorna el valor TRUE si el código leido es correcto, FALSE si no.
     * El código leido puede ser incorrecto si:
     * Contiene uno o más caracteres fuera del rango [PRIMERA_LETRA,ULTIMA_LETRA].
     * No contiene el largo LARGO_CODIGO
     *
     * @param codigo Contendrá el código leído desde la entrada. Si hay un error
     * no se garantiza la consistencia del mismo. Verificar, para ello, el retorno
     * de esta operación.
     * @return true si el código cumple con las condiciones, false en caso contrario.
     */
    public static boolean leerCodigo(char[] codigo){

return true;
    }

    /**
     * Imprime en la salida estándar el código pasado como argumento. Deja el
     * cursor al final de la impresión si generar una nueva línea.
     * @param codigo El código que se desea imprimir.
     */
    public static void imprimirCodigo(char[] codigo){
    }
    /**
     * Calcula las notas de codAdivinador en función de codPensador. Asigna los
     buenos
     * y los regulares a los argumentos con el mismo nombre
     * @param codAdivinador El código del adivinador. Se asume que es un código correcto.
     * @param codPensador El código del pensador. Se asume que es un código correcto.
     * @param buenos El cálculo de buenos será asignado a este parámetro.
     * @param regulares El cálculo de regulares será asignado a este parámetro.
     */
    public static void calcularNota(char[] codAdivinador, char[] codPensador, AtomicInteger
            buenos, AtomicInteger regulares){
    }




}

