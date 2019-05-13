package mx.com.riyoce.prueba.ing.modelo;

import java.io.Serializable;

/**
 * Clase modelo para el response del error
 * @author riyoce@gmail.com
 * 12 may 2019 20:01:05
 *
 */
public class CustomErrorResponse implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 3155874762752406386L;
	
	/**
	 * timestamp para informe del error
	 */
    private String timestamp;
	
	/**
	 * Estatus http
	 */
    private int status;
    
    /**
     * Descripcion del error
     */
    private String error;

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomErrorResponse [timestamp=");
		builder.append(timestamp);
		builder.append(", status=");
		builder.append(status);
		builder.append(", error=");
		builder.append(error);
		builder.append("]");
		return builder.toString();
	}

}
