package com.umss.fcyt.modelo;

public class Paciente {
	private TipoPaciente tipo;
	private GravedadPaciente gravedad;
	private String nombre;
	private EstadoFinal estadoFinal;
	private int tiempoEspera;
	private int tiempoDeAtencion;
	private int horaEntrada;
	private int horaSalida;

	Thread procesoPaciente;

	public Paciente(String nombre) {
		this.nombre = nombre;
		this.tipo = TipoPaciente.PACIENTES_GRAVES;
		this.estadoFinal = EstadoFinal.DADO_ALTA;
		this.gravedad = null;

		this.tiempoDeAtencion = 10;// otra variable
		this.tiempoEspera = 2;
		this.horaEntrada = 2;
		this.horaSalida = 5;
	}

	
	
	public EstadoFinal getEstadoFinal() {
		return estadoFinal;
	}



	public void setEstadoFinal(EstadoFinal estadoFinal) {
		this.estadoFinal = estadoFinal;
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
	public int getTiempoEspera(){
		return tiempoEspera;
	}
	public void setTiempoEspera(int tiempoEspera){
		this.tiempoEspera = tiempoEspera;
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
	public int getHoraEntrada(){
		return horaEntrada;
	}
	public void setHoraEntrada(int hora){
		this.horaEntrada = hora;
	}
	public int getHoraSalida(){
		return horaSalida;
	}
	public void setHoraSalida(int hora){
		this.horaSalida = hora;
	}
}
