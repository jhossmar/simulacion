package com.umss.fcyt.modelo;

import java.util.ArrayList;

public class SalaDeEspera extends ArrayList<Paciente> {

	public void encolar(Paciente dato) {
		if (dato != null) {
			this.add(dato);
		} else {
			System.out.println("Introduzca un dato no nulo");
		}
	}

	public void desencolar() {
		if (this.size() > 0) {
			this.remove(0);
		}
	}
	
	public void eliminarEnPosicion(int indice) {
		this.remove(indice);
	}
	
	public Paciente frente() {
		Paciente datoAuxiliar = null;
		if (this.size() > 0) {
			datoAuxiliar = this.get(0);
		}
		return datoAuxiliar;
	}

	public boolean vacia() {
		return this.isEmpty();
	}
	
	public static void main(String[] args) {
		SalaDeEspera s = new SalaDeEspera();
		Paciente p1= new Paciente("beimar");
		Paciente p2= new Paciente("jose");
		Paciente p3= new Paciente("maria");
		Paciente p4= new Paciente("alvaro");
		
		s.encolar(p1);
		s.encolar(p2);
		s.encolar(p3);
		s.encolar(p4);
		
		System.out.println(s.frente().getNombre());
		s.desencolar();
		
		System.out.println(s.frente().getNombre());
		s.desencolar();
		
		System.out.println(s.frente().getNombre());
		s.desencolar();
		
		System.out.println(s.frente().getNombre());
		s.desencolar();
	}
}