package com.co.labx.util.dto;

import java.math.BigDecimal;
import java.util.Date;

public class KardexResponseDTO {

	private ProductoResponseDTO producto;
	private String bodega;
	private String lote;
	private String estado;
	private BigDecimal cantidad;
	private BigDecimal cantidadAnterior;
	private Date FechaVencimiento;
	
	public ProductoResponseDTO getProducto() {
		return producto;
	}
	
	public void setProducto(ProductoResponseDTO producto) {
		this.producto = producto;
	}
	
	public String getBodega() {
		return bodega;
	}
	
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getCantidadAnterior() {
		return cantidadAnterior;
	}
	public void setCantidadAnterior(BigDecimal cantidadAnterior) {
		this.cantidadAnterior = cantidadAnterior;
	}
	
	public Date getFechaVencimiento() {
		return FechaVencimiento;
	}
	
	public void setFechaVencimiento(Date fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
	}
	
}
