package com.co.labx.insumo.service;

import java.util.List;

import com.co.labx.insumo.dto.ProductoDTO;
import com.co.labx.util.dto.ProductoResponseDTO;
import com.co.labx.util.dto.ResponseDTO;

public interface IProductoService {

	List<ProductoResponseDTO> obtenerProductos();
	ProductoResponseDTO obtenerProducto(String id);
	void guardarProducto(ResponseDTO<ProductoResponseDTO> response, ProductoDTO productoDTO) throws Exception;
}
