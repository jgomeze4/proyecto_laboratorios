package com.co.labx.inventario.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.co.labx.inventario.DTO.KardexDTO;
import com.co.labx.inventario.DTO.MovimientoKardexDTO;
import com.co.labx.inventario.constants.KardexConstants;
import com.co.labx.inventario.constants.MovimientoKardexConstants;
import com.co.labx.inventario.helper.KardexHelper;
import com.co.labx.inventario.model.Kardex;
import com.co.labx.inventario.model.KardexPK;
import com.co.labx.inventario.repository.IKardexRepository;
import com.co.labx.util.dto.KardexResponseDTO;
import com.co.labx.util.dto.ProductoResponseDTO;
import com.co.labx.util.dto.ResponseDTO;
import com.co.labx.util.service.ClienteLabxService;
import com.co.labx.util.service.IClienteLabxService;

@Service
public class KardexServiceImpl implements IKardexService {

	@Autowired
	private IKardexRepository kardexRepository;

	@Autowired
	private IMovimientoService movimientoService;

	@Autowired
	private Environment env;

	private IClienteLabxService<ProductoResponseDTO> clienteProductoService;

	public KardexServiceImpl() {
		clienteProductoService = new ClienteLabxService<>(ProductoResponseDTO.class);
	}

	@Override
	public List<Kardex> listar() {
		return kardexRepository.findAll();
	}

	@Override
	@Transactional
	public void ingresar(ResponseDTO<KardexResponseDTO> response, KardexDTO kardexDTO, Map<String, String> headers) throws Exception {
		KardexPK kardexPK = new KardexPK();
		ProductoResponseDTO productoResponseDTO = obtenerInfoProducto(response, kardexDTO, headers);
		
		kardexPK.setUuidProducto(kardexDTO.getIdProducto());
		kardexPK.setUuidBodega(kardexDTO.getIdBodega());
		kardexPK.setLote(kardexDTO.getLote());

		Kardex kardex = new Kardex();
		Optional<Kardex> kardexResult = kardexRepository.findById(kardexPK);
		if (kardexResult.isPresent()) {
			kardex = kardexResult.get();

			if(kardexDTO.getCantidad().compareTo(BigDecimal.ZERO) < 1) {
				response.setMessage("La cantidad para ingresar debe ser mayor a 0");
				response.setSuccess(false);
				throw new Exception(response.getMessage());
			}
			
			kardex.setCantidadAnterior(kardex.getCantidad());
			kardex.setCantidad(kardex.getCantidad().add(kardexDTO.getCantidad()));
			kardex.setUuidUsuarioModificacion(kardexDTO.getIdUsuario());
			kardex.setFehcaModificacion(Calendar.getInstance().getTime());
		} else {
			kardex = KardexHelper.parseKardexDTOAKardex(kardexDTO);

			kardex.setActivo(KardexConstants.KARDEX_ESTADO_ACTIVO);
			kardex.setCantidad(kardexDTO.getCantidad());
			kardex.setCantidadAnterior(new BigDecimal(0));
			kardex.setUuidUsuarioCreacion(kardexDTO.getIdUsuario());
			kardex.setFehcaCreacion(Calendar.getInstance().getTime());
			kardex.setUuidUsuarioModificacion(kardexDTO.getIdUsuario());
			kardex.setFehcaModificacion(Calendar.getInstance().getTime());
		}

		kardex = kardexRepository.save(kardex);

		MovimientoKardexDTO mov = new MovimientoKardexDTO();

		mov.setCantidad(kardexDTO.getCantidad());
		mov.setIdUsuario(kardexDTO.getIdUsuario());
		mov.setKardexDTO(kardexDTO);
		mov.setFecha(Calendar.getInstance().getTime());
		mov.setTipoMovimiento(MovimientoKardexConstants.ENTRADA);

		movimientoService.generarMovimiento(mov);
		
		response.setData(KardexHelper.parseKardexAKardexResponseDTO(productoResponseDTO, kardex));
		response.setSuccess(true);
	}

	private ProductoResponseDTO obtenerInfoProducto(ResponseDTO<KardexResponseDTO> response, KardexDTO kardexDTO, Map<String, String> headers) throws Exception {
		try {
			String url = String.format("%s%s%s", env.getProperty("labx.producto.host"),
					env.getProperty("labx.insumo.path"), env.getProperty("labx.insumo.findPath")).replace("{idProducto}", kardexDTO.getIdProducto());
			ProductoResponseDTO productoResponseDTO = clienteProductoService.doGet(url, 200, headers);

			if (productoResponseDTO == null) {
				response.setMessage("El producto con el ID " + kardexDTO.getIdProducto() + " no existe.");
				response.setSuccess(false);
				throw new Exception(response.getMessage());
			}
			return productoResponseDTO;
		} catch (Exception e) {
			if(e.getMessage().contains(kardexDTO.getIdProducto())) {
				response.setMessage(e.getMessage());
			} else {
				response.setMessage("Ocurrió un error consultando producto, por favor intenté más tarde.");
			}
			response.setSuccess(false);
			throw new Exception(response.getMessage());
		}
	}
	
}
