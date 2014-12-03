package com.umss.fcyt.modelo;

public class Paciente implements Runnable {
	private TipoPaciente tipo;
	private GravedadPaciente gravedad;
	private String nombre;
	private Cubiculo cubiculoPerteneciente;
	
	private int tiempoDeAtencion;
	
	Thread procesoPaciente;
	
	public Paciente(String nombre) {
		this.nombre = nombre;
		this.tipo = null;
		this.gravedad = null;
		this.cubiculoPerteneciente = null;
		
		this.tiempoDeAtencion = (horaAleatoria(30)  + 10) * 1000;
	}
	
	public void inicializarProcesoPaciente() {
		this.procesoPaciente = new Thread(this);
		this.procesoPaciente.start();
	}
	
	public int horaAleatoria(int limite) {
		int resultado = (int) (Math.random() * limite);
		return resultado;
	}
	
	@Override
	public void run() {
		
		cubiculoPerteneciente.atenderPaciente();//se ocupa la camilla
		
		try {
			Thread.sleep(tiempoDeAtencion);//paciete es atendido
			
			cubiculoPerteneciente.liberarSalaEmergencias();
			System.out.println("termino de ser Atendido");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
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
