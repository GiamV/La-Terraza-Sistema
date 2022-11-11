package com.idat.laterraza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.laterraza.entity.Producto;
import com.idat.laterraza.service.IProductoService;

@CrossOrigin(origins= {"http://localhost/4200"})
@RestController
@RequestMapping("/producto")
public class productoController {
	
	@Autowired
	private IProductoService productoService;
	
	//LISTAR PRODUCTOS
	@GetMapping("/productos")
	public List<Producto> listar(){
		return productoService.findAll();
	}
	
	//BUSCAR PRODUCTO POR ID
	@GetMapping("/producto/{id}")
	public Producto producto (@PathVariable Long id) {
		return productoService.findById(id);
	}
	
	//CREAR NUEVO PRODUCTO
	@PostMapping("/productonew")
	public Producto productonew(@RequestBody Producto producto) {
		productoService.save(producto);
		return productoService.findById(producto.getIdProducto()); 
	}
	
	//ACTUALIZAR PRODUCTO
	@PutMapping("/productoupdate/{id}")
	public Producto actualizar(@RequestBody Producto producto,@PathVariable Long id) {
		Producto productoActual=productoService.findById(id);
		productoActual.setProducto(producto.getProducto());
		productoActual.setCategoria(producto.getCategoria());
		productoActual.setEstado(producto.getEstado());
		productoActual.setImagen(producto.getImagen());
		productoActual.setPrecio(producto.getPrecio());
	
		productoService.save(productoActual);
		return productoService.findById(id);
	}
	
	//ELIMINAR PRODUCTO
	@DeleteMapping("/productodelete/{id}")
	public void delete(@PathVariable Long id) {
		productoService.eliminarProducto(id);
	}
	
	
	
	
}
