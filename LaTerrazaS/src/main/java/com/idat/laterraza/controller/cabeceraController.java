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

import com.idat.laterraza.entity.CabeceraVenta;
import com.idat.laterraza.service.ICabeceraVentaService;

@CrossOrigin(origins= {"http://localhost/4200"})
@RestController
@RequestMapping("/cabecera")
public class cabeceraController {

	@Autowired
	private ICabeceraVentaService cabeceraService;
	
	//LISTAR CABECERAS DE VENTA
	@GetMapping("/cabeceras")
	public List<CabeceraVenta> listar(){
		return cabeceraService.findAll();
	}
	
	//BUSCAR CABECERA POR ID
	@GetMapping("/cabecera/{id}")
	public CabeceraVenta cabecera (@PathVariable Long id) {
		return cabeceraService.findById(id);
	}
	
	//CREAR NUEVO CABECERA
	@PostMapping("/cabeceranew")
	public CabeceraVenta cabeceraonew(@RequestBody CabeceraVenta cabecera) {
		cabeceraService.save(cabecera);
		return cabeceraService.findById(cabecera.getIdCabecera()); 
	}
	
	//ACTUALIZAR CABECERA
	@PutMapping("/cabeceraupdate/{id}")
	public CabeceraVenta actualizar(@RequestBody CabeceraVenta cabecera,@PathVariable Long id) {
		CabeceraVenta cabeceraActual=cabeceraService.findById(id);
		cabeceraActual.setBruto(cabecera.getBruto());
		cabeceraActual.setIgv(cabecera.getIgv());
		cabeceraActual.setNeto(cabecera.getNeto());
		cabeceraActual.setFechamat(cabecera.getFechamat());
		cabeceraActual.setEstado(cabecera.getEstado());
		cabeceraActual.setTipoPago(cabecera.getTipoPago());
		
		cabeceraService.save(cabeceraActual);
		return cabeceraService.findById(id);
	}
	
	//ELIMINAR CABECERA
	@DeleteMapping("/cabeceradelete/{id}")
	public void delete(@PathVariable Long id) {
		cabeceraService.eliminarCabeceraVenta(id);
	}

}
