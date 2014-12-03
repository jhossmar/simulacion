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

	//consumir productos
	public synchronized void atenderPaciente() {
		if(cantidadDisponiblesDeCamillas == 0) {
			try {
				System.out.println("un paciente en la cola");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		cantidadDisponiblesDeCamillas--;
		//System.out.println("paciente esta siendo atendido");
	}
	
	//cuando un paciente termina de ser atendido
	public synchronized void liberarSalaEmergencias() {
		this.cantidadDisponiblesDeCamillas++;
		
		notify();
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
