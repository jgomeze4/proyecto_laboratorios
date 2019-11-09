package com.co.labx.util.dto;

import java.io.Serializable;

public class UsuarioResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6275091986239873955L;
	
	private String email;
	private String nombre;
	private String cliente;
	private String token;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
