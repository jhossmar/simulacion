package com.umss.fcyt.modelo.simulacion;

import com.umss.fcyt.modelo.Paciente;

public class ProcesoAtencionAInfecciosos {
static StringBuffer proceso = new StringBuffer();
	
	public static String atenderAPaciente(Paciente paciente) {
		comprobarPacienteInfectado(paciente.getNombre());
		verificarGravedadDeInfeccion(paciente.getNombre());
		designarACubiculoDeInfectados(paciente.getNombre());
		atenderConTratamiento(paciente.getNombre());
		
		return proceso.toString();
	}
	
	public static void comprobarPacienteInfectado(String nombre) {
		proceso.append("El paciente : " + nombre + " tiene una enfermedad contagiosa \n");
	}
	
	public static void verificarGravedadDeInfeccion(String nombre) {
		
	}
	
	public static void designarACubiculoDeInfectados(String nombre) {
		proceso.append(nombre + " es llevado al cubiculo de infecciosos \n");
	}
	
	public static void atenderConTratamiento(String nombre) {
		proceso.append(nombre + " recive el tratamiento por el medico de turno \n");
	}
}
