package com.umss.fcyt.modelo.simulacion;

import java.util.Iterator;
import java.util.List;

import com.umss.fcyt.modelo.Cubiculo;
import com.umss.fcyt.modelo.Paciente;
import com.umss.fcyt.modelo.SalaDeEspera;
import com.umss.fcyt.modelo.SalaEmergencias;
import com.umss.fcyt.modelo.TipoPaciente;
import com.umss.fcyt.modelo.modelosimulacion.GeneradorDeVariables;

public class SimuladorDos {

	private SalaEmergencias salaDeEmergencias;

	private Reloj reloj;

	private int tiempoTranscurrido = 0;

	private int tiempoDeEntradaPaciente;
	

	public StringBuffer descripcionSimulacion;

	private GeneradorDeVariables generadorDeVariables;


	public SimuladorDos(SalaEmergencias sala) {
		this.salaDeEmergencias = sala;
		generadorDeVariables = new GeneradorDeVariables();
	}

	public SimuladorDos() {
		Cubiculo c = new Cubiculo(2, TipoPaciente.QUEMADURAS);
		Cubiculo c2 = new Cubiculo(2, TipoPaciente.PACIENTES_GRAVES);
		this.salaDeEmergencias = new SalaEmergencias();
		this.salaDeEmergencias.agregarCubiculo(c);

		this.salaDeEmergencias.agregarCubiculo(c2);
		
		this.descripcionSimulacion = new StringBuffer();
		
		this.reloj = new Reloj();


		generadorDeVariables = new GeneradorDeVariables();

		this.tiempoDeEntradaPaciente = 1;//variable aleatoria desde 1 a otro
	
	}

	public void pasoSimulacion() {
		this.descripcionSimulacion = null;
		this.descripcionSimulacion = new StringBuffer();
		
		// liberarCubiculos
		descripcionSimulacion.append("================================================== \n");
		reloj.actualizar(tiempoTranscurrido);
		descripcionSimulacion.append("Hora : " + reloj.toString() + "\n");
		//System.out.println("==================================================");
		//System.out.println("Tiempo : " + reloj.toString());

		
		//libero cubiculos
		for(int i=0;i < salaDeEmergencias.getCubiculos().size();i++) {
			Cubiculo c = salaDeEmergencias.getCubiculos().get(i);
			descripcionSimulacion.append("El cubiculo de " +c.getTipoDePacienteParaAtender() + " esta atendiendo a: "+c.getPacientes().size()
					+"  pacientes \n" + "Y tiene : " + c.retornarCantidadCamillasDisponibles() + " camillas disponibles \n");
			
			//System.out.println("El cubiculo de " +c.getTipoDePacienteParaAtender() + "esta atendiendo a: "+c.getPacientes().size()
				//	+"  pacientes");
			//System.out.println("Y tiene : " + c.retornarCantidadCamillasDisponibles() + " camillas disponibles");

			for(int j = 0;j < c.getPacientes().size();j++) {
				Paciente paciente = c.getPacientes().get(j);
				//System.out.println("El paciente ");
				if(paciente.getTiempoDeAtencion() == 0) {
					descripcionSimulacion.append("Se termino de atender al paciente : " + paciente.getNombre() + "\n");
					
					//System.out.println("Se termino de atender al paciente : " + paciente.getNombre());
					c.getPacientes().remove(j);
					//System.out.println(c.getPacientes().size());
				}
			}
		}
		
		//recorro los cubiculos en los que hay espacio si hay meterlos
		for(int i=0;i < salaDeEmergencias.getCubiculos().size();i++) {
			Cubiculo cubiculo = salaDeEmergencias.getCubiculos().get(i);
			//System.out.println(salaDeEmergencias.getCubiculos().size());
			if(cubiculo.verificarEspacio()) {
				//System.out.println("Tamano :" + cubiculo.getPacientes().size());
					int indicePrimero = 0;
					for(int j = 0 ;j < salaDeEmergencias.getSalaEspera().size();j++) {
						Paciente aux = salaDeEmergencias.getSalaEspera().get(j);
						if((aux.getTipo() == cubiculo.getTipoDePacienteParaAtender())) {
							indicePrimero = j;
							Paciente paciente = salaDeEmergencias.getSalaEspera().get(indicePrimero);
							if(cubiculo.agregarPaciente(paciente)){
								this.salaDeEmergencias.agregarPaciente(paciente);
								this.salaDeEmergencias.getSalaEspera().eliminarEnPosicion(indicePrimero);
								descripcionSimulacion.append("El paciente :"+ paciente.getNombre()+ " esta siendo atendido  "+ "en el cubiculo de : "
										+ cubiculo.getTipoDePacienteParaAtender().toString() + " por unos :"+paciente.getTiempoDeAtencion()+ " minutos .....\n");
								
								//System.out.println("El paciente :"+ paciente.getNombre()+ " esta siendo atendido  "+ "en el cubiculo de : "
													//+ cubiculo.getTipoDePacienteParaAtender().toString() + " por unos :"+paciente.getTiempoDeAtencion()+ " minutos .....");

							}
														//System.out.println("beimar" + j);
							//break;//solo para romper el bucle
						}
					}

			
		}
		

		// caso en que no hay nadie y tambien hace actuar la variable de tiempo
		// de entrada de un paciente
		ingresaNuevoPaciente();

		
		
		
		//reduce tiempo de atencion solo a los que estan en los cubiculos
		for (Cubiculo cubiculo2 : salaDeEmergencias.getCubiculos()) { // problema con la variable cubiculo@marcelo
		    for (Paciente paciente : cubiculo2.getPacientes()) {
				paciente.reducirTiempoDeAtencion();
			}
		}
		

		
		this.tiempoTranscurrido = this.tiempoTranscurrido + 1;
		descripcionSimulacion.append("==================================================\n");
		//System.out.println("==================================================");
	 }
	}


