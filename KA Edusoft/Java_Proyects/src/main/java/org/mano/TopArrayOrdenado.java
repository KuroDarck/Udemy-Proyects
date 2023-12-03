package org.mano;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TopArrayOrdenado {

    /**
     * Variable necesaria para la lista
     */
    public static final int MAX_TOP = 100;

    public record TopArrayOrd(
            int[] arrayOrdenado,
            AtomicInteger topeArray
    ) {
    }

    /**
     * iniciarArreglo(int): función que recibirá la cantidad máxima de celdas que el arreglo contendrá.
     * Lo inicializará como vacío y lo retornará como resultado.
     */
    public static TopArrayOrd iniciarArreglo(int iniciarEn) {
        return new TopArrayOrd(new int[MAX_TOP], new AtomicInteger(iniciarEn));
    }

    /**
     * esVacio(TopArrayOrdenado): función booleana que retornará TRUE si el arreglo está vacío, FALSE si no.
     */
    public static boolean esVacio(TopArrayOrd arrayOrd) {
        return arrayOrd.topeArray.get() == -1;
    }

    /**
     * esLleno(TopArrayOrdenado): funcíon booleana que retorna TRUE si el arreglo está lleno, FALSE Si no.
     */
    public static boolean esLleno(TopArrayOrd arrayOrd) {
        return arrayOrd.topeArray.get() == MAX_TOP;
    }

    /**
     * cantidadMaxima(TopArrayOrdeando): función entera que retornará
     * la cantidad máxima de elementos que pueden ser insertados en el arreglo.
     * Dicho valor será el que se utilizó en la función iniciarArreglo
     * al crear el elemento TopArrayOrdenado.
     */
    public static int cantidadMaxima(TopArrayOrd arrayOrd) {
        return arrayOrd.topeArray.get();
    }

    /**
     * Cantidad(TopArrayOrdenado): función que retornará la cantidad de elementos
     * contenidos en el arreglo hasta el momento, cero si no se ha insertado ninguno.
     */
    public static int cantidad(TopArrayOrd arrayOrd) {
        int cantidad = 0;
        for (int i = 0; i < arrayOrd.topeArray.get(); i++) {
            if (arrayOrd.arrayOrdenado[i] != 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    /**
     * Add(int, TopArrayOrdenado): inserta en el arreglo el entero pasado como argumento ordenado de forma ascendente.
     */
    public static void add(int a, TopArrayOrd arrayOrd) {
        int copiaTemporal;
        boolean flag = true;
        for (int i = 0; i < arrayOrd.topeArray.get(); i++) {
            if (i == 0) {
                arrayOrd.arrayOrdenado[i] = a;
            } else {
                break;
            }
        }
        while (flag) {
            flag = false;
            for (int j = 0; j < arrayOrd.topeArray.get() - 1; j++) {
                if (arrayOrd.arrayOrdenado[j] > arrayOrd.arrayOrdenado[j + 1]) {
                    copiaTemporal = arrayOrd.arrayOrdenado[j];
                    arrayOrd.arrayOrdenado[j] = arrayOrd.arrayOrdenado[j + 1];
                    arrayOrd.arrayOrdenado[j + 1] = copiaTemporal;
                    flag = true;
                }
            }
        }
    }

    /**
     * Existe(int, TopArrayOrdenado): retorna TRUE si el entero pasado como argumento
     * existe en el arreglo, FALSE si no. Si el arreglo está vacío también se retorna FALSE.
     * El algoritmo para buscar el elemento debe ser por bipartición.
     */
    public static boolean existe(int a, TopArrayOrd arrayOrd) {
        for (int i = 0; i < arrayOrd.topeArray.get(); i++) {
            if (arrayOrd.arrayOrdenado[i] == a) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ocurrencias(int, TopArrayOrdenado): retorna la cantidad de ocurrencias
     * del entero pasado como argumento, o cero si dicho número no existe dentro del arreglo.
     * El algoritmo de búsqueda debe ser por bipartición.
     */
    public static int ocurrencias(int a, TopArrayOrd arrayOrd) {
        int contarOcurrencia = 0;
        for (int i = 0; i < arrayOrd.topeArray.get(); i++) {
            if (a == arrayOrd.arrayOrdenado[i]) {
                contarOcurrencia++;
            }
        }
        return contarOcurrencia;
    }

    /**
     * Índices(int, TopArrayOrdenado): retorna un arreglo de enteros conteniendo
     * los índices en que un número aparece.
     * Por ejemplo, si el arreglo tuviera los valores [4,5,6,4,8,9,4]
     * y se pasara como valor a esta operación el 4, se retornará como argumento
     * un arreglo con los valores [0,3,6], que son las posiciones en que 4 aparece en el arreglo.
     * Si el número no aparece en el arreglo se retornará un arreglo con una única celda y el valor -1: [-1].
     * Nótese que en la práctica será más sencillo, ya que la operación de inserción add inserta
     * de manera ordenada, por tanto, el arreglo con tope sería [4,4,4,5,6,8,9] y, en consecuencia, el retorno sería [0,1,2].
     */
    public static int[] indice(int a, TopArrayOrd arrayOrd) {
        int[] temporal = new int[0];
        int contador = 0;
        for (int i = 0; i < arrayOrd.topeArray.get(); i++) {
            if (arrayOrd.arrayOrdenado[i] == a) {
                temporal[contador] = i;
                contador++;
            }
        }

        return new int[]{};
    }

    /**
     * eliminarPrimera(int, TopArrayOrdenado): Elimina la primera ocurrencia del elemento pasado como argumento.
     * Se debe utilizar la operación índices como parte de la implementación de este procedimiento.
     * Si no existe en el arreglo el valor indicado esta operación no hace nada.
     */
    public static void eliminarPrimera(int a, TopArrayOrd arrayOrd) {

    }

    /**
     * eliminarUltimo(int, TopArrayOrdenado): Ídem anterior pero eliminando la última ocurrencia del número indicado.
     */
    public static void eliminarUltimo(int a, TopArrayOrd arrayOrd) {


    }

    /**
     * Vaciar(TopArrayOrdenado): Elimina todos los elementos del arreglo y lo deja vacío.
     */
    public static void vaciar(TopArrayOrd arrayOrd) {
        for (int i = 0; i < arrayOrd.topeArray.get(); i++) {
            arrayOrd.arrayOrdenado[i] = 0;
        }
    }

    //comienzo del main program
    public static void main(String[] args) {


    }
}