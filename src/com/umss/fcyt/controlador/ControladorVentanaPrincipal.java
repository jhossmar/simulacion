package com.umss.fcyt.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.umss.fcyt.modelo.Cubiculo;
import com.umss.fcyt.modelo.Paciente;
import com.umss.fcyt.modelo.SalaEmergencias;
import com.umss.fcyt.modelo.TipoPaciente;
import com.umss.fcyt.modelo.simulacion.Reloj;
import com.umss.fcyt.modelo.simulacion.SimuladorDos;
import com.umss.fcyt.vista.VentanaPrincipal;

public class ControladorVentanaPrincipal implements Runnable, ActionListener{

	VentanaPrincipal ventanaPrincipal;
	
	int tiempoDuracionSimulacion = 1440;
	
	private SimuladorDos simulador;

	private Reloj reloj;

	private static final int VELOCIDAD_MAXIMA_SIMULACION = 100;
	private static final int VELOCIDAD_MINIMA_SIMULACION = 1000;

	private int velocidadActualDeSimulacion;

	private Thread procesoSimulacion;
	
	private SalaEmergencias sala;

	public ControladorVentanaPrincipal(VentanaPrincipal ventana) {
		this.ventanaPrincipal = ventana;
	
		this.reloj = new Reloj();
		
		this.velocidadActualDeSimulacion = 1000;
		
		this.simulador = new SimuladorDos();
		
		this.sala = simulador.getSalaDeEmergencias();
		
		agregarAccionesBotones();
	}

	public void agregarAccionesBotones() {
		ventanaPrincipal.botonEjecutar.addActionListener(this);
		ventanaPrincipal.botonPausar.addActionListener(this);
		ventanaPrincipal.botonDetener.addActionListener(this);
		ventanaPrincipal.botonContinuar.addActionListener(this);
		
		ventanaPrincipal.itemEjecutar.addActionListener(this);
		ventanaPrincipal.itemPausar.addActionListener(this);
		ventanaPrincipal.itemDetener.addActionListener(this);
		ventanaPrincipal.itemContinuar.addActionListener(this);
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
				
				actualizarVista();
				
				//SwingUtilities.updateComponentTreeUI(ventanaPrincipal);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			contadorTiempo++;
		}
	}

	public void actualizarVista() {
		ventanaPrincipal.panelQuemados.removeAll();
		
		for(Paciente p : sala.getCubiculos().get(0).getPacientes()) {
			System.out.println("");
			ventanaPrincipal.agregarPaciente(ventanaPrincipal.panelQuemados);
		}
		
		System.out.println("jfksdjakfjalsjd :" + sala.getSalaEspera().size());
		for(Paciente a : sala.getSalaEspera()) {
			ventanaPrincipal.agregarPaciente(ventanaPrincipal.panelTriaje);
		}
	}

	public void pausarSimulacion() {
		this.procesoSimulacion.suspend();
	}

	public void detenerSimulacion() {
		this.procesoSimulacion.stop();
	}
	
	public void continuarSimulacion() {
		this.procesoSimulacion.resume();
	}
	
	public static void main(String[] args) {
		ControladorVentanaPrincipal c = new ControladorVentanaPrincipal(new VentanaPrincipal());
		c.iniciarSimulacion();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == ventanaPrincipal.botonEjecutar  || e.getSource() == ventanaPrincipal.itemEjecutar){
			this.iniciarSimulacion();
		}
		if(e.getSource() == ventanaPrincipal.botonPausar || e.getSource() == ventanaPrincipal.itemPausar){
			this.pausarSimulacion();
		}
		if(e.getSource() == ventanaPrincipal.botonDetener || e.getSource() == ventanaPrincipal.itemDetener){
			this.detenerSimulacion();
		}
		if(e.getSource() == ventanaPrincipal.botonContinuar || e.getSource() == ventanaPrincipal.itemContinuar){
			this.continuarSimulacion();
		}
		
	}
}