	public void ingresaNuevoPaciente() {
		if (tiempoTranscurrido == tiempoDeEntradaPaciente) {
			Paciente p = new Paciente("Beimar " + tiempoTranscurrido);

			this.salaDeEmergencias.getSalaEspera().encolar(p);
			descripcionSimulacion.append("Un paciente llega al hospital y se pone en la sala de espera \n");
			//System.out.println("Un paciente llega al hospital y se pone en la sala de espera");

			for (Cubiculo cubiculo : salaDeEmergencias.getCubiculos()) {
				
				if (cubiculo.getTipoDePacienteParaAtender() == p.getTipo()) {//se verifica a que cubiculo entra
					descripcionSimulacion.append("Paciente :  "+ p.getNombre()+ " pertenece a "+ cubiculo.getTipoDePacienteParaAtender()
							.toString() + "\n");
					
					//System.out.println("Paciente :  "+ p.getNombre()+ " pertenece a "+ cubiculo.getTipoDePacienteParaAtender()
									//.toString());
					descripcionSimulacion.append("Realizando Triaje : que tipo de paciente es.... \n");
					//System.out.println("Realizando Triaje : que tipo de paciente es.... ");
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
							this.salaDeEmergencias.agregarPaciente(p);
							this.salaDeEmergencias.getSalaEspera().eliminarEnPosicion(indicePrimero);
							descripcionSimulacion.append("El paciente :"+ p.getNombre()+ " esta siendo atendido  "+ "en el cubiculo de : "
									+ cubiculo.getTipoDePacienteParaAtender().toString() + " por unos :"+ p.getTiempoDeAtencion()+ " minutos ..... \n");
							
							//System.out.println("El paciente :"+ p.getNombre()+ " esta siendo atendido  "+ "en el cubiculo de : "
											//+ cubiculo.getTipoDePacienteParaAtender().toString() + " por unos :"+ p.getTiempoDeAtencion()+ " minutos .....");
						} else {
							descripcionSimulacion.append("no es el primero de la fila \n");
							//System.out.println("no es el primero de la fila");
						}
						
					} else {
						descripcionSimulacion.append("La sala de :"+ cubiculo.getTipoDePacienteParaAtender().toString()
								+ " esta llena el paciente sigue esperando \n");
						
						//System.out.println("La sala de :"+ cubiculo.getTipoDePacienteParaAtender().toString()
							//	+ " esta llena el paciente sigue esperando");
					}
				}
			}

			//despues de haber transcurrido el tiempo de entrada del paciente(aqui va la variable aleatoria ese tres)
			//this.tiempoDeEntradaPaciente = this.tiempoDeEntradaPaciente + 3;// ojo parece que mas tres
			 int valorgenerado=this.generadorDeVariables.getVarTiempoDeLlegada();
		     this.tiempoDeEntradaPaciente = this.tiempoDeEntradaPaciente+valorgenerado;              
		   
		    System.out.println("##marce##valor de tiempoDeLLegada generado = "+valorgenerado );
		    System.out.println("##marce###el siguiente pasiente llegara dentro de :"+tiempoDeEntradaPaciente);
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

//		simuDos.pasoSimulacion();//tiempo 0(no hace nada)
//		simuDos.pasoSimulacion();//tiempo uno etc... entra paciente
//		simuDos.pasoSimulacion();
//		simuDos.pasoSimulacion();
//		simuDos.pasoSimulacion();//entra paciente
//		simuDos.pasoSimulacion();//
//		simuDos.pasoSimulacion();
//		simuDos.pasoSimulacion();//entra paciente   //por aqui deberia salir el primer paciente
//		simuDos.pasoSimulacion();
//		simuDos.pasoSimulacion();
//		simuDos.pasoSimulacion();
//		simuDos.pasoSimulacion();
//		simuDos.pasoSimulacion();
//		simuDos.pasoSimulacion();
		
		
		for (int i = 0; i < 45; i++) {
			simuDos.pasoSimulacion();
			System.out.println(simuDos.descripcionSimulacion.toString());		}
//		
		for (Paciente p : simuDos.getSalaDeEmergencias().getSalaEspera()) {
			System.out.println(" " + p.getNombre());
		}
		
		
		System.out.println("=====================");
		for (Paciente p : simuDos.getSalaDeEmergencias().getPacientes()) {
			System.out.println(" " + p.getNombre());
		}
		//solo estan entrando los primeros con el metodo separado raro!!!
//		Reloj r = new Reloj();
//		r.actualizar(12);
//		System.out.println(r.toString());
	
	}

}