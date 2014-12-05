package com.umss.fcyt.controlador;

import javax.swing.SwingUtilities;

import com.umss.fcyt.modelo.Cubiculo;
import com.umss.fcyt.modelo.Paciente;
import com.umss.fcyt.modelo.SalaEmergencias;
import com.umss.fcyt.modelo.TipoPaciente;
import com.umss.fcyt.modelo.simulacion.Reloj;
import com.umss.fcyt.modelo.simulacion.SimuladorDos;
import com.umss.fcyt.vista.VentanaPrincipal;

public class ControladorVentanaPrincipal implements Runnable{

	VentanaPrincipal ventanaPrincipal;
	
	int tiempoDuracionSimulacion = 1440;
	
	private SimuladorDos simulador;

	private Reloj reloj;

	private static final int VELOCIDAD_MAXIMA_SIMULACION = 100;
	private static final int VELOCIDAD_MINIMA_SIMULACION = 1000;

	private int velocidadActualDeSimulacion;

	private Thread procesoSimulacion;

	public ControladorVentanaPrincipal(VentanaPrincipal ventana) {
		this.ventanaPrincipal = ventana;
	
		this.reloj = new Reloj();
		
		this.velocidadActualDeSimulacion = 3;
		
		this.simulador = new SimuladorDos();
	}

	//este constructor puede servir para guardar y abrir archivos
//	public ControladorVentanaPrincipal(SalaEmergencias salaEmergencias) {
//		this.salaDeEmergencias = salaEmergencias;
//		this.reloj = new Reloj();
//		this.velocidadActualDeSimulacion = VELOCIDAD_MINIMA_SIMULACION;
//		this.tiempoTranscurrido = 0;
//	}

	public void iniciarSimulacion() {
		this.procesoSimulacion = new Thread(this);
		this.procesoSimulacion.start();
	}

	/**
	 * TODO para cambiar la velocidad de simulacion
	 * 
	 * @param minutos
	 */
	public void cambiarVelocidadDeSimulacion(int minutos) {

	}

	@Override
	public void run() {
		int contadorTiempo = 0;
		
		while(contadorTiempo <= tiempoDuracionSimulacion) {
			
			try {
				Thread.sleep(velocidadActualDeSimulacion);
				
				simulador.pasoSimulacion();
				
				
				SwingUtilities.updateComponentTreeUI(ventanaPrincipal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			contadorTiempo++;
		}
	}

	public void pararSimulacion() {

	}

	public void pausarSimulacion() {

	}

	public void detenerSimulacion() {

	}
	
	public static void main(String[] args) {
		ControladorVentanaPrincipal c = new ControladorVentanaPrincipal(new VentanaPrincipal());
		c.iniciarSimulacion();
	}
}
