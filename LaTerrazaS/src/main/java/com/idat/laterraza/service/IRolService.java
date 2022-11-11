package com.idat.laterraza.service;

import java.util.List;


import com.idat.laterraza.entity.Rol;

public interface IRolService {
	//DATA ACCESS OBJECT
	public List<Rol> findAll();
	
	public Rol findById (Long id);
	
	//CREAR METODO PARA AGREGAR:
	public void save(Rol rol);
	
	//CREAR METODO PARA EDITAR:
	public Rol editarRol(Long id);
	
	//CREAR METODO PARA ELIMINAR:
	public void eliminarRol(Long id);
}
