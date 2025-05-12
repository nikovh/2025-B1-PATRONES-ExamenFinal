package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import java.time.LocalDate;
import java.util.List;

public class DescuentoDecorador implements DescuentoStrategy {
    
    private List<DescuentoStrategy> descuentos;

    public DescuentoDecorador(List<DescuentoStrategy> descuentos) {
        this.descuentos = descuentos;
    }

    @Override
    public double calcularDescuento(Producto producto, Object usuario, LocalDate dia) {
        return descuentos.stream()
                .mapToDouble(descuento -> descuento.calcularDescuento(producto, usuario, dia))
                .max()
                .orElse(0.0);
    }
}
