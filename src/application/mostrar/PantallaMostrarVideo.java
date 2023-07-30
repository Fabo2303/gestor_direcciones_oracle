package application.mostrar;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import application.componentes.Video;
import application.inicial.PantallaCrudVideo;
import application.registros.VideoReg;
import application.utilidades.Boton;
import application.utilidades.CargaImagen;
import application.utilidades.Formato;
import application.utilidades.Reproductor;

public class PantallaMostrarVideo {

	private JFrame ventana;
	private JPanel panelFondo;
	private JLabel imagenFondo, codigoLabel, nombreLabel, descripcionLabel, urlLabel, idProyLabel;
	private JTextField codigoField, nombreField, urlField, idProyField;
	private JTextArea descripcionArea;
	private Boton cargarImagenBtn, abrirBtn, activarBtn, guardarBtn, volverBtn;
	private Formato formato;
	private boolean editado;
	private Video archivo;
	private VideoReg videoReg;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;

	public PantallaMostrarVideo(JFrame ventana_, Video archivo_) {
		this.ventana = ventana_;
		this.archivo = archivo_;
		this.panelFondo = new JPanel();
		this.formato = new Formato();
		this.editado = false;
		this.videoReg = new VideoReg();
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
		initCodigo();
		initNombre();
		initDescripcion();
		initUrl();
		initProy();
		initBack();
		initData();
		pintarFondo();
	}

