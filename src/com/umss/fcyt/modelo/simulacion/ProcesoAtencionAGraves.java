package com.umss.fcyt.modelo.simulacion;

import com.umss.fcyt.modelo.Paciente;

public class ProcesoAtencionAGraves{
	static StringBuffer proceso = new StringBuffer();
	
	public static String atenderAPaciente(Paciente paciente) {
		llevarACirugia(paciente.getNombre());
		estabilizarPaciente(paciente.getNombre());
		return proceso.toString();
	}
	
	public static void llevarACirugia(String nombre) {
		proceso.append("El paciente : " + nombre + " esta en estado grave \n");
		proceso.append("al paciente " + nombre + " se le lleva al quirofano \n");
	}
	
	public static void estabilizarPaciente(String nombre) {
		proceso.append("se estabiliza al paciente \n");
		proceso.append("el paciente :"+nombre+" debe esperar en el cubiculo \n");
	}
}
