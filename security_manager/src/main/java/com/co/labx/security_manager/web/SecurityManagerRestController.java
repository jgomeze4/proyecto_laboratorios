package com.co.labx.security_manager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.util.dto.ResponseDTO;
import com.co.labx.security_manager.dto.UsuarioAuthDTO;
import com.co.labx.security_manager.dto.UsuarioDTO;
import com.co.labx.util.dto.UsuarioResponseDTO;
import com.co.labx.security_manager.service.IUsuarioService;

@RestController
@RequestMapping("/security")
public class SecurityManagerRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/autenticar")
	public ResponseEntity<ResponseDTO> generateToken(@RequestBody UsuarioDTO usuarioDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			UsuarioResponseDTO usuarioResponseDTO = usuarioService.autenticar(usuarioDTO);
			if(usuarioResponseDTO == null) {
				responseDTO.setSuccess(false);
				responseDTO.setMessage("Valores Incorrectos");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
			} else {
				responseDTO.setSuccess(true);
				responseDTO.setUsuario(usuarioResponseDTO);
				return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
			}
		} catch (Exception e) {
			responseDTO.setSuccess(false);
			responseDTO.setMessage("Ocurrió un error, por favor intenté más tarde");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
		}
	}
	
	@PostMapping("/validar")
	public ResponseEntity<String> generateToken(@RequestBody UsuarioAuthDTO usuarioAuthDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			String token = usuarioService.validarToken(usuarioAuthDTO);
			if(token == null) {
				responseDTO.setSuccess(false);
				responseDTO.setMessage("No hay sesión activa");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			} else {
				responseDTO.setSuccess(true);
				return ResponseEntity.status(HttpStatus.OK).body(token);
			}
		} catch (Exception e) {
			responseDTO.setSuccess(false);
			responseDTO.setMessage("Ocurrió un error, por favor intenté más tarde");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
