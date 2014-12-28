package com.umss.fcyt.simulaciongraficos;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class VentanaPrincipal extends JFrame {
	

	public VentanaPrincipal() {
		
		construirVentana();
		
		inicializarComponentes();//inicializa los componentes
		comenzarPrograma();

	}


	
	public void inicializarComponentes() {
		this.setLayout(new FlowLayout(3));
		PanelSimulacion p = new PanelSimulacion();
		p.setPreferredSize(new Dimension(500, 350));
		this.add(p);
		
//		PanelDeProcesos b = new PanelDeProcesos();
//		b.setVisible(true);
//		this.add(b);

	}


	/*
	 * metodos importantes que no tienen que faltar en un JFrame o un JDialog
	 */
	public void construirVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension a = this.getToolkit().getScreenSize();
		this.setSize(a);
		setTitle("Simulacion");
	}

	/*
	 * metodo que hace que un componente se haga visible (importante)
	 */
	public void comenzarPrograma() {
		setVisible(true);
	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new VentanaPrincipal();
		
	}

	

}
