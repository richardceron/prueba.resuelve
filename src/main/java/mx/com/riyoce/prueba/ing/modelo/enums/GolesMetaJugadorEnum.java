package mx.com.riyoce.prueba.ing.modelo.enums;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * Enumerador que guarda la relacion
 * entre nivel del jugador y goles requeridos
 * @author riyoce@gmail.com
 * 5 may 2019 21:56:44
 *
 */
public enum GolesMetaJugadorEnum {

	NIVEL_A("A", 5),
	NIVEL_B("B", 10),
	NIVEL_C("C", 15),
	NIVEL_CUAUH("CUAUH", 20);
	
	/**
	 * Clave del nivel
	 */
	private String claveNivel;
	
	/**
	 * Goles Minimos
	 */
	private Integer golesMinimos;

	/**
	 * Constructor privado privado
	 * @param claveNivel
	 * @param golesMinimos
	 */
	private GolesMetaJugadorEnum(String claveNivel, Integer golesMinimos) {
		this.claveNivel = claveNivel;
		this.golesMinimos = golesMinimos;
	}
	
	/**
	 * Metodo que obtiene el enum correspondiente
	 * al nivel
	 * @param claveNivel
	 * @returno
	 */
	public static GolesMetaJugadorEnum getEnum(String claveNivel) {
	    for(GolesMetaJugadorEnum v : values()){
	        if(StringUtils.equals(v.getClaveNivel(), claveNivel)){
	            return v;
	        }
	    }
	    throw new IllegalArgumentException(MessageFormat.format("El nivel {0} no existe en la configuracion", claveNivel));
	}

	/**
	 * @return the claveNivel
	 */
	public String getClaveNivel() {
		return claveNivel;
	}

	/**
	 * @return the golesMinimos
	 */
	public Integer getGolesMinimos() {
		return golesMinimos;
	}
	
}
