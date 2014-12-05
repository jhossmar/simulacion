package com.umss.fcyt.controlador;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.umss.fcyt.vista.VentanaPrincipal;

public class ClasePrincipalAplicacion {

	public static void cambiarLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			//UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		cambiarLookAndFeel();
		
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ControladorVentanaPrincipal controlador = new ControladorVentanaPrincipal(ventanaPrincipal);
		
		ventanaPrincipal.setVisible(true);
		controlador.iniciarSimulacion();
	}
}
