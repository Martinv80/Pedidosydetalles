package interfaz;

import modelo.Producto;
import modelo.Pedido;

public class Main {

    public static void main(String[] args) {

        Producto p1 = new Producto("P01", "Camiseta", 15);
        Producto p2 = new Producto("P02", "Pantalon", 30);
        Producto p3 = new Producto("P03", "Zapatos", 50);
        Producto p4 = new Producto("P04", "Gorra", 10);

        Pedido pedido = new Pedido();

        pedido.agregarProducto(p1, 2);
        pedido.agregarProducto(p2, 1);
        pedido.agregarProducto(p3, 1);
        pedido.agregarProducto(p4, 3);

        System.out.println("=== PEDIDO ===");
        System.out.println(pedido.mostrarResumen());

        System.out.println("Cantidad de detalles: "
                + pedido.cantidadDetalles());

        // Prueba del desafio
        pedido.agregarProducto(p1, 1);

        System.out.println("\nPedido con producto repetido:");
        System.out.println(pedido.mostrarResumen());

        System.out.println("Eliminar posicion 1: "
                + pedido.eliminarDetalle(1));

        System.out.println("Eliminar posicion 10: "
                + pedido.eliminarDetalle(10));

        System.out.println("\nPedido actualizado:");
        System.out.println(pedido.mostrarResumen());
    }
}