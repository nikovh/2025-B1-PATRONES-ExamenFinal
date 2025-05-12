package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import java.time.LocalDate;
import java.util.List;

public class CalculadorDescuento {

    // Método para aplicar el descuento al producto
    public Long aplicarDescuento(Producto producto, LocalDate dia) {

        double porcentaje = obtenerMayorPorcentaje(producto, dia);
        Long precioLista = producto.getPrecioLista();
        
        return Math.round(precioLista - (precioLista * porcentaje));
    }

    // public Long aplicarDescuento(Producto producto) {
    //     double descuento = obtenerDescuento(producto);
    //     Long precioLista = producto.getPrecioLista();
    //     return Math.round(precioLista - (precioLista * descuento));
    // }

    // private double obtenerDescuento(Producto producto) {
    //     // Implementa aquí la lógica para obtener el descuento adecuado
    //     return 0.5; // Ejemplo: 10% de descuento
    // }

    public double obtenerMayorPorcentaje(Producto p, LocalDate dia) {
        List<DescuentoStrategy> estrategias = List.of(
            new DescuentoLunes(),
            new DescuentoMartes(),
            new DescuentoMiercoles(),
            new DescuentoEmpleado()
        );
        return estrategias.stream()
            .mapToDouble(estrategia -> estrategia.calcularDescuento(p, dia))
            .max()
            .orElse(0.0);
    }
}
