package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.domain.Categoria;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DescuentoLunesTest {
    @Test
    void aplicaDescuentoLunes() {
        //lunes
        LocalDate lunes = LocalDate.of(2025, 5, 5);

        //compresor
        Categoria compresores = () -> "Compresores de Aire";
        Producto producto = Mockito.mock(Producto.class);
        Mockito.when(producto.getCategoria()).thenReturn(compresores);

        DescuentoLunes estrategia = new DescuentoLunes();

        double porcentaje = estrategia.calcularDescuento(producto, lunes);
        assertEquals(0.06, porcentaje, 0.01);
    }

    @Test
    void noAplicaDescuentoLunes() {
        //martes
        LocalDate martes = LocalDate.of(2025, 5, 6);

        //compresor
        Categoria compresores = () -> "Compresores de Aire";
        Producto producto = Mockito.mock(Producto.class);
        Mockito.when(producto.getCategoria()).thenReturn(compresores);

        // Instancia de la estrategia de descuento
        DescuentoLunes estrategia = new DescuentoLunes();

        double porcentaje = new DescuentoLunes().calcularDescuento(producto, martes);
        assertEquals(0.0, porcentaje);
    }
}
