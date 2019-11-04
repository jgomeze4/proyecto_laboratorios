package com.co.labx.inventario.service;

import com.co.labx.inventario.DTO.MovimientoKardexDTO;
import com.co.labx.inventario.model.MovimientoKardex;

public interface IMovimientoService {

	MovimientoKardex generarMovimiento(MovimientoKardexDTO movimientoKardexDTO);
	
}
