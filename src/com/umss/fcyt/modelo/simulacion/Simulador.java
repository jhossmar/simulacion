package com.umss.fcyt.modelo.simulacion;

import com.umss.fcyt.modelo.Cubiculo;
import com.umss.fcyt.modelo.Paciente;
import com.umss.fcyt.modelo.SalaDeEspera;
import com.umss.fcyt.modelo.SalaEmergencias;
import com.umss.fcyt.modelo.TipoPaciente;

public class Simulador implements Runnable {
	private SalaEmergencias salaDeEmergencias;
	
	private Reloj reloj;
	
	private static final int VELOCIDAD_MAXIMA_SIMULACION = 100;
	private static final int VELOCIDAD_MINIMA_SIMULACION = 1000;
	
	private int velocidadActualDeSimulacion;
	
	private int tiempoTranscurrido;

	private Thread procesoSimulacion;
	
	public Simulador() {
		this.salaDeEmergencias = salaDeEmergencias;
		this.reloj = new Reloj();
		this.velocidadActualDeSimulacion = VELOCIDAD_MINIMA_SIMULACION;
		this.tiempoTranscurrido = 0;
	}
	
	public Simulador(SalaEmergencias salaEmergencias) {
		this.salaDeEmergencias = salaEmergencias;
	}
	
	public void iniciarSimulacion() {
		this.procesoSimulacion = new Thread(this);
		this.procesoSimulacion.start();
	}
	

	@Override
	public void run() {
		int contadorMinutos = 0;
		
		while(contadorMinutos < reloj.getCantidadMinutosDia()) {
			try {
				Thread.sleep(velocidadActualDeSimulacion);
				System.out.println("Sala de Emergencias Atendiendo");
				
				System.out.println("HORA : " + tiempoTranscurrido);
				
				this.tiempoTranscurrido++;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	public void pararSimulacion() {
		
	}
	
	public void pausarSimulacion() {
		
	}
	
	public void detenerSimulacion() {
		
	}
	
	public static void main(String[] args) {
		Cubiculo c = new Cubiculo(3, TipoPaciente.QUEMADURAS);
		Cubiculo c2 = new Cubiculo(3, TipoPaciente.QUEMADURAS);
		
		Paciente p = new Paciente("Beimar");
		Paciente p2 = new Paciente("juan");

		
		SalaEmergencias sala = new SalaEmergencias();
		sala.agregarCubiculo(c);
		sala.agregarCubiculo(c2);
		
		Simulador s = new Simulador();
		s.iniciarSimulacion();
	}
	
}
