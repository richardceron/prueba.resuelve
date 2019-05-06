package mx.com.riyoce.prueba.ing.servicios.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import mx.com.riyoce.prueba.ing.modelo.JugadorRequest;
import mx.com.riyoce.prueba.ing.modelo.JugadorResponse;
import mx.com.riyoce.prueba.ing.modelos.excepciones.JugadoresException;
import mx.com.riyoce.prueba.ing.servicios.JugadorService;
import mx.com.riyoce.prueba.ing.servicios.utils.GolesUtils;

/**
 * Implementacion para las operaciones de negocio
 * de jugadores
 * 
 * @author riyoce@gmail.com
 * 5 may 2019 20:45:20
 *
 */
@Service("jugadorService")
public class JugadorServiceImpl implements JugadorService {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LogManager.getLogger(JugadorServiceImpl.class);
	
	/**
	 * Divisor para la mitad del bono
	 */
	private static final BigDecimal DOS_DIVISOR = new BigDecimal(2);
	
	/**
	 * Metodo que procesa el calculo de sueldos
	 * para los jugadoresoo
	 * @param jugadores
	 * @return
	 * @throws JugadoresException
	 */
	@Override
	public List<JugadorResponse> procesaSolicitud(List<JugadorRequest> jugadores) throws JugadoresException {
		try {
			List<JugadorResponse> response = new ArrayList<JugadorResponse>();
			float porcentajeEquipo = calculaPorcentajeEquipo(jugadores);
			
			for (JugadorRequest jugadorRequest : jugadores) {
				JugadorResponse jugadorResponse = new JugadorResponse();
				BeanUtils.copyProperties(jugadorResponse, jugadorRequest);
				asignaSueldo(jugadorResponse, porcentajeEquipo);
				response.add(jugadorResponse);
			}
			
			return response;
		} catch (Exception e) {
			LOGGER.error("Error al procesar la solicitud", e);
			throw new JugadoresException("Error al procesar la solicitud", e);
		}
		
	}

	/**
	 * Metodo que asigna el sueldo por referencia al jugador.
	 * Calcula el monto real del bono individual y grupal
	 * @param jugador
	 * @param porcentajeEquipo
	 */
	private void asignaSueldo(JugadorResponse jugador, float porcentajeEquipo) {
		//Dicide el bono recibido en el request por la mitad
		BigDecimal bonoBase = NumberUtils.toScaledBigDecimal(jugador.getBono()).divide(DOS_DIVISOR);
		BigDecimal bonoEquipo = GolesUtils.calculaMontoBono(porcentajeEquipo, bonoBase);
		BigDecimal bonoPersonal = GolesUtils.calculaMontoBono(GolesUtils.getPorcentajeGoles(GolesUtils.getGolesRequeridos(jugador), jugador.getGoles()), bonoBase);
		BigDecimal bonoReal = bonoEquipo.add(bonoPersonal);
		jugador.setSueldoCompleto(bonoReal.add(jugador.getSueldo()));
	}
	
	/**
	 * Metodo que calcula el pocentaje
	 * obtenido del equipo con base en la
	 * sumatoria de los goles esperados y los goles obtenidos
	 * @param jugadores
	 * @return
	 */
	private float calculaPorcentajeEquipo(List<JugadorRequest> jugadores) {
		Integer totalGolesRequeridos = NumberUtils.INTEGER_ZERO;
		Integer totalGolesEquipo = NumberUtils.INTEGER_ZERO;
		
		for (JugadorRequest jugadorRequest : jugadores) {
			totalGolesRequeridos += GolesUtils.getGolesRequeridos(jugadorRequest);
			totalGolesEquipo += jugadorRequest.getGoles();
		}
		
		return GolesUtils.getPorcentajeGoles(totalGolesRequeridos, totalGolesEquipo);
	}
	
}
