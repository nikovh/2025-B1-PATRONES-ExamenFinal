package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import java.time.LocalDate;
import java.util.List;

public class DescuentoDecorador implements DescuentoStrategy {
    
    private List<DescuentoStrategy> estrategias;

    public DescuentoDecorador(List<DescuentoStrategy> estrategias) {
        this.estrategias = estrategias;
    }

    @Override
    public double calcularDescuento(Producto producto, LocalDate dia) {
        return estrategias.stream()
                .mapToDouble(estrategia -> estrategia.calcularDescuento(producto, dia))
                .max()
                .orElse(0.0);
    }
}
