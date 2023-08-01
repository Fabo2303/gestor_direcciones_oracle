package application.inicial;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import application.InterfazInicio;
import application.ingresar.PantallaIngresarPdf;
import application.tabla.TablaPDF;
import application.utilidades.CustomButton;
import application.utilidades.ImagePanel;
import application.utilidades.Formato;

public class PantallaCrudPdf extends ImagePanel{
	private JFrame myFrame;
	private Formato formato;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	
	public PantallaCrudPdf(JFrame myFrame) {
		super("imagenes\\fondo.png");
		setLayout(null);
		this.formato = new Formato();
		this.myFrame = myFrame;
		initContent();
		myFrame.getContentPane().repaint();
		myFrame.getContentPane().revalidate();
	}

	private void initContent(){
		initLabels();
		initButtonAgregar();
		initButtonModificar();
		initButtonBack();
	}
	
	private void initLabels() {
		JLabel Text = new JLabel("CRUD DE ARCHIVOS");
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

	private void initButtonAgregar(){
		CustomButton buttonAgregar = new CustomButton();
		buttonAgregar.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.37), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formatButton(buttonAgregar, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonAgregar.setText("AGREGAR");
		buttonAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new PantallaIngresarPdf(myFrame));
				myFrame.revalidate();
			}
		});
		add(buttonAgregar);
	}

	private void initButtonModificar(){
		CustomButton buttonModificar = new CustomButton();
		buttonModificar.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.49), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formatButton(buttonModificar, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonModificar.setText("MODIFICAR");
		buttonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new TablaPDF(myFrame));
				myFrame.revalidate();
			}
		});
		add(buttonModificar);
	}

	private void initButtonBack(){
		CustomButton buttonBack = new CustomButton();
		buttonBack.setBounds((WIDTH*11/17)/2, (int)(HEIGHT*0.61), (int)(WIDTH*6/17), (int)(HEIGHT*7/72));
		formato.formatButton(buttonBack, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		buttonBack.setText("VOLVER");
		buttonBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new InterfazInicio(myFrame));
				myFrame.revalidate();
			}
		});
		add(buttonBack);
	}
}