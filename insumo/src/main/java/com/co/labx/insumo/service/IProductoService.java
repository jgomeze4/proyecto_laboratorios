package com.co.labx.insumo.service;

import java.util.List;

import com.co.labx.insumo.dto.ProductoDTO;
import com.co.labx.insumo.model.Producto;

public interface IProductoService {

	List<Producto> obtenerProductos();
	Producto guardarProducto(ProductoDTO productoDTO) throws Exception;
}
