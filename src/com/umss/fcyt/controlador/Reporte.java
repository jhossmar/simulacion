package com.umss.fcyt.controlador;


import com.umss.fcyt.modelo.EstadoFinal;
import com.umss.fcyt.modelo.SalaEmergencias;    
import com.umss.fcyt.modelo.TipoPaciente;

import java.awt.Color; 
import org.jfree.chart.*; 

import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.data.general.DefaultPieDataset;

import java.util.ArrayList; 

import javax.swing.JFrame;
public class Reporte {
	
	private ArrayList<String>lista;
	private ArrayList<Integer>valores;
	private ArrayList<String> nombres;
	private ArrayList<Integer> tiemposEspera;
	private ArrayList<Integer> tiemposAtencion;
	private ArrayList<TipoPaciente> cubiculo;
	private ArrayList<Integer> horaEntrada;
	private ArrayList<Integer> horaSalida;
	private ArrayList<EstadoFinal> estadoFinal;
	
	SalaEmergencias sala;
	
	public Reporte(ArrayList<String>lista, SalaEmergencias sala){
		 this.lista = lista;
		 this.sala = sala;
		 ArrayList<Integer>valores = sala.getDatos();
		 this.valores = valores;
		 ArrayList<String> nombres = sala.getNombres();
		 this.nombres = nombres;
		 ArrayList<Integer> tiemposEspera = sala.getTiempoEspera();
		 this.tiemposEspera = tiemposEspera;
		 ArrayList<Integer> tiemposAtencion = sala.getTiempoAtencion();
		 this.tiemposAtencion = tiemposAtencion;
		 
		 ArrayList<TipoPaciente> cubiculo = sala.getCubiculo();
		 this.cubiculo = cubiculo;
		 ArrayList<Integer> horaEntrada = sala.getHoraEntrada();
		 this.horaEntrada = horaEntrada;
		 ArrayList<Integer> horaSalida = sala.getHoraSalida();
		 this.horaSalida = horaSalida;
		 ArrayList<EstadoFinal> estadoFinal = sala.getEstadoFinal();
		 this.estadoFinal = estadoFinal;
	}
	public void crearGraficoCircular(){
		
		DefaultPieDataset data = new DefaultPieDataset();
		for(int i = 0;i<lista.size();i++){
			String variable = lista.get(i);
			if(variable == "Tiempo de Espera"){
				
				graficarCircularTiempoEspera(nombres,tiemposEspera);
				
			}else{
				if(variable == "Tiempo de Atencion"){
					
					graficarCircularTiempoAtencion(nombres,tiemposAtencion);
					
				}else{
			if(variable == "Pacientes dados de Alta"){
				int valor = valores.get(3);
				data.setValue(variable, valor);
			}else{
				if(variable == "Pacientes Internados"){
					int valor = valores.get(4);
					data.setValue(variable, valor);
				}else{
					if(variable == "Pacientes Fechas Reprogramadas"){
						int valor = valores.get(5);
						data.setValue(variable, valor);
					}else{
						if(variable == "Pacientes Fallecidos"){
							int valor = valores.get(6);
							data.setValue(variable, valor);
						}else{
							if(variable == "Pacientes Consulta Externa"){
								int valor = valores.get(7);
								data.setValue(variable, valor);
							}
						}
					}
					}
				}
				}
			}
			}
		JFreeChart chart = ChartFactory.createPieChart(
		         "REPORTE EN GRAFICO CIRCULAR DE LOS RESULTADOS DE LOS PACIENTES",
		         data,
		         true,
		         true,
		         false);
		ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setLocation(0, 430);
        frame.setVisible(true);
        
	}
	public void graficarCircularTiempoAtencion(ArrayList<String>nombres,ArrayList<Integer>tiemposAtencion){
		DefaultPieDataset data = new DefaultPieDataset();
		for(int i = 0;i<nombres.size();i++){
			data.setValue(nombres.get(i), tiemposAtencion.get(i));
		}
		JFreeChart chart = ChartFactory.createPieChart(
		         "REPORTE EN GRAFICO CIRCULAR DE LOS TIEMPOS DE ATENCION",
		         data,
		         true,
		         true,
		         false);
		ChartFrame frame = new ChartFrame("JFreeChart", chart);
       frame.pack();
       frame.setVisible(true);
	}
	public void graficarCircularTiempoEspera(ArrayList<String>nombres,ArrayList<Integer>tiemposEspera){
		DefaultPieDataset data = new DefaultPieDataset();
		for(int i = 0;i<nombres.size();i++){
			data.setValue(nombres.get(i), tiemposEspera.get(i));
		}
		JFreeChart chart = ChartFactory.createPieChart(
		         "REPORTE EN GRAFICO CIRCULAR DE LOS TIEMPOS DE ESPERA",
		         data,
		         true,
		         true,
		         false);
		ChartFrame frame = new ChartFrame("JFreeChart", chart);
       frame.pack();
       frame.setLocation(750, 0);
       frame.setVisible(true);
	}
	public void graficarBarra(){
		
		ChartPanel panel;
		JFreeChart chart = null;
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		for(int i = 0;i<lista.size();i++){
			String variable = lista.get(i);
			String resultado = "Resultado Final";
			if(variable == "Cantidad de Pacientes"){
				int valor = valores.get(0);
				data.addValue(valor, variable, variable);
			}else{
				if(variable == "Tiempo de Espera"){
					
					graficarBarraTiempoEspera(nombres,tiemposEspera);
					
				}else{
					if(variable == "Tiempo de Atencion"){
						
						graficarBarraTiempoAtencion(nombres,tiemposAtencion);
						
					}else{
						if(variable == "Pacientes dados de Alta"){
							int valor = valores.get(3);
							data.addValue(valor, variable, resultado);
						}else{
							if(variable == "Pacientes Internados"){
								int valor = valores.get(4);
								data.addValue(valor, variable, resultado);
							}else{
								if(variable == "Pacientes Fechas Reprogramadas"){
									int valor = valores.get(5);
									data.addValue(valor, variable, resultado);
								}else{
									if(variable == "Pacientes Fallecidos"){
										int valor = valores.get(6);
										data.addValue(valor, variable, resultado);
									}else{
										if(variable == "Pacientes Consulta Externa"){
											int valor = valores.get(7);
											data.addValue(valor, variable, resultado);
										}
									}
								}
							}
						}
					}
				}
			}
			}
		chart = ChartFactory.createBarChart("REPORTE EN GRAFICO DE BARRAS DE LA SIMULACION",
				"",
				"",
				data,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		chart.setBackgroundPaint(Color.cyan);
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);
		
		panel = new ChartPanel(chart);
		panel.setBounds(5, 10, 410, 400);
		
		ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setLocation(0, 430);
        frame.setVisible(true);
	}
	
