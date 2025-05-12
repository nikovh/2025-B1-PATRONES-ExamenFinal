package cl.patrones.examen.productos.service;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.model.ProductoConDescuento;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ProductoServiceConDescuento implements ProductoService {

    private final ProductoService productoService;

    public ProductoServiceConDescuento() {
        this.productoService = new ProductoServiceImpl();
    }

    @Override
    public List<? extends Producto> getProductos() {
        List<? extends Producto> productosOriginales = productoService.getProductos();

        // envolver cada producto para aplicar el descuento
        return productosOriginales.stream()
                .map(ProductoConDescuento::new)
                .collect(Collectors.toList());
    }
    
}
