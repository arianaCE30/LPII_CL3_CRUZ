package org.cibertec.edu.pe.controller;

import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {

	@Autowired
	private IProductoServicio servProducto;

	// Listar Productos
	@GetMapping({ "/productos" })
	public String listarProductos(Model m) {
		m.addAttribute("productos", servProducto.listarProductos());
		return "index";

	}

	// Producto Nuevo
	@GetMapping("/producto/nuevo") // Muestra el formulario para crear nuevo producto
	public String crearProducto(Model m) {
		Producto prod = new Producto();
		m.addAttribute("producto", prod);
		return "nuevo_producto";
	}

	@PostMapping("/productos") // Guarda el producto
	public String guardarProducto(@ModelAttribute("producto") Producto producto) { // ModelAttribute recoge el objeto de la interfaz
		servProducto.guardarProducto(producto);
		return "redirect:/productos";
	}

	// Actualizar Producto existente
	@GetMapping("/producto/editar/{id}") // Muestra el formulario para crear nuevo producto
	public String buscarProducto(@PathVariable int id, Model m) {
		m.addAttribute("producto", servProducto.obtenerProductoxId(id));
		return "editar_producto";
	}
	
	@PostMapping("/productos/{id}")
	public String actualizarProducto(@PathVariable int id, @ModelAttribute ("producto") Producto producto, Model m) {
		Producto productoExiste = servProducto.obtenerProductoxId(id);
		productoExiste.setIdProductoCL3(id);
		productoExiste.setNombreCL3(producto.getNombreCL3());
		productoExiste.setPrecioVentaCL3(producto.getPrecioVentaCL3());
		productoExiste.setStock(producto.getStock());
		productoExiste.setPrecioCompraCL3(producto.getPrecioCompraCL3());
		productoExiste.setEstadoCL3(producto.getEstadoCL3());
		productoExiste.setDescripCL3(producto.getDescripCL3());
		
		servProducto.actualizarProducto(productoExiste);
		return "redirect:/productos";
	}
	
	//Eliminar producto
		@GetMapping("/producto/{id}")
		public String eliminarProducto(@PathVariable int id) {
			servProducto.eliminarProducto(id);
			return "redirect:/productos";
		}

}