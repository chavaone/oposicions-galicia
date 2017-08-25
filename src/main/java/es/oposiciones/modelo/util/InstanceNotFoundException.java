package es.oposiciones.modelo.util;

@SuppressWarnings("serial")
public class InstanceNotFoundException extends InstanceException {

	public InstanceNotFoundException(Object clave, String nombreClase) {
		super("Instancia no encontrada", clave, nombreClase);
	}

}
