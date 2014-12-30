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

	public String toString() {
		String respuesta = "";
		respuesta = respuesta + nombreEntidad+ "    ";
		respuesta = respuesta + nombreImagen + "    ";
		for (String string : procesos) {
			respuesta = respuesta + string + "    ";
		}
		
		return respuesta;
	}
	
	public String getNombreEntidad() {
		return nombreEntidad;
	}

	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
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
