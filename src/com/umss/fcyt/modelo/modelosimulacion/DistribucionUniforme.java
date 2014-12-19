package com.umss.fcyt.modelo.modelosimulacion;

public class DistribucionUniforme {
private  double valorGenerado = 0.0;
public DistribucionUniforme() {
	// TODO Auto-generated constructor stub
}
public void generar(int a , int b){
	GeneradorCongruencialMixto gene = new GeneradorCongruencialMixto();
	double valor = gene.numeroAleatorio();
	double res = a + ((b-a)*valor);
	String aux = ""+res;
	if(aux.equalsIgnoreCase("NaN") || aux.equalsIgnoreCase("Infinity"))
	{
		generar(a,b);
	}
	valorGenerado = res;
	
}
public double getValor(){
	return valorGenerado;
}
public static void main(String[]args){
	
	int a1=0;
	int a2=0;
	int a3=0;
	int a4=0;
	int a5=0;
	int a6=0;
	while(true){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	DistribucionUniforme gen = new DistribucionUniforme();
	gen.generar(1, 7);
	int res = (int)gen.getValor();
	System.out.println((int)res);
	
	switch(res) {
	 case 1: 
	     a1++;  
	     break;
	 case 2: 
	     a2++;
	     break;
	 case 3: 
	     a3++;
	     break;
	 case 4: 
	     a4++;
	     break;
	 case 5: 
		 a5++;
	 case 6:
	     a6++;
	     break;
	}
	System.out.println("1s ="+a1);
	System.out.println("2s ="+a2);
	System.out.println("3s ="+a3);
	System.out.println("4s ="+a4);
	System.out.println("5s ="+a5);
	System.out.println("6s ="+a6);
  }
}
}
