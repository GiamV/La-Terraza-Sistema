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

import com.idat.laterraza.entity.DetalleVenta;
import com.idat.laterraza.service.IDetalleVentaService;

@CrossOrigin(origins= {"http://localhost/4200"})
@RestController
@RequestMapping("/detalle")
public class detalleController {
	
	@Autowired
	private IDetalleVentaService detalleService;
	
	//LISTAR DETALLES
	@GetMapping("/detalles")
	public List<DetalleVenta> listar(){
		return detalleService.findAll();
	}
	
	//BUSCAR DETALLE POR ID
	@GetMapping("/detalle/{id}")
	public DetalleVenta detalle (@PathVariable Long id) {
		return detalleService.findById(id);
	}
	
	//CREAR NUEVO DETALLE
	@PostMapping("/detallenew")
	public DetalleVenta detallenew(@RequestBody DetalleVenta detalle) {
		detalleService.save(detalle);
		return detalleService.findById(detalle.getIdDetalleVenta()); 
	}
	
	//ACTUALIZAR DETALLE
	@PutMapping("/detalleupdate/{id}")
	public DetalleVenta actualizar(@RequestBody DetalleVenta detalle,@PathVariable Long id) {
		DetalleVenta detalleActual=detalleService.findById(id);
		detalleActual.setProducto(detalle.getProducto());
		detalleActual.setCantidad(detalle.getCantidad());
		detalleActual.setCabecera(detalle.getCabecera());
		detalleActual.setPrecio(detalle.getPrecio());
		detalleActual.setEstado(detalle.getEstado());
	
		detalleService.save(detalleActual);
		return detalleService.findById(id);
	}
	
	//ELIMINAR DETALLE
	@DeleteMapping("/detalledelete/{id}")
	public void delete(@PathVariable Long id) {
		detalleService.eliminarDetalleVenta(id);
	}

}
