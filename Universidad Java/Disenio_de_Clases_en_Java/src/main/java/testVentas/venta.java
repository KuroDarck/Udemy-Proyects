package testVentas;

import org.ventas.Orden;
import org.ventas.Producto;

public class venta {

    public static void main(String[] args) {

        // Crear objetos de productos
        Producto producto1 = new Producto("Pantalones", 30.00);
        Producto producto2 = new Producto("Camiseta", 15.00);
        Producto producto3 = new Producto("Zapatos", 50.00);
        Producto producto4 = new Producto("Sombrero", 10.00);
        Producto producto5 = new Producto("Calcetines", 5.00);

        // Crear una orden
        Orden orden1 = new Orden();
       
        // Agregar productos a la orden
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        orden1.agregarProducto(producto3);
        orden1.agregarProducto(producto4);
        orden1.agregarProducto(producto5);

        // Mostrar la orden
        orden1.mostrarOrden();
    }
}
