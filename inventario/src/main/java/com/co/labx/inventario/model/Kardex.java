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

	@Column(name = "activo", columnDefinition = "varchar(1) default 'A'")
	private String activo;

	private BigDecimal cantidad;

	@Column(name="cantidad_anterior")
	private BigDecimal cantidadAnterior;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;

	@Column(name="id_usuario")
	private Long idUsuario;

	//bi-directional many-to-one association to Producto
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_producto", insertable=false, updatable=false)
	private Producto producto;

	//bi-directional many-to-one association to Bodega
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_bodega", insertable=false, updatable=false)
	private Bodega bodega;

	//bi-directional many-to-one association to MovimientoKardex
	/*@OneToMany(mappedBy="kardex")
	private List<MovimientoKardex> movimientoKardexs;*/

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

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

}