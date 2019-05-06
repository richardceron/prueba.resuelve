package mx.com.riyoce.prueba.ing.modelos.excepciones;

/**
 * Excepcion dle proceso de jugadores
 * @author riyoce@gmail.com
 * 6 may 2019 0:24:21
 *
 */
public class JugadoresException extends Exception {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 6258188392614578915L;
	
	/**
	 * Constrcutor para excepcion con mensaje y causa
	 * @param message
	 * @param cause
	 */
	public JugadoresException(String message, Throwable cause) {
		super(message, cause);
	}

}
