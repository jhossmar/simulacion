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

import com.umss.fcyt.controlador.ControladorPanelSimulacion;
import com.umss.fcyt.simulaciongraficos.PanelSimulacion;

import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JToolBar toolBar;
	private JButton btnGuardar;
	public JButton btnGenerarrepote;
	
	public JMenuItem itemEjecutar;
	public JMenuItem itemPausar;
	public JMenuItem itemContinuar;
	public JMenuItem itemDetener;
	public JMenuItem mntmManualDeUsuario;
	
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
	public JTextArea txtAreaEnfermeraLicenciada;
	public JTextArea textAreaEnfermeraAuxiliar;
	public JTextArea textAreaMedicoTurno;
	public JTextArea textAreaPersonaEncargada;
	
	
	public JComboBox comboBoxEntidadResponsableDosCubiculo;
	public JComboBox comboBoxEntidadResponsableUnoCubiculo;
	
	public JComboBox comboBoxProcesoUno;
	public JComboBox comboBoxProcesoDos;
	public JComboBox comboBoxProcesoTres;
	public JComboBox comboBoxProcesoCuatro;
	public JComboBox comboBoxProcesoCinco;
	public JComboBox comboBoxProcesoSeis;
	
	public JComboBox comboBoxEntidadReponsableTriaje;
	
	public JLabel lblEntidadUnoTriaje;
	public JLabel lblEntidadDosTriaje;
	public JButton btnAceptarCambios;
	 
	public VentanaPrincipal() {
		inicializarVentana();
		
	}
	
	public void inicializarVentana() {
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
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmManualDeUsuario = new JMenuItem("Manual de Usuario");
		mnAyuda.add(mntmManualDeUsuario);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 21, 550, 27);
		contentPane.add(toolBar);
		
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
		//contentPane.add(panel);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLACK));
		panel_1.setBounds(30, 441, 1010, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblComportamientoDeEntidades = new JLabel("Comportamiento de Entidades");
		lblComportamientoDeEntidades.setBounds(10, 0, 252, 14);
		panel_1.add(lblComportamientoDeEntidades);
		
		JLabel lblEnfermeraLicenciada_2 = new JLabel("Enfermera Licenciada");
		lblEnfermeraLicenciada_2.setBounds(10, 21, 133, 14);
		panel_1.add(lblEnfermeraLicenciada_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 233, 112);
		panel_1.add(scrollPane);
		
		txtAreaEnfermeraLicenciada = new JTextArea();
		scrollPane.setViewportView(txtAreaEnfermeraLicenciada);
		
		JLabel lblEnfermeraAuxiliar_2 = new JLabel("Enfermera Auxiliar");
		lblEnfermeraAuxiliar_2.setBounds(263, 21, 133, 14);
		panel_1.add(lblEnfermeraAuxiliar_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(263, 46, 233, 112);
		panel_1.add(scrollPane_1);
		
		textAreaEnfermeraAuxiliar = new JTextArea();
		scrollPane_1.setViewportView(textAreaEnfermeraAuxiliar);
		
		JLabel lblMedicoDeTurno_4 = new JLabel("Medico de Turno");
		lblMedicoDeTurno_4.setBounds(521, 21, 117, 14);
		panel_1.add(lblMedicoDeTurno_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(521, 46, 233, 112);
		panel_1.add(scrollPane_2);
		
		textAreaMedicoTurno = new JTextArea();
		scrollPane_2.setViewportView(textAreaMedicoTurno);
		
		JLabel lblImagenEnfermeraLicenciada = new JLabel(new ImageIcon("imagenes/enfermeraLicenciadaCubiculo.png"));
		lblImagenEnfermeraLicenciada.setBounds(181, 0, 62, 48);
		panel_1.add(lblImagenEnfermeraLicenciada);
		
		JLabel labelImagenEnfermeraAxiliar = new JLabel(new ImageIcon("imagenes/enfermeraCubiculo.png"));
		labelImagenEnfermeraAxiliar.setBounds(434, 0, 62, 48);
		panel_1.add(labelImagenEnfermeraAxiliar);
		
		JLabel labelImagenDoctor = new JLabel(new ImageIcon("imagenes/doctorCubiculo.png"));
		labelImagenDoctor.setBounds(692, 0, 62, 48);
		panel_1.add(labelImagenDoctor);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(588, 64, 496, 95);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Procesos");
		lblNewLabel_1.setBounds(40, 11, 126, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblEntidadResponsable_1 = new JLabel("Entidad Responsable");
		lblEntidadResponsable_1.setBounds(319, 11, 145, 14);
		panel_2.add(lblEntidadResponsable_1);
		
		JLabel lblRealizarEvaluacion = new JLabel("1.- Realizar Evaluacion ");
		lblRealizarEvaluacion.setBounds(10, 44, 215, 14);
		panel_2.add(lblRealizarEvaluacion);
		
		JLabel lblDesignarA_1 = new JLabel("3.- Designar a un Cubiculo");
		lblDesignarA_1.setBounds(10, 73, 215, 14);
		panel_2.add(lblDesignarA_1);
		
		lblEntidadUnoTriaje = new JLabel("");
		lblEntidadUnoTriaje.setBounds(310, 36, 154, 14);
		panel_2.add(lblEntidadUnoTriaje);
		
		lblEntidadDosTriaje = new JLabel("");
		lblEntidadDosTriaje.setBounds(310, 73, 154, 14);
		panel_2.add(lblEntidadDosTriaje);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setBounds(588, 219, 496, 211);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblProcesos = new JLabel("Procesos");
		lblProcesos.setBounds(29, 0, 92, 14);
		panel_3.add(lblProcesos);
		
		JLabel lblEntidadResponsable_2 = new JLabel("Entidad Responsable");
		lblEntidadResponsable_2.setBounds(294, 0, 157, 14);
		panel_3.add(lblEntidadResponsable_2);
		
		JLabel lblTenderEn = new JLabel("1.- Tender en Camilla");
		lblTenderEn.setBounds(10, 44, 227, 14);
		panel_3.add(lblTenderEn);
		
		JLabel lblQuitarVestimenta = new JLabel("2.- Quitar Vestimenta");
		lblQuitarVestimenta.setBounds(10, 69, 227, 14);
		panel_3.add(lblQuitarVestimenta);
		
		JLabel lblAplicarCompresas = new JLabel("3.- Aplicar compresas Frias");
		lblAplicarCompresas.setBounds(10, 94, 227, 14);
		panel_3.add(lblAplicarCompresas);
		
		JLabel lblCubrirCon = new JLabel("4.- Cubrir con Sabanas y Mantas");
		lblCubrirCon.setBounds(10, 119, 227, 14);
		panel_3.add(lblCubrirCon);
		
		JLabel lblAplicarAnalgesico = new JLabel("5.- Aplicar Analgesico");
		lblAplicarAnalgesico.setBounds(10, 144, 227, 14);
		panel_3.add(lblAplicarAnalgesico);
		
		JLabel lblAdministrarVacuna = new JLabel("6.- Administrar Vacuna");
		lblAdministrarVacuna.setBounds(10, 169, 227, 14);
		panel_3.add(lblAdministrarVacuna);
		
		comboBoxProcesoUno = new JComboBox();
		comboBoxProcesoUno.setBounds(294, 41, 166, 20);
		panel_3.add(comboBoxProcesoUno);
		
		comboBoxProcesoDos = new JComboBox();
		comboBoxProcesoDos.setBounds(294, 66, 166, 20);
		panel_3.add(comboBoxProcesoDos);
		
		comboBoxProcesoTres = new JComboBox();
		comboBoxProcesoTres.setBounds(294, 91, 166, 20);
		panel_3.add(comboBoxProcesoTres);
		
		comboBoxProcesoCuatro = new JComboBox();
		comboBoxProcesoCuatro.setBounds(294, 116, 166, 20);
		panel_3.add(comboBoxProcesoCuatro);
		
		comboBoxProcesoCinco = new JComboBox();
		comboBoxProcesoCinco.setBounds(294, 141, 166, 20);
		panel_3.add(comboBoxProcesoCinco);
		
		comboBoxProcesoSeis = new JComboBox();
		comboBoxProcesoSeis.setBounds(294, 166, 166, 20);
		panel_3.add(comboBoxProcesoSeis);
		
		btnAceptarCambios = new JButton("Aceptar Cambios");
		btnAceptarCambios.setBounds(167, 188, 130, 23);
		panel_3.add(btnAceptarCambios);
		
		JLabel lblLocacionTriaje = new JLabel("Locacion : Triaje");
		lblLocacionTriaje.setBounds(588, 49, 99, 14);
		contentPane.add(lblLocacionTriaje);
		
		JLabel lblLocacionCubiculo = new JLabel("Locacion : Cubiculo de Quemados");
		lblLocacionCubiculo.setBounds(588, 169, 204, 14);
		contentPane.add(lblLocacionCubiculo);
		
		comboBoxEntidadReponsableTriaje = new JComboBox();
		comboBoxEntidadReponsableTriaje.setBounds(911, 46, 174, 20);
		contentPane.add(comboBoxEntidadReponsableTriaje);
		
		comboBoxEntidadResponsableDosCubiculo = new JComboBox();
		comboBoxEntidadResponsableDosCubiculo.setBounds(942, 194, 142, 20);
		contentPane.add(comboBoxEntidadResponsableDosCubiculo);
		
		comboBoxEntidadResponsableUnoCubiculo = new JComboBox();
		comboBoxEntidadResponsableUnoCubiculo.setBounds(783, 194, 149, 20);
		contentPane.add(comboBoxEntidadResponsableUnoCubiculo);
		
		JLabel lblResponsable = new JLabel("Responsable");
		lblResponsable.setBounds(795, 49, 106, 14);
		contentPane.add(lblResponsable);
		
		JLabel lblEntidadesResponsable = new JLabel("Entidades Responsable");
		lblEntidadesResponsable.setBounds(588, 194, 185, 20);
		contentPane.add(lblEntidadesResponsable);
		
		JLabel lblPersonaEncargada_3 = new JLabel("Persona Encargada");
		lblPersonaEncargada_3.setBounds(776, 21, 133, 14);
		//panel_1.add(lblPersonaEncargada_3);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(764, 46, 236, 112);
		//panel_1.add(scrollPane_3);
		
		textAreaPersonaEncargada = new JTextArea();
		scrollPane_3.setViewportView(textAreaPersonaEncargada);
		internalFrame.setVisible(true);
		//agregarCubiculos();
		
		ControladorPanelSimulacion controladorPanelSimulacion = new ControladorPanelSimulacion(this);
	}
}
