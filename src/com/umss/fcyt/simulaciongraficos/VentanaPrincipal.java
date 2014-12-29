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
		getContentPane().setLayout(null);
		PanelSimulacion p = new PanelSimulacion();
		p.setBounds(5, 5, 500, 350);
		getContentPane().add(p);
		
		PanelDeProcesos b = new PanelDeProcesos();
		b.setBounds(510, 5, 460, 403);
		b.setVisible(true);
		getContentPane().add(b);

	}


	/*
	 * metodos importantes que no tienen que faltar en un JFrame o un JDialog
	 */
	public void construirVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension a = this.getToolkit().getScreenSize();
		this.setSize(a);
		setTitle("MusicMaster");
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
