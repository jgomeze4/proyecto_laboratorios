package com.co.labx.util.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6867281147033775704L;
	
	private Boolean success;
	private UsuarioResponseDTO usuario;
	private String message;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public UsuarioResponseDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioResponseDTO usuario) {
		this.usuario = usuario;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
		
}
