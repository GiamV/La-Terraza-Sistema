package com.idat.laterraza.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	private static final long serialVersionUID=1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long idCategoria;
	private String categoria;
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
