package com.co.labx.inventario.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the kardex database table.
 * 
 */
@Entity
@Table(name="kardex")
@NamedQuery(name="Kardex.findAll", query="SELECT k FROM Kardex k")
public class Kardex implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KardexPK id;

	private String activo;

	private BigDecimal cantidad;

	@Column(name="cantidad_anterior")
	private BigDecimal cantidadAnterior;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;

	@Temporal(TemporalType.DATE)
	@Column(name="fehca_creacion")
	private Date fehcaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fehca_modificacion")
	private Date fehcaModificacion;

	@Column(name="uuid_usuario_creacion")
	private String uuidUsuarioCreacion;

	@Column(name="uuid_usuario_modificacion")
	private String uuidUsuarioModificacion;

	//bi-directional many-to-one association to MovimientoKardex
	@OneToMany(mappedBy="kardex")
	private List<MovimientoKardex> movimientoKardexs;

	public Kardex() {
	}

	public KardexPK getId() {
		return this.id;
	}

	public void setId(KardexPK id) {
		this.id = id;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCantidadAnterior() {
		return this.cantidadAnterior;
	}

	public void setCantidadAnterior(BigDecimal cantidadAnterior) {
		this.cantidadAnterior = cantidadAnterior;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFehcaCreacion() {
		return this.fehcaCreacion;
	}

	public void setFehcaCreacion(Date fehcaCreacion) {
		this.fehcaCreacion = fehcaCreacion;
	}

	public Date getFehcaModificacion() {
		return this.fehcaModificacion;
	}

	public void setFehcaModificacion(Date fehcaModificacion) {
		this.fehcaModificacion = fehcaModificacion;
	}

	public String getUuidUsuarioCreacion() {
		return this.uuidUsuarioCreacion;
	}

	public void setUuidUsuarioCreacion(String uuidUsuarioCreacion) {
		this.uuidUsuarioCreacion = uuidUsuarioCreacion;
	}

	public String getUuidUsuarioModificacion() {
		return this.uuidUsuarioModificacion;
	}

	public void setUuidUsuarioModificacion(String uuidUsuarioModificacion) {
		this.uuidUsuarioModificacion = uuidUsuarioModificacion;
	}

	public List<MovimientoKardex> getMovimientoKardexs() {
		return this.movimientoKardexs;
	}

	public void setMovimientoKardexs(List<MovimientoKardex> movimientoKardexs) {
		this.movimientoKardexs = movimientoKardexs;
	}

	public MovimientoKardex addMovimientoKardex(MovimientoKardex movimientoKardex) {
		getMovimientoKardexs().add(movimientoKardex);
		movimientoKardex.setKardex(this);

		return movimientoKardex;
	}

	public MovimientoKardex removeMovimientoKardex(MovimientoKardex movimientoKardex) {
		getMovimientoKardexs().remove(movimientoKardex);
		movimientoKardex.setKardex(null);

		return movimientoKardex;
	}

}