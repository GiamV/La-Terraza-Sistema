package com.idat.laterraza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.laterraza.entity.Rol;
import com.idat.laterraza.service.IRolService;




@CrossOrigin(origins= {"http://localhost/4200"})
@RestController
@RequestMapping("/apii")
public class rolController {
	@Autowired
	private IRolService rolService;
	
	@GetMapping("/rol")
	public List<Rol> index(){
		return rolService.findAll();
	}
}
