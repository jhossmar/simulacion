package com.umss.fcyt.simulaciongraficos;

public class Monitor {
	boolean hayPermiso;//un int ocupa mucha mas memoria asi que se utilizara boolean
	
	//si es true es como si ya tuviera permiso pero si es false no tiene permiso de entrada
	public Monitor(boolean permiso) {
		hayPermiso = permiso;
	}
	
	//puuede ser solo permisos
	public synchronized void obtenerPermiso(String nombre) {
		while(hayPermiso) {
			try {
				System.out.println(nombre + " ya existe un producto en el almacen");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hayPermiso = true;
		System.out.println(nombre + " hay permiso");
		notify();
	}
	
	public synchronized void cederPermiso(String nombre) {
		while(!hayPermiso) {
			try {
				System.out.println("no hay permiso" + nombre);
				wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Se consumio un producto del almacen Cliente : " + nombre);
		hayPermiso = false;
		notify();
	}
	
//	public static void main(String[] args) {
//		Monitor monitor = new Monitor(false);
//		
//		Productor p = new Productor("P :",monitor);
//		Productor p1 = new Productor("P 1 :",monitor);
//		
//		Consumidor c = new Consumidor("Beimar", monitor);
//		Consumidor c1 = new Consumidor("Jose", monitor);
//		Consumidor c2 = new Consumidor("Maria", monitor);
//		
//		p.iniciar();
//		p1.iniciar();
//		c.iniciar();
//		c1.iniciar();
//		c2.iniciar();
//		
//	}
}
