package es.oposiciones.modelo.util;

@SuppressWarnings("serial")
public abstract class InstanceException extends Exception {

	private Object clave;
	private String nombreClase;

	protected InstanceException(String mensaje, Object clave, 
			String nombreClase) {
		super(mensaje + " (clave = '" + clave + "' - clase = '" + 
				nombreClase + "')");
		this.clave = clave;
		this.nombreClase = nombreClase;
	}

	public Object getClave() {
		return clave;
	}

	public String getNombreClase() {
		return nombreClase;
	}

}
