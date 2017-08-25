package es.oposiciones.modelo.util;

import es.oposiciones.modelo.dominio.Centro;

public class Distancia {

	private Centro centro;
	private long tiempo;
	private String tiempoTexto;
	private int kms;

	public Distancia() {
	}

	public Distancia(Centro centro, long tiempo, String tiempoTexto, int kms) {
		this.centro = centro;
		this.tiempo = tiempo;
		this.tiempoTexto = tiempoTexto;
		this.kms = kms;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

	public String getTiempoTexto() {
		return tiempoTexto;
	}

	public void setTiempoTexto(String tiempoTexto) {
		this.tiempoTexto = tiempoTexto;
	}

	public int getKms() {
		return kms;
	}

	public void setKms(int kms) {
		this.kms = kms;
	}

}
