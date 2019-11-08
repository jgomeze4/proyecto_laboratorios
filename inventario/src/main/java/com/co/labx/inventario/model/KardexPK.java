package com.co.labx.inventario.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kardex database table.
 * 
 */
@Embeddable
public class KardexPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="uuid_producto")
	private String uuidProducto;

	private String lote;

	@Column(name="uuid_bodega")
	private String uuidBodega;

	public KardexPK() {
	}
	public String getUuidProducto() {
		return this.uuidProducto;
	}
	public void setUuidProducto(String uuidProducto) {
		this.uuidProducto = uuidProducto;
	}
	public String getLote() {
		return this.lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getUuidBodega() {
		return this.uuidBodega;
	}
	public void setUuidBodega(String uuidBodega) {
		this.uuidBodega = uuidBodega;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof KardexPK)) {
			return false;
		}
		KardexPK castOther = (KardexPK)other;
		return 
			this.uuidProducto.equals(castOther.uuidProducto)
			&& this.lote.equals(castOther.lote)
			&& this.uuidBodega.equals(castOther.uuidBodega);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.uuidProducto.hashCode();
		hash = hash * prime + this.lote.hashCode();
		hash = hash * prime + this.uuidBodega.hashCode();
		
		return hash;
	}
}