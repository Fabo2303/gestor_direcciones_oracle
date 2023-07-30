package application;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import application.inicial.PantallaCrudImagen;
import application.inicial.PantallaCrudPdf;
import application.inicial.PantallaCrudVideo;
import application.tabla.TablaAuditoria;
import application.utilidades.Boton;
import application.utilidades.CustomPanel.ImagePanel;
import application.utilidades.Formato;

public class InterfazInicio{
	private JFrame myFrame;
	private ImagePanel background;
	private Formato formato;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	
	public InterfazInicio() {
		this.formato = new Formato();
		this.myFrame = new JFrame();
		initFondo();
		initFrame();
		initContenido();
	}
	
	public InterfazInicio(JFrame myFrame) {
		this.myFrame = myFrame;
		this.formato = new Formato();
		initFondo();
		initFrame();
		initContenido();
	}

	public void initFrame(){
		myFrame.setSize(WIDTH,HEIGHT);
		myFrame.setLocationRelativeTo(null);
		myFrame.setTitle("Sitio web de peliculas");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("C:\\Users\\fabia\\IdeaProjects\\gestor_direcciones_oracle\\imagenes\\server.png");
		myFrame.setIconImage(icon.getImage());
		myFrame.setResizable(false);
		myFrame.setVisible(true);
	}

	private void initFondo() {
		background = new ImagePanel("C:\\Users\\fabia\\IdeaProjects\\gestor_direcciones_oracle\\imagenes\\fondo.png");
		background.setLayout(null);
		myFrame.getContentPane().add(background);
	}
	
	private void initContenido(){
		initLabels();
		initButtonVid();
		initButtonPdf();
		initButtonImage();
		initButtonAuditoria();
		myFrame.repaint();
		myFrame.revalidate();
	}
	
	private void initLabels() {
		JLabel Text = new JLabel("BIENVENIDO A FISITUBE");
		Text.setHorizontalAlignment(JLabel.CENTER);
		Text.setBounds((int)(WIDTH*0.05), (int)(HEIGHT*0.09), (int)(WIDTH*0.9), (int)(HEIGHT*0.1));
		formato.formato(Text, 0, (int)(WIDTH*0.0375));
        background.add(Text);
        
        JLabel Text2 = new JLabel("Seleccione una opción:");
		Text2.setHorizontalAlignment(JLabel.CENTER);
        Text2.setBounds((int)(WIDTH*0.175), (int)(HEIGHT*0.23), (int)(WIDTH*0.65), (int)(HEIGHT*0.1));
		formato.formato(Text2, 0, (int)(WIDTH*0.02625));
        background.add(Text2);
	}

	private void initButtonVid(){
		Boton buttonVid = new Boton();
		buttonVid.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.37), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonVid, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonVid.setText("VIDEOS");
		buttonVid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.remove(background);
				PantallaCrudVideo crudVideo = new PantallaCrudVideo(myFrame);
			}
		});
		background.add(buttonVid);
	}

	private void initButtonPdf(){
		Boton buttonPDF = new Boton();
		buttonPDF.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.49), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonPDF, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonPDF.setText("PDF");
		buttonPDF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.remove(background);
				PantallaCrudPdf crudPdf = new PantallaCrudPdf(myFrame);
			}
		});
		background.add(buttonPDF);
	}

	private void initButtonImage(){
		Boton buttonImage = new Boton();
		buttonImage.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.61), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonImage, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonImage.setText("IMÁGENES");
		buttonImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.remove(background);
				PantallaCrudImagen crudImagen = new PantallaCrudImagen(myFrame);
			}
		});
		background.add(buttonImage);
	}

	private void initButtonAuditoria(){
		Boton buttonAuditoria = new Boton();
		buttonAuditoria.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.73), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonAuditoria, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonAuditoria.setText("AUDITORÍA");
		buttonAuditoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.remove(background);
				TablaAuditoria tablaAuditoria = new TablaAuditoria(myFrame);
			}
		});
		background.add(buttonAuditoria);
	}
	
	public static void main(String[] args) {
		InterfazInicio windows = new InterfazInicio();
	}
}
