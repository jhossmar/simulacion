package com.umss.fcyt.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import com.umss.fcyt.modelo.Entidad;
import com.umss.fcyt.modelo.simulacion.ProcesoAtencionAQuemados;
import com.umss.fcyt.modelo.simulacion.ProcesoAtencionTriaje;
import com.umss.fcyt.vista.VentanaPrincipal;

public class ControladorPanelSimulacion implements ItemListener, ActionListener {

	VentanaPrincipal ventanaPrincipal;
	ArrayList<String> entidadesResponsables;
	ArrayList<String> entidadesResponsablesProcesos = new ArrayList<String>();

	Entidad entidadCubiculo;
	Entidad entidadCubiculoDos;
	Entidad entidadTriaje;
	
	ArrayList<String> procesosUno = new ArrayList<String>();
	ArrayList<String> procesosDos = new ArrayList<String>();

	boolean tieneElementos = false;
	
	ProcesoAtencionAQuemados procesoQuemados = new ProcesoAtencionAQuemados();

	public ControladorPanelSimulacion(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		inicializarEntidadesResponsables();
		agregarTextoACombosResponsables();

		agregarListener();
	}

	public void agregarListener() {
		ventanaPrincipal.comboBoxEntidadReponsableTriaje.addItemListener(this);
		ventanaPrincipal.comboBoxEntidadResponsableUnoCubiculo
				.addItemListener(this);
		ventanaPrincipal.comboBoxEntidadResponsableDosCubiculo
				.addItemListener(this);

		ventanaPrincipal.btnAceptarCambios.addActionListener(this);
		
		ventanaPrincipal.comboBoxProcesoUno.addItemListener(this);
		ventanaPrincipal.comboBoxProcesoDos.addItemListener(this);
		ventanaPrincipal.comboBoxProcesoTres.addItemListener(this);
		ventanaPrincipal.comboBoxProcesoCuatro.addItemListener(this);
		ventanaPrincipal.comboBoxProcesoCinco.addItemListener(this);
		ventanaPrincipal.comboBoxProcesoSeis.addItemListener(this);
	}

	public void agregarTextoACombosResponsables() {

		ventanaPrincipal.comboBoxEntidadReponsableTriaje.addItem("");
		ventanaPrincipal.comboBoxEntidadResponsableUnoCubiculo.addItem("");
		ventanaPrincipal.comboBoxEntidadResponsableDosCubiculo.addItem("");
		for (String responsable : entidadesResponsables) {
			ventanaPrincipal.comboBoxEntidadReponsableTriaje
					.addItem(responsable);
			ventanaPrincipal.comboBoxEntidadResponsableUnoCubiculo
					.addItem(responsable);
			ventanaPrincipal.comboBoxEntidadResponsableDosCubiculo
					.addItem(responsable);
		}
		
		ventanaPrincipal.comboBoxProcesoUno.addItem("");
		ventanaPrincipal.comboBoxProcesoDos.addItem("");
		ventanaPrincipal.comboBoxProcesoTres.addItem("");
		ventanaPrincipal.comboBoxProcesoCuatro.addItem("");
		ventanaPrincipal.comboBoxProcesoCinco.addItem("");
		ventanaPrincipal.comboBoxProcesoSeis.addItem("");
	}

