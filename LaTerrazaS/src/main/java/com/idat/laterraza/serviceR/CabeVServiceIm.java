package com.idat.laterraza.serviceR;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.laterraza.entity.CabeceraVenta;

import com.idat.laterraza.repository.ICabeceraRepository;


@Service
public class CabeVServiceIm {
	@Autowired
	ICabeceraRepository CabeceraRepo;
	
	public CabeceraVenta saveCabecera(Long coduser) {
		return (CabeceraVenta) CabeceraRepo.saveCabe(coduser);
	}
	
	public CabeceraVenta getCabe(Long coduser) {
		return CabeceraRepo.getCabeidUser(coduser);
	}
	
	public void venderCabe(Long codcab,Long xcoduser) {
		CabeceraRepo.venderCabe(codcab,xcoduser);
	}
	

}
