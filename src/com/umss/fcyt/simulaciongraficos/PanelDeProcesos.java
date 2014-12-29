package com.umss.fcyt.simulaciongraficos;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.AbstractListModel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.Point;
import java.awt.ScrollPane;

import javax.swing.JButton;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextPane;

import com.sun.corba.se.spi.orb.StringPair;

import javax.swing.ListSelectionModel;

public class PanelDeProcesos extends JPanel {

	static DefaultListModel modeloLista = new DefaultListModel();
	private JComboBox box_Entidad;
	private JComboBox box_Proceso;
	private JList list;
	private JScrollPane scrollLista;
	
	/**
	*Create the panel.
	 */
	public PanelDeProcesos() {
		
		box_Entidad = new JComboBox();
		box_Entidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		box_Entidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		setLayout(null);
		box_Entidad.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "Enfermera", "Paciente"}));
		box_Entidad.setBounds(15, 81, 101, 24);
		add(box_Entidad);
		
		box_Proceso = new JComboBox();
		box_Proceso.setModel(new DefaultComboBoxModel(new String[] {"quitar ropa de vetir", "detener proceso que indujo la quemadura", "irrigar la zona quemada con solucion fria", "cubrir con sabanas limpias", "utilizar protocolo RCP ", "internar Paciente", "Dar de Alta"}));
		box_Proceso.setBounds(133, 81, 327, 24);
		add(box_Proceso);
		
		JLabel lblEntidad = new JLabel("ENTIDAD");
		lblEntidad.setBounds(15, 62, 59, 15);
		add(lblEntidad);
		
		JLabel lblProceso = new JLabel("PROCESO");
		lblProceso.setBounds(133, 62, 66, 15);
		add(lblProceso);
		
		JButton btnIntroducir = new JButton("Introducir");
		btnIntroducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  introducirSeleccionados();
			
			}
		});
		btnIntroducir.setBounds(174, 126, 103, 25);
		add(btnIntroducir);
		
		JLabel lblPanelDeProcesos = new JLabel("PANEL DE PROCESOS");
		lblPanelDeProcesos.setFont(new Font("DejaVu Serif Condensed", Font.BOLD | Font.ITALIC, 16));
		lblPanelDeProcesos.setBounds(148, 12, 211, 24);
		add(lblPanelDeProcesos);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//list.setBounds(15, 160, 445, 121);
		//add(list);
		
		scrollLista = new JScrollPane();
		scrollLista.setBounds(15,163,445,233);
		scrollLista.setViewportView(list);
        add(scrollLista);
	}

	
	
	protected void introducirSeleccionados() {
		
		if(!seleccionado()){
		String aux = (String)box_Entidad.getSelectedItem()+"  "+(String)box_Proceso.getSelectedItem();
        modeloLista.addElement(aux);
		list.setModel(modeloLista);
		desplazar();
		
		
		}
		
		
	}


    /**
     * despalaza el visor de el JList a la ultima linea
     * */
	private void desplazar() {
		Dimension tamanholista = list.getSize();
		Point p = new Point(0,tamanholista.height);
		scrollLista.getViewport().setViewPosition(p);
		
		
	}



	private boolean seleccionado() {
		 return false;
	}
}
