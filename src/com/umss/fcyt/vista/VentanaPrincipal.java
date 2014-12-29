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
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

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
	public JButton botonPausar;
	public JButton botonDetener;
	public JButton botonContinuar;
	
	 //panel de graficos
	 public JPanel panelQuemados;
	 public PanelSimulacion panelSimulacion;
	

	int contador =0;
	public JSlider sliderVelocidad;
	 
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
		panelQuemados.setBounds(30, 80, 500, 350);
		
		panelSimulacion = new PanelSimulacion();
		panelSimulacion.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelQuemados.add(panelSimulacion);
		contentPane.add(panelQuemados);
		
		JLabel lblNewLabel = new JLabel("Locacion: Cubiculo Quemados");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(28, 49, 242, 20);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		getContentPane().setLayout(null);
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(595, 80, 445, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblJerarquiaDeProcesos = new JLabel("Jerarquia de Procesos");
		lblJerarquiaDeProcesos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblJerarquiaDeProcesos.setBounds(66, 11, 164, 24);
		panel.add(lblJerarquiaDeProcesos);
		
		JLabel lblEntidadResponsable = new JLabel("Entidad Responsable");
		lblEntidadResponsable.setBackground(new Color(47, 79, 79));
		lblEntidadResponsable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblEntidadResponsable.setBounds(280, 11, 135, 24);
		panel.add(lblEntidadResponsable);
		
		JLabel lblLlevarAl = new JLabel("1.- Llevar al Paciente a Triaje");
		lblLlevarAl.setBounds(29, 56, 191, 14);
		panel.add(lblLlevarAl);
		
		JLabel lblRealizarRevision = new JLabel("2.- Realizar revision del paciente");
		lblRealizarRevision.setBounds(29, 81, 191, 14);
		panel.add(lblRealizarRevision);
		
		JLabel lblDesignarA = new JLabel("3.- Designar a un cubiculo");
		lblDesignarA.setBounds(29, 106, 191, 14);
		panel.add(lblDesignarA);
		
		JLabel lblLlevarAl_1 = new JLabel("4.- Llevar al Paciente al cubiculo respectivo");
		lblLlevarAl_1.setBounds(29, 131, 215, 14);
		panel.add(lblLlevarAl_1);
		
		JLabel lblTenderAl = new JLabel("5.- Tender al paciente en la camilla");
		lblTenderAl.setBounds(29, 156, 215, 14);
		panel.add(lblTenderAl);
		
		JLabel lblQuitarRopas = new JLabel("6.- Quitar Ropas de Vestir y anillos");
		lblQuitarRopas.setBounds(29, 181, 221, 14);
		panel.add(lblQuitarRopas);
		
		JLabel lblDetenerEl = new JLabel("7.- Detener el proceso que indujo la quemadura");
		lblDetenerEl.setBounds(28, 206, 242, 14);
		panel.add(lblDetenerEl);
		
		JLabel lblIrrigarLa = new JLabel("8.- Irrigar la zona con solucion fria de suero");
		lblIrrigarLa.setBounds(27, 231, 243, 14);
		panel.add(lblIrrigarLa);
		
		JLabel lblCubrirAl = new JLabel("9.- Cubrir al paciente con sabanas limpias");
		lblCubrirAl.setBounds(29, 256, 241, 14);
		panel.add(lblCubrirAl);
		
		JLabel lblDarDe = new JLabel("10.- Dar de alta");
		lblDarDe.setBounds(28, 281, 242, 14);
		panel.add(lblDarDe);
		
		JLabel lblLlevarAl_2 = new JLabel("11.- Llevar al paciente donde se lo designo");
		lblLlevarAl_2.setBounds(29, 310, 241, 14);
		panel.add(lblLlevarAl_2);
		
		JLabel lblPersonaEncargada = new JLabel("Persona Encargada");
		lblPersonaEncargada.setBounds(290, 56, 143, 14);
		panel.add(lblPersonaEncargada);
		
		JLabel lblEnfermeraLicenciada = new JLabel("Enfermera Licenciada");
		lblEnfermeraLicenciada.setBounds(290, 81, 143, 14);
		panel.add(lblEnfermeraLicenciada);
		
		JLabel lblEnfermeraLicenciada_1 = new JLabel("Enfermera Licenciada");
		lblEnfermeraLicenciada_1.setBounds(290, 106, 143, 14);
		panel.add(lblEnfermeraLicenciada_1);
		
		JLabel lblPersonaEncargada_1 = new JLabel("Persona Encargada");
		lblPersonaEncargada_1.setBounds(290, 131, 143, 14);
		panel.add(lblPersonaEncargada_1);
		
		JLabel lblEnfermeraAuxiliar = new JLabel("Enfermera Auxiliar");
		lblEnfermeraAuxiliar.setBounds(290, 156, 143, 14);
		panel.add(lblEnfermeraAuxiliar);
		
		JLabel lblEnfermeraAuxiliar_1 = new JLabel("Enfermera Auxiliar");
		lblEnfermeraAuxiliar_1.setBounds(290, 181, 133, 14);
		panel.add(lblEnfermeraAuxiliar_1);
		
		JLabel lblMedicoDeTurno = new JLabel("Medico de Turno");
		lblMedicoDeTurno.setBounds(290, 206, 143, 14);
		panel.add(lblMedicoDeTurno);
		
		JLabel lblMedicoDeTurno_1 = new JLabel("Medico de Turno");
		lblMedicoDeTurno_1.setBounds(290, 231, 133, 14);
		panel.add(lblMedicoDeTurno_1);
		
		JLabel lblMedicoDeTurno_2 = new JLabel("Medico de Turno");
		lblMedicoDeTurno_2.setBounds(290, 256, 143, 14);
		panel.add(lblMedicoDeTurno_2);
		
		JLabel lblMedicoDeTurno_3 = new JLabel("Medico de Turno");
		lblMedicoDeTurno_3.setBounds(290, 281, 135, 14);
		panel.add(lblMedicoDeTurno_3);
		
		JLabel lblPersonaEncargada_2 = new JLabel("Persona Encargada");
		lblPersonaEncargada_2.setBounds(290, 310, 130, 14);
		panel.add(lblPersonaEncargada_2);
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
