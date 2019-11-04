package com.co.labx.security_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.co.labx.security_manager.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(nativeQuery = true, value="SELECT * FROM usuarios WHERE Email = :email and Contrasena = :contrasena")
	Usuario validarUsuarioContrasena(@Param("email") String email, @Param("contrasena") String contrasena);
	
	@Query(nativeQuery = true, value="SELECT * FROM usuarios WHERE email = :email and token = :token having TIMESTAMPDIFF(MINUTE, fecha_uso_token, now()) <= 30")
	Usuario validarToken(@Param("email") String email, @Param("token") String token);
	
}
