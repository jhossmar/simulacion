package com.umss.fcyt.modelo;

public class Paciente implements Runnable {
	private TipoPaciente tipo;
	private GravedadPaciente gravedad;
	private String nombre;
	private Cubiculo cubiculoPerteneciente;
	
	Thread procesoPaciente;
	
	public Paciente(String nombre) {
		this.nombre = nombre;
		this.tipo = null;
		this.gravedad = null;
		this.cubiculoPerteneciente = null;
		
		inicializarProcesoPaciente();
	}
	
	private void inicializarProcesoPaciente() {
		this.procesoPaciente = new Thread();
		this.procesoPaciente.start();
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
