package application.inicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.InterfazInicio;
import application.ingresar.PantallaIngresarImagen;
import application.ingresar.PantallaIngresarVideo;
import application.tabla.TablaImagen;
import application.tabla.TablaVideo;
import application.utilidades.Boton;
import application.utilidades.CargaImagen;
import application.utilidades.CustomPanel;
import application.utilidades.Formato;

public class PantallaCrudImagen{
	private JFrame myFrame;
	private CustomPanel.ImagePanel background;
	private Formato formato;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	
	public PantallaCrudImagen(JFrame myFrame) {
		this.formato = new Formato();
		this.myFrame = myFrame;
		initBackground();
		initContent();
		myFrame.getContentPane().repaint();
		myFrame.getContentPane().revalidate();
	}
	
	private void initBackground() {
		background = new CustomPanel.ImagePanel("C:\\Users\\fabia\\IdeaProjects\\gestor_direcciones_oracle\\imagenes\\fondo.png");
		background.setLayout(null);
		myFrame.getContentPane().add(background);
	}
	
	private void initContent(){
		initLabels();
		initButtonAgregar();
		initButtonModificar();
		initButtonBack();
		
	}
	
	private void initLabels() {
		JLabel Text = new JLabel("CRUD DE IMAGENES");
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

	private void initButtonAgregar(){
		Boton buttonAgregar = new Boton();
		buttonAgregar.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.37), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonAgregar, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonAgregar.setText("AGREGAR");
		buttonAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.remove(background);
				PantallaIngresarImagen pai = new PantallaIngresarImagen(myFrame);
			}
		});
		background.add(buttonAgregar);
	}

	private void initButtonModificar(){
		Boton buttonModificar = new Boton();
		buttonModificar.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.49), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonModificar, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonModificar.setText("MODIFICAR");
		buttonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.remove(background);
				TablaImagen tablaVideo = new TablaImagen(myFrame);
			}
		});
		background.add(buttonModificar);
	}

	private void initButtonBack() {
		Boton buttonBack = new Boton();
		buttonBack.setBounds((WIDTH * 11 / 17) / 2, (int) (HEIGHT * 0.61), (int) (WIDTH * 6 / 17), (int) (HEIGHT * 7 / 72));
		formato.formato(buttonBack, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		buttonBack.setText("VOLVER");
		buttonBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.remove(background);
				InterfazInicio ii = new InterfazInicio(myFrame);
			}
		});
		background.add(buttonBack);
	}
}
