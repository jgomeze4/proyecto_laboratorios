package com.co.labx.util.dto;

import java.io.Serializable;

public class FamiliaResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1554128386070395673L;
	private String id;
	private String nombre;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
