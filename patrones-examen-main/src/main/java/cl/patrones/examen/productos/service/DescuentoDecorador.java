package cl.patrones.examen.productos.service;

import java.time.LocalDate;
import java.util.List;

public class DescuentoDecorador implements DescuentoStrategy {
    private List<DescuentoStrategy> descuentos;

    public DescuentoDecorador(List<DescuentoStrategy> descuentos) {
        this.descuentos = descuentos;
    }

    @Override
    public double calcularDescuento(Producto producto, Usuario usuario, LocalDate dia) {
        return descuentos.stream()
                .mapToDouble(descuento -> descuento.calcularDescuento(producto, usuario, dia))
                .max()
                .orElse(0.0);
    }
}
