package com.co.labx.security_manager.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the Usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uuid_usuario")
	private String idUsuario;

	@Column(name="activo")
	private String activo;

	@Column(name="cliente")
	private String cliente;

	@Column(name="contrasena")
	private String contrasena;

	@Column(name="email")
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Fecha_Geneacion_Token")
	private Date fecha_Geneacion_Token;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Fecha_Uso_Token")
	private Date fecha_Uso_Token;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Token")
	private String token;

	public Usuario() {
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
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

	public Date getFecha_Geneacion_Token() {
		return this.fecha_Geneacion_Token;
	}

	public void setFecha_Geneacion_Token(Date fecha_Geneacion_Token) {
		this.fecha_Geneacion_Token = fecha_Geneacion_Token;
	}

	public Date getFecha_Uso_Token() {
		return this.fecha_Uso_Token;
	}

	public void setFecha_Uso_Token(Date fecha_Uso_Token) {
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