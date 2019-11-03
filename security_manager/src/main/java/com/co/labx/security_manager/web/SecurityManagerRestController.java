package com.co.labx.security_manager.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.security_manager.dto.UsuarioAuthDTO;
import com.co.labx.security_manager.dto.UsuarioDTO;
import com.co.labx.security_manager.service.IUsuarioService;

@RestController
@RequestMapping("/api/security")
public class SecurityManagerRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/autenticar")
	public String generateToken(@RequestBody UsuarioDTO usuarioDTO) {
		String token = usuarioService.autenticar(usuarioDTO);
		
		return token;
	}
	
	@PostMapping("/validar")
	public String generateToken(@RequestBody UsuarioAuthDTO usuarioAuthDTO) {
		
		return "";
	}
}
