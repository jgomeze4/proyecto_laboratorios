package com.co.labx.security_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.co.labx.security_manager.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(nativeQuery = true, value="SELECT u.* FROM usuarios u WHERE u.email = :email and u.contrasena = :contrasena")
	Usuario validarUsuarioContrasena(@Param("email") String email, @Param("contrasena") String contrasena);
	
}
