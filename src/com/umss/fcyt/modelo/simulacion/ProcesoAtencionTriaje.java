package com.umss.fcyt.modelo.simulacion;

import java.util.ArrayList;

import com.umss.fcyt.modelo.Paciente;

public class ProcesoAtencionTriaje {
	ArrayList<String> procesos = new ArrayList<String>(); 
	
	public ProcesoAtencionTriaje() {
		procesos.add(realizarEvaluacion);
		procesos.add(designarACubiculo);
	}
	
	public ArrayList<String> getProcesos() {
		return procesos;
	}

	String realizarEvaluacion = "";
	
	String designarACubiculo = "";
	
	
}
