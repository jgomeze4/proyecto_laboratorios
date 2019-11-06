package com.co.labx.security_manager.dto;

public class ResponseDTO {

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
