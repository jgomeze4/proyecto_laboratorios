package com.co.labx.insumo.service;

import java.util.List;

import com.co.labx.insumo.dto.ProductoDTO;
import com.co.labx.util.dto.ProductoResponseDTO;

public interface IProductoService {

	List<ProductoResponseDTO> obtenerProductos();
	ProductoResponseDTO obtenerProducto(String id);
	ProductoResponseDTO guardarProducto(ProductoDTO productoDTO) throws Exception;
}
