package com.umss.fcyt.modelo.simulacion;

import java.util.Iterator;
import java.util.List;

import com.umss.fcyt.modelo.Cubiculo;
import com.umss.fcyt.modelo.Paciente;
import com.umss.fcyt.modelo.SalaDeEspera;
import com.umss.fcyt.modelo.SalaEmergencias;
import com.umss.fcyt.modelo.TipoPaciente;

public class SimuladorDos {

	private SalaEmergencias salaDeEmergencias;

	private Reloj reloj;

	private int tiempoTranscurrido = 0;

	private int tiempoDeEntradaPaciente;

	public SimuladorDos(SalaEmergencias sala) {
		this.salaDeEmergencias = sala;
	}

	public SimuladorDos() {
		Cubiculo c = new Cubiculo(2, TipoPaciente.QUEMADURAS);
		Cubiculo c2 = new Cubiculo(2, TipoPaciente.PACIENTES_GRAVES);
		this.salaDeEmergencias = new SalaEmergencias();
		this.salaDeEmergencias.agregarCubiculo(c);
		this.salaDeEmergencias.agregarCubiculo(c2);

		this.tiempoDeEntradaPaciente = 1;//variable aleatoria desde 1 a otro
	}

	public void pasoSimulacion() {
		// liberarCubiculos
		System.out.println("==================================================");
		System.out.println("Tiempo : " + tiempoTranscurrido);

		
		//libero cubiculos
		for(int i=0;i < salaDeEmergencias.getCubiculos().size();i++) {
			Cubiculo c = salaDeEmergencias.getCubiculos().get(i);
			for(int j = 0;j < c.getPacientes().size();j++) {
				Paciente paciente = c.getPacientes().get(j);
				//System.out.println("El paciente ");
				if(paciente.getTiempoDeAtencion() == 0) {
					System.out.println("Se termino de atender al paciente : " + paciente.getNombre());
					c.getPacientes().remove(j);
					System.out.println(c.getPacientes().size());
				}
			}
		}
		
		//recorro los cubiculos en los que hay espacio si hay meterlos
		for(int i=0;i < salaDeEmergencias.getCubiculos().size();i++) {
			Cubiculo cubiculo = salaDeEmergencias.getCubiculos().get(i);
			//System.out.println(salaDeEmergencias.getCubiculos().size());
			if(cubiculo.verificarEspacio()) {
				System.out.println("Tamano :" + cubiculo.getPacientes().size());
				
					int indicePrimero = 0;
					for(int j = 0 ;j < salaDeEmergencias.getSalaEspera().size();j++) {
						Paciente aux = salaDeEmergencias.getSalaEspera().get(j);
						if((aux.getTipo() == cubiculo.getTipoDePacienteParaAtender())) {
							indicePrimero = j;
							Paciente paciente = salaDeEmergencias.getSalaEspera().get(indicePrimero);
							cubiculo.agregarPaciente(paciente);
							this.salaDeEmergencias.getSalaEspera().eliminarEnPosicion(indicePrimero);
								
							System.out.println("El paciente :"+ paciente.getNombre()+ " esta siendo atendido  "+ "en el cubiculo de : "
												+ cubiculo.getTipoDePacienteParaAtender().toString() + " por unos :"+paciente.getTiempoDeAtencion()+ " minutos .....");
						}
					}
					
					
				
				
			}
			
		}
		

		// caso en que no hay nadie y tambien hace actuar la variable de tiempo
		// de entrada de un paciente
		ingresaNuevoPaciente();

		
		
		
		//reduce tiempo de atencion solo a los que estan en los cubiculos
		for (Cubiculo cubiculo : salaDeEmergencias.getCubiculos()) {
			for (Paciente paciente : cubiculo.getPacientes()) {
				paciente.reducirTiempoDeAtencion();
			}
		}

		
		this.tiempoTranscurrido = this.tiempoTranscurrido + 1;
		System.out.println("==================================================");
	}

