package com.co.labx.inventario.model;

import javax.persistence.Embeddable;
import javax.persistence.Column;

import java.io.Serializable;

@Embeddable
public class PruebaPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int idprueba;

	@Column(unique=true, nullable=false, length=45)
	private String pruebacol;

	@Column(unique=true, nullable=false, length=45)
	private String pruebacol3;

	@Column(unique=true, nullable=false, length=45)
	private String pruebacol6;

	public PruebaPK() {
	}
	public int getIdprueba() {
		return this.idprueba;
	}
	public void setIdprueba(int idprueba) {
		this.idprueba = idprueba;
	}
	public String getPruebacol() {
		return this.pruebacol;
	}
	public void setPruebacol(String pruebacol) {
		this.pruebacol = pruebacol;
	}
	public String getPruebacol3() {
		return this.pruebacol3;
	}
	public void setPruebacol3(String pruebacol3) {
		this.pruebacol3 = pruebacol3;
	}
	public String getPruebacol6() {
		return this.pruebacol6;
	}
	public void setPruebacol6(String pruebacol6) {
		this.pruebacol6 = pruebacol6;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PruebaPK)) {
			return false;
		}
		PruebaPK castOther = (PruebaPK)other;
		return 
			(this.idprueba == castOther.idprueba)
			&& this.pruebacol.equals(castOther.pruebacol)
			&& this.pruebacol3.equals(castOther.pruebacol3)
			&& this.pruebacol6.equals(castOther.pruebacol6);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idprueba;
		hash = hash * prime + this.pruebacol.hashCode();
		hash = hash * prime + this.pruebacol3.hashCode();
		hash = hash * prime + this.pruebacol6.hashCode();
		
		return hash;
	}
	
}
