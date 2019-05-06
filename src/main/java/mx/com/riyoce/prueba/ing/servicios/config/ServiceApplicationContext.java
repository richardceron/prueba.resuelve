package mx.com.riyoce.prueba.ing.servicios.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

/**
 * Clase de configuracion para los contextos
 * de servicios de negocio
 * @author riyoce@gmail.com
 * 6 may 2019 0:31:43
 *
 */
@Configuration
@ComponentScan(basePackages = "mx.com.riyoce.prueba.ing.servicios.impl",
includeFilters = {
        @ComponentScan.Filter(type=FilterType.ANNOTATION, value=Service.class)
    })
public class ServiceApplicationContext {

}
