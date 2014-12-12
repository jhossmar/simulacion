package com.umss.fcyt.controlador;

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

import com.umss.fcyt.vista.VentanaReportes;
import java.util.ArrayList; 
public class Reporte {
	
	private int grafico;
	private ArrayList<String>lista;
	public Reporte(int grafico,ArrayList<String>lista ){
		 this.grafico = grafico;
		 this.lista = lista;
	}
	public void grafica(){
		if(grafico == 0){
			crearGraficoBarras(lista);
		}
	}
	public void crearGraficoBarras(ArrayList<String>lista){
		
		ChartPanel panel;
		JFreeChart chart = null;
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		
		String producto = "sopa";
		String producto1 = "soda";
		
		String dia1 = "dia1";
		String dia2 = "dia2";
		String dia3 = "dia3";
		String dia4 = "dia4";
		
		data.addValue(18, producto, dia1);
		data.addValue(15, producto, dia2);
		data.addValue(14, producto, dia3);
		data.addValue(1, producto, dia4);
		
		data.addValue(50, producto1, dia1);
		data.addValue(45, producto1, dia2);
		data.addValue(31, producto1, dia3);
		data.addValue(10, producto1, dia4);
		
		chart = ChartFactory.createBarChart("Grafico de Barras",
				"Dia",
				"Cantidad",
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
		//return panel;
		
	}
}
