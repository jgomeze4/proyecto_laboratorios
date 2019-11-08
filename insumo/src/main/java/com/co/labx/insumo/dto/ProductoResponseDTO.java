package com.co.labx.insumo.dto;

public class ProductoResponseDTO {

	private String idProducto;

	private String clasificacionRiesgo;

	private String codigo;

	private String marca;

	private String nombre;

	private String presentacion;

	private String proveedor;

	private String regInvima;
	
	private FamiliaResponseDTO familia;

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
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

	public FamiliaResponseDTO getFamiliaResponseDTO() {
		return familiaResponseDTO;
	}
	
	public void setFamiliaResponseDTO(FamiliaResponseDTO familiaResponseDTO) {
		this.familiaResponseDTO = familiaResponseDTO;
	}
	
}
