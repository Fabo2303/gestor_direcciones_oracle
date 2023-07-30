package application.ingresar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import application.componentes.Proyecto;
import application.componentes.Video;
import application.inicial.PantallaCrudVideo;
import application.registros.ProyectoReg;
import application.registros.VideoReg;
import application.utilidades.Boton;
import application.utilidades.CargaImagen;
import application.utilidades.Formato;

public class PantallaIngresarVideo {

	private JFrame ventana;
	private JPanel panelFondo;
	private JLabel imagenFondo, titulo1Label, titulo2Label, nombreLabel, descripcionLabel, urlLabel, idProyLabel;
	private JTextField nombreField, urlField, idProyField;
	private JTextArea descripcionArea;
	private Boton cargarImagenBtn, guardarBtn, volverBtn;
	private Formato formato;
	private VideoReg videoReg;
	private ProyectoReg proyReg;
	private Proyecto proy;
	private JComboBox<String> comboBox;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;

	public PantallaIngresarVideo(JFrame ventana_) {
		this.ventana = ventana_;
		this.videoReg = new VideoReg();
		this.panelFondo = new JPanel();
		this.formato = new Formato();
		this.proyReg = new ProyectoReg();
		// this.editado = false;
		configVentana();
		initFondo();
		initComponentes();
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}

	private void configVentana() {
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setLocationRelativeTo(null);
		panelFondo.setLayout(null);
		ventana.getContentPane().add(panelFondo);
	}

	private void initFondo() {
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setLocationRelativeTo(null);
	}

	private void pintarFondo() {
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
		CargaImagen.setImagen(imagenFondo, "fondo.png");
		panelFondo.add(imagenFondo);
	}

	private void initComponentes() {
		
		initNombre();
		initTitulo();
		initDescripcion();
		initUrl();
		initProy();
		initBack();
		pintarFondo();
	}

	private void initTitulo() {
		titulo1Label = new JLabel("AGREGAR");
		titulo1Label.setBounds((int) (WIDTH * 0.095), (int) (HEIGHT * 0.085), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(titulo1Label, 1, (float) (HEIGHT * 0.055));
		titulo1Label.setForeground(new Color(255, 102, 196));
		panelFondo.add(titulo1Label);

		titulo2Label = new JLabel("VIDEO");
		titulo2Label.setBounds((int) (titulo1Label.getX()+titulo1Label.getWidth()/2 - WIDTH*0.05), (int) (titulo1Label.getY()+titulo1Label.getHeight()+HEIGHT*0.005), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(titulo2Label, 1, (float) (HEIGHT * 0.055));
		titulo2Label.setForeground(new Color(255, 102, 196));
		panelFondo.add(titulo2Label);

	}

	private void initNombre() {
		nombreLabel = new JLabel("NOMBRE DEL VIDEO:");
		nombreLabel.setBounds((int) (WIDTH * 0.075), (int) (HEIGHT * 0.275), (int) ((int) (WIDTH * 0.45)),
				(int) (HEIGHT * 0.055));
		formato.formato(nombreLabel, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(nombreLabel);

		nombreField = new JTextField();
		nombreField.setBounds((int) (nombreLabel.getX() + WIDTH * 0.025),
				(int) (nombreLabel.getY() + nombreLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.35),
				(int) (nombreLabel.getHeight()));
		formato.formato(nombreField, 0, (float) (HEIGHT * 0.035));
		nombreField.setEditable(true);
		nombreField.setFocusable(true);
		MouseAdapter editNombre = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nombreField.setEditable(true);
				nombreField.setFocusable(true);
			}
		};

		nombreField.addMouseListener(editNombre);
		panelFondo.add(nombreField);

		JLabel contorno = new JLabel();
		contorno.setBounds((int) (nombreField.getX() - WIDTH * 0.004), (int) (nombreField.getY() - WIDTH * 0.004),
				(int) (nombreField.getWidth() + WIDTH * 0.008), (int) (nombreField.getHeight() + WIDTH * 0.008));
		contorno.setOpaque(false);
		contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelFondo.add(contorno);
	}

	private void initDescripcion() {
		descripcionLabel = new JLabel("DESCRIPCION:");
		descripcionLabel.setBounds((int) (nombreLabel.getX()),
				(int) (nombreField.getY() + nombreField.getHeight() + HEIGHT * 0.05), (int) (nombreLabel.getWidth()),
				(int) (nombreLabel.getHeight()));
		formato.formato(descripcionLabel, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(descripcionLabel);

		descripcionArea = new JTextArea();
		descripcionArea.setBounds((int) (descripcionLabel.getX() + WIDTH * 0.025),
				(int) (descripcionLabel.getY() + descripcionLabel.getHeight() + HEIGHT * 0.025),
				(int) (nombreField.getWidth()), (int) (4.25 * nombreField.getHeight()));
		formato.formato(descripcionArea, 0, (float) (HEIGHT * 0.035));
		descripcionArea.setEditable(true);
		descripcionArea.setFocusable(true);
		MouseAdapter editDescrpcion = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				descripcionArea.setEditable(true);
				descripcionArea.setFocusable(true);
			}
		};

		descripcionArea.addMouseListener(editDescrpcion);
		panelFondo.add(descripcionArea);

		JScrollPane descripcionScroll = new JScrollPane(descripcionArea);
		descripcionScroll.setBounds(descripcionArea.getX(), descripcionArea.getY(), descripcionArea.getWidth(),
				descripcionArea.getHeight());
		panelFondo.add(descripcionScroll);

		JLabel contorno = new JLabel();
		contorno.setBounds((int) (descripcionArea.getX() - WIDTH * 0.004),
				(int) (descripcionArea.getY() - WIDTH * 0.004), (int) (descripcionArea.getWidth() + WIDTH * 0.008),
				(int) (descripcionArea.getHeight() + WIDTH * 0.008));
		contorno.setOpaque(false);
		contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelFondo.add(contorno);
	}

