package com.co.labx.inventario.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.labx.inventario.DTO.KardexDTO;
import com.co.labx.inventario.DTO.MovimientoKardexDTO;
import com.co.labx.inventario.constants.MovimientoKardexConstants;
import com.co.labx.inventario.model.Kardex;
import com.co.labx.inventario.model.KardexPK;
import com.co.labx.inventario.repository.IKardexRepository;

@Service
public class KardexServiceImpl implements IKardexService {

	@Autowired
	private IKardexRepository kardexRepository;
	
	@Autowired
	private IMovimientoService movimientoService;

	@Override
	public List<Kardex> listar() {
		return kardexRepository.findAll();
	}

	@Override
	@Transactional
	public Kardex ingresar(KardexDTO kardexDTO) {
		KardexPK kardexPK = new KardexPK();
		kardexPK.setIdProducto(kardexDTO.getIdProducto());
		kardexPK.setIdBodega(kardexDTO.getIdBodega());
		kardexPK.setLote(kardexDTO.getLote());
		
		Kardex kardex = new Kardex();
		Optional<Kardex> kardexResult = kardexRepository.findById(kardexPK);
		if(kardexResult.isPresent()) {
			kardex = kardexResult.get();
			
			kardex.setCantidadAnterior(kardexDTO.getCantidad());
			kardex.setCantidad(kardex.getCantidad().add(kardexDTO.getCantidad()));
		} else {
			kardex = new Kardex();
			
			kardex.setId(kardexPK);
			kardex.setActivo(kardexDTO.getActivo()== null?"A":kardexDTO.getActivo());
			kardex.setCantidad(kardexDTO.getCantidad());
			kardex.setCantidadAnterior(new BigDecimal(0));
			kardex.setFechaVencimiento(kardexDTO.getFechaVencimiento());
			kardex.setIdUsuario(kardexDTO.getIdUsuario());
		}
		
		kardex = kardexRepository.save(kardex);
				
		MovimientoKardexDTO mov = new MovimientoKardexDTO();
		
		mov.setCantidad(kardexDTO.getCantidad());
		mov.setIdUsuario(kardexDTO.getIdUsuario());
		mov.setKardexDTO(kardexDTO);
		mov.setFecha(Calendar.getInstance().getTime());
		mov.setTipoMovimiento(MovimientoKardexConstants.ENTRADA);
		
		movimientoService.generarMovimiento(mov);		
		
		return kardex;
	}
	


}
