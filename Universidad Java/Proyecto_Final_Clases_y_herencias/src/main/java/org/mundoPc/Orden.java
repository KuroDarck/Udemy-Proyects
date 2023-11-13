package org.mundoPc;

import org.jetbrains.annotations.NotNull;

public class Orden{
    private int idOrden;  // Identificador único de la orden
    private Computadora[] computadora;  // Arreglo de objetos Computadora que representan los productos de la orden
    private final static int MAX_COMPUTADORAS = 10;  // Número máximo de productos que puede contener una orden
    private static int contadorOrden;  // Contador estático para dar un identificador único a cada orden
    private int contadorComputadora;  // Contador para el número actual de productos en la orden

    // Constructor de la clase Orden
    public Orden() {
        this.idOrden = ++contadorOrden;  // Asigna un identificador único a la orden
        this.computadora = new Computadora[MAX_COMPUTADORAS];  // Inicializa el arreglo de productos
    }

    // Método para agregar un producto (Computadora) a la orden
    public void addComputador(@NotNull Computadora computador) {
        if (this.contadorComputadora < Orden.MAX_COMPUTADORAS) {
            this.computadora[this.contadorComputadora++] = computador;  // Añade el producto al arreglo
        } else {
            throw new IllegalStateException("No puede superar el límite de ítems:" + Orden.MAX_COMPUTADORAS + " en la orden");
        }
    }

    // Método para mostrar la información de la orden
    public void mostrarOrden() {
        System.out.println("Orden #" + Orden.contadorOrden);
        System.out.println("********************************");
        System.out.println("Productos de la orden:");
        System.out.println("********************************");
        for (int i = 0; i < contadorComputadora; i++) {
            System.out.println(this.computadora[i]);  // Muestra la información de cada producto en la orden
        }
        System.out.println("********************************");
    }
}

