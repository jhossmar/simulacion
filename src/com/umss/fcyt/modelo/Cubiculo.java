package com.umss.fcyt.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cubiculo {

	
	//faltan implementar dos metodos importantes
	private int cantidadDisponiblesDeCamillas;//ya no es necesario
	
	private int cantidadMaximaDeCamillas;
	private TipoPaciente tipoDePacienteParaAtender;
	
	private List<Paciente> pacientes;
	
	public Cubiculo(int cantidadDeCamillas, TipoPaciente tipoPaciente) {
		this.tipoDePacienteParaAtender = tipoPaciente;
		this.cantidadMaximaDeCamillas = cantidadDeCamillas;
		//this.cantidadDisponiblesDeCamillas = cantidadMaximaDeCamillas;//ya no es necesario
		this.pacientes = new ArrayList<Paciente>();
	}
	
	public String retornarCantidadCamillasDisponibles() {
		return ""+ (cantidadMaximaDeCamillas - pacientes.size());//retorna mal cuando metes a mas pacientes de lo que debes
	}
	
	public boolean verificarEspacio() {
		boolean respuesta = false;
		if(this.pacientes.size() < cantidadMaximaDeCamillas) {
			return true;
		}
		
		return respuesta;
	}
	
	public boolean agregarPaciente(Paciente paciente) {
		if(verificarEspacio()) {
			this.pacientes.add(paciente);
			return true;
		}
		return false;
	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
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
