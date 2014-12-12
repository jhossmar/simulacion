package com.umss.fcyt.vista;

import java.awt.Color;  
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartUtilities;
import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;

import com.umss.fcyt.controlador.Reporte;

public class VentanaReportes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReportes frame = new VentanaReportes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaReportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 25, 504, 495);
		contentPane.add(panel);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(8, "Mujeres", "Lunes");
        dataset.setValue(7, "Hombres", "Lunes");
        dataset.setValue(9, "Mujeres", "Martes");
        dataset.setValue(4, "Hombres", "Martes");
        dataset.setValue(4, "Mujeres", "Miercoles");
        dataset.setValue(5, "Hombres", "Miercoles");
        dataset.setValue(8, "Mujeres", "Jueves");
        dataset.setValue(9, "Hombres", "Jueves");
        dataset.setValue(7, "Mujeres", "Viernes");
        dataset.setValue(8, "Hombres", "Viernes");
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart
        ("Participacion por Genero","Genero", "Dias",
        dataset, PlotOrientation.VERTICAL, false,true, false);
        try {
        	ChartUtilities.saveChartAsJPEG(new File("/home/jose/Desktop/Barchart.jpg"), chart, 500,
        	300);
        	} catch (IOException e) {
        	System.err.println("Error creando grafico.");
        	}
        chart.setBackgroundPaint(Color.cyan);
        chart.getTitle().setPaint(Color.black);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.red);
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
       chartPanel.setPreferredSize(new Dimension(600,400));
        panel.add(chartPanel);
		}
}
