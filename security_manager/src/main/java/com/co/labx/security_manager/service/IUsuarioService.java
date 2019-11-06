package com.co.labx.security_manager.service;

import com.co.labx.security_manager.dto.UsuarioAuthDTO;
import com.co.labx.security_manager.dto.UsuarioDTO;
import com.co.labx.security_manager.dto.UsuarioResponseDTO;

public interface IUsuarioService {

	UsuarioResponseDTO autenticar(UsuarioDTO usuarioDTO);
	
	String validarToken(UsuarioAuthDTO usuarioAuthDTO);
	
	void crearUsuario(UsuarioDTO usuarioDTO);
	
}
