package com.co.labx.inventario.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the movimiento_kardex database table.
 * 
 */
@Entity
@Table(name="movimiento_kardex")
@NamedQuery(name="MovimientoKardex.findAll", query="SELECT m FROM MovimientoKardex m")
public class MovimientoKardex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uuid_movimiento_kardex")
	private String uuidMovimientoKardex;

	private BigDecimal cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_movimiento")
	private Date fechaMovimiento;

	@Column(name="tipo_movimiento")
	private String tipoMovimiento;

	@Column(name="uuid_usuario_moviento")
	private String uuidUsuarioMoviento;

	//bi-directional many-to-one association to Kardex
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="lote", referencedColumnName="lote"),
		@JoinColumn(name="uuid_bodega", referencedColumnName="uuid_bodega"),
		@JoinColumn(name="uuid_producto", referencedColumnName="uuid_producto")
		})
	private Kardex kardex;

	public MovimientoKardex() {
	}

	public String getUuidMovimientoKardex() {
		return this.uuidMovimientoKardex;
	}

	public void setUuidMovimientoKardex(String uuidMovimientoKardex) {
		this.uuidMovimientoKardex = uuidMovimientoKardex;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaMovimiento() {
		return this.fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getTipoMovimiento() {
		return this.tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getUuidUsuarioMoviento() {
		return this.uuidUsuarioMoviento;
	}

	public void setUuidUsuarioMoviento(String uuidUsuarioMoviento) {
		this.uuidUsuarioMoviento = uuidUsuarioMoviento;
	}

	public Kardex getKardex() {
		return this.kardex;
	}

	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}

}