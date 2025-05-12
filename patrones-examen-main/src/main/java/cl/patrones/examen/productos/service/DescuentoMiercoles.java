package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class DescuentoMiercoles implements DescuentoStrategy {
    
    private static final double DESCUENTO_MIERCOLES = 0.1;
    
    @Override
    public double calcularDescuento(Producto producto, LocalDate dia) {
        // Verifica si el día es miercoles y 
        if (dia.getDayOfWeek() == DayOfWeek.WEDNESDAY && producto.getCategoria().getNombre().equalsIgnoreCase("Taladros Percutores")) {
            // Aplica un descuento del 10% para los miercoles
            //return producto.getPrecio() * 0.10;
            return DESCUENTO_MIERCOLES;
        }
        // Si no es miercoles, no hay descuento
        return 0.0;
    }
}
