package com.umss.fcyt.controlador;


import com.umss.fcyt.modelo.SalaEmergencias;    
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
	
	private int grafico;
	private ArrayList<String>lista;
	private ArrayList<Integer>valores;
	public Reporte(int grafico,ArrayList<String>lista){
		 this.grafico = grafico;
		 this.lista = lista;
		 SalaEmergencias sala = new SalaEmergencias();
		 ArrayList<Integer>valores = sala.getDatos();
		 this.valores = valores;
	}
	public void crearGraficoCircular(){
		
		DefaultPieDataset data = new DefaultPieDataset();
		for(int i = 0;i<lista.size();i++){
			String variable = lista.get(i);
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
		JFreeChart chart = ChartFactory.createPieChart(
		         "REPORTE EN GRAFICO CIRCULAR DE LA SIMULACION",
		         data,
		         true,
		         true,
		         false);
		ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
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
					int valor = valores.get(1);
					data.addValue(valor, variable, variable+" en minutos");
				}else{
					if(variable == "Tiempo de Atencion"){
						int valor = valores.get(2);
						data.addValue(valor, variable, variable+" en minutos");
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
}