	private void initCodigo() {
		codigoLabel = new JLabel("CODIGO DEL VIDEO:");
		codigoLabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.085), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(codigoLabel, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(codigoLabel);

		codigoField = new JTextField();
		codigoField.setBounds((int) (codigoLabel.getX() + WIDTH * 0.025),
				(int) (codigoLabel.getY() + codigoLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.35),
				(int) (codigoLabel.getHeight()));
		formato.formato(codigoField, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(codigoField);

		JLabel contorno = new JLabel();
		contorno.setBounds((int) (codigoField.getX() - WIDTH * 0.004), (int) (codigoField.getY() - WIDTH * 0.004),
				(int) (codigoField.getWidth() + WIDTH * 0.008), (int) (codigoField.getHeight() + WIDTH * 0.008));
		contorno.setOpaque(false);
		contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelFondo.add(contorno);

	}

	private void initNombre() {
		nombreLabel = new JLabel("NOMBRE DEL VIDEO:");
		nombreLabel.setBounds((int) (codigoLabel.getX()),
				(int) (codigoField.getY() + codigoField.getHeight() + HEIGHT * 0.05), (int) (codigoLabel.getWidth()),
				(int) (codigoLabel.getHeight()));
		formato.formato(nombreLabel, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(nombreLabel);

		nombreField = new JTextField();
		nombreField.setBounds((int) (nombreLabel.getX() + WIDTH * 0.025),
				(int) (nombreLabel.getY() + nombreLabel.getHeight() + HEIGHT * 0.025), (int) (codigoField.getWidth()),
				(int) (codigoField.getHeight()));
		formato.formato(nombreField, 0, (float) (HEIGHT * 0.035));

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
		urlLabel.setBounds((int) (WIDTH * 0.55), (int) (HEIGHT * 0.085), (int) (WIDTH * 0.4), (int) (HEIGHT * 0.055));
		formato.formato(urlLabel, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(urlLabel);

		urlField = new JTextField();
		urlField.setBounds((int) (urlLabel.getX() + WIDTH * 0.025),
				(int) (urlLabel.getY() + codigoLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.35),
				(int) (urlLabel.getHeight()));
		formato.formato(urlField, 0, (float) (HEIGHT * 0.035));
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
		cargarImagenBtn.setText("CARGAR IMAGEN");
		cargarImagenBtn.setBounds(urlField.getX(), nombreLabel.getY(), (int) (urlField.getWidth() * 0.6),
				(int) (urlField.getHeight() * 2.25));
		formato.formato(cargarImagenBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		MouseAdapter cargarImagen = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				urlField.setEditable(true);
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

		abrirBtn = new Boton();
		abrirBtn.setText("ABRIR");
		abrirBtn.setBounds((int) (cargarImagenBtn.getX() + cargarImagenBtn.getWidth() + WIDTH * 0.01),
				(int) (cargarImagenBtn.getY()), (int) (urlField.getWidth() * 0.37),
				(int) (urlField.getHeight() * 2.25));
		formato.formato(abrirBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		MouseAdapter abrirImagen = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (archivo.getVisualizacion() == 1) {
					String[] options = {"W.Media.Player", "VLC", "Rep. Video"};
					int op = JOptionPane.showOptionDialog(null, "Elija el reproductor", "Clickea una opcion", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					switch(op) {
					case 0: Reproductor.AbrirVideo(urlField.getText());break;
					case 1: Reproductor.AbrirEnVLC(urlField.getText());break;
					case 2: Reproductor.AbrirDOC(urlField.getText());break;
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Archivo: NO HABILITADO!");
			}
		};
		abrirBtn.addMouseListener(abrirImagen);
		panelFondo.add(abrirBtn);
	}

	private void initProy() {
		idProyLabel = new JLabel("ID DEL PROYECTO:");
		idProyLabel.setBounds((int) (urlLabel.getX()), (int) (descripcionLabel.getY()), (int) (WIDTH * 0.4),
				(int) (HEIGHT * 0.055));
		formato.formato(idProyLabel, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(idProyLabel);

		idProyField = new JTextField();
		idProyField.setBounds((int) (idProyLabel.getX() + WIDTH * 0.025),
				(int) (idProyLabel.getY() + codigoLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.35),
				(int) (idProyLabel.getHeight()));
		formato.formato(idProyField, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(idProyField);

		JLabel contorno = new JLabel();
		contorno.setBounds((int) (idProyField.getX() - WIDTH * 0.004), (int) (idProyField.getY() - WIDTH * 0.004),
				(int) (idProyField.getWidth() + WIDTH * 0.008), (int) (idProyField.getHeight() + WIDTH * 0.008));
		contorno.setOpaque(false);
		contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelFondo.add(contorno);

		activarBtn = new Boton();
		if (archivo.getVisualizacion() == 1)
			activarBtn.setText("DESACTIVAR");
		else
			activarBtn.setText("ACTIVAR");
		activarBtn.setBounds((int) (idProyField.getX() + idProyField.getWidth() * 0.1),
				(int) (descripcionArea.getY() + descripcionArea.getHeight() / 2), (int) (idProyField.getWidth() * 0.8),
				(int) (idProyLabel.getHeight() * 1.75));
		formato.formato(activarBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		MouseAdapter activarArchivo = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int opt;
				if (archivo.getVisualizacion() == 1) {
					opt = JOptionPane.showConfirmDialog(null, "Desactivar archivo?", "Desactivacion",
							JOptionPane.YES_NO_OPTION);
					if (opt == JOptionPane.YES_OPTION) {
						archivo.setVisualizacion(0);
						JOptionPane.showMessageDialog(null, "Archivo: DESACTIVADO CON EXITO!");
						activarBtn.setText("ACTIVAR");
						editado = true;
					}
				} else {
					opt = JOptionPane.showConfirmDialog(null, "Activar archivo?", "Activacion",
							JOptionPane.YES_NO_OPTION);
					if (opt == JOptionPane.YES_OPTION) {
						archivo.setVisualizacion(1);
						JOptionPane.showMessageDialog(null, "Archivo: ACTIVADO CON EXITO!");
						activarBtn.setText("DEACTIVAR");
						editado = true;
					}
				}
			}
		};

		activarBtn.addMouseListener(activarArchivo);
		panelFondo.add(activarBtn);

		guardarBtn = new Boton();
		guardarBtn.setText("GUARDAR");
		guardarBtn.setBounds((int) (idProyField.getX() + idProyField.getWidth() * 0.1),
				(int) (activarBtn.getY() + activarBtn.getHeight() + HEIGHT * 0.05),
				(int) (idProyField.getWidth() * 0.8), (int) (idProyLabel.getHeight() * 1.75));
		formato.formato(guardarBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		MouseAdapter actualizarArchivo = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = nombreField.getText().toUpperCase();
				String descripcion = descripcionArea.getText().toUpperCase();
				String url = urlField.getText();
				if (!nombre.equals(archivo.getTitulo())) {
					editado = true;
					archivo.setTitulo(nombre);

				}
				if (!descripcion.equals(archivo.getDescripcion())) {
					editado = true;
					archivo.setDescripcion(descripcion);

				}
				if (!url.equals(archivo.getUrl())) {
					editado = true;
					archivo.setUrl(url);

				}

				if (editado) {
					int opt = JOptionPane.showConfirmDialog(null, "Actualizar datos?", "Modificacion",
							JOptionPane.YES_NO_OPTION);
					if (opt == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Archivo: ACTUALIZADO CON EXITO!");
						editado = false;
						videoReg.update(archivo);
						nombreField.setEditable(editado);
						nombreField.setFocusable(editado);
						descripcionArea.setEditable(editado);
						descripcionArea.setFocusable(editado);
						urlField.setEditable(editado);
						urlField.setFocusable(editado);
						// FUNCION UPDATE DEL SQL
					}
				}
			}
		};

		guardarBtn.addMouseListener(actualizarArchivo);
		panelFondo.add(activarBtn);
		panelFondo.add(guardarBtn);

	}

	private void initBack() {
		volverBtn = new Boton();
		volverBtn.setText("VOLVER");
		volverBtn.setBounds((int) (descripcionArea.getX() + descripcionArea.getWidth() * 0.1),
				(int) (descripcionArea.getY() + descripcionArea.getHeight() + HEIGHT * 0.05),
				(int) (descripcionArea.getWidth() * 0.7), (int) (descripcionLabel.getHeight() * 1.75));
		formato.formato(volverBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		MouseAdapter volver = new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//DEBERIA VOLVER A LA TABLA
				ventana.remove(panelFondo);
				PantallaCrudVideo pcv = new PantallaCrudVideo(ventana);
			}
		};
		volverBtn.addMouseListener(volver);
		panelFondo.add(volverBtn);
	}

	private void initData() {
		codigoField.setText(String.valueOf(archivo.getId()));
		nombreField.setText(archivo.getTitulo());
		descripcionArea.setText(archivo.getDescripcion());
		urlField.setText(archivo.getUrl());
		idProyField.setText(String.valueOf(archivo.getId_proy()));
	}
}