package com.co.labx.security_manager.service;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.labx.security_manager.constants.UsuarioConstants;
import com.co.labx.security_manager.dto.UsuarioAuthDTO;
import com.co.labx.security_manager.dto.UsuarioDTO;
import com.co.labx.security_manager.dto.UsuarioResponseDTO;
import com.co.labx.security_manager.helper.CifrarHelper;
import com.co.labx.security_manager.model.Usuario;
import com.co.labx.security_manager.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public UsuarioResponseDTO autenticar(UsuarioDTO usuarioDTO) {
		//valida usuario y password con DB
		UsuarioResponseDTO usuarioResponseDTO = null;
		String contrasena = CifrarHelper.Base64AString(usuarioDTO.getContrasena());
		Usuario usuario = usuarioRepository.validarUsuarioContrasena(usuarioDTO.getEmail(), CifrarHelper.valorASHA256(contrasena), UsuarioConstants.ESTADO_ACTIVO);
		String token = null;
		if(usuario != null) {
			token = UUID.randomUUID().toString();
			
			usuario.setToken(token);
			usuario.setFecha_Geneacion_Token(new java.sql.Date((Calendar.getInstance().getTime()).getTime()));
			usuario.setFecha_Uso_Token(usuario.getFecha_Geneacion_Token());
			//Update de usuario, con token y la fecha de geneación
			usuarioRepository.save(usuario);
			
			usuarioResponseDTO = new UsuarioResponseDTO();
			usuarioResponseDTO.setCliente(usuario.getCliente());
			usuarioResponseDTO.setUuId(usuario.getIdUsuario());
			usuarioResponseDTO.setToken(token);
			usuarioResponseDTO.setNombre(usuario.getNombre());
			usuarioResponseDTO.setEmail(usuario.getEmail());
		}
		
		return usuarioResponseDTO;
	}

	@Override
	@Transactional
	public String validarToken(UsuarioAuthDTO usuarioAuthDTO) {
		Usuario usuario = usuarioRepository.validarToken(usuarioAuthDTO.getEmail(), usuarioAuthDTO.getToken(), UsuarioConstants.ESTADO_ACTIVO);
		String token = null;
		if(usuario != null) {
			token = usuario.getToken();
			usuario.setFecha_Uso_Token(new java.sql.Date((Calendar.getInstance().getTime()).getTime()));
			//Update de usuario, con token y la fecha de geneación
			usuarioRepository.save(usuario);
		}
		return token;
	}

	@Override
	public void crearUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		
		String contrasena = CifrarHelper.Base64AString(usuarioDTO.getContrasena());
		System.out.print(contrasena);
		usuario.setIdUsuario(UUID.randomUUID().toString());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setActivo(UsuarioConstants.ESTADO_ACTIVO);
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setIdUsuario(UUID.randomUUID().toString());
		usuario.setContrasena(CifrarHelper.valorASHA256(contrasena));
		
		usuarioRepository.save(usuario);
	}
	
	
	
}
