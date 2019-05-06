package mx.com.riyoce.prueba.ing.servicios;

import java.util.List;

import mx.com.riyoce.prueba.ing.modelo.JugadorRequest;
import mx.com.riyoce.prueba.ing.modelo.JugadorResponse;
import mx.com.riyoce.prueba.ing.modelos.excepciones.JugadoresException;

/**
 * Interface para las operaciones de negocio
 * de jugadores
 * @author riyoce@gmail.com
 * 5 may 2019 20:39:36
 *
 */
public interface JugadorService {

	/**
	 * Metodo que procesa el calculo de sueldos
	 * para los jugadoresoo
	 * @param jugadores
	 * @return
	 * @throws JugadoresException
	 */
	List<JugadorResponse> procesaSolicitud(List<JugadorRequest> jugadores) throws JugadoresException;
	
}
