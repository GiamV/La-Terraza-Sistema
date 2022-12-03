package com.idat.laterraza.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idat.laterraza.entity.CabeceraVenta;


public interface ICabeceraRepository extends JpaRepository<CabeceraVenta, Long> {
	
	@Query(value= "{call registrar_cab(:xcoduser)}",nativeQuery=true)
	CabeceraVenta saveCabe(@Param("xcoduser")Long xcoduser);
	
	@Query(value= "{call consultar_cab(:xcoduser)}",nativeQuery=true)
	CabeceraVenta getCabeidUser(@Param("xcoduser")Long xcoduser);
	
	@Query(value="{call CompraHecha (:xcodcab,:xcoduser)}",nativeQuery=true)
	void venderCabe(@Param("xcodcab")Long xcodcab,@Param("xcoduser")Long xcoduser);
	
	@Query(value= "{call consultaventa(:xcoduser)}",nativeQuery=true)
	List<CabeceraVenta> findByUV(@Param("xcoduser")Long xcoduser);

}


