package cl.patrones.examen.productos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

public class CalculadorDescuento {
    public double aplicarDescuento(Producto producto, Usuario usuario, LocalDate dia) {
        // Crear una lista de estrategias de descuento
        List<DescuentoStrategy> estrategias = Arrays.asList(
            new DescuentoLunes(),
            new DescuentoMartes(),
            new DescuentoMiércoles(),
            new DescuentoEmpleado()
        );

        DescuentoDecorador decorador = new DescuentoDecorador(estrategias);
        double descuento = decorador.calcularDescuento(producto, usuario, dia);
        return producto.getPrecio() * (1 - descuento);
    }
}
