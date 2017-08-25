package es.oposiciones.modelo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.oposiciones.modelo.dao.AyuntamientoDao;
import es.oposiciones.modelo.dao.CentroDao;
import es.oposiciones.modelo.dao.LocalidadDao;
import es.oposiciones.modelo.dao.ProvinciaDao;
import es.oposiciones.modelo.dominio.Ayuntamiento;
import es.oposiciones.modelo.dominio.Centro;
import es.oposiciones.modelo.dominio.Localidad;
import es.oposiciones.modelo.dominio.Provincia;

public class EntidadesServicio {

	@Autowired
	private ProvinciaDao provinciaDao;

	@Autowired
	private AyuntamientoDao ayuntamientoDao;

	@Autowired
	private LocalidadDao localidadDao;

	@Autowired
	private CentroDao centroDao;

	public Provincia getProvincia(int id) {
		return provinciaDao.buscar(id);
	}

	public Ayuntamiento getAyuntamiento(int id) {
		return ayuntamientoDao.buscar(id);
	}

	public Localidad getLocalidad(int id) {
		return localidadDao.buscar(id);
	}

	public Centro getCentro(int id) {
		return centroDao.buscar(id);
	}

	public Provincia getProvincia(String nombre) {
		return provinciaDao.buscar(nombre);
	}

	public Ayuntamiento getAyuntamiento(String nombre) {
		return ayuntamientoDao.buscar(nombre);
	}

	public Localidad getLocalidad(String nombre) {
		return localidadDao.buscar(nombre);
	}

	public Centro getCentro(String nombre) {
		return centroDao.buscar(nombre);
	}

	public List<Provincia> getProvincias() {
		return provinciaDao.buscarTodos();
	}

	public List<Ayuntamiento> getAyuntamientos() {
		return ayuntamientoDao.buscarTodos();
	}

	public List<Localidad> getLocalidades() {
		return localidadDao.buscarTodos();
	}

	public List<Centro> getCentros() {
		return centroDao.buscarTodos();
	}

}
