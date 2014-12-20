package com.umss.fcyt.modelo;

import java.util.ArrayList; 
import java.util.List;
import java.util.Queue;

public class SalaEmergencias {
	private List<Paciente> pacientes;
	private List<Medico> medicos;
	private List<Enfermera> enfermeros;
	private List<Cubiculo> cubiculos;
	private SalaDeEspera salaEspera;
	
	public SalaEmergencias() {
		this.pacientes = new ArrayList<Paciente>();
		this.medicos = null;
		this.enfermeros = null;
		this.cubiculos = new ArrayList<Cubiculo>();
		
		this.salaEspera = new SalaDeEspera();
	}

	
	
	public SalaDeEspera getSalaEspera() {
		return salaEspera;
	}



	public void setSalaEspera(SalaDeEspera salaEspera) {
		this.salaEspera = salaEspera;
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
	
	public ArrayList<Integer> getDatos(){

        ArrayList<Integer> valores = new ArrayList<Integer>();
		valores.add(pacientes.size());
		valores.add(calcularTiempoEspera());
		valores.add(calcularTiempoAtencion());
		valores.add(calcularCantidadPacientesPorEstadoFinal(EstadoFinal.DADO_ALTA));
		valores.add(calcularCantidadPacientesPorEstadoFinal(EstadoFinal.INTERNADO));
		valores.add(calcularCantidadPacientesPorEstadoFinal(EstadoFinal.FECHA_REPROGRAMADA));
		valores.add(calcularCantidadPacientesPorEstadoFinal(EstadoFinal.FALLECIDO));
		valores.add(calcularCantidadPacientesPorEstadoFinal(EstadoFinal.CONSULTA_EXTERNA));
        //valores.add(pacientesInternados.size());
		//valores.add(pacientesReprogramados.size());
		//valores.add(pacientesFallecidos.size());
		//valores.add(pacientesFechasReprogramadas.size());
		
//		valores.add(10);
//		valores.add(10);
//		valores.add(25);
//		valores.add(2);
//		valores.add(3);
//		valores.add(1);
//		valores.add(2);
//		valores.add(2);
		return valores;
	}
	public int calcularTiempoEspera(){
		int tiempo = 0;
		for(Paciente p : pacientes) {
			tiempo = tiempo + p.getTiempoEspera();
		}
		return tiempo;
	}
	
	public int calcularCantidadPacientesPorEstadoFinal(EstadoFinal estadoFinal) {
		int cantidad = 0;
		for (Paciente paciente : pacientes) {
			if(paciente.getEstadoFinal() == estadoFinal) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public int calcularTiempoAtencion() {
		int suma = 0;
		for(Paciente p : pacientes) {
			suma = suma + p.getTiempoDeAtencion();
		}
		
		return (suma / pacientes.size());
	}
	
	public ArrayList<String> getNombres(){
		ArrayList<String> nombres = new ArrayList<String>();
		for(Paciente p : pacientes){
			nombres.add(p.getNombre());
		}
		return nombres;
	}
	public ArrayList<Integer> getTiempoEspera(){
		ArrayList<Integer> tiempos = new ArrayList<Integer>();
		
		for(Paciente p : pacientes){
			tiempos.add(p.getTiempoEspera());
		}
		
		return tiempos;
	}
	public ArrayList<Integer> getTiempoAtencion(){
		ArrayList<Integer> tiempos = new ArrayList<Integer>();
		
		for(Paciente p : pacientes){
			tiempos.add(p.getTiempoDeAtencion());
		}
		
		return tiempos;
	}



	public ArrayList<TipoPaciente> getCubiculo() {
		ArrayList<TipoPaciente> cubiculos = new ArrayList<TipoPaciente>();
		for(Paciente p : pacientes){
			cubiculos.add(p.getTipo());
		}
		return cubiculos;
	}



	public ArrayList<Integer> getHoraEntrada() {
		ArrayList<Integer> horaEntradas = new ArrayList<Integer>();
		for(Paciente p : pacientes){
			horaEntradas.add(p.getHoraEntrada());
		}
		return horaEntradas;
	}



	public ArrayList<Integer> getHoraSalida() {
		ArrayList<Integer> horaSalida = new ArrayList<Integer>();
		for(Paciente p : pacientes){
			horaSalida.add(p.getHoraSalida());
		}
		return horaSalida;
	}



	public ArrayList<EstadoFinal> getEstadoFinal() {
		ArrayList<EstadoFinal> estadoFinal = new ArrayList<EstadoFinal>();
		for(Paciente p : pacientes){
			estadoFinal.add(p.getEstadoFinal());
		}
		return estadoFinal;
	}
}
