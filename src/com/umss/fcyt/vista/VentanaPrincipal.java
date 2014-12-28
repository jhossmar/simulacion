package com.umss.fcyt.vista;

// HEAD
import java.awt.BorderLayout;   
//=======
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
// branch 'master' of https://github.com/jhossmar/simulacion.git
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import com.umss.fcyt.simulaciongraficos.PanelSimulacion;

import java.awt.Font;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JToolBar toolBar;
	private JButton btnGuardar;
	public JButton btnGenerarrepote;
	
	public JMenuItem itemEjecutar;
	public JMenuItem itemPausar;
	public JMenuItem itemContinuar;
	public JMenuItem itemDetener;
	
	//comandos de simulacion
	public JButton botonEjecutar;
	public  JButton botonPausar;
	public  JButton botonDetener;
	 public JButton botonContinuar;
	
	 //panel de graficos
	 public JPanel panelQuemados;
	

	int contador =0;
	public JSlider sliderVelocidad;
	public JTextArea textoDescripcion;
	 
	public VentanaPrincipal() {
		setResizable(false);
		setTitle("Simulador Sala de Emergencias");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/icono1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 550, 21);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmGuardarDiseo = new JMenuItem("Guardar Dise");
		mnArchivo.add(mntmGuardarDiseo);
		
		JMenuItem mntmAbrirDiseo = new JMenuItem("Abrir Dise");
		mnArchivo.add(mntmAbrirDiseo);
		
		JMenuItem mntmCerrarPrograma = new JMenuItem("Cerrar Programa");
		mnArchivo.add(mntmCerrarPrograma);
		
		JMenu mnEdicion = new JMenu("Edicion");
		menuBar.add(mnEdicion);
		
		JMenu mnSimulacion = new JMenu("Simulacion");
		menuBar.add(mnSimulacion);
		
		itemEjecutar = new JMenuItem("Ejecutar");
		mnSimulacion.add(itemEjecutar);
		
		itemPausar = new JMenuItem("Pausar");
		mnSimulacion.add(itemPausar);
		
		itemContinuar = new JMenuItem("Continuar");
		mnSimulacion.add(itemContinuar);
		
		itemDetener = new JMenuItem("Detener ");
		mnSimulacion.add(itemDetener);
		
		JMenuItem mntmAcelerar = new JMenuItem("Acelerar");
		mnSimulacion.add(mntmAcelerar);
		
		JMenuItem mntmDesacelerar = new JMenuItem("Desacelerar");
		mnSimulacion.add(mntmDesacelerar);
		
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		JMenuItem mntmCantidadPacientesAtendidos = new JMenuItem("Cantidad Pacientes Atendidos");
		mnReporte.add(mntmCantidadPacientesAtendidos);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Tiempo Promedio de Atencion");
		mnReporte.add(mntmNewMenuItem);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmListaDeComandos = new JMenuItem("Lista de comandos");
		mnAyuda.add(mntmListaDeComandos);
		
		JMenuItem mntmManualDeUsuario = new JMenuItem("Manual de usuario");
		mnAyuda.add(mntmManualDeUsuario);
		
		JMenuItem mntmSobreNosotros = new JMenuItem("Sobre nosotros");
		mnAyuda.add(mntmSobreNosotros);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 21, 550, 27);
		contentPane.add(toolBar);
		
		btnGuardar = new JButton("Guardar");
		toolBar.add(btnGuardar);
		
		btnGenerarrepote = new JButton("GenerarRepote");
		toolBar.add(btnGenerarrepote);
		
		botonEjecutar = new JButton("Ejecutar");
		toolBar.add(botonEjecutar);
		
		botonPausar = new JButton("Pausar");
		toolBar.add(botonPausar);
		
		botonDetener = new JButton("Detener");
		toolBar.add(botonDetener);
		
		botonContinuar = new JButton("Continuar");
		toolBar.add(botonContinuar);
		
		JInternalFrame internalFrame = new JInternalFrame("Paleta de Herramientas");
		internalFrame.setFrameIcon(new ImageIcon("imagenes/icono1.png"));
		internalFrame.setBounds(10, 66, 194, 294);
		//contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 11, 59, 54);
		internalFrame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(92, 11, 59, 54);
		internalFrame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("New button");
		button.setBounds(10, 76, 59, 54);
		internalFrame.getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(92, 76, 59, 54);
		internalFrame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(10, 141, 59, 54);
		internalFrame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(92, 141, 59, 54);
		internalFrame.getContentPane().add(button_3);
		
		sliderVelocidad = new JSlider(1,10,1);
		sliderVelocidad.setFocusable(false);
		sliderVelocidad.setMajorTickSpacing(1);
		sliderVelocidad.setPaintTicks(true);
		sliderVelocidad.setBounds(10, 206, 158, 26);
		internalFrame.getContentPane().add(sliderVelocidad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dia normal", "Fines de semana", "Dia feriado"}));
		comboBox.setBounds(28, 243, 123, 20);
		internalFrame.getContentPane().add(comboBox);
		
		panelQuemados = new JPanel(new FlowLayout());
		//panelQuemados.setSize(-477, -246);
		panelQuemados.setBackground(Color.DARK_GRAY);
		panelQuemados.setBounds(30, 100, 500, 350);
		
		panelQuemados.add(new PanelSimulacion());
		contentPane.add(panelQuemados);
		
		JLabel lblNewLabel = new JLabel("Cubiculo Quemados");
		lblNewLabel.setBounds(20, 59, 116, 20);
		contentPane.add(lblNewLabel);
		
		textoDescripcion = new JTextArea();
		textoDescripcion.setEditable(false);
		textoDescripcion.setBounds(242, 515, 832, 95);
		//contentPane.add(textoDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(textoDescripcion);
		scrollPane.setBounds(242, 500, 832, 110);
		contentPane.add(scrollPane);
		internalFrame.setVisible(true);

		
		//agregarCubiculos();
		
	}
	
	public void agregarAPanel(JPanel panel, int cantidad) {
		
		for (int i = 0; i < cantidad; i++) {
			JLabel labelPaciente = new JLabel();
			labelPaciente.setVisible(false);
			labelPaciente.setBorder(BorderFactory.createBevelBorder(1, Color.BLUE, Color.gray));
			labelPaciente.setIcon(new ImageIcon("imagenes/paciente.png"));
			panel.add(labelPaciente);
		}
	}
	
	public void mostrar(JPanel panel ,int cantidad) {
		
		Component[] components = panel.getComponents();
		
		for (int i = 0; i < components.length; i++) {
			components[i].setVisible(false);
		}
		
		for (int i = 0; i < cantidad; i++) {
			components[i].setVisible(true);
		}
	}
	
	public void agregarCubiculos() {
		agregarAPanel(panelQuemados, 2);
	}
}
