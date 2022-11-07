package com.idat.laterraza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.laterraza.dao.ICabeceraVentaDao;
import com.idat.laterraza.entity.CabeceraVenta;


@Service
public class ICabeceraVentaServiceImpl implements ICabeceraVentaService {
	@Autowired
	private ICabeceraVentaDao cabeceraVentaDao;
	
	@Transactional(readOnly=true)
	
	@Override
	public List<CabeceraVenta> findAll() {
		
		return (List<CabeceraVenta>)cabeceraVentaDao.findAll();
	}
	@Transactional
	@Override
	public void save(CabeceraVenta cabeceraVenta) {
		cabeceraVentaDao.save(cabeceraVenta);
		
	}
	@Transactional
	@Override
	public CabeceraVenta editarCabeceraVenta(Long id) {
		// TODO Auto-generated method stub
		return cabeceraVentaDao.findById(id).orElse(null);
	}
	@Transactional
	@Override
	public void eliminarCabeceraVenta(Long id) {
		cabeceraVentaDao.deleteById(id);
		
	}

}
