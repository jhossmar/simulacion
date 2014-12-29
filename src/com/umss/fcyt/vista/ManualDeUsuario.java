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
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 12, 175, 284);
			contentPanel.add(scrollPane);
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
					String[] values = new String[] {"1 Instalacion y Ejecucion", "2 Descripcion de los Procesos simulados", "3 Reportes"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				scrollPane.setViewportView(list);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 26, 534, 270);
		contentPanel.add(scrollPane);
		
		panel_pdf = new PagePanel();
		scrollPane.setViewportView(panel_pdf);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void mostrarPDF(MouseEvent e) throws IOException {
		  JList theList = (JList) e.getSource();
	        if (e.getClickCount() == 2) {
	          int index = theList.locationToIndex(e.getPoint());
	          if (index >= 0) {
	            String o = (String)theList.getModel().getElementAt(index);
	            int pos= (int)o.charAt(0);
	           // System.out.println("Double-clicked on: " + pos);
             if(pos==49)
	            {
            	 String file = "documentos/1.pdf";
                 RandomAccessFile raf = new RandomAccessFile(file, "r");
                 FileChannel channel = raf.getChannel();
                 ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,0,channel.size());
                 PDFFile pdfFile = new PDFFile(buf);
                 PDFPage page = pdfFile.getPage(0);
                 panel_pdf.useZoomTool(false);
                 panel_pdf.showPage(page);
	             
                 
	            }else
	              {
	            	if(pos==50)
	            	 {
	            		
	            	}else
	            	   {
	            		if(pos==51){
	            			
	            	    }
	            	  }
	              }
	            
	          }
	        }
	}
}
