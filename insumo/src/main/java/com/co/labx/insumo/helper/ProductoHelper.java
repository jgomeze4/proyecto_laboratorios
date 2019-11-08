package com.co.labx.insumo.helper;

import com.co.labx.insumo.dto.ProductoResponseDTO;
import com.co.labx.insumo.model.Producto;

public class ProductoHelper {

	public static ProductoResponseDTO productoAProductoResponseDTO(Producto producto) {
		ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO();

		productoResponseDTO.setIdProducto(producto.getIdProducto());
		productoResponseDTO.setClasificacionRiesgo(producto.getClasificacionRiesgo());
		productoResponseDTO.setCodigo(producto.getCodigo());
		productoResponseDTO.setMarca(producto.getMarca());
		productoResponseDTO.setNombre(producto.getNombre());
		productoResponseDTO.setPresentacion(producto.getPresentacion());
		productoResponseDTO.setProveedor(producto.getProveedor());
		productoResponseDTO.setRegInvima(producto.getRegInvima());
		productoResponseDTO.setFamilia(FamiliaHelper.familiaAFamiliaResponseDTO(producto.getFamilia()));

		return productoResponseDTO;
	}

}
