package com.umss.fcyt.vista;

import java.awt.EventQueue; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaTabla extends JFrame {

	public JTable table;
	
	public DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTabla frame = new VentanaTabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaTabla() {
		setTitle("TABLA CON LOS DATOS");
		setBounds(100, 100, 643, 300);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 560, 227);
		getContentPane().add(scrollPane);
		String[] columnNames = { "Nombre del Paciente", "Tiempo de Atencion","Cubiculo","Hora de entrada","Hora de Salida","Estado Final"};
		model = new DefaultTableModel(null, columnNames);
		table = new JTable(model);
		
		scrollPane.setViewportView(table);
	}

}
