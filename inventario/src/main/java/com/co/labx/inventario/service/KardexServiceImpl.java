package com.co.labx.inventario.service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	public List<KardexResponseDTO> listar(Map<String, String> headers) throws Exception {
		List<KardexResponseDTO> kardexResponseDTOs = new ArrayList<KardexResponseDTO>();
		List<Kardex> kardex = kardexRepository.findAll();
		for (Kardex kardex2 : kardex) {
			ProductoResponseDTO productoResponseDTO = obtenerInfoProducto(new ResponseDTO<KardexResponseDTO>(), kardex2.getId().getUuidProducto(), headers);
			kardexResponseDTOs.add(KardexHelper.parseKardexAKardexResponseDTO(productoResponseDTO, kardex2));
		}
		return kardexResponseDTOs;
	}

	@Override
	@Transactional
	public void ingresar(ResponseDTO<KardexResponseDTO> response, KardexDTO kardexDTO, Map<String, String> headers)
			throws Exception {
		KardexPK kardexPK = new KardexPK();
		ProductoResponseDTO productoResponseDTO = obtenerInfoProducto(response, kardexDTO.getIdProducto(), headers);

		kardexPK.setUuidProducto(kardexDTO.getIdProducto());
		kardexPK.setUuidBodega(kardexDTO.getIdBodega());
		kardexPK.setLote(kardexDTO.getLote());

		Kardex kardex = new Kardex();
		Optional<Kardex> kardexResult = kardexRepository.findById(kardexPK);
		if (kardexResult.isPresent()) {
			kardex = kardexResult.get();

			if (kardexDTO.getCantidad().compareTo(BigDecimal.ZERO) < 1) {
				response.setMessage("La cantidad para ingresar debe ser mayor a 0");
				response.setSuccess(false);
				throw new Exception(response.getMessage());
			}
			if (kardex.getActivo().equals(KardexConstants.KARDEX_ESTADO_VENCIDO)) {
				response.setMessage(
						"No se puede hacer ingreso de inventario, el producto " + kardex.getId() + " está vencido.");
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

	private ProductoResponseDTO obtenerInfoProducto(ResponseDTO<KardexResponseDTO> response, String idProducto,
			Map<String, String> headers) throws Exception {
		try {
			String url = String.format("%s%s%s", env.getProperty("labx.producto.host"),
					env.getProperty("labx.insumo.path"), env.getProperty("labx.insumo.findPath"))
					.replace("{idProducto}", idProducto);
			ProductoResponseDTO productoResponseDTO = clienteProductoService.doGet(url, 200, headers);

			if (productoResponseDTO == null) {
				response.setMessage("El producto con el ID " + idProducto + " no existe.");
				response.setSuccess(false);
				throw new Exception(response.getMessage());
			}
			return productoResponseDTO;
		} catch (Exception e) {
			if (e.getMessage().contains(idProducto)) {
				response.setMessage(e.getMessage());
			} else {
				response.setMessage("Ocurrió un error consultando producto, por favor intenté más tarde.");
			}
			response.setSuccess(false);
			throw new Exception(response.getMessage());
		}
	}

	@Override
	@Transactional
	public void validarKardexVencido() {
		List<Kardex> kardex = kardexRepository.findByKardexVencimiento();

		for (Kardex k : kardex) {
			k.setFehcaModificacion(Calendar.getInstance().getTime());
			k.setActivo(KardexConstants.KARDEX_ESTADO_VENCIDO);

			kardexRepository.save(k);
		}

	}

	@Override
	public void salida(ResponseDTO<KardexResponseDTO> response, KardexDTO kardexDTO, Map<String, String> headers)
			throws Exception {
		KardexPK kardexPK = new KardexPK();
		ProductoResponseDTO productoResponseDTO = obtenerInfoProducto(response, kardexDTO.getIdProducto(), headers);

		kardexPK.setUuidProducto(kardexDTO.getIdProducto());
		kardexPK.setUuidBodega(kardexDTO.getIdBodega());
		kardexPK.setLote(kardexDTO.getLote());

		Kardex kardex = new Kardex();
		Optional<Kardex> kardexResult = kardexRepository.findById(kardexPK);
		if (kardexResult.isPresent()) {
			kardex = kardexResult.get();

			BigDecimal cantidadSalida = kardexDTO.getCantidad().multiply(new BigDecimal(-1));

			if (kardexDTO.getCantidad().compareTo(BigDecimal.ZERO) < 1) {
				response.setMessage("La cantidad para hacer la salida debe ser mayor a 0");
				response.setSuccess(false);
				throw new Exception(response.getMessage());
			}
			if (kardex.getCantidad().add(cantidadSalida).compareTo(BigDecimal.ZERO) < 0) {
				response.setMessage(
						"La cantidad asignada para la salida no debe ser superior a " + kardex.getCantidad());
				response.setSuccess(false);
				throw new Exception(response.getMessage());
			}
			if (kardex.getActivo().equals(KardexConstants.KARDEX_ESTADO_VENCIDO)
					&& kardex.getCantidad().add(cantidadSalida).compareTo(BigDecimal.ZERO) > 0) {
				response.setMessage(
						"No se puede hacer salida de inventario, el producto " + kardex.getId().getUuidProducto()
								+ " del lote " + kardex.getId().getLote() + " está vencido, se debe hacer una salida total.");
				response.setSuccess(false);
				throw new Exception(response.getMessage());
			}

			kardex.setCantidadAnterior(kardex.getCantidad());
			kardex.setCantidad(kardex.getCantidad().add(cantidadSalida));
			kardex.setUuidUsuarioModificacion(kardexDTO.getIdUsuario());
			kardex.setFehcaModificacion(Calendar.getInstance().getTime());
		} else {
			response.setMessage("No se puede hacer salida para el producto " + kardexDTO.getIdProducto()
					+ " que tiene lote " + kardexDTO.getLote() + " no se encuentra registrado.");
			response.setSuccess(false);
			throw new Exception(response.getMessage());
		}

		kardex = kardexRepository.save(kardex);

		MovimientoKardexDTO mov = new MovimientoKardexDTO();

		mov.setCantidad(kardexDTO.getCantidad());
		mov.setIdUsuario(kardexDTO.getIdUsuario());
		mov.setKardexDTO(kardexDTO);
		mov.setFecha(Calendar.getInstance().getTime());
		mov.setTipoMovimiento(MovimientoKardexConstants.SALIDA);

		movimientoService.generarMovimiento(mov);

		response.setData(KardexHelper.parseKardexAKardexResponseDTO(productoResponseDTO, kardex));
		response.setSuccess(true);
	}

}
