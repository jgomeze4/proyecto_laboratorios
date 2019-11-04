package com.co.labx.security_manager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.labx.security_manager.dto.ResponseDTO;
import com.co.labx.security_manager.dto.UsuarioAuthDTO;
import com.co.labx.security_manager.dto.UsuarioDTO;
import com.co.labx.security_manager.model.Usuario;
import com.co.labx.security_manager.service.IUsuarioService;

@RestController
@RequestMapping("/api/security")
public class SecurityManagerRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/autenticar")
	public ResponseEntity<ResponseDTO> generateToken(@RequestBody UsuarioDTO usuarioDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			String token = usuarioService.autenticar(usuarioDTO);
			if(token == null) {
				responseDTO.setSuccess(false);
				responseDTO.setMessage("Valores Incorrectos");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
			} else {
				responseDTO.setSuccess(true);
				responseDTO.setToken(token);
				return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			responseDTO.setSuccess(false);
			responseDTO.setMessage("Ocurrió un error, por favor intenté más tarde");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
		}
	}
	
	@PostMapping("/validar")
	public String generateToken(@RequestBody UsuarioAuthDTO usuarioAuthDTO) {
		
		return "";
	}
}
