package com.co.labx.insumo.dto;

import java.math.BigInteger;

public class ProductoDTO {
	
	private Long idProducto;

	private String activo;

	private String clasificacionRiesgo;

	private String codigo;

	private BigInteger idUsuario;

	private String marca;

	private String nombre;

	private String presentacion;

	private String proveedor;

	private String regInvima;

	private String tempAlmacenamiento;
	
	private Long idFamilia;
	
	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getClasificacionRiesgo() {
		return clasificacionRiesgo;
	}

	public void setClasificacionRiesgo(String clasificacionRiesgo) {
		this.clasificacionRiesgo = clasificacionRiesgo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigInteger getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(BigInteger idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getRegInvima() {
		return regInvima;
	}

	public void setRegInvima(String regInvima) {
		this.regInvima = regInvima;
	}

	public String getTempAlmacenamiento() {
		return tempAlmacenamiento;
	}

	public void setTempAlmacenamiento(String tempAlmacenamiento) {
		this.tempAlmacenamiento = tempAlmacenamiento;
	}

	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

}
