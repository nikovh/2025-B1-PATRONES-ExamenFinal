package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

public class CalculadorDescuento {

    // Método para aplicar el descuento al producto
    public double aplicarDescuento(Producto producto, LocalDate dia) {
        // Crear una lista de estrategias de descuento
        List<DescuentoStrategy> estrategias = Arrays.asList(
            new DescuentoLunes(),
            new DescuentoMartes(),
            new DescuentoMiercoles(),
            new DescuentoEmpleado()
        );

        DescuentoDecorador decorador = new DescuentoDecorador(estrategias);
        double descuento = decorador.calcularDescuento(producto, null, dia);
        return producto.getPrecioLista() * (1 - descuento);
    }
}
