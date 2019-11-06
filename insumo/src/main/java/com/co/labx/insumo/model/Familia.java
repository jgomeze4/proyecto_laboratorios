package com.co.labx.insumo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the familias database table.
 * 
 */
@Entity
@Table(name="familias")
public class Familia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uuid_familia")
	private String idFamilia;

	private String activo;

	private String nombre;
	
	@Column(name="uuid_usuario")
	private String idUsuario;

	public Familia() {
	}

	public String getIdFamilia() {
		return this.idFamilia;
	}

	public void setIdFamilia(String idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}