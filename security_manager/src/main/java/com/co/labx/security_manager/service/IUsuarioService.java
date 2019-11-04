package com.co.labx.security_manager.service;

import com.co.labx.security_manager.dto.UsuarioAuthDTO;
import com.co.labx.security_manager.dto.UsuarioDTO;

public interface IUsuarioService {

	String autenticar(UsuarioDTO usuarioDTO);
	
	String validarToken(UsuarioAuthDTO usuarioAuthDTO);
	
}