	public void ingresaNuevoPaciente() {
		if (tiempoTranscurrido == tiempoDeEntradaPaciente) {
			Paciente p = new Paciente("Beimar " + tiempoTranscurrido);

			this.salaDeEmergencias.getSalaEspera().encolar(p);
			System.out.println("un paciente llega al hospital y se pone en la sala de espera");

			for (Cubiculo cubiculo : salaDeEmergencias.getCubiculos()) {
				System.out.println("Realizando Triaje : que tipo de paciente es.... ");
				if (cubiculo.getTipoDePacienteParaAtender() == p.getTipo()) {//se verifica a que cubiculo entra
					System.out.println("Paciente :  "+ p.getNombre()+ " pertenece a "+ cubiculo.getTipoDePacienteParaAtender()
									.toString());
					if (cubiculo.verificarEspacio()) {//falla verificar si el primero de todos los quemados
						
						
						//para verificar si el primero de la cola
						int indicePrimero = 0;
						for(int i = 0 ;i < salaDeEmergencias.getSalaEspera().size();i++) {
							Paciente aux = salaDeEmergencias.getSalaEspera().get(i);
							if((aux.getTipo() == cubiculo.getTipoDePacienteParaAtender())) {
								indicePrimero = i;
							}
						}
						Paciente aux = salaDeEmergencias.getSalaEspera().get(indicePrimero);
						if(aux.equals(p)&& (aux.getTipo() == cubiculo.getTipoDePacienteParaAtender())) {
							cubiculo.agregarPaciente(p);
							this.salaDeEmergencias.getSalaEspera().eliminarEnPosicion(indicePrimero);
							
							System.out.println("El paciente :"+ p.getNombre()+ " esta siendo atendido  "+ "en el cubiculo de : "
											+ cubiculo.getTipoDePacienteParaAtender().toString() + " por unos :"+ p.getTiempoDeAtencion()+ " minutos .....");
						} else {
							System.out.println("no es el primero de la fila");
						}
						
					} else {
						System.out.println("La sala de :"+ cubiculo.getTipoDePacienteParaAtender().toString()
								+ " esta llena el paciente sigue esperando");
					}
				}
			}

			// despues de haber transcurrido el tiempo de entrada del paciente(aqui va la variable aleatoria ese tres)
			this.tiempoDeEntradaPaciente = this.tiempoDeEntradaPaciente + 3;// ojo parece que mas tres
		}
	}
	
	public int horaAleatoria(int limite) {
		int resultado = (int) (Math.random() * limite);
		return resultado;
	}

	public SalaEmergencias getSalaDeEmergencias() {
		return salaDeEmergencias;
	}

	public void setSalaDeEmergencias(SalaEmergencias salaDeEmergencias) {
		this.salaDeEmergencias = salaDeEmergencias;
	}

	public Reloj getReloj() {
		return reloj;
	}

	public void setReloj(Reloj reloj) {
		this.reloj = reloj;
	}

	public int getTiempoTranscurrido() {
		return tiempoTranscurrido;
	}

	public void setTiempoTranscurrido(int tiempoTranscurrido) {
		this.tiempoTranscurrido = tiempoTranscurrido;
	}

	public static void main(String[] args) {
		SimuladorDos simuDos = new SimuladorDos();

		simuDos.pasoSimulacion();//tiempo 0(no hace nada)
		simuDos.pasoSimulacion();//tiempo uno etc... entra paciente
		simuDos.pasoSimulacion();
		simuDos.pasoSimulacion();
		simuDos.pasoSimulacion();//entra paciente
		simuDos.pasoSimulacion();//
		simuDos.pasoSimulacion();
		simuDos.pasoSimulacion();//entra paciente   //por aqui deberia salir el primer paciente
		simuDos.pasoSimulacion();
		simuDos.pasoSimulacion();
		simuDos.pasoSimulacion();
		simuDos.pasoSimulacion();
		simuDos.pasoSimulacion();
		simuDos.pasoSimulacion();
	}

}
