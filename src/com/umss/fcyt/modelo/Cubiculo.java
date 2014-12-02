package com.umss.fcyt.modelo;

public class Cubiculo {

	
	//faltan implementar dos metodos importantes
	private int cantidadDisponiblesDeCamillas;
	private int cantidadMaximaDeCamillas;
	private TipoPaciente tipoDePacienteParaAtender;

	public Cubiculo(int cantidadDeCamillas, TipoPaciente tipoPaciente) {
		this.tipoDePacienteParaAtender = tipoPaciente;
		this.cantidadMaximaDeCamillas = cantidadDeCamillas;
		this.cantidadDisponiblesDeCamillas = cantidadMaximaDeCamillas;
	}

	public TipoPaciente getTipoDePacienteParaAtender() {
		return tipoDePacienteParaAtender;
	}

	public void setTipoDePacienteParaAtender(
			TipoPaciente tipoDePacienteParaAtender) {
		this.tipoDePacienteParaAtender = tipoDePacienteParaAtender;
	}

	public void agregarCamilla() {
		this.cantidadMaximaDeCamillas++;
		this.cantidadDisponiblesDeCamillas++;
	}

	public int getCantidadDisponiblesDeCamillas() {
		return cantidadDisponiblesDeCamillas;
	}

	public void setCantidadDisponiblesDeCamillas(
			int cantidadDisponiblesDeCamillas) {
		this.cantidadDisponiblesDeCamillas = cantidadDisponiblesDeCamillas;
	}

	public int getCantidadMaximaDeCamillas() {
		return cantidadMaximaDeCamillas;
	}

	public void setCantidadMaximaDeCamillas(int cantidadMaximaDeCamillas) {
		this.cantidadMaximaDeCamillas = cantidadMaximaDeCamillas;
	}

}
