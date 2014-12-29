package com.umss.fcyt.simulaciongraficos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelSimulacion extends JPanel implements ActionListener {

	ImageIcon imagenFondo;

	int contador = 0;
	
	Timer temporizador;

	int retraso;
	ArrayList<Paciente2D> pacientes;
//	ArrayList<Doctor2D> doctores;
//	ArrayList<EnfermeraAxiliar2D> enfermeras;
//	ArrayList<EnfermeraLicenciada2D> enfermerasLicenciadas;
	ArrayList<Estaticos2D> objetos;
	
	public Monitor monitorPermisoEntrada = new Monitor(true);
	public Monitor monitorHayPacienteTriaje = new Monitor(false);
	public Monitor monitorPermisoACubiculo = new Monitor(false);
	public Monitor monitorPermisoEntrarACubiculo = new Monitor(true);
	public Monitor monitorPermisoSalirDeCubiculo = new Monitor(false);
	public Monitor monitorPermisoAtenderAuxiliar = new Monitor(false);
	public Monitor monitorPermisoAtenderDoctor = new Monitor(false);

	boolean simulacionIniciada = false;
	
	public Estaticos2D camilla;

	public Thread graficador;
	
	public StringBuffer licenciadaDescripcion = new StringBuffer();
	public StringBuffer auxiliarDescripcion = new StringBuffer();
	public StringBuffer medicoDescripcion = new StringBuffer();

	//Doctor2D representa como un proceso y lo mismo en las enfermeras
	private Doctor2D doctor;

	private EnfermeraLicenciada2D enfermeraTriaje;

	private EnfermeraAxiliar2D enfermeraCubiculo;
	
	public PanelSimulacion() {

		Dimension a = this.getToolkit().getScreenSize();
		Dimension b = new Dimension(500, 350);
		this.setPreferredSize(b);

		this.pacientes = new ArrayList<Paciente2D>();
//		this.doctores = new ArrayList<Doctor2D>();
//		this.enfermeras = new ArrayList<EnfermeraAxiliar2D>();
		this.objetos = new ArrayList<Estaticos2D>();
		//this.enfermerasLicenciadas = new ArrayList<EnfermeraLicenciada2D>();
		
		agregarDoctores();
		agregarEnfermeras();
		agregarObjetos();
		
		this.retraso = 5000;

		this.temporizador = new Timer(retraso, this);

		setFocusable(true);

		imagenFondo = new ImageIcon("imagenes/Sala.png");
		
		setVisible(true);
		
		graficador = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(100);
						repaint();
					} catch (InterruptedException e) {
						System.out.println("me estan interrumpiendo");
						e.printStackTrace();
					}
				}
				
				
			}
		});
	}
	
	
	
	public void cambiarCamillaVacia(String nombreImagen) {
		camilla.cambiarImagen(nombreImagen);
	}
	
	private void agregarObjetos() {
		Estaticos2D herramientas = new Estaticos2D(this, 308, 80, "imagenes/herramientas.gif");
		herramientas.setLargo(63);
		herramientas.setAncho(45);
		objetos.add(herramientas);
		
		camilla = new Estaticos2D(this, 390, 20, "imagenes/camillaVacia.gif");
		camilla.setAncho(70);
		camilla.setLargo(50);
		objetos.add(camilla);
	}

	public void agregarDoctores() {
		doctor = new Doctor2D(this);
		//doctores.add(doctor);
		doctor.iniciarMovimiento();
	}
	
	public void agregarEnfermeras() {
		enfermeraTriaje = new EnfermeraLicenciada2D(this, 285, 290, "imagenes/enfermeraLicenciadaTriaje.gif");
		//enfermerasLicenciadas.add(enfermeraCubiculo);
		enfermeraTriaje.iniciarMovimiento();
		
		enfermeraCubiculo = new EnfermeraAxiliar2D(this,365,100, "imagenes/enfermeraCubiculo.png");
		enfermeraCubiculo.setAncho(45);
		enfermeraCubiculo.setLargo(45);
		//enfermeras.add(enfermeraTriaje);
		enfermeraCubiculo.iniciarMovimiento();
	}
	
	public void cambiarImagen(String nombreIm) {
		this.imagenFondo = new ImageIcon(nombreIm);
	}

	
	public void paint(Graphics g) {
		//se sigue pintando luego se arregla
		//super.paint(g);
		g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), null);																		
		
		for (ElementoDibujable paciente : pacientes) {
			
			paciente.dibujar(g);
		}
		
		for (Estaticos2D objeto : objetos) {
			objeto.dibujar(g);
		}
		
		//for (EnfermeraAxiliar2D enfermera : enfermeras) {
			enfermeraCubiculo.dibujar(g);
		//}
		
		//for (EnfermeraLicenciada2D enfermeraLicen : enfermerasLicenciadas) {
			enfermeraTriaje.dibujar(g);
		//}
		
		//for (Doctor2D doctor : doctores) {
			doctor.dibujar(g);
		//}
	}

	public void iniciarSimulacionGrafica() {
		if(!simulacionIniciada) {
			//this.temporizador.start();
			this.graficador.start();
			simulacionIniciada = true;
		}
		
	}
	
	public void pararMovimiento() {
		this.temporizador.stop();
		for (Paciente2D paciente : pacientes) {
			paciente.hilo.stop();
			
		}
		
		//for (EnfermeraAxiliar2D enfermera : enfermeras) {
			enfermeraCubiculo.hilo.stop();
		//}
		
		//for (EnfermeraLicenciada2D enfermeraLicen : enfermerasLicenciadas) {
			enfermeraTriaje.hilo.stop();
		//}
		
		//for (Doctor2D doctor : doctores) {
			doctor.hilo.stop();
		//}
	}
	
	public void pausarSimulacionGrafica() {
		this.temporizador.stop();
		for (Paciente2D paciente : pacientes) {
			paciente.hilo.suspend();
			
		}
		
		//for (EnfermeraAxiliar2D enfermera : enfermeras) {
			enfermeraCubiculo.hilo.suspend();;
		//}
		
		//for (EnfermeraLicenciada2D enfermeraLicen : enfermerasLicenciadas) {
			enfermeraTriaje.hilo.suspend();
		//}
		
		//for (Doctor2D doctor : doctores) {
			doctor.hilo.suspend();
		//}
	}
	
	public void continuarSimulacionGrafica() {
		this.temporizador.stop();
		for (Paciente2D paciente : pacientes) {
			paciente.hilo.resume();
			
		}
		
		//for (EnfermeraAxiliar2D enfermera : enfermeras) {
			enfermeraCubiculo.hilo.resume();
		//}
		
		//for (EnfermeraLicenciada2D enfermeraLicen : enfermerasLicenciadas) {
			enfermeraTriaje.hilo.resume();
		//}
		
		//for (Doctor2D doctor : doctores) {
			doctor.hilo.resume();
		//}
	}
	
	public void agregarPaciente() {
		Paciente2D nuevoPaciente = new Paciente2D(this);
		this.pacientes.add(nuevoPaciente);
		
		nuevoPaciente.iniciarMovimiento();
	}
	
	//puede ser un metodo que agrega unicamente pacientes segun el tiempo (ES MUCHO MAS REAL)
	@Override
	public void actionPerformed(ActionEvent arg0) {
//		if(contador < 3) {
//			Paciente2D nuevoPaciente = new Paciente2D(this);
//			this.pacientes.add(nuevoPaciente);
//			
//			nuevoPaciente.iniciarMovimiento();
//			contador++;
//		} 
	}

}
