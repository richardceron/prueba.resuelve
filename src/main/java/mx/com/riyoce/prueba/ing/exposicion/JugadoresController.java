package mx.com.riyoce.prueba.ing.exposicion;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.riyoce.prueba.ing.modelo.CustomErrorResponse;
import mx.com.riyoce.prueba.ing.modelo.JugadorRequest;
import mx.com.riyoce.prueba.ing.modelo.JugadorResponse;
import mx.com.riyoce.prueba.ing.modelo.excepciones.JugadoresException;
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
	 * Dateformat para el retorno de mensajes
	 */
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
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
	
	/**
	 * Maneja la excepcion JugadoresException
	 * @return
	 */
	@ExceptionHandler({JugadoresException.class})
	@ResponseBody
	public CustomErrorResponse handleJugadoresException(JugadoresException e) {
		return generaReponseError(MessageFormat.format("Error en validaciones de negocio: {0}: {1}", e.getCause(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	/**
	 * Maneja la excepcion HttpMessageNotReadableException
	 * @return
	 */
	@ExceptionHandler({HttpMessageNotReadableException.class})
	@ResponseBody
	public CustomErrorResponse handleHttpMessageNotReadableException() {
		return generaReponseError("Los parametros introducidos no son validos", HttpStatus.BAD_REQUEST.value());
	}
	
	/**
	 * Genera el response de error
	 * @param errorMessage
	 * @param status
	 * @return
	 */
	private CustomErrorResponse generaReponseError(String errorMessage, int status) {
		CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(sdf.format(new Date()));
        errors.setError(errorMessage);
        errors.setStatus(status);
        return errors;
	}
}
