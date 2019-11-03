package com.co.labx.inventario.model;

import javax.persistence.Table;
import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

@Entity
@Table(name="prueba")
public class Prueba implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PruebaPK id;

	@Column(length=45)
	private String pruebacol1;

	@Column(length=45)
	private String pruebacol2;

	private int pruebacol4;

	@Column(length=45)
	private String pruebacol5;

	public Prueba() {
	}

	public PruebaPK getId() {
		return this.id;
	}

	public void setId(PruebaPK id) {
		this.id = id;
	}

	public String getPruebacol1() {
		return this.pruebacol1;
	}

	public void setPruebacol1(String pruebacol1) {
		this.pruebacol1 = pruebacol1;
	}

	public String getPruebacol2() {
		return this.pruebacol2;
	}

	public void setPruebacol2(String pruebacol2) {
		this.pruebacol2 = pruebacol2;
	}

	public int getPruebacol4() {
		return this.pruebacol4;
	}

	public void setPruebacol4(int pruebacol4) {
		this.pruebacol4 = pruebacol4;
	}

	public String getPruebacol5() {
		return this.pruebacol5;
	}

	public void setPruebacol5(String pruebacol5) {
		this.pruebacol5 = pruebacol5;
	}

}
