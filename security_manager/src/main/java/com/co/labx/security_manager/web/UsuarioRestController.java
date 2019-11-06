package com.co.labx.security_manager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.security_manager.dto.UsuarioDTO;
import com.co.labx.security_manager.service.IUsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Object> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			usuarioService.crearUsuario(usuarioDTO);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
