package com.umss.fcyt.simulaciongraficos;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Estaticos2D implements ElementoDibujable{
	private int coordenaX;
	private int coordenaY;

	private int ancho = 35;
	private int largo = 35;

	private ImageIcon imagen;
	private PanelSimulacion panelJuego;

	private String nombreImagen;

	public Estaticos2D(PanelSimulacion panelJuego, int coordenaX, int coordenaY, String nombreImagen) {
		
		this.coordenaX = coordenaX;
		this.coordenaY = coordenaY;
		this.panelJuego = panelJuego;// panel donde se dibujan las notas

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

		//panelJuego.repaint();
	}

	public int getCoordenaX() {
		return coordenaX;
	}

	public void cambiarImagen(String nombreImagen) {
		ImageIcon nuevo = new ImageIcon(nombreImagen);
		setImage(nuevo, ancho, largo);
		//panelJuego.repaint();
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
}
