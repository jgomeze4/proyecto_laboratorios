package com.co.labx.inventario.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public MovimientoKardex generarMovimiento(MovimientoKardexDTO movimientoKardexDTO) {
		MovimientoKardex moKardex = new MovimientoKardex();
		
		Kardex kar = new Kardex();
		KardexPK kardexPK = new KardexPK();
		kardexPK.setIdProducto(movimientoKardexDTO.getKardexDTO().getIdProducto());
		kardexPK.setIdBodega(movimientoKardexDTO.getKardexDTO().getIdBodega());
		kardexPK.setLote(movimientoKardexDTO.getKardexDTO().getLote());		
		kar.setId(kardexPK);
		
		moKardex.setKardex(kar);
		moKardex.setIdUsuario(movimientoKardexDTO.getIdUsuario());
		moKardex.setFecha(Calendar.getInstance().getTime());
		moKardex.setIdUsuario(movimientoKardexDTO.getIdUsuario());
		moKardex.setTipoMovimiento(movimientoKardexDTO.getTipoMovimiento());
		moKardex.setCantidad(movimientoKardexDTO.getCantidad());
		
		return movimientoKardexRepository.save(moKardex);
	}

}
