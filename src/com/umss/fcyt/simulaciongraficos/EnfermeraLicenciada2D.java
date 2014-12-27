package com.umss.fcyt.simulaciongraficos;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class EnfermeraLicenciada2D implements ElementoAnimable, ElementoDibujable, Runnable{
	private int coordenaX;
	private int coordenaY;

	private int ancho = 35;
	private int largo = 35;
	
	int velocidad = 100;
	int avance = 5;
	int tiempoAtencion = 2000;

	private ImageIcon imagen;
	private PanelSimulacion panelJuego;

	private String nombreImagen;

	ArrayList<String> hayPaciente;
	ArrayList<String> seAtiende;
	
	public EnfermeraLicenciada2D(PanelSimulacion panelSimulacion, int coordenaX, int coordenaY, String nombreImagen) {
		
		this.coordenaX = coordenaX;
		this.coordenaY = coordenaY;
		this.panelJuego = panelSimulacion;// panel donde se dibujan las notas

		this.hayPaciente = panelSimulacion.hayPacienteTriaje;
		this.seAtiende = panelSimulacion.seAtendioTriaje;
		
		this.nombreImagen = nombreImagen;
		
		this.imagen = new ImageIcon(this.nombreImagen);
	}

	/*
	 * metodo que hace que la nota se dibuje
	 */
	@Override
	public void dibujar(Graphics g) {
		// aumentar algo para control
		g.drawImage(imagen.getImage(), this.coordenaX, this.coordenaY, ancho,
				largo, null);

		panelJuego.repaint();
	}

	/*
	 * metodo que hace que la nota cambie su coordena en y
	 */
	@Override
	public void animar() {
		while(true) {
			
			synchronized (hayPaciente) {
				if(hayPaciente.size() == 0) {
					try {
						System.out.println("no hay pacientes en el triaje");
						hayPaciente.wait();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				hayPaciente.remove(0);
				realizarEvaluacion();
			}
			
			synchronized (seAtiende) {
				seAtiende.add("nuevo");
				seAtiende.notify();
			}
			
			regresar();
		}
	}

	public void regresar() {
		while(coordenaX <= 285) {
			try {
				Thread.sleep(velocidad);
				coordenaX = coordenaX + avance;
				panelJuego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void realizarEvaluacion() {
		while(coordenaX >= 245) {
			try {
				Thread.sleep(velocidad);
				coordenaX = coordenaX - avance;
				panelJuego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		atenderPaciente(tiempoAtencion);
		
	}
	
	public void atenderPaciente(int tiempo) {
		try {
			Thread.sleep(tiempo);
			panelJuego.repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getCoordenaX() {
		return coordenaX;
	}

	// CAmbia la imagen
	public void setImage(ImageIcon imagen, int ancho, int largo) {
		this.imagen = imagen;
		// this.ancho = ancho;
		// this.largo = largo;
	}

	public void setCoordenaX(int coordenaX) {
		this.coordenaX = coordenaX;
	}

	public int getCoordenaY() {
		return coordenaY;
	}

	public void setCoordenaY(int coordenaY) {
		this.coordenaY = coordenaY;
	}
	
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public void iniciarMovimiento() {
		Thread hilo = new Thread(this);
		hilo.start();
	}
	
	@Override
	public void run() {
		animar();
	}
}
