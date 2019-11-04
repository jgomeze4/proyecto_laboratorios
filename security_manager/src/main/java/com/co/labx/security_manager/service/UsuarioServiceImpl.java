package com.co.labx.security_manager.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.labx.security_manager.dto.UsuarioDTO;
import com.co.labx.security_manager.model.Usuario;
import com.co.labx.security_manager.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public String autenticar(UsuarioDTO usuarioDTO) {
		//valida usuario y password con DB
		Usuario usuario = usuarioRepository.validarUsuarioContrasena(usuarioDTO.getEmail(), usuarioDTO.getContrasena());
		String token = null;
		if(usuario != null) {
			token = UUID.randomUUID().toString();
			
			usuario.setToken(token);
			usuario.setFecha_Geneacion_Token(new Timestamp(new Date().getTime()));
			usuario.setFecha_Uso_Token(usuario.getFecha_Geneacion_Token());
			//Update de usuario, con token y la fecha de geneación
			usuarioRepository.save(usuario);
		}
		return token;
	}
	
}
