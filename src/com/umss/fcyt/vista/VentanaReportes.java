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

	// la tabla
	public JTable table;

	// el modelo de tabla, aquí van a estar los datos.
	public DefaultTableModel model;

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

	public VentanaReportes() {
		setTitle("TABLA CON LOS DATOS");
		setBounds(100, 100, 596, 331);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 560, 227);
		
		getContentPane().add(scrollPane);

		String[] columnNames = { "Variables", "Valores"};

		model = new DefaultTableModel(null, columnNames);
		table = new JTable(model);
		
		scrollPane.setViewportView(table);
	}
}
