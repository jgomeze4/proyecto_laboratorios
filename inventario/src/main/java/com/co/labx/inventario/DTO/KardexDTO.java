package com.co.labx.inventario.DTO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class KardexDTO {

	private BigInteger idProducto;
	private BigInteger idBodega;
	private String lote;
	private String activo;
	private BigDecimal cantidad;
	private Date fechaVencimiento;
	private Long idUsuario;
	
	public BigInteger getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(BigInteger idProducto) {
		this.idProducto = idProducto;
	}
	public BigInteger getIdBodega() {
		return idBodega;
	}
	public void setIdBodega(BigInteger idBodega) {
		this.idBodega = idBodega;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
