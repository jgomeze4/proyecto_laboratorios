package com.co.labx.insumo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Table(name="productos")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3077705420982538970L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO", unique=true, nullable=false)
	private String idProducto;

	@Column(name="C_R1", nullable=false)
	private short cR1;

	@Column(name="C_R2", nullable=false)
	private short cR2;

	@Column(name="C_R3", nullable=false)
	private short cR3;

	@Lob
	@Column(name="CLASIFICACION", nullable=false)
	private String clasificacion;

	@Column(name="CODIGO", nullable=false, length=20)
	private String codigo;

	@Column(name="ESTADO", nullable=false)
	private byte estado;

	@Lob
	@Column(name="FAMILIA", nullable=false)
	private String familia;

	@Lob
	@Column(name="HISTORIAL", nullable=false)
	private String historial;

	@Lob
	@Column(name="INVIMA", nullable=false)
	private String invima;

	@Lob
	@Column(name="MARCA", nullable=false)
	private String marca;

	@Lob
	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	@Column(name="NUM_REACTIVOS", nullable=false)
	private byte numReactivos;

	@Lob
	@Column(name="PRESENTACION", nullable=false)
	private String presentacion;

	@Lob
	@Column(name="PROVEEDOR", nullable=false)
	private String proveedor;

	@Column(name="TEMPERATURA_ALMA", nullable=false, length=20)
	private String temperaturaAlma;

	@Lob
	@Column(name="USUARIO_CREACION", nullable=false)
	private String usuarioCreacion;

	public Producto() {
	}

	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public short getCR1() {
		return this.cR1;
	}

	public void setCR1(short cR1) {
		this.cR1 = cR1;
	}

	public short getCR2() {
		return this.cR2;
	}

	public void setCR2(short cR2) {
		this.cR2 = cR2;
	}

	public short getCR3() {
		return this.cR3;
	}

	public void setCR3(short cR3) {
		this.cR3 = cR3;
	}

	public String getClasificacion() {
		return this.clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getFamilia() {
		return this.familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getHistorial() {
		return this.historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	public String getInvima() {
		return this.invima;
	}

	public void setInvima(String invima) {
		this.invima = invima;
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

	public byte getNumReactivos() {
		return this.numReactivos;
	}

	public void setNumReactivos(byte numReactivos) {
		this.numReactivos = numReactivos;
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

	public String getTemperaturaAlma() {
		return this.temperaturaAlma;
	}

	public void setTemperaturaAlma(String temperaturaAlma) {
		this.temperaturaAlma = temperaturaAlma;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

}
