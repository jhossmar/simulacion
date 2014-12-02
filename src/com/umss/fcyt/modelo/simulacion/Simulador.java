package com.umss.fcyt.modelo.simulacion;

import com.umss.fcyt.modelo.SalaDeEspera;
import com.umss.fcyt.modelo.SalaEmergencias;

public class Simulador implements Runnable {
	private SalaEmergencias salaDeEmergencias;
	
	private Reloj reloj;
	
	private int velocidadMaximaDeSimulacion;
	private int velocidadMinimaDeSimulacion;
	
	private int velocidadActualDeSimulacion;

	private Thread procesoSimulacion;
	
	public Simulador() {
		this.salaDeEmergencias = salaDeEmergencias;
	}
	
	public Simulador(SalaEmergencias salaEmergencias) {
		this.salaDeEmergencias = salaEmergencias;
	}
	
	public void iniciarSimulacion() {
		this.procesoSimulacion = new Thread(this);
		this.procesoSimulacion.start();
	}
	
	public void pararSimulacion() {
		
	}
	
	public void pausarSimulacion() {
		
	}
	
	public void detenerSimulacion() {
		
	}
	
	@Override
	public void run() {
		
	}
	
	
}