	public void graficarBarraTiempoEspera(ArrayList<String>nombres,ArrayList<Integer>tiemposEspera){
		ChartPanel panel;
		JFreeChart chart = null;
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		for(int i = 0; i<nombres.size(); i++){
			data.addValue(tiemposEspera.get(i), nombres.get(i), nombres.get(i));
		}
		chart = ChartFactory.createBarChart("REPORTE EN GRAFICO DE BARRAS DE LOS TIEMPOS DE ESPERA",
				"",
				"",
				data,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		chart.setBackgroundPaint(Color.cyan);
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);
		
		panel = new ChartPanel(chart);
		panel.setBounds(5, 10, 410, 400);
		
		ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setLocation(750, 0);
        frame.setVisible(true);
	}
	public void graficarBarraTiempoAtencion(ArrayList<String>nombres,ArrayList<Integer>tiemposAtencion){
		ChartPanel panel;
		JFreeChart chart = null;
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		for(int i = 0; i<nombres.size(); i++){
			data.addValue(tiemposAtencion.get(i), nombres.get(i), nombres.get(i));
		}
		chart = ChartFactory.createBarChart("REPORTE EN GRAFICO DE BARRAS DE LOS TIEMPOS DE ATENCION",
				"",
				"",
				data,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		chart.setBackgroundPaint(Color.cyan);
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);
		
		panel = new ChartPanel(chart);
		panel.setBounds(500, 50, 510, 500);
		
		ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);
	}
	
	public String[] getTabla(String variable){
		String [] res = new String [2];
		
		if(variable == "Cantidad de Pacientes"){
			int valor = valores.get(0);
			res[0] = variable;
			res[1] = ""+valor;
		}else{
			if(variable == "Tiempo de Espera"){
				int valor = valores.get(1);
				res[0] = variable;
				res[1] = ""+valor;
			}else{
				if(variable == "Tiempo de Atencion"){
					int valor = valores.get(2);
					res[0] = variable;
					res[1] = ""+valor;
				}else{
					if(variable == "Pacientes dados de Alta"){
						int valor = valores.get(3);
						res[0] = variable;
						res[1] = ""+valor;
					}else{
						if(variable == "Pacientes Internados"){
							int valor = valores.get(4);
							res[0] = variable;
							res[1] = ""+valor;
						}else{
							if(variable == "Pacientes Fechas Reprogramadas"){
								int valor = valores.get(5);
								res[0] = variable;
								res[1] = ""+valor;
							}else{
								if(variable == "Pacientes Fallecidos"){
									int valor = valores.get(6);
									res[0] = variable;
									res[1] = ""+valor;
								}else{
									if(variable == "Pacientes Consulta Externa"){
										int valor = valores.get(7);
										res[0] = variable;
										res[1] = ""+valor;
									}
								}
							}
						}
					}
				}
			}
		}
		return res;
	}
	public String [] getReporteTabla(int pos){
		String [] filas = new String[6];
		filas[0] = nombres.get(pos);
		filas[1] = tiemposAtencion.get(pos)+"";
		filas[2] = cubiculo.get(pos)+"";
		filas[3] = horaEntrada.get(pos)+"";
		filas[4] = horaSalida.get(pos)+"";
		filas[5] = estadoFinal.get(pos)+"";
		return filas;
	}
}
