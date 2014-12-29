package com.umss.fcyt.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.umss.fcyt.modelo.Cubiculo;
import com.umss.fcyt.modelo.Paciente;
import com.umss.fcyt.modelo.SalaEmergencias;
import com.umss.fcyt.modelo.TipoPaciente;
import com.umss.fcyt.modelo.simulacion.Reloj;
import com.umss.fcyt.modelo.simulacion.SimuladorDos;
import com.umss.fcyt.vista.VentanaPrincipal;
import com.umss.fcyt.vista.VentanaPrincipalReportes;

public class ControladorVentanaPrincipal implements Runnable, ActionListener {

	VentanaPrincipal ventanaPrincipal;

	int tiempoDuracionSimulacion = 1440;

	private SimuladorDos simulador;

	private Reloj reloj;

	private static final int VELOCIDAD_MAXIMA_SIMULACION = 100;
	private static final int VELOCIDAD_MINIMA_SIMULACION = 5000;

	private int velocidadActualDeSimulacion;

	private Thread procesoSimulacion;

	private SalaEmergencias sala;

	public Thread graficadorDescripciones;

	public ControladorVentanaPrincipal(VentanaPrincipal ventana) {
		this.ventanaPrincipal = ventana;
		
		this.velocidadActualDeSimulacion = VELOCIDAD_MINIMA_SIMULACION;

		this.simulador = new SimuladorDos();

		this.sala = simulador.getSalaDeEmergencias();
		
		this.reloj = simulador.getReloj();

		graficadorDescripciones = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
						String texto = ventanaPrincipal.panelSimulacion.licenciadaDescripcion.toString();
						ventanaPrincipal.txtAreaEnfermeraLicenciada.setText(texto);
						
						String texto2 = ventanaPrincipal.panelSimulacion.auxiliarDescripcion.toString();
						ventanaPrincipal.textAreaEnfermeraAuxiliar.setText(texto2);
						
						String texto3 = ventanaPrincipal.panelSimulacion.medicoDescripcion.toString();
						ventanaPrincipal.textAreaMedicoTurno.setText(texto3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
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
		ventanaPrincipal.btnGenerarrepote.addActionListener(this);

		ventanaPrincipal.sliderVelocidad
				.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						JSlider source = (JSlider) e.getSource();
						if (!source.getValueIsAdjusting()) {

							int fps = (int) source.getValue();

							calcularNuevaVelocidad(fps);
						}
					}
				});
	}

	public void calcularNuevaVelocidad(int valor) {
		switch (valor) {
		case 1:
			velocidadActualDeSimulacion = 1000;
			break;
		case 2:
			velocidadActualDeSimulacion = 800;
			break;
		case 3:
			velocidadActualDeSimulacion = 600;
			break;
		case 4:
			velocidadActualDeSimulacion = 400;
			break;
		case 5:
			velocidadActualDeSimulacion = 200;
			break;
		case 6:
			velocidadActualDeSimulacion = 100;
			break;
		case 7:
			velocidadActualDeSimulacion = 50;
			break;
		case 8:
			velocidadActualDeSimulacion = 25;
			break;
		case 9:
			velocidadActualDeSimulacion = 10;
			break;
		case 10:
			velocidadActualDeSimulacion = 5;
			break;

		default:
			break;
		}
	}

	// este constructor puede servir para guardar y abrir archivos
	// public ControladorVentanaPrincipal(SalaEmergencias salaEmergencias) {
	// this.salaDeEmergencias = salaEmergencias;
	// this.reloj = new Reloj();
	// this.velocidadActualDeSimulacion = VELOCIDAD_MINIMA_SIMULACION;
	// this.tiempoTranscurrido = 0;
	// }

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
		
		while (contadorTiempo <= tiempoDuracionSimulacion) {

			try {
				Thread.sleep(velocidadActualDeSimulacion);

				this.sala.agregarPaciente(new Paciente("Beimar Huarachi"));
				ventanaPrincipal.panelSimulacion.agregarPaciente();

				contadorTiempo++;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
		}
	}

	public void actualizarVista() {
		
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ventanaPrincipal.botonEjecutar
				|| e.getSource() == ventanaPrincipal.itemEjecutar) {
			this.iniciarSimulacion();
			graficadorDescripciones.start();
			ventanaPrincipal.panelSimulacion.iniciarSimulacionGrafica();
		}
		if (e.getSource() == ventanaPrincipal.botonPausar
				|| e.getSource() == ventanaPrincipal.itemPausar) {
			this.pausarSimulacion();
			graficadorDescripciones.suspend();
			ventanaPrincipal.panelSimulacion.pausarSimulacionGrafica();
		}
		if (e.getSource() == ventanaPrincipal.botonDetener
				|| e.getSource() == ventanaPrincipal.itemDetener) {
			this.detenerSimulacion();
			graficadorDescripciones.stop();
			ventanaPrincipal.panelSimulacion.pararMovimiento();
		}
		if (e.getSource() == ventanaPrincipal.botonContinuar
				|| e.getSource() == ventanaPrincipal.itemContinuar) {
			this.continuarSimulacion();
			graficadorDescripciones.resume();
			ventanaPrincipal.panelSimulacion.continuarSimulacionGrafica();
		}

		if(e.getSource() == ventanaPrincipal.btnGenerarrepote) {
			VentanaPrincipalReportes ventana = new VentanaPrincipalReportes(sala);
			ventana.setVisible(true);
		}
	}
}
