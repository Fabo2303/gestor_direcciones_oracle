package application;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import application.inicial.PantallaCrudImagen;
import application.inicial.PantallaCrudPdf;
import application.inicial.PantallaCrudVideo;
import application.tabla.TablaAuditoria;
import application.utilidades.CustomButton;
import application.utilidades.ImagePanel;
import application.utilidades.Formato;

public class InterfazInicio extends ImagePanel{
	private JFrame myFrame;
	private Formato formato;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	
	public InterfazInicio(JFrame myFrame) {
		super("imagenes\\fondo.png");
		this.myFrame = myFrame;
		this.formato = new Formato();
		setLayout(null);
		initContenido();
	}
	
	private void initContenido(){
		initLabels();
		initVideoButton();
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
        add(Text);
        
        JLabel Text2 = new JLabel("Seleccione una opción:");
		Text2.setHorizontalAlignment(JLabel.CENTER);
        Text2.setBounds((int)(WIDTH*0.175), (int)(HEIGHT*0.23), (int)(WIDTH*0.65), (int)(HEIGHT*0.1));
		formato.formato(Text2, 0, (int)(WIDTH*0.02625));
        add(Text2);
	}

	private void initVideoButton(){
		CustomButton videoButton = new CustomButton();
		videoButton.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.37), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		videoButton.setText("VIDEOS");
		formato.formatButton(videoButton, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		videoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new PantallaCrudVideo(myFrame));
				myFrame.revalidate();
			}
		});
		add(videoButton);
	}

	private void initButtonPdf(){
		CustomButton buttonPDF = new CustomButton();
		buttonPDF.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.49), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formatButton(buttonPDF, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonPDF.setText("PDF");
		buttonPDF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new PantallaCrudPdf(myFrame));
				myFrame.revalidate();
			}
		});
		add(buttonPDF);
	}

	private void initButtonImage(){
		CustomButton buttonImage = new CustomButton();
		buttonImage.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.61), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formatButton(buttonImage, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonImage.setText("IMÁGENES");
		buttonImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new PantallaCrudImagen(myFrame));
				myFrame.revalidate();
			}
		});
		add(buttonImage);
	}

	private void initButtonAuditoria(){
		CustomButton buttonAuditoria = new CustomButton();
		buttonAuditoria.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.73), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formatButton(buttonAuditoria, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonAuditoria.setText("AUDITORÍA");
		buttonAuditoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new TablaAuditoria(myFrame));
				myFrame.revalidate();
			}
		});
		add(buttonAuditoria);
	}

	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		myFrame.setSize(1280,720);
		myFrame.setLocationRelativeTo(null);
		myFrame.setTitle("Manejador de direcciones");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("C:\\Users\\fabia\\IdeaProjects\\gestor_direcciones_oracle\\imagenes\\server.png");
		myFrame.setIconImage(icon.getImage());
		myFrame.setResizable(false);
		myFrame.setContentPane(new InterfazInicio(myFrame));
		myFrame.setVisible(true);
	}
}