	public void inicializarEntidadesResponsables() {
		this.entidadesResponsables = new ArrayList<String>();
		this.entidadesResponsables.add("Medico de Turno");
		this.entidadesResponsables.add("Enfermera Auxiliar");
		this.entidadesResponsables.add("Enfermera Licenciada");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == ventanaPrincipal.comboBoxEntidadReponsableTriaje) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				this.entidadTriaje = new Entidad("", "", new ArrayList<String>());
				String tipo = "" + e.getItem();
				if(tipo.equalsIgnoreCase("Medico de Turno")) {
					entidadTriaje.setNombreImagen("imagenes/doctorTriaje.png");
				} else if(tipo.equalsIgnoreCase("Enfermera Auxiliar")) {
					entidadTriaje.setNombreImagen("imagenes/enfermeraTriaje.png");
				} else if(tipo.equalsIgnoreCase("Enfermera Licenciada")) {
					entidadTriaje.setNombreImagen("imagenes/enfermeraLicenciadaTriaje.gif");
				}
				entidadTriaje.setNombreEntidad(tipo);
				ProcesoAtencionTriaje proceso = new ProcesoAtencionTriaje();
				entidadTriaje.setProcesos(proceso.getProcesos());
				ventanaPrincipal.lblEntidadUnoTriaje.setText(tipo);
				ventanaPrincipal.lblEntidadDosTriaje.setText(tipo);
			}
		}

		if (e.getSource() == ventanaPrincipal.comboBoxEntidadResponsableUnoCubiculo) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				ventanaPrincipal.comboBoxProcesoUno.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoDos.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoTres.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoCuatro.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoCinco.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoSeis.addItem(e.getItem());
				
				entidadCubiculo = new Entidad("", "", new ArrayList<String>());
				String tipo = "" + e.getItem();
				if(tipo.equalsIgnoreCase("Medico de Turno")) {
					entidadCubiculo.setNombreImagen("imagenes/doctorCubiculo.png");
				} else if(tipo.equalsIgnoreCase("Enfermera Auxiliar")) {
					entidadCubiculo.setNombreImagen("imagenes/enfermeraCubiculo.png");
				} else if(tipo.equalsIgnoreCase("Enfermera Licenciada")) {
					entidadCubiculo.setNombreImagen("imagenes/enfermeraLicenciadaCubiculo.png");
				}
				
				entidadCubiculo.setNombreEntidad(tipo);
				
			}
		}

		if (e.getSource() == ventanaPrincipal.comboBoxEntidadResponsableDosCubiculo) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				ventanaPrincipal.comboBoxProcesoUno.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoDos.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoTres.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoCuatro.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoCinco.addItem(e.getItem());
				ventanaPrincipal.comboBoxProcesoSeis.addItem(e.getItem());
				
				entidadCubiculoDos = new Entidad("", "", new ArrayList<String>());
				String tipo = "" + e.getItem();
				if(tipo.equalsIgnoreCase("Medico de Turno")) {
					entidadCubiculoDos.setNombreImagen("imagenes/doctorCubiculo.png");
				} else if(tipo.equalsIgnoreCase("Enfermera Auxiliar")) {
					entidadCubiculoDos.setNombreImagen("imagenes/enfermeraCubiculo.png");
				} else if(tipo.equalsIgnoreCase("Enfermera Licenciada")) {
					entidadCubiculoDos.setNombreImagen("imagenes/enfermeraLicenciadaCubiculo.png");
				}
				
				entidadCubiculoDos.setNombreEntidad(tipo);
			}
		}

		if (e.getSource() == ventanaPrincipal.comboBoxProcesoUno) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String tipoEntidad = "" + e.getItem();
				if(tipoEntidad.equalsIgnoreCase(entidadCubiculo.getNombreEntidad())) {
					this.procesosUno.add(this.procesoQuemados.getProcesos().get(0));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(0));
				} else if(tipoEntidad.equalsIgnoreCase(entidadCubiculoDos.getNombreEntidad())) {
					this.procesosDos.add(this.procesoQuemados.getProcesos().get(0));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(0));
				}
			}
		}
		if (e.getSource() == ventanaPrincipal.comboBoxProcesoDos) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String tipoEntidad = "" + e.getItem();
				if(tipoEntidad.equalsIgnoreCase(entidadCubiculo.getNombreEntidad())) {
					this.procesosUno.add(this.procesoQuemados.getProcesos().get(1));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(1));
				} else if(tipoEntidad.equalsIgnoreCase(entidadCubiculoDos.getNombreEntidad())) {
					this.procesosDos.add(this.procesoQuemados.getProcesos().get(1));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(1));
				}
			}
		}
		if (e.getSource() == ventanaPrincipal.comboBoxProcesoTres) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String tipoEntidad = "" + e.getItem();
				if(tipoEntidad.equalsIgnoreCase(entidadCubiculo.getNombreEntidad())) {
					this.procesosUno.add(this.procesoQuemados.getProcesos().get(2));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(2));
				} else if(tipoEntidad.equalsIgnoreCase(entidadCubiculoDos.getNombreEntidad())) {
					this.procesosDos.add(this.procesoQuemados.getProcesos().get(2));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(2));
				}
			}
		}
		if (e.getSource() == ventanaPrincipal.comboBoxProcesoCuatro) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String tipoEntidad = "" + e.getItem();
				if(tipoEntidad.equalsIgnoreCase(entidadCubiculo.getNombreEntidad())) {
					this.procesosUno.add(this.procesoQuemados.getProcesos().get(3));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(3));
				} else if(tipoEntidad.equalsIgnoreCase(entidadCubiculoDos.getNombreEntidad())) {
					this.procesosDos.add(this.procesoQuemados.getProcesos().get(3));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(3));
				}
			}
		}
		
		if (e.getSource() == ventanaPrincipal.comboBoxProcesoCinco) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String tipoEntidad = "" + e.getItem();
				if(tipoEntidad.equalsIgnoreCase(entidadCubiculo.getNombreEntidad())) {
					this.procesosUno.add(this.procesoQuemados.getProcesos().get(4));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(4));
				} else if(tipoEntidad.equalsIgnoreCase(entidadCubiculoDos.getNombreEntidad())) {
					this.procesosDos.add(this.procesoQuemados.getProcesos().get(4));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(4));
				}
			}
		}
		
		if (e.getSource() == ventanaPrincipal.comboBoxProcesoSeis) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String tipoEntidad = "" + e.getItem();
				if(tipoEntidad.equalsIgnoreCase(entidadCubiculo.getNombreEntidad())) {
					this.procesosUno.add(this.procesoQuemados.getProcesos().get(5));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(5));
				} else if(tipoEntidad.equalsIgnoreCase(entidadCubiculoDos.getNombreEntidad())) {
					this.procesosDos.add(this.procesoQuemados.getProcesos().get(5));
					System.out.println(tipoEntidad + "" + procesoQuemados.getProcesos().get(5));
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaPrincipal.btnAceptarCambios) {
			this.entidadCubiculo.setProcesos(procesosUno);
			this.entidadCubiculoDos.setProcesos(procesosDos);
			
			System.out.println(entidadCubiculo.toString());
			System.out.println();
			System.out.println(entidadCubiculoDos.toString());
			
			ventanaPrincipal.panelSimulacion.entidadCubiculoUno = this.entidadCubiculo;
			ventanaPrincipal.panelSimulacion.entidadCubiculoDos = this.entidadCubiculoDos;
			ventanaPrincipal.panelSimulacion.entidadTriajenew = this.entidadTriaje;
			
			ventanaPrincipal.panelSimulacion.agregarDoctores();
			ventanaPrincipal.panelSimulacion.agregarEnfermeras();
			
			ventanaPrincipal.panelSimulacion.terminadoAsignacion = true;
			ventanaPrincipal.panelSimulacion.repaint();
			ventanaPrincipal.panelSimulacion.updateUI();
			ventanaPrincipal.btnAceptarCambios.disable();
		}
	}
}
