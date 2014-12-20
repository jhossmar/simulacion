package com.umss.fcyt.modelo.simulacion;

import com.umss.fcyt.modelo.Paciente;

public class ProcesoAtencionAQuemados {
	static StringBuffer proceso = new StringBuffer();
	
	public static String atenderAPaciente(Paciente paciente) {
		desvestir(paciente.getNombre());
		irrigarLaZonaAfectada(paciente.getNombre());
		return proceso.toString();
	}
	
	public static void desvestir(String nombre) {
		proceso.append("El paciente : " + nombre + " tiene quemaduras \n");
		proceso.append("al paciente " + nombre + " se le quita la ropa y anillos \n");
		proceso.append("... se detiene el proceso de indujo de la quemadura \n");
	}
	
	public static void irrigarLaZonaAfectada(String nombre) {
		proceso.append("...se irriga la zona afectada con solucion de suero \n");
		proceso.append("el paciente :"+nombre+" es cubierto con sabanas limpias \n");
		proceso.append("el paciente :"+nombre+" se termina de atender pero debe esperar a reposar \n");

	}
}
