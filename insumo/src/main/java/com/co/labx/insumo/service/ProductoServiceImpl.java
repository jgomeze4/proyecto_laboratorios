package com.co.labx.insumo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.labx.insumo.model.Producto;
import com.co.labx.insumo.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public List<Producto> obtenerProductos() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional
	public Producto guardarProducto(Producto producto) {
		if(producto.getFamilia() == null) {
			new Exception("El producto no tiene familia asociada");
		}
		
		return productoRepository.save(producto);
	}
	
	
	
}
