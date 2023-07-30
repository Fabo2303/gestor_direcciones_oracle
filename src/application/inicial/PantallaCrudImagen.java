package application.inicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import application.InterfazInicio;
import application.ingresar.PantallaIngresarImagen;
import application.tabla.TablaImagen;
import application.utilidades.Boton;
import application.utilidades.CargaImagen;
import application.utilidades.Formato;

public class PantallaCrudImagen{
	private JFrame ventana;
	private JPanel fondo = new JPanel();
	private JLabel background;
	private Formato formato;
	private Boton buttonAgregar = new Boton();
	private Boton buttonModficar = new Boton();
	private Boton buttonBack = new Boton();
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	
	public PantallaCrudImagen(JFrame ventana) {
		this.formato = new Formato();
		this.ventana = ventana;
		//initFrame();
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
		initListeners();
		
	}
	
	private void initLabels() {
		JLabel Text = new JLabel("CRUD DE IMAGENES");
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
		buttonAgregar.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.37), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonAgregar, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonAgregar.setText("AGREGAR");
		fondo.add(buttonAgregar);
		
		buttonModficar.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.49), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonModficar, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonModficar.setText("MODIFICAR");
		fondo.add(buttonModficar);
		
		buttonBack.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.61), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formato(buttonBack, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonBack.setText("VOLVER");
		fondo.add(buttonBack);
	}
	
	private void initListeners() {
		buttonAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ventana.remove(fondo);
				PantallaIngresarImagen pai = new PantallaIngresarImagen(ventana);
            }
		});
		buttonModficar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ventana.remove(fondo);
				//FUNCION TABLA DE ARMANDO
				TablaImagen tablaImagen = new TablaImagen(ventana);
            }
		});
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.remove(fondo);
				InterfazInicio ii = new InterfazInicio(ventana);
			}
		});
	}
}
