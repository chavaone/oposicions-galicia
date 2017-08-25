package es.oposiciones.modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Centro {

	private int id;
	private String codigo;
	private String nombre;
	private String direccion;
	private Localidad localidad;
	private Ayuntamiento ayuntamiento;
	private String codigoPostal;
	private String telefono;
	private String coordenadaX;
	private String coordenadaY;

	public Centro() {
	}

	public Centro(String codigo, String nombre, String direccion, Localidad localidad, Ayuntamiento ayuntamiento,
			String codigoPostal, String telefono, String coordenadaX, String coordenadaY) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
		this.ayuntamiento = ayuntamiento;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idLocalidad")
	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "idAyuntamiento")
	public Ayuntamiento getAyuntamiento() {
		return ayuntamiento;
	}

	public void setAyuntamiento(Ayuntamiento ayuntamiento) {
		this.ayuntamiento = ayuntamiento;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(String coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public String getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(String coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

}
