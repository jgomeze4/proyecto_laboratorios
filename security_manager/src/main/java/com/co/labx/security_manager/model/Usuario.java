package com.co.labx.security_manager.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Usuarios database table.
 * 
 */
@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private Long idUsuario;

	@Column(name="Activo")
	private String activo;

	@Column(name="Cliente")
	private String cliente;

	@Column(name="Contrasena")
	private String contrasena;

	@Column(name="Email")
	private String email;

	@Column(name="Fecha_Geneacion_Token")
	private Timestamp fecha_Geneacion_Token;

	@Column(name="Fecha_Uso_Token")
	private Timestamp fecha_Uso_Token;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Token")
	private String token;

	public Usuario() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getFecha_Geneacion_Token() {
		return this.fecha_Geneacion_Token;
	}

	public void setFecha_Geneacion_Token(Timestamp fecha_Geneacion_Token) {
		this.fecha_Geneacion_Token = fecha_Geneacion_Token;
	}

	public Timestamp getFecha_Uso_Token() {
		return this.fecha_Uso_Token;
	}

	public void setFecha_Uso_Token(Timestamp fecha_Uso_Token) {
		this.fecha_Uso_Token = fecha_Uso_Token;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}