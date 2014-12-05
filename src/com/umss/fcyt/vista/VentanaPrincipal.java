package com.umss.fcyt.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JToolBar toolBar;
	private JButton btnGuardar;
	private JButton btnGenerarrepote;
	private JButton btnEjecutar;
	private JButton btnPausar;
	private JButton btnDetener;
	 public JPanel panelQuemados;
	 JPanel panelGraves;
	 JPanel panelInfecciosos;
	 JPanel panelNormales;
	 JPanel panelTriaje;

	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			//UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VentanaPrincipal frame = new VentanaPrincipal();
		frame.setVisible(true);
	}

	public VentanaPrincipal() {
		setResizable(false);
		setTitle("Simulador Sala de Emergencias");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/icono1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
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
		
		JMenuItem mntmEjecutar = new JMenuItem("Ejecutar");
		mnSimulacion.add(mntmEjecutar);
		
		JMenuItem mntmPausar = new JMenuItem("Pausar");
		mnSimulacion.add(mntmPausar);
		
		JMenuItem mntmReiniciar = new JMenuItem("Reiniciar");
		mnSimulacion.add(mntmReiniciar);
		
		JMenuItem mntmDetener = new JMenuItem("Detener ");
		mnSimulacion.add(mntmDetener);
		
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
		
		btnEjecutar = new JButton("Ejecutar");
		toolBar.add(btnEjecutar);
		
		btnPausar = new JButton("Pausar");
		toolBar.add(btnPausar);
		
		btnDetener = new JButton("Detener");
		toolBar.add(btnDetener);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		toolBar.add(btnReiniciar);
		
		JInternalFrame internalFrame = new JInternalFrame("Paleta de Herramientas");
		internalFrame.setFrameIcon(new ImageIcon("imagenes/icono1.png"));
		internalFrame.setBounds(10, 59, 194, 294);
		contentPane.add(internalFrame);
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
		
		JSlider slider = new JSlider();
		slider.setBounds(10, 206, 158, 26);
		internalFrame.getContentPane().add(slider);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dia normal", "Fines de semana", "Dia feriado"}));
		comboBox.setBounds(28, 243, 123, 20);
		internalFrame.getContentPane().add(comboBox);
		
		
		
		panelQuemados = new JPanel();
		panelQuemados.setBackground(Color.DARK_GRAY);
		panelQuemados.setBounds(242, 90, 401, 203);
		contentPane.add(panelQuemados);
		
		panelGraves = new JPanel();
		panelGraves.setBackground(Color.DARK_GRAY);
		panelGraves.setBounds(673, 90, 401, 203);
		contentPane.add(panelGraves);
		
		panelInfecciosos = new JPanel();
		panelInfecciosos.setBackground(Color.DARK_GRAY);
		panelInfecciosos.setBounds(242, 347, 401, 203);
		contentPane.add(panelInfecciosos);
		
		panelNormales = new JPanel();
		panelNormales.setBackground(Color.DARK_GRAY);
		panelNormales.setBounds(673, 347, 401, 203);
		contentPane.add(panelNormales);
		
		panelTriaje = new JPanel();
		panelTriaje.setBackground(Color.DARK_GRAY);
		panelTriaje.setBounds(10, 402, 210, 134);
		contentPane.add(panelTriaje);
		
		JLabel lblNewLabel = new JLabel("Cubiculo Quemados");
		lblNewLabel.setBounds(253, 59, 116, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblCubiculoPacientesGraves = new JLabel("Cubiculo Pacientes Graves");
		lblCubiculoPacientesGraves.setBounds(672, 59, 116, 20);
		contentPane.add(lblCubiculoPacientesGraves);
		
		JLabel lblCubiculoPacientesInfecciosos = new JLabel("Cubiculo Pacientes Infecciosos");
		lblCubiculoPacientesInfecciosos.setBounds(242, 316, 151, 20);
		contentPane.add(lblCubiculoPacientesInfecciosos);
		
		JLabel lblCubiculoPacientesNormales = new JLabel("Cubiculo Pacientes Normales");
		lblCubiculoPacientesNormales.setBounds(672, 316, 174, 20);
		contentPane.add(lblCubiculoPacientesNormales);
		
		JLabel lblTriaje = new JLabel("Triaje");
		lblTriaje.setBounds(20, 371, 116, 20);
		contentPane.add(lblTriaje);
		internalFrame.setVisible(true);

		agregarPaciente(panelTriaje);
	}
	
	public void eliminarPaciente(JPanel panel) {
		
		if(panel.getComponents().length != 0) {
			panel.remove(0);
			System.out.println("no se puedo");
		}
		
	}
	
	public void agregarPaciente(JPanel panel) {
		panel.setLayout(new FlowLayout(1, 10,10));
		
		JLabel laabelPaciente = new JLabel();
		laabelPaciente.setIcon(new ImageIcon("imagenes/icono1.png"));
		laabelPaciente.setBounds(20, 371, 116, 20);
		panel.add(laabelPaciente);
	}
}