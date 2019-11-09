package com.co.labx.security_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.co.labx.security_manager.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, String> {

	@Query(nativeQuery = true, value="SELECT * FROM usuarios WHERE Email = :email and Contrasena = :contrasena and activo = :activo")
	Usuario validarUsuarioContrasena(@Param("email") String email, @Param("contrasena") String contrasena, @Param("activo") String activo);
	
	@Query(nativeQuery = true, value="SELECT * FROM usuarios WHERE uuid_usuario = :uuid and token = :token and activo = :activo having TIMESTAMPDIFF(MINUTE, fecha_uso_token, now()) <= 30")
	Usuario validarToken(@Param("uuid") String uuid, @Param("token") String token, @Param("activo") String activo);
	
}
