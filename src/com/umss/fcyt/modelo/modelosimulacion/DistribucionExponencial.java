package com.umss.fcyt.modelo.modelosimulacion;

public class DistribucionExponencial {
    private double valorGenerado = 0.0; 
    
    public DistribucionExponencial(){
    
    }
    /**Este metodo genera un valor aleatorio no
     uniforme q sigue una distribucion exponencial*/
    public void generarValor(double media)
    { 
    double valorCon = 0.0; 
    double auxGen = 0.0;
    
    GeneradorCongruencialMixto generador = new GeneradorCongruencialMixto();
    valorCon = generador.numeroAleatorio();
    auxGen = -(media*(Math.log(valorCon)));
    String aux = ""+auxGen;
    if(aux.equalsIgnoreCase("Infinity"))
      generarValor(media);
    else
    this.valorGenerado = auxGen;
    }
    /*Devuelve el valor generado*/
    public double getValor()
    {
    return valorGenerado;
    }
 
    public static void main(String[]args)
    {
    
    while (true){
    	DistribucionExponencial Expone = new DistribucionExponencial();
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    Expone.generarValor(30);
    Double valor = Expone.getValor();
    System.out.println(valor);
    }
    /*
        Double res = Math.log(0.2);
        System.out.println(res);
    */
    
    }

   
    
}
