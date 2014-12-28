package com.umss.fcyt.simulaciongraficos;

import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Paciente2D implements ElementoAnimable, ElementoDibujable,
		Runnable {

	private int coordenaX = 50;
	private int coordenaY = 200;

	private int ancho = 50;
	private int largo = 50;

	private ImageIcon imagen;
	private PanelSimulacion panelJuego;

	private String nombreImagen = "imagenes/personaOficial.png";

	Monitor monitorPermisoEntrada;
	Monitor monitorHayPacienteTriaje;
	Monitor monitorPermisoACubiculo;
	Monitor monitorPermisoEntrarACubiculo;
	Monitor monitorPermisoSalirDeCubiculo;
	Monitor monitorPermisoAtenderAuxiliar;

	int velocidad = 100;// indica la velocidad de recorrido
	int avance = 10;// indica cuanto avanza el paciente por unidad de velocidad

	public Paciente2D(PanelSimulacion panelJuego) {
		this.panelJuego = panelJuego;// panel donde se dibujan las notas

		monitorPermisoEntrada = panelJuego.monitorPermisoEntrada;
		monitorHayPacienteTriaje = panelJuego.monitorHayPacienteTriaje;
		monitorPermisoACubiculo = panelJuego.monitorPermisoACubiculo;
		monitorPermisoEntrarACubiculo = panelJuego.monitorPermisoEntrarACubiculo;
		monitorPermisoSalirDeCubiculo = panelJuego.monitorPermisoSalirDeCubiculo;
		monitorPermisoAtenderAuxiliar = panelJuego.monitorPermisoAtenderAuxiliar;

		this.imagen = new ImageIcon(nombreImagen);

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
		monitorPermisoEntrada.obtenerPermiso("beimar");

		entraPaciente();
		monitorHayPacienteTriaje.cederPermiso("ya estoy adentro atende");

		monitorPermisoACubiculo.obtenerPermiso("estoy en marcha a cubiculo");

		entraCubiculo();
		monitorPermisoAtenderAuxiliar.cederPermiso("estoy aqui curame");
		monitorPermisoSalirDeCubiculo
				.obtenerPermiso("obteniendo permiso para salir del cubiculo de atencion");

		saleHospital();

	}

	public void entraPaciente() {
		// triaje
		while (coordenaX <= 190) {
			coordenaX = coordenaX + avance;
			try {
				Thread.sleep(velocidad);
				panelJuego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		cambiarImagen("imagenes/personaOficialAbajo.png");

		while ((coordenaX > 190) && (coordenaY <= 280)) {
			coordenaY = coordenaY + avance;
			try {
				Thread.sleep(velocidad);
				panelJuego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		cambiarImagen("imagenes/personaOficialArriba.png");
	}

	public void entraCubiculo() {
		// cubiculo
		while ((coordenaY >= 20)) {
			coordenaY = coordenaY - avance;
			try {
				Thread.sleep(velocidad);
				panelJuego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		cambiarImagen("imagenes/personaOficial.png");
		monitorPermisoEntrarACubiculo
				.obtenerPermiso("obteniendo permiso para entrar a cubiculo");

		while ((coordenaX <= 400)) {
			coordenaX = coordenaX + avance;
			try {
				Thread.sleep(velocidad);
				panelJuego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void saleHospital() {

		cambiarImagen("imagenes/personaOficialIzquierda.png");
		// salir
		while ((coordenaX >= 210)) {
			coordenaX = coordenaX - avance;
			try {
				Thread.sleep(velocidad);
				panelJuego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		cambiarImagen("imagenes/personaOficialAbajo.png");
		while ((coordenaY <= 190)) {
			coordenaY = coordenaY + avance;
			try {
				Thread.sleep(velocidad);
				panelJuego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		cambiarImagen("imagenes/personaOficial.png");
		while ((coordenaX <= 470)) {
			coordenaX = coordenaX + avance;
			try {
				Thread.sleep(velocidad);
				panelJuego.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void cambiarImagen(String nombreImagen) {
		ImageIcon nuevo = new ImageIcon(nombreImagen);
		setImage(nuevo, ancho, largo);
		panelJuego.repaint();
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

	public void iniciarMovimiento() {
		Thread hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		animar();
	}
}
