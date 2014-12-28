package com.umss.fcyt.simulaciongraficos;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;

import java.awt.FlowLayout;
import java.awt.List;
import javax.swing.JButton;

public class PanelDeProcesos extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelDeProcesos() {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "Enfermera", "paciente"}));
		comboBox.setBounds(12, 39, 235, 24);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"quitar ropa de vetir", "detener proceso que indujo la quemadura", "irrigar la zona quemada con solucion fria", "cubrir con sabanas limpias", "utilizar protocolo RCP ", "internar Paciente", "Dar De Alta"}));
		comboBox_1.setBounds(12, 83, 235, 24);
		add(comboBox_1);
		
		JLabel lblEntidad = new JLabel("ENTIDAD");
		lblEntidad.setBounds(12, 12, 70, 15);
		add(lblEntidad);
		
		JLabel lblProceso = new JLabel("PROCESO");
		lblProceso.setBounds(12, 65, 70, 15);
		add(lblProceso);
		
		List list_1 = new List();
		list_1.setBounds(12, 151, 235, 139);
		add(list_1);
		
		JButton btnIntroducir = new JButton("Introducir");
		btnIntroducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  introducirSeleccionados();
			
			}
		});
		btnIntroducir.setBounds(138, 119, 117, 25);
		add(btnIntroducir);

	}

	
	
	protected void introducirSeleccionados() {
		
		
	}
}
