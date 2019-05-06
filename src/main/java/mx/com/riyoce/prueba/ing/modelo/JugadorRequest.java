package mx.com.riyoce.prueba.ing.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * Clase que representa el objeto jugador para el request
 * 
 * @author riyoce@gmail.com 5 may 2019 18:24:23
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JugadorRequest implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 6484307437464901076L;

	/**
	 * Nombre del jugador
	 */
	private String nombre;

	/**
	 * Nivel del jugador
	 */
	private String nivel;

	/**
	 * Goles anotados
	 */
	private Integer goles;

	/**
	 * Sueldo base
	 */
	private BigDecimal sueldo;

	/**
	 * Bono variable
	 */
	private BigDecimal bono;

	/**
	 * Equipo del jugador
	 */
	private String equipo;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the goles
	 */
	public Integer getGoles() {
		return goles;
	}

	/**
	 * @param goles the goles to set
	 */
	public void setGoles(Integer goles) {
		this.goles = goles;
	}

	/**
	 * @return the sueldo
	 */
	public BigDecimal getSueldo() {
		return sueldo;
	}

	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * @return the bono
	 */
	public BigDecimal getBono() {
		return bono;
	}

	/**
	 * @param bono the bono to set
	 */
	public void setBono(BigDecimal bono) {
		this.bono = bono;
	}

	/**
	 * @return the equipo
	 */
	public String getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JugadorRequest [nombre=");
		builder.append(nombre);
		builder.append(", nivel=");
		builder.append(nivel);
		builder.append(", goles=");
		builder.append(goles);
		builder.append(", sueldo=");
		builder.append(sueldo);
		builder.append(", bono=");
		builder.append(bono);
		builder.append(", equipo=");
		builder.append(equipo);
		builder.append("]");
		return builder.toString();
	}

}
