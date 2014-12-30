package com.umss.fcyt.simulaciongraficos;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.umss.fcyt.modelo.Entidad;

public class EnfermeraLicenciada2D implements ElementoAnimable,
		ElementoDibujable, Runnable {
	private int coordenaX;
	private int coordenaY;

	private int ancho = 35;
	private int largo = 35;

	int velocidad = 100;
	int avance = 5;
	int tiempoAtencion = 3000;

	private ImageIcon imagen;
	private PanelSimulacion panelJuego;

	private String nombreImagen;

	Monitor monitorPermisoEntrada;
	Monitor monitorHayPacienteTriaje;
	Monitor monitorPermisoACubiculo;
	
	public Thread hilo;

	StringBuffer textoDescripcion;
	
	Entidad entidad;
	
	public EnfermeraLicenciada2D(PanelSimulacion panelSimulacion,
			int coordenaX, int coordenaY, String nombreImagen) {

		this.coordenaX = coordenaX;
		this.coordenaY = coordenaY;
		this.panelJuego = panelSimulacion;// panel donde se dibujan las notas
		this.entidad = panelSimulacion.entidadTriajenew;
		
		monitorPermisoEntrada = panelSimulacion.monitorPermisoEntrada;
		monitorHayPacienteTriaje = panelSimulacion.monitorHayPacienteTriaje;
		monitorPermisoACubiculo = panelSimulacion.monitorPermisoACubiculo;

		this.nombreImagen = nombreImagen;
		
		//this.textoDescripcion = panelSimulacion.licenciadaDescripcion;

		this.imagen = new ImageIcon(this.nombreImagen);
		
		if((entidad.getNombreEntidad()).equalsIgnoreCase("Medico de Turno")) {
			this.textoDescripcion = panelJuego.medicoDescripcion;
		} else if((entidad.getNombreEntidad()).equalsIgnoreCase("Enfermera Auxiliar")) {
			this.textoDescripcion = panelJuego.auxiliarDescripcion;
		} else if((entidad.getNombreEntidad()).equalsIgnoreCase("Enfermera Licenciada")) {
			this.textoDescripcion = panelJuego.licenciadaDescripcion;
		}
	}

	/*
	 * metodo que hace que la nota se dibuje
	 */
	@Override
	public void dibujar(Graphics g) {
		// aumentar algo para control
		g.drawImage(imagen.getImage(), this.coordenaX, this.coordenaY, ancho,
				largo, null);
	}

	/*
	 * metodo que hace que la nota cambie su coordena en y
	 */
	@Override
	public void animar() {
		while (true) {

			monitorHayPacienteTriaje.obtenerPermiso("estoy parada");
			textoDescripcion.append(entidad.getNombreEntidad() + 
					": preparando para la evaluacion del paciente\n");
			realizarEvaluacion();
			monitorPermisoACubiculo.cederPermiso("puedes ir a cubiculo");
			monitorPermisoEntrada.cederPermiso("hay espacio entra chango");

			regresar();

		}
	}

	public void regresar() {
		while (coordenaX <= 285) {
			try {
				Thread.sleep(velocidad);
				coordenaX = coordenaX + avance;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void realizarEvaluacion() {
		while (coordenaX >= 245) {
			try {
				Thread.sleep(velocidad);
				coordenaX = coordenaX - avance;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		textoDescripcion.append(entidad.getNombreEntidad() +
				": realizando la evaluacion del paciente\n");
		atenderPaciente(tiempoAtencion);
		textoDescripcion.append(entidad.getNombreEntidad() +
				": designando al paciente al cubiculo de quemados\n");
	}

	public void atenderPaciente(int tiempo) {
		try {
			Thread.sleep(tiempo);
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
		hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		animar();
	}
}
