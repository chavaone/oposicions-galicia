package es.oposiciones.modelo.util;

public abstract class DistanciaHaversine {

	/**
	 * Método para calcular la distancia entre dos puntos dadas sus coordenadas
	 */
	public static Double calcular(String lat1, String long1, String lat2, String long2) {
		final int R = 6371; // Radio de la Tierra
		Double latitud1 = Double.valueOf(lat1.replaceAll(",", "."));
		Double longitud1 = Double.valueOf(long1.replaceAll(",", "."));
		Double latitud2 = Double.valueOf(lat2.replaceAll(",", "."));
		Double longitud2 = Double.valueOf(long2.replaceAll(",", "."));
		Double latDistance = enRadianes(latitud2 - latitud1);
		Double lonDistance = enRadianes(longitud2 - longitud1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
				Math.cos(enRadianes(latitud1)) * Math.cos(enRadianes(latitud2)) *
				Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return R * c;
	}

	private static Double enRadianes(Double value) {
		return value * Math.PI / 180;
	}

}
