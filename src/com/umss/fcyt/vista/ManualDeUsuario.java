package com.umss.fcyt.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import com.sun.pdfview.*;
import com.umss.fcyt.controlador.ControladorVentanaPrincipal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ManualDeUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private PagePanel panel_pdf;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManualDeUsuario dialog = new ManualDeUsuario(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param ventanaPrincipal 
	 */
	public ManualDeUsuario(VentanaPrincipal ventanaPrincipal) {
	    super(ventanaPrincipal);
		setBounds(100, 100, 740, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);
		
		panel_pdf = new PagePanel();
		scrollPane.setViewportView(panel_pdf);
		{
			JScrollPane scrollPane_1 = new JScrollPane();
			contentPanel.add(scrollPane_1, BorderLayout.WEST);
			{
				JList list = new JList();
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					
					try {
						mostrarPDF(e);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("Error al mostrar el pdf");
					}
					
					}
				});
				list.setModel(new AbstractListModel() {
					String[] values = new String[] {"1 Instalacion y Ejecucion", "2 Menú y opciones", "3 Reportes", "4 Descripción de los Procesos simulados"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				scrollPane_1.setViewportView(list);
			}
		}
	}

	protected void mostrarPDF(MouseEvent e) throws IOException  {
		  JList theList = (JList) e.getSource();
	        if (e.getClickCount() == 2) {
	          int index = theList.locationToIndex(e.getPoint());
	          if (index >= 0) {
	            String o = (String)theList.getModel().getElementAt(index);
	            int pos= (int)o.charAt(0);
	           // System.out.println("Double-clicked on: " + pos);
             if(pos==49)
	            {
            	 mostrarPdf("documentos/1.pdf",1);
	             
                 
	            }else
	              {
	            	if(pos==50)
	            	 {
	            		mostrarPdf("documentos/1.pdf",2);
	            		
	            	}else
	            	   {
	            		if(pos==51){
	            			
		            		mostrarPdf("documentos/1.pdf",3);

	            	    }else
		            	   {
		            		if(pos==52){
		            			
		            	    }
		            	  }
	            	  }
	              }
	            
	          }
	        }
	}

	private void mostrarPdf(String nombreArchivo, int numPagina) throws IOException {
		//panel_pdf= new PagePanel();
		String file = nombreArchivo;
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,0,channel.size());
        PDFFile pdfFile = new PDFFile(buf);
        PDFPage page = pdfFile.getPage(numPagina);
       // panel_pdf.useZoomTool(true); para el zoom
        panel_pdf.showPage(page);
		
	}
}
