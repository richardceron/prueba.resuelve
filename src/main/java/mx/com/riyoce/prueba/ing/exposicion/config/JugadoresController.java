package mx.com.riyoce.prueba.ing.exposicion.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.riyoce.prueba.ing.modelo.JugadorRequest;
import mx.com.riyoce.prueba.ing.modelo.JugadorResponse;
import mx.com.riyoce.prueba.ing.modelos.excepciones.JugadoresException;
import mx.com.riyoce.prueba.ing.servicios.JugadorService;

/**
 * Clase de configuracion para el controlador rest
 * del aplicativo
 * @author riyoce@gmail.com
 * 5 may 2019 18:47:36
 *
 */
@RestController
@RequestMapping("/jugadores")
public class JugadoresController {

	/**
	 * {@link JugadorService}
	 */
	@Autowired
	private JugadorService jugadorService;
	
	/**
	 * Metodo que atiende la solicitud POST para
	 * generar los sueldos
	 * @param request
	 * @return
	 * @throws JugadoresException
	 */
	@RequestMapping(value = "/sueldos", method = RequestMethod.POST)
	@ResponseBody
	public List<JugadorResponse> generaSueldo(@RequestBody List<JugadorRequest> request) throws JugadoresException  {
		return jugadorService.procesaSolicitud(request);
	}
	
}
