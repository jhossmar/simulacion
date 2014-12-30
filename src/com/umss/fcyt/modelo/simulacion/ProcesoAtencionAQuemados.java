package com.umss.fcyt.modelo.simulacion;

import java.util.ArrayList;

import com.umss.fcyt.modelo.Paciente;

public class ProcesoAtencionAQuemados {
	ArrayList<String> procesos = new ArrayList<String>(); 
	
	public ProcesoAtencionAQuemados() {
		procesos.add(tenderCamilla);
		procesos.add(quitarRopa);
		procesos.add(aplicarCompresas);
		procesos.add(cubrirSabanas);
		procesos.add(aplicarAnalgesico);
		procesos.add(AdministrarVacuna);
		//procesos.add(darEstadoFinal);
	}
	
	 public ArrayList<String> getProcesos() {
		return procesos;
	}

	public void setProcesos(ArrayList<String> procesos) {
		this.procesos = procesos;
	}

	String tenderCamilla = "Tendiendo al paciente en la camilla";
	
	 String quitarRopa = "Quitando ropas de vestir y objetos metalicos";
	
	 String aplicarCompresas = "Aplicando compresas Frias para aliviar el dolor del paciente";
	
	 String cubrirSabanas = "Cubriendo con sabanas limpias y mantas para mantener la temperatura del paciente";
	
	 String aplicarAnalgesico = "Dando de ingerir Analgesicos opiaceos(Cloruro Morfico: 10 mgrs)";
	
	 String AdministrarVacuna = "Administrando vacuna con ganmaglubulina";
	
	 String darEstadoFinal = "hla";
	
}
