package com.umss.fcyt.vista;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.umss.fcyt.controlador.Reporte;
import com.umss.fcyt.modelo.SalaEmergencias;

import java.util.ArrayList; 

public class VentanaPrincipalReportes extends JFrame {

	private JPanel contentPane;
	private SalaEmergencias sala;
	private ArrayList<String> nombres;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaPrincipalReportes frame = new VentanaPrincipalReportes();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalReportes(SalaEmergencias sala) {
		this.sala = sala;
		final ArrayList<String> nombres = sala.getNombres();
		this.nombres = nombres;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPORTES DE LA SIMULACION");
		lblNewLabel.setBounds(136, 32, 210, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipoDeReporte = new JLabel("Tipo de Reporte:");
		lblTipoDeReporte.setBounds(45, 95, 121, 16);
		contentPane.add(lblTipoDeReporte);

		final JCheckBox cantidadPacientes = new JCheckBox("Cantidad de Pacientes");
		cantidadPacientes.setBounds(154, 143, 166, 25);
		contentPane.add(cantidadPacientes);
		
		final JCheckBox tiempoEspera = new JCheckBox("Tiempo de Espera");
		tiempoEspera.setBounds(154, 182, 153, 25);
		contentPane.add(tiempoEspera);
		
		final JCheckBox tiempoAtencion = new JCheckBox("Tiempo de Atencion");
		tiempoAtencion.setBounds(154, 224, 153, 25);
		contentPane.add(tiempoAtencion);
		
		final JComboBox diagra = new JComboBox();
		diagra.setModel(new DefaultComboBoxModel(new String[] {"Diagrama de Barras", "Diagrama Circular", "Tablas"}));
		diagra.setBounds(162, 92, 145, 22);
		contentPane.add(diagra);
		
		JLabel lblNewLabel_1 = new JLabel("Variables:");
		lblNewLabel_1.setBounds(45, 147, 75, 16);
		contentPane.add(lblNewLabel_1);
		
		//final JCheckBox cantidadPacientes = new JCheckBox("Cantidad de Pacientes");
		//cantidadPacientes.setBounds(154, 143, 166, 25);
		//contentPane.add(cantidadPacientes);
		
		//final JCheckBox tiempoEspera = new JCheckBox("Tiempo de Espera");
		//tiempoEspera.setBounds(154, 182, 153, 25);
		//contentPane.add(tiempoEspera);
		
		//final JCheckBox tiempoAtencion = new JCheckBox("Tiempo de Atencion");
		//tiempoAtencion.setBounds(154, 224, 153, 25);
		//contentPane.add(tiempoAtencion);
		
		final JCheckBox pacientesAlta = new JCheckBox("Pacientes dados de Alta");
		pacientesAlta.setBounds(154, 265, 166, 25);
		contentPane.add(pacientesAlta);
		
		final JCheckBox pacientesInternados = new JCheckBox("Pacientes Internados");
		pacientesInternados.setBounds(154, 306, 166, 25);
		contentPane.add(pacientesInternados);
		
		final JCheckBox pacientesReprogramados = new JCheckBox("Pacientes Fechas Reprogramadas");
		pacientesReprogramados.setBounds(154, 347, 221, 25);
		contentPane.add(pacientesReprogramados);
		
		final JCheckBox pacientesFallecidos = new JCheckBox("Pacientes Fallecidos");
		pacientesFallecidos.setBounds(154, 387, 153, 25);
		contentPane.add(pacientesFallecidos);
		
		final JCheckBox pacientesConsultaExterna = new JCheckBox("Pacientes Consulta Externa");
		pacientesConsultaExterna.setBounds(154, 429, 204, 25);
		contentPane.add(pacientesConsultaExterna);
		
		JButton btnMostrarReporte = new JButton("Mostrar Reporte");
		btnMostrarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int grafico = diagra.getSelectedIndex();
				
				ArrayList<String> lista = new ArrayList<String>();
				if(cantidadPacientes.isSelected()){
					lista.add(cantidadPacientes.getText());
				}
				if(tiempoEspera.isSelected()){
					lista.add(tiempoEspera.getText());
				}
				if(tiempoAtencion.isSelected()){
					lista.add(tiempoAtencion.getText());
				}
				if(pacientesAlta.isSelected()){
					lista.add(pacientesAlta.getText());
				}
				if(pacientesInternados.isSelected()){
					lista.add(pacientesInternados.getText());
				}
				if(pacientesReprogramados.isSelected()){
					lista.add(pacientesReprogramados.getText());
				}
				if(pacientesFallecidos.isSelected()){
					lista.add(pacientesFallecidos.getText());
				}
				if(pacientesConsultaExterna.isSelected()){
					lista.add(pacientesConsultaExterna.getText());
				}
				
				Reporte reporte = new Reporte(lista,sala);
				
				if(grafico == 0){
					reporte.graficarBarra();
					VentanaReportes tabla = new VentanaReportes();
					tabla.setVisible(true);
					for(int i = 0;i<lista.size();i++){
						
						String [] aux = reporte.getTabla(lista.get(i));
						tabla.model.addRow(aux);
					}
				}else{
					if(grafico == 1){
						
						reporte.crearGraficoCircular();
						VentanaReportes tabla = new VentanaReportes();
						tabla.setVisible(true);
						for(int i = 0;i<lista.size();i++){
							
							String [] aux = reporte.getTabla(lista.get(i));
							tabla.model.addRow(aux);
						}
						
					}else{
						VentanaTabla tabla = new VentanaTabla();
						tabla.setVisible(true);
						for(int i = 0;i<nombres.size();i++){
							
							String [] aux = reporte.getTabla(lista.get(i));
							tabla.model.addRow(aux);
						}
						
						VentanaReportes tabla = new VentanaReportes();
						tabla.setVisible(true);
						for(int i = 0;i<lista.size();i++){
							
							String [] aux = reporte.getTabla(lista.get(i));
							tabla.model.addRow(aux);
						}
					}
				}
					
				//}
				
			}
		});
		btnMostrarReporte.setBounds(210, 494, 148, 25);
		contentPane.add(btnMostrarReporte);
	}
}
