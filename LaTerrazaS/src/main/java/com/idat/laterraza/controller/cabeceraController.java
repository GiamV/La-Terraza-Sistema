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
import com.idat.laterraza.serviceR.CabeVServiceIm;


@CrossOrigin(origins= {"http://localhost/4200"})
@RestController
@RequestMapping("/cabecera")
public class cabeceraController {

	@Autowired
	private ICabeceraVentaService cabeceraService;
	@Autowired
	private CabeVServiceIm cabeService;
	
	
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
	
	//CREAR NUEVO CABECERA Carrito
		@PostMapping("/cabeceraregistro/{id}")
		public CabeceraVenta cabeceraregister(@PathVariable Long id) {
			return cabeService.saveCabecera(id);
		}
	
		//BUSCAR CABECERA POR ID
		@GetMapping("/cabeceraidu/{id}")
		public CabeceraVenta getbyidUser (@PathVariable Long id) {
			return cabeService.getCabe(id);
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
		cabeceraActual.setTipoCabecera(cabecera.getTipoCabecera());
		
		cabeceraService.save(cabeceraActual);
		return cabeceraService.findById(id);
	}
	
	//ELIMINAR CABECERA
	@DeleteMapping("/cabeceradelete/{id}")
	public void delete(@PathVariable Long id) {
		cabeceraService.eliminarCabeceraVenta(id);
	}
	
	//LISTAR CABECERA DE CARRITO DE COMPRAS
	@GetMapping("cabeceraCarrito/{idUser}")
	public CabeceraVenta carrito(@PathVariable Long idUser) {
		List<CabeceraVenta> listaCabecera=cabeceraService.findAll();
		
		CabeceraVenta cabe=new CabeceraVenta();
		for (int i=0;i<listaCabecera.size();i++) {
			if(listaCabecera.get(i).getTipoCabecera().equals("Carrito") && 
			listaCabecera.get(i).getUsuario().getIdUsuario().equals(idUser)) {
				
				 cabe=listaCabecera.get(i);
				 break;
			}
		}
		
		return cabe;
		
	}
	
	//CAMBIAR ESTADO DE CARRITO A VENTA
	@PutMapping("/venderCabecera/{idCab}")
	public void vender(@PathVariable Long idCab,@RequestBody CabeceraVenta cabecera) {
		CabeceraVenta cabe=cabeceraService.findById(idCab);
		System.out.println("====================================");
		System.out.println(cabe.getUsuario().getIdUsuario()+"       "+idCab);

		System.out.println("====================================");

		cabeService.venderCabe(idCab,cabe.getUsuario().getIdUsuario());
		cabeceraregister(cabe.getUsuario().getIdUsuario());
		
	}
	
	
	
	

}
