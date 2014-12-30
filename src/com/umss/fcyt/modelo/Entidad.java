package com.umss.fcyt.modelo;

import java.util.ArrayList;

public class Entidad {
	
	String nombreEntidad;//que tipo de entidad es (doctor, enfermera, enfermeraLicen)
	String nombreImagen;
	ArrayList<String> procesos;
	
	public Entidad(String nombreEntidad, String nombreImagen, ArrayList<String> procesos) {
		this.nombreEntidad = nombreEntidad;
		this.nombreImagen = nombreImagen;
		this.procesos = procesos;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public ArrayList<String> getProcesos() {
		return procesos;
	}

	public void setProcesos(ArrayList<String> procesos) {
		this.procesos = procesos;
	}
}
