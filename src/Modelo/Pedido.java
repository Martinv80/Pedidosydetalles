package modelo;

import java.util.ArrayList;

public class Pedido {

    private ArrayList<DetallePedido> detalles;

    public Pedido() {
        detalles = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {

        if (producto == null || cantidad <= 0) {
            return;
        }

        // Acumular cantidad si el producto ya existe
        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto().getCodigo().equals(producto.getCodigo())) {

                detalle.setCantidad(detalle.getCantidad() + cantidad);
                return;
            }
        }

        DetallePedido detalle = new DetallePedido(producto, cantidad);
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double total = 0;

        for (DetallePedido detalle : detalles) {
            total += detalle.calcularSubtotal();
        }

        return total;
    }

    public int cantidadDetalles() {
        return detalles.size();
    }

    public boolean eliminarDetalle(int posicion) {

        if (posicion >= 0 && posicion < detalles.size()) {
            detalles.remove(posicion);
            return true;
        }

        return false;
    }

    public String mostrarResumen() {
        String resultado = "";

        for (DetallePedido detalle : detalles) {
            resultado += detalle.mostrarInformacion() + "\n";
        }

        return resultado + "Total del pedido: $" + calcularTotal();
    }
}
