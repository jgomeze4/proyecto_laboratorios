package com.co.labx.inventario.DTO;

import java.math.BigDecimal;
import java.util.Date;

public class MovimientoKardexDTO {

	private String idMovimiento;
	private BigDecimal cantidad;
	private String idUsuario;
	private KardexDTO kardexDTO;
	private String tipoMovimiento;
	private Date fecha;
	
	public String getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(String idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
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
