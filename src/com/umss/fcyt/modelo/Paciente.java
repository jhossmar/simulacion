package com.umss.fcyt.modelo;

public class Paciente implements Runnable{
	TipoPaciente tipo;
	GravedadPaciente gravedad;
	String nombre;
	Cubiculo cubiculoPerteneciente;
	
	public Paciente(String nombre) {
		this.tipo = null;
		this.gravedad = null;
		this.cubiculoPerteneciente = null;
	}
	
	@Override
	public void run() {
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cubiculo getCubiculoPerteneciente() {
		return cubiculoPerteneciente;
	}

	public void setCubiculoPerteneciente(Cubiculo cubiculoPerteneciente) {
		this.cubiculoPerteneciente = cubiculoPerteneciente;
	}

	public TipoPaciente getTipo() {
		return tipo;
	}

	public void setTipo(TipoPaciente tipo) {
		this.tipo = tipo;
	}

	public GravedadPaciente getGravedad() {
		return gravedad;
	}

	public void setGravedad(GravedadPaciente gravedad) {
		this.gravedad = gravedad;
	}
	
	
}
