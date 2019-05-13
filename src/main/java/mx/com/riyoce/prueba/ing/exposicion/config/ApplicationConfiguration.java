package mx.com.riyoce.prueba.ing.exposicion.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Clase de configuracion para los componentes
 * web del servicio
 * @author riyoce@gmail.com
 * 5 may 2019 19:18:16
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "mx.com.riyoce.prueba.ing.exposicion")
public class ApplicationConfiguration {

}
