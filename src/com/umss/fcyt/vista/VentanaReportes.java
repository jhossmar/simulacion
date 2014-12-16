package com.umss.fcyt.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaReportes extends JFrame {
	
	// versi�n
	private static final long serialVersionUID = 1L;

	// la tabla
	public JTable table;

	// el modelo de tabla, aqu� van a estar los datos.
	public DefaultTableModel model;

	// funci�n principal
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReportes frame = new VentanaReportes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// constructor del frame que contruye toda la ventana...
	public VentanaReportes() {
		//t�tulo
		setTitle("Java Swing 9 El JTable");
		// cuando cerramos la ventana se cierra la aplicaci�n por completo
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// dimensiones y posici�n
		setBounds(100, 100, 596, 331);
		// establece una capa absoluta para posicionar los elementos donde queramos
		getContentPane().setLayout(null);

		// el panel con barras de scroll autom�ticas
		JScrollPane scrollPane = new JScrollPane();
		// dimensiones y posici�n del panel de scroll
		scrollPane.setBounds(10, 11, 560, 227);
		
		// se a�ade el panel de scroll a la ventana 
		getContentPane().add(scrollPane);

		// nombre de las columnas 
		String[] columnNames = { "Variables", "Valores"};

		// creo un modelo de datos, sin datos por eso 'null' y establezco los
		// nombres de columna
		model = new DefaultTableModel(null, columnNames);
		// creo la tabla con el modelo de datos creado
		table = new JTable(model);
		
		// se pone la tabla en el scroll
		scrollPane.setViewportView(table);
	}
}
