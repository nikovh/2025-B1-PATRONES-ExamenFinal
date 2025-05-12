package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.domain.Categoria;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class DescuentoMartes implements DescuentoStrategy {
    
    private static final double DESCUENTO_MARTES = 0.08; // 8% de descuento para los martes

    @Override
    public double calcularDescuento(Producto producto, Object usuario, LocalDate dia) {
        // Verifica si el día es martes y 
        if (dia.getDayOfWeek() == DayOfWeek.TUESDAY && producto.getCategoria().getNombre().equalsIgnoreCase("Esmeriles Angulares")) {
            // Aplica un descuento del 8% para los martes
            //return producto.getPrecio() * 0.08;
            return DESCUENTO_MARTES;
        }
        // Si no es martes, no hay descuento
        return 0.0;
    }
}
