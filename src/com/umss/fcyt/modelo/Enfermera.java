package com.umss.fcyt.modelo;

public class Enfermera {
	private String nombre;
	Cubiculo cubiculoActual;
	
	public Enfermera(String nombre) {
		this.nombre = nombre;
		this.cubiculoActual = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cubiculo getCubiculoActual() {
		return cubiculoActual;
	}

	public void setCubiculoActual(Cubiculo cubiculoActual) {
		this.cubiculoActual = cubiculoActual;
	}
}
