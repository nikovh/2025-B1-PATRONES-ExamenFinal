package cl.patrones.examen.productos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cl.patrones.examen.productos.service.ProductoService;

import cl.patrones.examen.productos.service.CalculadorDescuento;
import cl.patrones.examen.productos.domain.Categoria;

import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@Controller
public class AppController {
	
	private ProductoService productoService;
	
	public AppController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}

	@GetMapping("/")
	String inicio(Model model) {
		var productos = productoService.getProductos();
		model.addAttribute("productos", productos);
		return "inicio";
	}


	@GetMapping("/productos/descuento")
    public String obtenerDescuento() {
        // Crear una categoría de ejemplo
        return "Endpoint temporal deshabilitado";
    }
	
}
