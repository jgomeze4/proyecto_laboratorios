package com.co.labx.insumo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.labx.insumo.dto.ProductoDTO;
import com.co.labx.insumo.model.Familia;
import com.co.labx.insumo.model.Producto;
import com.co.labx.insumo.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IFamiliaService familiaService;

	@Override
	public List<Producto> obtenerProductos() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional
	public Producto guardarProducto(ProductoDTO productoDTO) throws Exception {
		return productoRepository.save(parseProductoDTOtoProducto(productoDTO));
	}
	
	
	private Producto parseProductoDTOtoProducto(ProductoDTO productoDTO) throws Exception {
		Familia familia = familiaService.findById(productoDTO.getIdFamilia());
		
		if(familia == null) {
			throw new Exception("No hay familia con el id " + productoDTO.getIdFamilia());
		}
		
		Producto producto;
		if(productoDTO.getIdProducto() == null) {
			producto = new Producto();
		} else {
			Optional<Producto> productoResult = productoRepository.findById(productoDTO.getIdProducto());
			if(productoResult.isPresent()) {
				producto = productoResult.get();
			} else {
				throw new Exception("No hay producto con el id " + productoDTO.getIdProducto());
			}
		}
		
		producto.setActivo(productoDTO.getActivo());
		producto.setClasificacionRiesgo(productoDTO.getClasificacionRiesgo());
		producto.setCodigo(productoDTO.getCodigo());
		producto.setIdUsuario(productoDTO.getIdUsuario());
		producto.setMarca(productoDTO.getMarca());
		producto.setNombre(productoDTO.getNombre());
		producto.setPresentacion(productoDTO.getPresentacion());
		producto.setProveedor(productoDTO.getProveedor());
		producto.setRegInvima(productoDTO.getRegInvima());
		producto.setTempAlmacenamiento(productoDTO.getTempAlmacenamiento());
		producto.setFamilia(familia);
		
		return producto;
	}
	
	
}
