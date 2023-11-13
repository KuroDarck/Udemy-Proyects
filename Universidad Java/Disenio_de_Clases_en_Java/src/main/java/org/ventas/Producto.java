package org.ventas;

public class Producto {
    private int idProducto; // Identificador del producto
    private static int contadorProducto; // Contador estático para generar el identificador único
    private String nombre; // Nombre del producto
    private double precio; // Precio del producto

    public Producto() {
        // Constructor vacío
    }

    public Producto(String nombre, double precio) {
        this.idProducto = ++Producto.contadorProducto; // Incrementa el contador y asigna el valor al identificador del producto
        this.nombre = nombre; // Asigna el nombre del producto
        this.precio = precio; // Asigna el precio del producto
    }

    public String getNombre() {
        return nombre; // Devuelve el nombre del producto
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Establece el nombre del producto
    }

    public double getPrecio() {
        return precio; // Devuelve el precio del producto
    }

    public void setPrecio(double precio) {
        this.precio = precio; // Establece el precio del producto
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("producto{");
        sb.append("idProducto=").append(idProducto); // Agrega el identificador del producto al StringBuilder
        sb.append(", nombre='").append(nombre).append('\''); // Agrega el nombre del producto al StringBuilder
        sb.append(", precio=").append(precio); // Agrega el precio del producto al StringBuilder
        sb.append('}');
        return sb.toString(); // Devuelve la representación en cadena del objeto Producto
    }
}
