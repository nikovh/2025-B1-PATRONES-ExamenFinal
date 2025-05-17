package cl.patrones.examen.productos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cl.patrones.examen.productos.service.ProductoService;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.service.ProductoServiceConDescuento;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String inicio(Model model) {
        List<? extends Producto> productos = productoService.getProductos();
        model.addAttribute("productos", productos); 
		return "inicio";
    }

	
}
