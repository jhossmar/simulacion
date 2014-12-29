package com.umss.fcyt.modelo.modelosimulacion;

import java.util.Random;

import com.umss.fcyt.modelo.EstadoFinal;
import com.umss.fcyt.modelo.Paciente;
import com.umss.fcyt.modelo.TipoPaciente;
/**
 * clase para gerar los valores de las distintas variables aleatorias
 * encontradas 
 * */
public class GeneradorDeVariables {
	
public GeneradorDeVariables(){

}

/**
 * determina el tipo de paciente
 * @return tipo de Paciente: DERIVADORS_OTRO_HOSPITAL,ACCIDENTE_TRANSITO,QUEMADURAS,
 *	        CONTAGIOSOS,PACIENTES_GRAVES o PACIENTES_NORMALES
 **/
public TipoPaciente getVarTipoDePaciente(){
	TipoPaciente res = TipoPaciente.PACIENTES_GRAVES;
    DistribucionUniforme distribucionUnif = new DistribucionUniforme();
    distribucionUnif.generar(1, 5);//dado que en el informe esta variable sige una distribucion exponencial con media = 25
    int aux = (int)distribucionUnif.getValor();
    switch(aux) {
	 case 1: 
	      res = TipoPaciente.QUEMADURAS;
	     break;
	 case 2: 
		 res = TipoPaciente.CONTAGIOSOS;
	     break;
	 case 3: 
		 res = TipoPaciente.PACIENTES_GRAVES;
         break;	 
 	 case 4:
		 res = TipoPaciente.PACIENTES_NORMALES;
	     break;
	}
   System.out.println("Se genero al  tipo de paciente paciente :" + res);
    return res;
    }
	
public EstadoFinal getEstadoFinal(){
	EstadoFinal res = EstadoFinal.CONSULTA_EXTERNA;
    DistribucionUniforme distribucionUnif = new DistribucionUniforme();
    distribucionUnif.generar(1, 6);//dado que en el informe esta variable sige una distribucion exponencial con media = 25
    int aux = (int)distribucionUnif.getValor();
    switch(aux) {
	 case 1: 
	      res = EstadoFinal.CONSULTA_EXTERNA;
	     break;
	 case 2: 
		 res =EstadoFinal.DADO_ALTA;
	     break;
	 case 3: 
		 res = EstadoFinal.FALLECIDO;
         break;	 
 	 case 4:
		 res = EstadoFinal.INTERNADO;
	     break;
 	 case 5:
		 res = EstadoFinal.FECHA_REPROGRAMADA;
	     break;
	}
   //System.out.println("Se genero al  tipo de paciente paciente :" + res);
    return res;
    }

	



/**
 * determina el tiempo que pasa desde que llega un paciente al otro
 * @return tiempo de llegada en minutos
 */
public int  getVarTiempoDeLlegada(){
	double res;
    DistribucionExponencial distribucionExp = new DistribucionExponencial();
    distribucionExp.generarValor(25);//dado que en el informe esta variable sige una distribucion exponencial con media = 25
    res = distribucionExp.getValor();
    System.out.println("##marce###valor generado "+res);
	return (int)res;
	
	
}

/**
 * determina el tiempo que se tarda en atender a un paciente
 * @param tipoDePaciente tipo de paciente(quemado, contagioso ..etc)
 * @return tiempo de atencion en minutos
 * */
public int getVarTiempoDeAtencion(TipoPaciente tipoDePaciente ){
    	
	double res;
    DistribucionExponencial distribucionExp = new DistribucionExponencial();
    distribucionExp.generarValor(30);//dado que en el informe esta variable sige una distribucion exponencial con media=30
    res = distribucionExp.getValor();
    System.out.println("##marce###valor generado "+res);
	return (int)res;
	
	
	
	
    
}

/**
 *  determina si un paciente debe ser internado o no;
 *  @param tipoDeDia  tipo  de de dia (fin de semana o normal)
 *  @param tipoDePaciente tipo de paciente (quemaduras, grabes ..etc)
 * @return false = el paciente no debe ser dado de alta;
 *  true = el paciente debe ser dado de alta
 **/ 
public boolean pacienteDadoDeAlta( TipoPaciente tipoDePaciente, String tipoDeDia){
	
      return false;
}

/**
 * determina si el paciente debe ser internado o no
 *
 * @return true= el paciente debe ser internado. false= el paciente no debe ser internado
 * */
public boolean pacienteDebeSerInternado(TipoPaciente tipoDePaciente){
	
	return false;
	
}


/**
 * Determina si un medico espesialista  se encuentra disponible o no
 * @return true= si se encuentra el medico disponible; false= no se encuentra el medico disponible
 * 
 * */
public boolean medicoEspecialistaDisponible(TipoPaciente tipoDePaciente){

	return true;
	
	
}

}


/*
 * Resumen de  variables en capitulo 4:
 *     
 * Variables:
 *  
 *   1 Tipo de Pasiente
 *   2 Cantidad de pasientes en la sala de emergencias-> Deberia depender de las variables 3 y 4
 *   3 tiempo de llegada de los pasientes
 *   4 tiempo de atención
 *   5 cantidad de pacientes dados de alta el mismo dia( dias normales)
 *   6 cantidad de pacientes dados de alta el mismo dia( fines de semana)
 *   7 cantidad de pasientes que son internados 
 *   8 probabilidad de que un pasiente encuente a medico 
 *     especialista segun necesidad que tenga-> ? es una variable?
 *   9 disponibilidad del medico especialista
 *   10 tiempo en que se  desocupa una cama-> depende de las variables 4, 5 o 6,
 * 
 * */



