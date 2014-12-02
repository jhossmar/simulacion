package com.umss.fcyt.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SalaEmergencias {
	private List<Paciente> pacientes;
	private List<Medico> medicos;
	private List<Enfermera> enfermeros;
	private List<Cubiculo> cubiculos;
	private SalaDeEspera pacientesEsperando;
	
	public SalaEmergencias() {
		this.pacientes = null;
		this.medicos = null;
		this.enfermeros = null;
		this.cubiculos = null;
		
		
	}

	public void agregarPaciente(Paciente paciente) {
		if(pacientes == null) {
			this.pacientes = new ArrayList<Paciente>();
		}
		this.pacientes.add(paciente);
	}
	
	public void agregarMedico(Medico medico) {
		if(medicos == null) {
			this.medicos = new ArrayList<Medico>();
		}
		this.medicos.add(medico);
	}
	
	public void agregarEnfermero(Enfermera enfermero) {
		if(enfermeros == null) {
			this.enfermeros = new ArrayList<Enfermera>();
		}
		this.enfermeros.add(enfermero);
	}
	
	public void agregarCubiculo(Cubiculo cubiculo) {
		if(cubiculos == null) {
			this.cubiculos = new ArrayList<Cubiculo>();
		}
		this.cubiculos.add(cubiculo);
	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Enfermera> getEnfermeros() {
		return enfermeros;
	}

	public void setEnfermeros(List<Enfermera> enfermeros) {
		this.enfermeros = enfermeros;
	}

	public List<Cubiculo> getCubiculos() {
		return cubiculos;
	}

	public void setCubiculos(List<Cubiculo> cubiculos) {
		this.cubiculos = cubiculos;
	}
	
	
	
}
