package com.co.labx.inventario.helper;

import java.math.BigDecimal;

import com.co.labx.inventario.DTO.KardexDTO;
import com.co.labx.inventario.model.Kardex;
import com.co.labx.inventario.model.KardexPK;

public class KardexHelper {

	public static Kardex parseKardexDTOAKardex(KardexDTO kardexDTO) {
		Kardex kardex = new Kardex();
		
		if(kardexDTO == null) {
			return null;
		}
		KardexPK kardexPK = new KardexPK();
		kardexPK.setUuidProducto(kardexDTO.getIdProducto());
		kardexPK.setUuidBodega(kardexDTO.getIdBodega());
		kardexPK.setLote(kardexDTO.getLote());
		kardex.setId(kardexPK);
		kardex.setActivo(kardexDTO.getActivo());
		kardex.setCantidad(kardexDTO.getCantidad());
		kardex.setCantidadAnterior(new BigDecimal(0));
		kardex.setFechaVencimiento(kardexDTO.getFechaVencimiento());
		kardex.setUuidUsuarioModificacion(kardexDTO.getIdUsuario());
		
		return kardex;
		
	}
	
	
}
