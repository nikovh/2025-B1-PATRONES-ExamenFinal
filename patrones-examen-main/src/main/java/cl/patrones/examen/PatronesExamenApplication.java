package cl.patrones.examen;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.service.CalculadorDescuento;
import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatronesExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatronesExamenApplication.class, args);

		// probarDescuento();
	}

	// private static void probarDescuento() {
    //     try {
    //         Producto producto = new Producto() {
    //             @Override
    //             public String getSku() {
    //                 return "TP001";
    //             }

    //             @Override
    //             public String getNombre() {
    //                 return "Taladro Percutor";
    //             }

    //             @Override
    //             public String getImagen() {
    //                 return "imagen.jpg";
    //             }

    //             @Override
    //             public Long getCosto() {
    //                 return 50000L;
    //             }

    //             @Override
    //             public Long getPrecioLista() {
    //                 return 100000L;
    //             }

    //             @Override
    //             public Long getDescuento() {
    //                 return 10L;
    //             }

    //             @Override
    //             public Long getPrecioFinal() {
    //                 return getPrecioLista() - (getPrecioLista() * getDescuento() / 100);
    //             }

    //             @Override
    //             public cl.patrones.examen.productos.domain.Categoria getCategoria() {
    //                 return () -> "Taladros Percutores";
    //             }
    //         };

    //         LocalDate dia = LocalDate.now();
    //         CalculadorDescuento calculador = new CalculadorDescuento();
    //         double precioConDescuento = calculador.aplicarDescuento(producto, dia);

    //         // Imprimir el resultado
    //         System.out.println("Precio con descuento calculado: $" + precioConDescuento);
    //     } catch (Exception e) {
    //         System.err.println("Error al calcular el descuento: " + e.getMessage());
    //     }
    // }
}
