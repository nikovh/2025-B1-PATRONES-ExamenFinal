package cl.patrones.examen.productos.service;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class DescuentoLunes implements DescuentoStrategy {
    @Override
    public double calcularDescuento(Producto producto, Usuario usuario, LocalDate dia) {
        // Verifica si el día es lunes y 
        if (dia.getDayOfWeek() == DayOfWeek.MONDAY && producto.getCategoria().equalsIgnoreCase("compresores-de-aire")) {
            // Aplica un descuento del 6% para los lunes
            //return producto.getPrecio() * 0.06;
            return 0.06;
        }
        // Si no es lunes, no hay descuento
        return 0.0;
    }
        
    
}
