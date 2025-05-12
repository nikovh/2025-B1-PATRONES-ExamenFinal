package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import java.time.LocalDate;

public interface DescuentoStrategy {
    double calcularDescuento(Producto producto, Object usuario, LocalDate dia);
}
