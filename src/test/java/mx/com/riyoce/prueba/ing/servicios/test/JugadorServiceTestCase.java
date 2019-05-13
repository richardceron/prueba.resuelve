package mx.com.riyoce.prueba.ing.servicios.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
import mx.com.riyoce.prueba.ing.modelo.JugadorRequest;
import mx.com.riyoce.prueba.ing.modelo.JugadorResponse;
import mx.com.riyoce.prueba.ing.servicios.JugadorService;
import mx.com.riyoce.prueba.ing.servicios.config.ServiceApplicationContext;

/**
 * Clase de pruebas para JugadorService	
 * @author riyoce@gmail.com
 * 12 may 2019 21:13:26
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceApplicationContext.class})
public class JugadorServiceTestCase extends TestCase {

	/**
	 * Objeto a probar
	 */
	@Autowired
	private JugadorService jugadorService;
	
	/**
	 * Prueba ok para procesaSolicitud
	 */
	@Test
	public void testProcesaSolicitud() {
		try {
			List<JugadorRequest> jugadores = new ArrayList<JugadorRequest>();
			JugadorRequest jugador = new JugadorRequest();
			jugador.setNombre("Juan Perez");
			jugador.setNivel("C");
			jugador.setGoles(1);
			jugador.setSueldo(new BigDecimal(50000));
			jugador.setBono(new BigDecimal(25000));
			jugador.setEquipo("rojo");
			jugadores.add(jugador);
			List<JugadorResponse> response = jugadorService.procesaSolicitud(jugadores);
			assertNotNull(response);
		} catch (Exception e) {
			fail("No se esperaba excepcion" + e);
		}
	}
	
	/**
	 * Prueba error para procesaSolicitud
	 * No se tienen goles minimos ni nivel
	 */
	@Test
	public void testProcesaSolicitudErrorNivel() {
		try {
			List<JugadorRequest> jugadores = new ArrayList<JugadorRequest>();
			JugadorRequest jugador = new JugadorRequest();
			jugador.setNombre("Juan Perez");
			jugador.setGoles(1);
			jugador.setSueldo(new BigDecimal(50000));
			jugador.setBono(new BigDecimal(25000));
			jugador.setEquipo("rojo");
			jugadores.add(jugador);
			jugadorService.procesaSolicitud(jugadores);
			fail("Se esperaba excepcion");
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
	/**
	 * Prueba error para procesaSolicitud
	 * No existe el nivel enviado
	 */
	@Test
	public void testProcesaSolicitudNivelNoExiste() {
		try {
			List<JugadorRequest> jugadores = new ArrayList<JugadorRequest>();
			JugadorRequest jugador = new JugadorRequest();
			jugador.setNombre("Juan Perez");
			jugador.setNivel("Z");
			jugador.setGoles(1);
			jugador.setSueldo(new BigDecimal(50000));
			jugador.setBono(new BigDecimal(25000));
			jugador.setEquipo("rojo");
			jugadores.add(jugador);
			jugadorService.procesaSolicitud(jugadores);
			fail("Se esperaba excepcion");
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
}
