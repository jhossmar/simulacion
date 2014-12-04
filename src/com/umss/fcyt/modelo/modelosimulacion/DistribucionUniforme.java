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
	
	DistribucionUniforme gen = new DistribucionUniforme();
	gen.generar(2, 8);
	double res = gen.getValor();
	System.out.println(res);
}
}
