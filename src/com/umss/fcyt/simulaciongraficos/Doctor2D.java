package com.umss.fcyt.simulaciongraficos;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.ImageIcon;

import com.umss.fcyt.modelo.Entidad;

public class Doctor2D implements ElementoAnimable, ElementoDibujable, Runnable {
	private int coordenaX = 410;
	private int coordenaY = 100;

	private int ancho = 45;
	private int largo = 45;

	int velocidad = 100;
	int avance = 5;
	int tiempoAtencion = 3000;

	private ImageIcon imagen;
	private PanelSimulacion panelJuego;

	private String nombreImagen = "imagenes/doctorCubiculo.png";

	Monitor monitorPermisoAtenderDoctor;
	Monitor monitorPermisoSalirDeCubiculo;
	Monitor monitorPermisoEntrarACubiculo;
	public Thread hilo;
	
	StringBuffer textoDescripcion;
	
	Entidad entidad;
	

	public Doctor2D(PanelSimulacion panelJuego) {
		this.panelJuego = panelJuego;// panel donde se dibujan las notas
		this.entidad = panelJuego.entidadCubiculoDos;
		
		this.imagen = new ImageIcon(entidad.getNombreImagen());
		System.out.println("beimar esta probando"+entidad.getNombreImagen());

		monitorPermisoAtenderDoctor = panelJuego.monitorPermisoAtenderDoctor;
		monitorPermisoSalirDeCubiculo = panelJuego.monitorPermisoSalirDeCubiculo;
		monitorPermisoEntrarACubiculo = panelJuego.monitorPermisoEntrarACubiculo;
		
		//this.textoDescripcion = panelJuego.medicoDescripcion;
		
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

			monitorPermisoAtenderDoctor
					.obtenerPermiso("estoy parado ");

			atenderPaciente();

			monitorPermisoSalirDeCubiculo
					.cederPermiso("ya te cure salite paciente");
			monitorPermisoEntrarACubiculo.cederPermiso("entra!! ya termine");

			regresar();
		}
	}

	public void atenderPaciente() {
		// 410 60
		while (coordenaY >= 60) {
			try {
				Thread.sleep(velocidad);
				coordenaY = coordenaY - avance;// darle nombre a 2
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		// atiende al paciente con el tiempo de atencion
		atenderPaciente(tiempoAtencion);

	}

	public void atenderPaciente(int tiempo) {
		for (String  string : entidad.getProcesos()) {
			try {
				//cuidado
				textoDescripcion
				.append(entidad.getNombreEntidad()+": " + string  + "\n");
				Thread.sleep(tiempoAtencion / entidad.getProcesos().size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		try {
//			Thread.sleep(tiempo);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	public void regresar() {
		panelJuego.cambiarCamillaVacia("imagenes/camillaVacia.gif");
		while (coordenaY <= 100) {
			try {
				Thread.sleep(velocidad);
				coordenaY = coordenaY + avance;// darle nombre a 2
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

	public void iniciarMovimiento() {
		hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		animar();
	}
}
