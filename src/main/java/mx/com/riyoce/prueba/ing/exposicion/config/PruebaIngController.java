package mx.com.riyoce.prueba.ing.exposicion.config;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.riyoce.prueba.ing.modelo.JugadorRequest;
import mx.com.riyoce.prueba.ing.modelo.JugadorResponse;

/**
 * Clase de configuracion para el controlador rest
 * del aplicativo
 * @author riyoce@gmail.com
 * 5 may 2019 18:47:36
 *
 */
@RestController
@RequestMapping("/jugadores")
public class PruebaIngController {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LogManager.getLogger(PruebaIngController.class);
	
	@RequestMapping(value = "/sueldos", method = RequestMethod.POST)
	@ResponseBody
	public List<JugadorResponse> generaSueldo(@RequestBody List<JugadorRequest> request) throws IllegalAccessException, InvocationTargetException {
		List<JugadorResponse> response = new ArrayList<>();
		for (JugadorRequest jugadorRequest : request) {
			LOGGER.info(MessageFormat.format("Jugador recibido en el request {0}", jugadorRequest.toString()));
			JugadorResponse jugadorResponse = new JugadorResponse();
			BeanUtils.copyProperties(jugadorResponse, jugadorRequest);
			jugadorResponse.setSueldoCompleto(BigDecimal.TEN);
			response.add(jugadorResponse);
		}
		
		return response;
	}
	
}
