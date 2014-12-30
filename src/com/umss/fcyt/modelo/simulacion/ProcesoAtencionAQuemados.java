package com.umss.fcyt.modelo.simulacion;

import java.util.ArrayList;

import com.umss.fcyt.modelo.Paciente;

public class ProcesoAtencionAQuemados {
	static StringBuffer proceso = new StringBuffer();
	static ArrayList<String> procesos = new ArrayList<String>(); 
	
	public ProcesoAtencionAQuemados() {
		procesos.add(tenderCamilla);
		procesos.add(quitarRopa);
		procesos.add(aplicarCompresas);
		procesos.add(cubrirSabanas);
		procesos.add(aplicarAnalgesico);
		procesos.add(AdministrarVacuna);
		//procesos.add(darEstadoFinal);
	}
	
	static String tenderCamilla = "";
	
	static String quitarRopa = "";
	
	static String aplicarCompresas = "";
	
	static String cubrirSabanas = "";
	
	static String aplicarAnalgesico = "";
	
	static String AdministrarVacuna = "";
	
	static String darEstadoFinal = "";
	
}
