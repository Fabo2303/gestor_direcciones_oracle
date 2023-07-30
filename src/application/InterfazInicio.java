package application;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import application.inicial.PantallaCrudImagen;
import application.inicial.PantallaCrudPdf;
import application.inicial.PantallaCrudVideo;
import application.tabla.TablaAuditoria;
import application.utilidades.Boton;
import application.utilidades.CargaImagen;
import application.utilidades.Formato;

public class InterfazInicio{
	private JFrame ventana;
	private JPanel fondo = new JPanel();
	private JLabel background;
	private Formato formato;
	private Boton buttonVids = new Boton();
	private Boton buttonPDF = new Boton();
	private Boton buttonImages = new Boton();
	private Boton buttonAuditoria = new Boton();
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	
	public InterfazInicio() {
		this.formato = new Formato();
		this.ventana = new JFrame();
		initFrame();
		initContenido();
		initFondo();
	}
	
	public InterfazInicio(JFrame ventana) {
		this.ventana = ventana;
		this.formato = new Formato();
		initFrame();
		initContenido();
		initFondo();
	}

	private void initFondo() {
		fondo.setLayout(null);
		initFondoPantalla();
		ventana.getContentPane().revalidate();
		ventana.getContentPane().repaint();
	}
	
	private void initFondoPantalla() {
		background = new JLabel();
		background.setBounds(0, 0, WIDTH, HEIGHT);
		CargaImagen.setImagen(background, "fondo.png");
		fondo.add(background);
		ventana.getContentPane().add(fondo);
	}
	
	private void initContenido(){
		initLabels();
		initBotones();
		initFunciones();
	}
	
	private void initLabels() {
		JLabel Text = new JLabel("BIENVENIDO A FISITUBE");
		Text.setHorizontalAlignment(JLabel.CENTER);
		Text.setBounds((int)(WIDTH*0.05), (int)(HEIGHT*0.09), (int)(WIDTH*0.9), (int)(HEIGHT*0.1));
		formato.formato(Text, 0, (int)(WIDTH*0.0375));
        fondo.add(Text);
        
        JLabel Text2 = new JLabel("Seleccione una opción:");
		Text2.setHorizontalAlignment(JLabel.CENTER);
        Text2.setBounds((int)(WIDTH*0.175), (int)(HEIGHT*0.23), (int)(WIDTH*0.65), (int)(HEIGHT*0.1));
		formato.formato(Text2, 0, (int)(WIDTH*0.02625));
        fondo.add(Text2);
	}
	
	private void initBotones() {
		Formato formato = new Formato();
		buttonVids.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.37), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonVids, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonVids.setText("VIDEOS");
		fondo.add(buttonVids);
		
		buttonPDF.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.49), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonPDF, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonPDF.setText("PDF");
		fondo.add(buttonPDF);
		
		buttonImages.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.61), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonImages, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonImages.setText("IMÁGENES");
		fondo.add(buttonImages);
		
		buttonAuditoria.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.73), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonAuditoria, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonAuditoria.setText("AUDITORÍA");
		fondo.add(buttonAuditoria);
	}
	
	public void initFunciones() {
		buttonVids.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.remove(fondo);
				PantallaCrudVideo crudVideo = new PantallaCrudVideo(ventana);
			}
		});
		
		buttonPDF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.remove(fondo);
				PantallaCrudPdf crudPdf = new PantallaCrudPdf(ventana);
			}
		});
		
		buttonImages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.remove(fondo);
				PantallaCrudImagen crudImagen = new PantallaCrudImagen(ventana);
			}
		});
		
		buttonAuditoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.remove(fondo);
				TablaAuditoria tablaAuditoria = new TablaAuditoria(ventana);
			}
		});
	}
	
	
	
	public void initFrame(){
		ventana.setSize(WIDTH,HEIGHT);
		ventana.setLocationRelativeTo(null);
		ventana.setTitle("Sitio web de peliculas");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("C:\\Users\\fabia\\IdeaProjects\\gestor_direcciones_oracle\\imagenes\\server.png");
		ventana.setIconImage(icon.getImage());
		ventana.setResizable(false);
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		InterfazInicio windows = new InterfazInicio();
	}
}
