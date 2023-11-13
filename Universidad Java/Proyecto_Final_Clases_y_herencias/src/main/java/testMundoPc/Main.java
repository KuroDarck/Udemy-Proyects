package testMundoPc;

import org.mundoPc.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("¡Hola y bienvenido!");

        // Crear un objeto Monitor con marca "Dell" y dimensiones 14.5
        Monitor monitor = new Monitor("Dell", 14.5);

        // Crear un objeto Teclado con tipo de entrada "bluetooth" y marca "Dell"
        Teclado teclado = new Teclado("bluetooth", "Dell");

        // Crear un objeto Raton con tipo de entrada "USB-bluetooth" y marca "Dell"
        Raton raton = new Raton("USB-bluetooth", "Dell");

        // Crear un objeto Computadora con nombre "Masterica", monitor, teclado y ratón previamente creados
        Computadora computadora1 = new Computadora("Masterica", monitor, teclado, raton);

        // Crear un objeto Orden
        Orden orden1 = new Orden();

        // Agregar la computadora1 a la orden1
        orden1.addComputador(computadora1);

        // Crear un nuevo objeto Monitor con marca "Mac" y dimensiones 14.5
        Monitor monitorM = new Monitor("Mac", 15.5);

        // Crear un nuevo objeto Teclado con tipo de entrada "Cable" y marca "Mac"
        Teclado tecladoT = new Teclado("Cable", "Mac");

        // Crear un nuevo objeto Raton con tipo de entrada "USB" y marca "Mac"
        Raton ratonR = new Raton("USB", "Mac");

        // Crear un nuevo objeto Computadora con nombre "Punish", monitorM, tecladoT y ratonR previamente creados
        computadora1 = new Computadora("Punish", monitorM, tecladoT, ratonR);

        // Agregar la nueva computadora1 a la orden1
        orden1.addComputador(computadora1);

        // Crear otro nuevo objeto Computadora con nombre "lexma", monitorM, teclado y ratonR previamente creados
        computadora1 = new Computadora("lexma", monitorM, teclado, ratonR);

        // Agregar la otra computadora1 a la orden1
        orden1.addComputador(computadora1);

        // Mostrar la orden1
        orden1.mostrarOrden();
    }
}