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
