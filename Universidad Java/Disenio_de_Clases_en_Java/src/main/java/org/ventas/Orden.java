package org.ventas;

import org.jetbrains.annotations.NotNull;

public class Orden extends Producto {

    private final int idOrden; // Identificador de la orden
    private static int contadorOrden; // Contador estático para generar el identificador único de la orden
    private int contadorProducto; // Contador para realizar un seguimiento de la cantidad de productos en la orden
    private static final int MAX_PRODUCTO = 10; // Máximo número de productos permitidos en la orden
    private final Producto[] producto; // Arreglo de productos en la orden

    public Orden() {
        this.idOrden = ++Orden.contadorOrden; // Incrementa el contador y asigna el valor al identificador de la orden
        this.producto = new Producto[Orden.MAX_PRODUCTO]; // Inicializa el arreglo de productos con el tamaño máximo
    }

    public void agregarProducto(@NotNull Producto producto) {
        if (this.contadorProducto < Orden.MAX_PRODUCTO) {
            this.producto[contadorProducto++] = producto; // Agrega el producto al arreglo y aumenta el contador de productos
        } else {
            throw new IllegalArgumentException("No puede superar el máximo de " + Orden.MAX_PRODUCTO + " en la orden");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : this.producto) {
            if (p != null) {
                total += p.getPrecio(); // Suma el precio de cada producto al total
            }
        }
        return total;
    }

    public void mostrarOrden() {
        System.out.println("Orden # " + this.idOrden); // Muestra el identificador de la orden
        System.out.println("Productos de la Orden");
        for (int i = 0; i < this.contadorProducto; i++) {
            System.out.println(this.producto[i]); // Muestra cada producto en la orden
        }
        System.out.println("Total: " + calcularTotal()); // Muestra el total de la orden
    }
}