package com.umss.fcyt.modelo;

public class Paciente {
	private TipoPaciente tipo;
	private GravedadPaciente gravedad;
	private String nombre;

	private int tiempoDeAtencion;

	Thread procesoPaciente;

	public Paciente(String nombre) {
		this.nombre = nombre;
		this.tipo = TipoPaciente.QUEMADURAS;
		this.gravedad = null;

		this.tiempoDeAtencion = 6;// otra variable
	}

	public boolean equals(Object obj) {
		if (obj instanceof Paciente) {
			Paciente tmpPersona = (Paciente) obj;
			if (this.nombre.equals(tmpPersona.nombre)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int getTiempoDeAtencion() {
		return tiempoDeAtencion;
	}

	public void setTiempoDeAtencion(int tiempoDeAtencion) {
		this.tiempoDeAtencion = tiempoDeAtencion;
	}

	public void reducirTiempoDeAtencion() {
		this.tiempoDeAtencion = this.tiempoDeAtencion - 1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