	private void initUrl() {
		urlLabel = new JLabel("URL:");
		urlLabel.setBounds((int) (WIDTH * 0.55), (int) (HEIGHT * 0.085), (int) (WIDTH * 0.45), (int) (HEIGHT * 0.055));
		formato.formato(urlLabel, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(urlLabel);

		urlField = new JTextField();
		urlField.setBounds((int) (urlLabel.getX() + WIDTH * 0.025),
				(int) (urlLabel.getY() + urlLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.35),
				(int) (urlLabel.getHeight()));
		formato.formato(urlField, 0, (float) (HEIGHT * 0.035));
		urlField.setEditable(true);
		urlField.setFocusable(true);
		MouseAdapter editUrl = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				urlField.setEditable(true);
				urlField.setFocusable(true);
			}
		};

		urlField.addMouseListener(editUrl);
		panelFondo.add(urlField);

		JLabel contorno = new JLabel();
		contorno.setBounds((int) (urlField.getX() - WIDTH * 0.004), (int) (urlField.getY() - WIDTH * 0.004),
				(int) (urlField.getWidth() + WIDTH * 0.008), (int) (urlField.getHeight() + WIDTH * 0.008));
		contorno.setOpaque(false);
		contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelFondo.add(contorno);

		cargarImagenBtn = new Boton();
		cargarImagenBtn.setText("CARGAR VIDEO");
		cargarImagenBtn.setBounds((int) (urlField.getX() + urlField.getWidth() * 0.1), nombreLabel.getY(),
				(int) (urlField.getWidth() * 0.8), (int) (urlField.getHeight() * 1.75));
		formato.formato(cargarImagenBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		MouseAdapter cargarImagen = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// urlField.setEditable(true);
				JFileChooser buscador = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos MP4", "mp4");
				buscador.setFileFilter(filter);

				int result = buscador.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = buscador.getSelectedFile();
					urlField.setText(selectedFile.getAbsolutePath());
				}
			}
		};
		cargarImagenBtn.addMouseListener(cargarImagen);
		panelFondo.add(cargarImagenBtn);
	}
	
	private void initProy() {
		idProyLabel = new JLabel("ID DEL PROYECTO:");
		idProyLabel.setBounds((int) (urlLabel.getX()), (int) (descripcionLabel.getY()), (int) (WIDTH * 0.4),
				(int) (HEIGHT * 0.055));
		formato.formato(idProyLabel, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(idProyLabel);

		ArrayList<Proyecto> proys = proyReg.extraerProyectos();
		proy = proys.get(0);
		String[] opciones = new String[proys.size()];
		for (int i = 0; i < opciones.length; i++) {
			opciones[i] = proys.get(i).getNomPyto();
		}
        comboBox = new JComboBox<>(opciones);
		comboBox.setBounds((int) (idProyLabel.getX() + WIDTH * 0.025),
				(int) (idProyLabel.getY() + nombreLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.35),
				(int) (idProyLabel.getHeight()));
		comboBox.setBackground(Color.decode("#09599B"));
		formato.formato(comboBox, 1, (float) (HEIGHT * 0.040));
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opcionSeleccionada = comboBox.getSelectedItem().toString();
				for(Proyecto p : proys) {
					if(p.buscarProyecto(opcionSeleccionada) != null) {
						proy = p;
						System.out.println(proy.getCodPyto());
						break;
					}
				}
			}

		});

		panelFondo.add(comboBox);
		guardarBtn = new Boton();
		guardarBtn.setText("GUARDAR");
		guardarBtn.setBounds((int) (comboBox.getX() + comboBox.getWidth() * 0.1),
				(int) (descripcionArea.getY() + descripcionArea.getHeight() / 2), (int) (idProyLabel.getWidth() * 0.7),
				(int) (idProyLabel.getHeight() * 1.75));
		formato.formato(guardarBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		
		MouseAdapter actualizarArchivo = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = nombreField.getText().toUpperCase();
				String descripcion = descripcionArea.getText().toUpperCase();
				String url = urlField.getText();
				String idProy = "" + proy.getCodPyto();
				try {
					Integer.parseInt(idProy);
				} catch (Exception ex) {
					idProy = "";
				}
				if (!nombre.equals("") && !descripcion.equals("") && !url.equals("") && !idProy.equals("")) {
					StringBuilder mensaje = new StringBuilder();
					mensaje.append("Guardar datos?");
					mensaje.append("\n");
					mensaje.append("Nombre: ");
					mensaje.append(nombre);
					mensaje.append("\n");
					mensaje.append("Descripcion: ");
					mensaje.append(descripcion);
					mensaje.append("\n");
					mensaje.append("URL: ");
					mensaje.append(url);
					mensaje.append("\n");
					mensaje.append("Proyecto ID: ");
					mensaje.append(idProy);
					Video v1 = new Video(0, nombre, descripcion, Integer.parseInt(idProy), 0, url, 1);
					

					int opt = JOptionPane.showConfirmDialog(null, mensaje.toString(), "Insert",
							JOptionPane.YES_NO_OPTION);
					if (opt == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Archivo insertado con exito!", "Ingreso",
								JOptionPane.INFORMATION_MESSAGE);
						videoReg.agregar(v1);
						reiniciarVentana();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Debe llenar todas las areas correctamente!", "Ingreso",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		};

		guardarBtn.addMouseListener(actualizarArchivo);
		panelFondo.add(guardarBtn);

	}

	private void reiniciarVentana() {
		panelFondo.removeAll();
		initComponentes();
		panelFondo.repaint();
		panelFondo.revalidate();
	}

	private void initBack() {
		volverBtn = new Boton();
		volverBtn.setText("VOLVER");
		volverBtn.setBounds((int) (WIDTH * 0.5 - descripcionArea.getWidth() * 0.35),
				(int) (descripcionArea.getY() + descripcionArea.getHeight() + HEIGHT * 0.05),
				(int) (descripcionArea.getWidth() * 0.7), (int) (descripcionLabel.getHeight() * 1.75));
		formato.formato(volverBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));

		MouseAdapter volver = new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.remove(panelFondo);
				PantallaCrudVideo pcv = new PantallaCrudVideo(ventana);
			}
		};
		volverBtn.addMouseListener(volver);
		panelFondo.add(volverBtn);
	}

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setSize(1280, 720);
		ventana.setTitle("ED-G5-UNMSM");
		ventana.setLocationRelativeTo(null); // Aparece al medio la ventana
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		PantallaIngresarVideo window = new PantallaIngresarVideo(ventana);
	}

}