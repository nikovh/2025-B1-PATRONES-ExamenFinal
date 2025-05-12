package cl.patrones.examen.productos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cl.patrones.examen.productos.service.ProductoService;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.service.ProductoServiceConDescuento;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// @Controller
// public class AppController {
	
// 	private final ProductoService productoService;
	
// 	// public AppController(ProductoService productoService) {
// 	// 	super();
// 	// 	this.productoService = productoService;
// 	// }
// 	public AppController() {
// 		//usar el nuevo servicio decorador
// 		this.productoService = new ProductoServiceConDescuento();
// 	}

// 	// @GetMapping("/")
// 	// String inicio(Model model) {
// 	// 	var productos = productoService.getProductos();
// 	// 	model.addAttribute("productos", productos);
// 	// 	return "inicio";
// 	// }

// 	@GetMapping("/")
// 	public String inicio(Model model) {
// 		// Obtener la lista de productos
// 		List<? extends Producto> productos = productoService.getProductos();
		
// 		// Agregar la lista de productos al modelo
// 		model.addAttribute("productos", productos);
		
// 		// Retornar el nombre de la vista
// 		return "avisos";
// 		// return "inicio";
// 	}

@Controller
public class AppController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String inicio(Model model) {
        List<? extends Producto> productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        // return "includes/avisos"; 
		return "inicio";
    }

	
}
