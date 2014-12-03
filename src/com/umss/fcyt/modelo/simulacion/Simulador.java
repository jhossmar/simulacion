package com.umss.fcyt.modelo.simulacion;

import com.umss.fcyt.modelo.Cubiculo;
import com.umss.fcyt.modelo.Paciente;
import com.umss.fcyt.modelo.SalaDeEspera;
import com.umss.fcyt.modelo.SalaEmergencias;
import com.umss.fcyt.modelo.TipoPaciente;
//recorrer con agregar a todos los cubiculos cada minuto
public class Simulador implements Runnable {
	private SalaEmergencias salaDeEmergencias;

	private Reloj reloj;

	private static final int VELOCIDAD_MAXIMA_SIMULACION = 100;
	private static final int VELOCIDAD_MINIMA_SIMULACION = 1000;

	private int velocidadActualDeSimulacion;

	private int tiempoTranscurrido;

	private Thread procesoSimulacion;

	public Simulador() {
		this.salaDeEmergencias = new SalaEmergencias();
		this.reloj = new Reloj();
		this.velocidadActualDeSimulacion = VELOCIDAD_MINIMA_SIMULACION;
		this.tiempoTranscurrido = 0;
	}

	public Simulador(SalaEmergencias salaEmergencias) {
		this.salaDeEmergencias = salaEmergencias;
		this.reloj = new Reloj();
		this.velocidadActualDeSimulacion = VELOCIDAD_MINIMA_SIMULACION;
		this.tiempoTranscurrido = 0;
	}

	public void iniciarSimulacion() {
		this.procesoSimulacion = new Thread(this);
		this.procesoSimulacion.start();
	}

	/**
	 * TODO para cambiar la velocidad de simulacion
	 * 
	 * @param minutos
	 */
	public void cambiarVelocidadDeSimulacion(int minutos) {

	}

	@Override
	public void run() {
		int contadorMinutos = 0;

		while (contadorMinutos < Reloj.getCantidadMinutosDia()) {
			try {
				// hace que el tiempo avance
				Thread.sleep(velocidadActualDeSimulacion);

				int tiempoDeEntradaPaciente = horaAleatoria(10);
				System.out.println("Intervalo de tiempo de ingreso a la sala de emergencia: " + tiempoDeEntradaPaciente);

				int contador = 0;
				while (contador <= tiempoDeEntradaPaciente) {
					Thread.sleep(velocidadActualDeSimulacion);
					System.out.println("Sala de Emergencias Atendiendo");
					System.out.println("HORA : " + reloj.toString());

					this.tiempoTranscurrido++;
					this.reloj.actualizar(this.tiempoTranscurrido);

					// incrementa la hora
					contadorMinutos++;
					contador++;
				}

				System.out.println("un paciente ingresa a la sala de emergencia");
				//aqui se crea un paciente  ojo cuidado con nullpointerException
				Paciente paciente = new Paciente("beimar" + contadorMinutos);
				paciente.setCubiculoPerteneciente(salaDeEmergencias.getCubiculos().get(0));
				paciente.inicializarProcesoPaciente();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public int horaAleatoria(int limite) {
		int resultado = (int) (Math.random() * limite);
		return resultado;
	}

	public void pararSimulacion() {

	}

	public void pausarSimulacion() {

	}

	public void detenerSimulacion() {

	}

	public static void main(String[] args) {
		Cubiculo c = new Cubiculo(2, TipoPaciente.QUEMADURAS);
		Cubiculo c2 = new Cubiculo(2, TipoPaciente.PACIENTES_GRAVES);

//		Paciente p = new Paciente("Beimar");
//		Paciente p2 = new Paciente("juan");

		SalaEmergencias sala = new SalaEmergencias();
		sala.agregarCubiculo(c);
		sala.agregarCubiculo(c2);

		Simulador s = new Simulador(sala);
		s.iniciarSimulacion();
		//System.out.println(s.horaAleatoria(5));
	}

}
