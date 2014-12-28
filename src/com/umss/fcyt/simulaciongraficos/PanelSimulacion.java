package com.umss.fcyt.simulaciongraficos;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelSimulacion extends JPanel implements ActionListener {

	ImageIcon imagenFondo;

	int contador = 0;
	
	Timer temporizador;

	int retraso;
	ArrayList<ElementoDibujable> pacientes;
	ArrayList<Doctor2D> doctores;
	ArrayList<EnfermeraAxiliar2D> enfermeras;
	ArrayList<EnfermeraLicenciada2D> enfermerasLicenciadas;
	ArrayList<Estaticos2D> objetos;
	
	public Monitor monitorPermisoEntrada = new Monitor(true);
	public Monitor monitorHayPacienteTriaje = new Monitor(false);
	public Monitor monitorPermisoACubiculo = new Monitor(false);
	public Monitor monitorPermisoEntrarACubiculo = new Monitor(true);
	public Monitor monitorPermisoSalirDeCubiculo = new Monitor(false);
	public Monitor monitorPermisoAtenderAuxiliar = new Monitor(false);
	public Monitor monitorPermisoAtenderDoctor = new Monitor(false);
	
	public PanelSimulacion() {

		Dimension a = this.getToolkit().getScreenSize();
		Dimension b = new Dimension(500, 350);
		this.setPreferredSize(b);

		this.pacientes = new ArrayList<ElementoDibujable>();
		this.doctores = new ArrayList<Doctor2D>();
		this.enfermeras = new ArrayList<EnfermeraAxiliar2D>();
		this.objetos = new ArrayList<Estaticos2D>();
		this.enfermerasLicenciadas = new ArrayList<EnfermeraLicenciada2D>();
		
		agregarDoctores();
		agregarEnfermeras();
		agregarObjetos();
		
		this.retraso = 1000;

		this.temporizador = new Timer(retraso, this);
		temporizador.start();
		setFocusable(true);

		imagenFondo = new ImageIcon("imagenes/Sala.png");
	}

	private void agregarObjetos() {
		Estaticos2D herramientas = new Estaticos2D(this, 308, 80, "imagenes/herramientas.gif");
		herramientas.setLargo(63);
		herramientas.setAncho(45);
		objetos.add(herramientas);
		
		Estaticos2D camilla = new Estaticos2D(this, 390, 20, "imagenes/camillaVacia.gif");
		camilla.setAncho(70);
		camilla.setLargo(50);
		objetos.add(camilla);
	}

	public void agregarDoctores() {
		Doctor2D doctor1 = new Doctor2D(this);
		doctores.add(doctor1);
		doctor1.iniciarMovimiento();
	}
	
	public void agregarEnfermeras() {
		EnfermeraLicenciada2D enfermera = new EnfermeraLicenciada2D(this, 285, 290, "imagenes/enfermeraTrans.png");
		enfermerasLicenciadas.add(enfermera);
		enfermera.iniciarMovimiento();
		
		EnfermeraAxiliar2D enfermera2 = new EnfermeraAxiliar2D(this,365,100, "imagenes/enfermeraCubi.png");
		enfermera2.setAncho(45);
		enfermera2.setLargo(45);
		enfermeras.add(enfermera2);
		enfermera2.iniciarMovimiento();
	}
	
	public void cambiarImagen(String nombreIm) {
		this.imagenFondo = new ImageIcon(nombreIm);
	}

	
	public void paint(final Graphics g) {
		super.paint(g);
		g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), null);
		this.repaint();																			
		
		for (ElementoDibujable paciente : pacientes) {
			paciente.dibujar(g);
		}
		
		for (Estaticos2D objeto : objetos) {
			objeto.dibujar(g);
		}
		
		for (EnfermeraAxiliar2D enfermera : enfermeras) {
			enfermera.dibujar(g);
		}
		
		for (EnfermeraLicenciada2D enfermeraLicen : enfermerasLicenciadas) {
			enfermeraLicen.dibujar(g);
		}
		
		for (Doctor2D doctor : doctores) {
			doctor.dibujar(g);
		}
		
	}

	public void pararMovimiento() {
		this.temporizador.stop();

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(contador < 2) {
			Paciente2D nuevoPaciente = new Paciente2D(this);
			this.pacientes.add(nuevoPaciente);
			
			nuevoPaciente.iniciarMovimiento();
			contador++;
		}
		
		
		
	}

}
