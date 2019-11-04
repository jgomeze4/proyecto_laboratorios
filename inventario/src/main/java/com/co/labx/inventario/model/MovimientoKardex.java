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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_movimiento_kardex")
	private Long idMovimientoKardex;

	private BigDecimal cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Column(name="id_usuario")
	private Long idUsuario;

	@Column(name="tipo_movimiento")
	private String tipoMovimiento;

	//bi-directional many-to-one association to Kardex
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="id_bodega", referencedColumnName="id_bodega"),
		@JoinColumn(name="id_producto", referencedColumnName="id_producto"),
		@JoinColumn(name="lote", referencedColumnName="lote")
		})
	private Kardex kardex;

	public MovimientoKardex() {
	}

	public Long getIdMovimientoKardex() {
		return this.idMovimientoKardex;
	}

	public void setIdMovimientoKardex(Long idMovimientoKardex) {
		this.idMovimientoKardex = idMovimientoKardex;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoMovimiento() {
		return this.tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Kardex getKardex() {
		return this.kardex;
	}

	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}

}