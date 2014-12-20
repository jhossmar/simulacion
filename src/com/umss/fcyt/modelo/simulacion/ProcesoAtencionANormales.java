package com.umss.fcyt.modelo.simulacion;

import com.umss.fcyt.modelo.Paciente;

public class ProcesoAtencionANormales {
	static StringBuffer proceso = new StringBuffer();
	
	public static String atenderAPaciente(Paciente paciente) {
		llevadoAcubiculo(paciente.getNombre());
		darAlta(paciente.getNombre());
		return proceso.toString();
	}
	
	public static void llevadoAcubiculo(String nombre) {
		proceso.append("El paciente : " + nombre + " es un paciente no grave \n");
		proceso.append("al paciente " + nombre + " se le toma la temperatura, medida y peso \n");
	}
	
	public static void darAlta(String nombre) {
		proceso.append("el medico le da la receta y tratamiento respectivo \n");
		proceso.append("el paciente :"+nombre+" es dado de alta \n");
	}
}
