package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.domain.Categoria;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class DescuentoLunes implements DescuentoStrategy {
    
    private static final double DESCUENTO_LUNES = 0.06; // 6% de descuento para los lunes

    @Override
    public double calcularDescuento(Producto producto, Object usuario, LocalDate dia) {
        // Verifica si el día es lunes y 
        if (dia.getDayOfWeek() == DayOfWeek.MONDAY && producto.getCategoria().getNombre().equalsIgnoreCase("Compresores de Aire")) {
            // Aplica un descuento del 6% para los lunes
            return DESCUENTO_LUNES;
        }
        // Si no es lunes, no hay descuento
        return 0.0;
    }
        
    
}
