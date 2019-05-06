package mx.com.riyoce.prueba.ing.servicios.utils;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import mx.com.riyoce.prueba.ing.modelo.JugadorRequest;
import mx.com.riyoce.prueba.ing.modelo.enums.GolesMetaJugadorEnum;

/**
 * Clase de utileria para el control de los goles
 * @author riyoce@gmail.com
 * 5 may 2019 22:40:43
 *
 */
public final class GolesUtils {

	/**
	 * Porcentaje total entero
	 */
	private static final Integer CIEN_PORCIENTO = 100;
	
	/**
	 * Porcentaje total big deciaml
	 */
	private static final BigDecimal CIEN_PORCIENTO_BD = new BigDecimal(100);
	
	/**
	 * Constrcutor privado
	 */
	private GolesUtils() {
		
	}
	
	/**
	 * Metodo que obtiene los goles requeridos del jugador
	 * segun el escenario
	 * @param jugadorRequest
	 * @return
	 */
	public static Integer getGolesRequeridos(JugadorRequest jugadorRequest) {
		//Valida si el jugador pertenece a resuelve FC (tiene un nivel cargado)
		if (!StringUtils.isEmpty(jugadorRequest.getNivel())) {
			return GolesMetaJugadorEnum.getEnum(jugadorRequest.getNivel().toUpperCase()).getGolesMinimos();
		} else {
			//Si no pertenece debera tener la propiedad goles_minimos
			return getGolesMinimos(jugadorRequest);
		}
	}
	
	/**
	 * Metodo que obtiene los goles minimos del request
	 * cuando el nivel no este cargado
	 * @param jugadorRequest
	 * @return
	 */
	private static Integer getGolesMinimos(JugadorRequest jugadorRequest) {
		if (!StringUtils.isEmpty(jugadorRequest.getGolesMinimos())) {
			return NumberUtils.toInt(jugadorRequest.getGolesMinimos());
		} else {
			throw new IllegalArgumentException("El valor goles_minimos no debe estar vacio en este escenario");
		}
	}
	
	/**
	 * Metodo que calcula el porcentaje del bono variable
	 * para la meta
	 * @param golesRequeridos
	 * @param golesAnotados
	 * @return
	 */
	public static float getPorcentajeGoles(Integer golesRequeridos, Integer golesAnotados) {
		Integer numeroBase = golesAnotados * CIEN_PORCIENTO;
		float porcentaje = numeroBase / golesRequeridos;
		return porcentaje > CIEN_PORCIENTO ? CIEN_PORCIENTO : porcentaje;
	}
	
	/**
	 * Metodoq ue calcula el monto real del bono
	 * @param porcentaje
	 * @param bonoCargado
	 * @return
	 */
	public static BigDecimal calculaMontoBono(float porcentaje, BigDecimal bonoCargado) {
		BigDecimal numeroBase = bonoCargado.multiply(NumberUtils.toScaledBigDecimal(porcentaje));
		return numeroBase.divide(CIEN_PORCIENTO_BD);
	}
	
}
