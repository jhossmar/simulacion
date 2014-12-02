package com.umss.fcyt.modelo.simulacion;

public class Reloj {
	int cantidadMinutosDia;
	
	public Reloj() {
		this.cantidadMinutosDia = 1440;
	}

	public int getCantidadMinutosDia() {
		return cantidadMinutosDia;
	}

	public void setCantidadMinutosDia(int cantidadMinutosDia) {
		this.cantidadMinutosDia = cantidadMinutosDia;
	}
	
	public int horaAleatoria(int limite) {
		int resultado = (int)(Math.random()*limite);
		return resultado;
	}
	
}
