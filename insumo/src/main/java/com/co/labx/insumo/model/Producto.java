package com.co.labx.insumo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Long idProducto;

	private String activo;

	@Column(name="clasificacion_riesgo")
	private String clasificacionRiesgo;

	private String codigo;

	@Column(name="id_usuario")
	private BigInteger idUsuario;

	private String marca;

	private String nombre;

	private String presentacion;

	private String proveedor;

	@Column(name="reg_invima")
	private String regInvima;

	@Column(name="temp_almacenamiento")
	private String tempAlmacenamiento;

	//bi-directional many-to-one association to Familia
	@ManyToOne
	@JoinColumn(name="id_familia")
	private Familia familia;

	public Producto() {
	}

	public Long getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getClasificacionRiesgo() {
		return this.clasificacionRiesgo;
	}

	public void setClasificacionRiesgo(String clasificacionRiesgo) {
		this.clasificacionRiesgo = clasificacionRiesgo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigInteger getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(BigInteger idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getRegInvima() {
		return this.regInvima;
	}

	public void setRegInvima(String regInvima) {
		this.regInvima = regInvima;
	}

	public String getTempAlmacenamiento() {
		return this.tempAlmacenamiento;
	}

	public void setTempAlmacenamiento(String tempAlmacenamiento) {
		this.tempAlmacenamiento = tempAlmacenamiento;
	}

	public Familia getFamilia() {
		return this.familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

}