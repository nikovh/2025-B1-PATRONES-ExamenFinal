package cl.patrones.examen.productos.service;

import java.time.LocalDate;

public interface DescuentoStrategy {
    double calcularDescuento(Producto producto, Usuario usuario, LocalDate dia);
}
