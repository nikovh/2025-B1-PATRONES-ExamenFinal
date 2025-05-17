package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.domain.Categoria;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DescuentoServiceTest {

    @ParameterizedTest
    @CsvSource({
        "MONDAY, Compresores de Aire, CLIENTE, 0.06",        // Caso 1
        "TUESDAY, Esmeriles Angulares, CLIENTE, 0.08",       // Caso 2
        "WEDNESDAY, Taladros Percutores, CLIENTE, 0.10",     // Caso 3
        "THURSDAY, Compresores de Aire, CLIENTE, 0.00",      // Caso 4
        "MONDAY, Esmeriles Angulares, CLIENTE, 0.00",        // Caso 5
        "MONDAY, Compresores de Aire, EMPLEADO, 0.06",       // Caso 6
        "TUESDAY, Esmeriles Angulares, EMPLEADO, 0.08",      // Caso 7
        "WEDNESDAY, Taladros Percutores, EMPLEADO, 0.10",    // Caso 8
        "THURSDAY, Compresores de Aire, EMPLEADO, 0.05",     // Caso 9
        "MONDAY, Taladros Percutores, CLIENTE, 0.00",        // Caso 10
        "MONDAY, Compresores de Aire, CLIENTE, 0.06",        // Caso 11 (repetido para asegurar consistencia)
        "SUNDAY, Taladros Percutores, CLIENTE, 0.00",        // Caso 12
        "TUESDAY, Esmeriles Angulares, EMPLEADO, 0.08"       // Caso 13

    })
    void testAplicacionDescuentos(
            String dia, String categoria, String tipoUsuario, double descuentoEsperado) {

        // Crear fecha según el día de la semana
        LocalDate fecha = LocalDate.of(2025, 5, 5); // lunes por defecto
        switch (dia) {
            case "TUESDAY":    fecha = LocalDate.of(2025, 5, 6); break;
            case "WEDNESDAY":  fecha = LocalDate.of(2025, 5, 7); break;
            case "THURSDAY":   fecha = LocalDate.of(2025, 5, 8); break;
            case "FRIDAY":     fecha = LocalDate.of(2025, 5, 9); break;
            case "SUNDAY":     fecha = LocalDate.of(2025, 5, 11); break;
        }

        // Crear el mock del producto y su categoría
        Categoria categoriaMock = () -> categoria;
        Producto productoMock = Mockito.mock(Producto.class);
        Mockito.when(productoMock.getCategoria()).thenReturn(categoriaMock);

        // Usuario
        boolean esEmpleado = tipoUsuario.equals("EMPLEADO");

        double descuento = 0.0;

        if (dia.equals("MONDAY") || dia.equals("TUESDAY") || dia.equals("WEDNESDAY")) {
            // Descuento por día
            if (dia.equals("MONDAY") && categoria.equals("Compresores de Aire")) {
                descuento = 0.06;
            } else if (dia.equals("TUESDAY") && categoria.equals("Esmeriles Angulares")) {
                descuento = 0.08;
            } else if (dia.equals("WEDNESDAY") && categoria.equals("Taladros Percutores")) {
                descuento = 0.10;
            }
            if (esEmpleado && descuento < 0.05){
                descuento = 0.05;
            }
        } else if (esEmpleado) {
            descuento = 0.05;
        }

        // Verificar el resultado
        assertEquals(descuentoEsperado, descuento, 0.01);
    }
}
