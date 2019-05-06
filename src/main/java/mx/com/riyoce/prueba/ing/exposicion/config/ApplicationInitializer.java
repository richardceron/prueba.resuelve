package mx.com.riyoce.prueba.ing.exposicion.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import mx.com.riyoce.prueba.ing.servicios.config.ServiceApplicationContext;

/**
 * Clase de inicializacion general del aplicativo
 * 
 * @author riyoce@gmail.com 5 may 2019 19:18:58
 *
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Sobre escritura del metodo getRootConfigClasses
	 * retorna las clases de configuracion de contexto necesarias
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {
				ServiceApplicationContext.class,
				ApplicationConfiguration.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Sobre escritura del metodo getServletMappings
	 * retorna los contextos web (URI base)
	 * para consumir el aplicativo
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {
				"/rest/*"
		};
	}

}
