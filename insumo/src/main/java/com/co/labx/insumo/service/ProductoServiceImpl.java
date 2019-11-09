package com.co.labx.insumo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.labx.insumo.constants.ProductoConstants;
import com.co.labx.util.dto.FamiliaResponseDTO;
import com.co.labx.insumo.dto.ProductoDTO;
import com.co.labx.util.dto.ProductoResponseDTO;
import com.co.labx.insumo.helper.ProductoHelper;
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
	public List<ProductoResponseDTO> obtenerProductos() {
		List<ProductoResponseDTO> productoResponseDTOs = new ArrayList<ProductoResponseDTO>();
		List<Producto> productos = productoRepository.findAll();
		productos.stream().forEach(x -> {
			productoResponseDTOs.add(ProductoHelper.productoAProductoResponseDTO(x));
		});
		
		return productoResponseDTOs;
	}

	@Override
	@Transactional
	public ProductoResponseDTO guardarProducto(ProductoDTO productoDTO) throws Exception {
		return ProductoHelper.productoAProductoResponseDTO(productoRepository.save(parseProductoDTOtoProducto(productoDTO)));
	}
	
	
	private Producto parseProductoDTOtoProducto(ProductoDTO productoDTO) throws Exception {
		FamiliaResponseDTO familia = familiaService.findById(productoDTO.getIdFamilia());
		
		if(familia == null) {
			throw new Exception("No hay familia con el id " + productoDTO.getIdFamilia());
		}
		
		Producto producto;
		if(productoDTO.getIdProducto() == null) {
			producto = new Producto();
			producto.setIdProducto(UUID.randomUUID().toString());
			producto.setActivo(ProductoConstants.ESTADO_ACTIVO);
		} else {
			Optional<Producto> productoResult = productoRepository.findById(productoDTO.getIdProducto());
			if(productoResult.isPresent()) {
				producto = productoResult.get();
			} else {
				throw new Exception("No hay producto con el id " + productoDTO.getIdProducto());
			}
		}
		
		producto.setClasificacionRiesgo(productoDTO.getClasificacionRiesgo());
		producto.setCodigo(productoDTO.getCodigo());
		producto.setIdUsuario(productoDTO.getIdUsuario());
		producto.setMarca(productoDTO.getMarca());
		producto.setNombre(productoDTO.getNombre());
		producto.setPresentacion(productoDTO.getPresentacion());
		producto.setProveedor(productoDTO.getProveedor());
		producto.setRegInvima(productoDTO.getRegInvima());
		producto.setTempAlmacenamiento(productoDTO.getTempAlmacenamiento());
		producto.setFamilia(new Familia());
		producto.getFamilia().setIdFamilia(familia.getId());
		
		return producto;
	}

	@Override
	public ProductoResponseDTO obtenerProducto(String id) {
		ProductoResponseDTO productoResponseDTO;
		
		Optional<Producto> producto = productoRepository.findById(id);
		
		productoResponseDTO = ProductoHelper.productoAProductoResponseDTO(producto.isPresent()?producto.get():null);
		
		return productoResponseDTO;
	}
	
	
}
