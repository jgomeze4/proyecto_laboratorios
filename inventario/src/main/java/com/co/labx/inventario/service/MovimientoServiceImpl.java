package com.co.labx.inventario.service;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.labx.inventario.DTO.MovimientoKardexDTO;
import com.co.labx.inventario.model.Kardex;
import com.co.labx.inventario.model.KardexPK;
import com.co.labx.inventario.model.MovimientoKardex;
import com.co.labx.inventario.repository.IMovimientoKardexRepository;

@Service
public class MovimientoServiceImpl implements IMovimientoService {

	@Autowired
	private IMovimientoKardexRepository movimientoKardexRepository;
	
	@Override
	@Transactional
	public MovimientoKardex generarMovimiento(MovimientoKardexDTO movimientoKardexDTO) {
		MovimientoKardex moKardex = new MovimientoKardex();
		
		Kardex kar = new Kardex();
		KardexPK kardexPK = new KardexPK();
		
		kardexPK.setUuidProducto(movimientoKardexDTO.getKardexDTO().getIdProducto());
		kardexPK.setUuidBodega(movimientoKardexDTO.getKardexDTO().getIdBodega());
		kardexPK.setLote(movimientoKardexDTO.getKardexDTO().getLote());		
		kar.setId(kardexPK);
		
		moKardex.setUuidMovimientoKardex(UUID.randomUUID().toString());
		moKardex.setKardex(kar);
		moKardex.setUuidUsuarioMoviento(movimientoKardexDTO.getIdUsuario());
		moKardex.setFechaMovimiento(Calendar.getInstance().getTime());
		moKardex.setTipoMovimiento(movimientoKardexDTO.getTipoMovimiento());
		moKardex.setCantidad(movimientoKardexDTO.getCantidad());
		
		return movimientoKardexRepository.save(moKardex);
	}

}
