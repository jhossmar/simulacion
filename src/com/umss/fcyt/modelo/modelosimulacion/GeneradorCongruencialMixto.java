package com.umss.fcyt.modelo.modelosimulacion;

import java.util.ArrayList;

public class GeneradorCongruencialMixto {
	final static int a  = 34;
	final static int xo = 3;
	final static int c = 2;
	final static int m = 99;
	public GeneradorCongruencialMixto() {
	
	}
	
	public Double numeroAleatorio() {
	
		double res = 0;
	    ArrayList<Double> lista = generar();
		res= lista.get((int)(Math.random()*lista.size()-1));
	return res;
    }

	/**Este metodo genera una secuencia de numeros aleatorios
	*mediante el generador congruencial mixto*/
	private ArrayList<Double> generar(){
    ArrayList<Integer> secuencia = new ArrayList<Integer>();
	ArrayList<Double> secuenciaD = new ArrayList<Double>();
	int x = xo;
	do
	{
		x = ((a*x) + c)% m;
     secuencia.add(x);
     secuenciaD.add(((double)x)/m);
	}while(verificarSecuencia(secuencia) == true);
	
	return secuenciaD;
	}
	/*Este metodo solo verifica q la serie no se 
	 * repita y q sea de ciclo completo*/
	private boolean verificarSecuencia(ArrayList<Integer> secu){
		boolean res = true;
		int i = 0;
		int j = 1;
		while((res == true) && (i<secu.size()))
		{    
			for( ; j<secu.size(); j ++){
				if(secu.get(j) == secu.get(i))
					res = false;
			}
			i++;
		}
		return res;
		
	}
	
public static void main(String[]args)
{  
	GeneradorCongruencialMixto gen = new GeneradorCongruencialMixto();
    ArrayList<Double> sec = gen.generar();
    System.out.println("cantidad de nuemros aleatorios: "+sec.size());
   for(int i = 0; i < sec.size(); i++){
	    System.out.println(i+": -> "+sec.get(i));
   }

}




}//fin clase
