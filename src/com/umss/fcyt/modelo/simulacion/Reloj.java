package com.umss.fcyt.modelo.simulacion;

public class Reloj {
	int cantidadMinutosDia;
	
	int hora;
	int minuto;
	
	public Reloj() {
		this.cantidadMinutosDia = 1440;
		int segundos = transformarMinutosASegundos(cantidadMinutosDia);
		convertirSegundos(segundos);
	}

	public void actualizar(int minutos) {
		
		int segundos = transformarMinutosASegundos(minutos);
		convertirSegundos(segundos);
	}
	
	public String toString() {
		String texto = "";
		if(this.minuto == 0) {
			texto = this.hora + " : 00";
		} else if(this.hora < 10 && this.minuto < 10) {
			texto = "0" + this.hora + " : " +"0"+ this.minuto;
		} else if(this.hora == 0 && this.minuto == 0) {
			texto = "00 : 00";
		} else if(this.minuto < 10) {
			texto = this.hora + " : " + "0" +this.minuto;
		} else if(this.hora == 0) {
			texto = "00 : " + this.minuto;
		} else if(this.hora < 10) {
			texto = "0" + this.hora + " : " + this.minuto;
		} else {
			texto = this.hora + " : " +this.minuto;
		}
		
		return texto;
	}
	
	public int transformarMinutosASegundos(int minutos) {
		return minutos * 60;
	}
	
	public int getCantidadMinutosDia() {
		return cantidadMinutosDia;
	}

	public void convertirSegundos(int segundos) {
		int horas = segundos / 3600;
		int segundosRestantes = segundos % 3600; 
		int minutos = segundosRestantes / 60;
		
		this.hora = horas;
		this.minuto = minutos;
	}
	
	public void setCantidadMinutosDia(int cantidadMinutosDia) {
		this.cantidadMinutosDia = cantidadMinutosDia;
	}
	
//	public int horaAleatoria(int limite) {
//		int resultado = (int)(Math.random()*limite);
//		return resultado;
//	}
	
}
