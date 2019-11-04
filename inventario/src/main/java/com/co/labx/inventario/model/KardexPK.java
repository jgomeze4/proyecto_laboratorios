package com.co.labx.inventario.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

/**
 * The primary key class for the kardex database table.
 * 
 */
@Embeddable
public class KardexPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_producto", insertable=false, updatable=false)
	private BigInteger idProducto;

	private String lote;

	@Column(name="id_bodega", insertable=false, updatable=false)
	private BigInteger idBodega;

	public KardexPK() {
	}
	public BigInteger getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(BigInteger idProducto) {
		this.idProducto = idProducto;
	}
	public String getLote() {
		return this.lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public BigInteger getIdBodega() {
		return this.idBodega;
	}
	public void setIdBodega(BigInteger idBodega) {
		this.idBodega = idBodega;
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
			this.idProducto.equals(castOther.idProducto)
			&& this.lote.equals(castOther.lote)
			&& this.idBodega.equals(castOther.idBodega);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProducto.hashCode();
		hash = hash * prime + this.lote.hashCode();
		hash = hash * prime + this.idBodega.hashCode();
		
		return hash;
	}
}