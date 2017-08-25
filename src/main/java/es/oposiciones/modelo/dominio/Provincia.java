package es.oposiciones.modelo.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Provincia {

	private int id;
	private String nombre;
	private List<Ayuntamiento> ayuntamientos;

	public Provincia() {
	}

	public Provincia(String nombre) {
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(mappedBy = "provincia")
	public List<Ayuntamiento> getAyuntamientos() {
		return ayuntamientos;
	}

	public void setAyuntamientos(List<Ayuntamiento> ayuntamientos) {
		this.ayuntamientos = ayuntamientos;
	}

}
