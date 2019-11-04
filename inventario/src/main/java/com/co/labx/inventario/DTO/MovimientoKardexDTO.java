package com.co.labx.inventario.DTO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class MovimientoKardexDTO {

	private BigInteger idMovimiento;
	private BigDecimal cantidad;
	private Long idUsuario;
	private KardexDTO kardexDTO;
	private String tipoMovimiento;
	private Date fecha;
	public BigInteger getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(BigInteger idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public KardexDTO getKardexDTO() {
		return kardexDTO;
	}
	public void setKardexDTO(KardexDTO kardexDTO) {
		this.kardexDTO = kardexDTO;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
	
}
