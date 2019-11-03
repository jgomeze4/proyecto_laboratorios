package com.co.labx.security_manager.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.labx.security_manager.dto.UsuarioDTO;
import com.co.labx.security_manager.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public String autenticar(UsuarioDTO usuarioDTO) {
		//valida usuario y password con DB
		
		String token = UUID.randomUUID().toString();
		
		//Update de usuario, con token y la fecha de geneación
		return token;
	}
	
}
