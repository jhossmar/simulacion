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
	 public JPanel panelGraves;
	 public JPanel panelInfecciosos;
	 public JPanel panelNormales;
	 public JPanel panelTriaje;
	

	int contador =0;
	public JSlider sliderVelocidad;
	public JTextArea textoDescripcion;
	public JLabel labelHora;
	 
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
		
		JMenuItem mntmGuardarDiseo = new JMenuItem("Guardar Dise\u00F1o");
		mnArchivo.add(mntmGuardarDiseo);
		
		JMenuItem mntmAbrirDiseo = new JMenuItem("Abrir Dise\u00F1o");
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
		
		panelQuemados = new JPanel();
		panelQuemados.setBackground(Color.DARK_GRAY);
		panelQuemados.setBounds(242, 110, 401, 175);
		contentPane.add(panelQuemados);
		
		panelGraves = new JPanel();
		panelGraves.setBackground(Color.DARK_GRAY);
		panelGraves.setBounds(673, 110, 401, 175);
		contentPane.add(panelGraves);
		
		panelInfecciosos = new JPanel();
		panelInfecciosos.setBackground(Color.DARK_GRAY);
		panelInfecciosos.setBounds(242, 316, 401, 175);
		contentPane.add(panelInfecciosos);
		
		panelNormales = new JPanel();
		panelNormales.setBackground(Color.DARK_GRAY);
		panelNormales.setBounds(673, 316, 401, 175);
		contentPane.add(panelNormales);
		
		panelTriaje = new JPanel();
		panelTriaje.setBackground(Color.DARK_GRAY);
		panelTriaje.setBounds(10, 402, 210, 134);
		contentPane.add(panelTriaje);
		
		JLabel lblNewLabel = new JLabel("Cubiculo Quemados");
		lblNewLabel.setBounds(242, 79, 116, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblCubiculoPacientesGraves = new JLabel("Cubiculo Pacientes Graves");
		lblCubiculoPacientesGraves.setBounds(673, 79, 174, 20);
		contentPane.add(lblCubiculoPacientesGraves);
		
		JLabel lblCubiculoPacientesInfecciosos = new JLabel("Cubiculo Pacientes Infecciosos");
		lblCubiculoPacientesInfecciosos.setBounds(242, 296, 198, 20);
		contentPane.add(lblCubiculoPacientesInfecciosos);
		
		JLabel lblCubiculoPacientesNormales = new JLabel("Cubiculo Pacientes Normales");
		lblCubiculoPacientesNormales.setBounds(673, 296, 174, 20);
		contentPane.add(lblCubiculoPacientesNormales);
		
		JLabel lblTriaje = new JLabel("Triaje");
		lblTriaje.setBounds(20, 371, 116, 20);
		contentPane.add(lblTriaje);
		
		textoDescripcion = new JTextArea();
		textoDescripcion.setEditable(false);
		textoDescripcion.setBounds(242, 515, 832, 95);
		//contentPane.add(textoDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(textoDescripcion);
		scrollPane.setBounds(242, 500, 832, 110);
		contentPane.add(scrollPane);
		
		JLabel lblHora = new JLabel("Hora :");
		lblHora.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblHora.setBounds(613, 42, 62, 14);
		contentPane.add(lblHora);
		
		labelHora = new JLabel("00:00");
		labelHora.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		labelHora.setBounds(680, 42, 62, 14);
		contentPane.add(labelHora);
		internalFrame.setVisible(true);

		
		agregarCubiculos();
		
	}
	
	public void agregarAPanel(JPanel panel, int cantidad) {
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10 , 10));
		
		for (int i = 0; i < cantidad; i++) {
			JLabel labelPaciente = new JLabel();
			labelPaciente.setVisible(false);
			labelPaciente.setBorder(BorderFactory.createBevelBorder(1, Color.BLUE, Color.gray));
			labelPaciente.setIcon(new ImageIcon("imagenes/paciente.png"));
			panel.add(labelPaciente);
		}
		
		panel.updateUI();
	}
	
	public void mostrar(JPanel panel ,int cantidad) {
		
		Component[] components = panel.getComponents();
		
		for (int i = 0; i < components.length; i++) {
			components[i].setVisible(false);
		}
		
		for (int i = 0; i < cantidad; i++) {
			components[i].setVisible(true);
		}
		
//		Component[] components = panel.getComponents();
//		int j = 0;
//		for (int i = 0; i < cantidad; i++) {
//			components[i].setVisible(true);
//			j = i;
//		}
//		
//		for (int i = j + 1; i < components.length; i++) {
//			components[i].setVisible(false);
//		}
	}
	
	public void agregarCubiculos() {
		agregarAPanel(panelGraves, 2);
		agregarAPanel(panelQuemados, 2);
		agregarAPanel(panelInfecciosos, 2);
		agregarAPanel(panelNormales, 2);
		
		agregarAPanel(panelTriaje, 20);
	}
}
