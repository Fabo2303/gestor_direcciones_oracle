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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import application.componentes.Pdf;
import application.componentes.Proyecto;
import application.inicial.PantallaCrudPdf;
import application.inicial.PantallaCrudVideo;
import application.registros.PdfReg;
import application.registros.ProyectoReg;
import application.utilidades.CustomButton;
import application.utilidades.ImagePanel;
import application.utilidades.Formato;

public class PantallaIngresarPdf extends ImagePanel{
	private JFrame myFrame;
	private JTextField fieldNombre, urlField;
	private JTextArea descripcionArea;
	private Formato formato;
	private PdfReg pdfReg;
	private ProyectoReg proyReg;
	private Proyecto proy;
	private JComboBox<String> comboBox;
	private final int HEIGHT = 720;
	private final int WIDTH = 1280;

	public PantallaIngresarPdf(JFrame myFrame) {
		super("C:\\Users\\fabia\\IdeaProjects\\gestor_direcciones_oracle\\imagenes\\fondo.png");
		setLayout(null);
		this.myFrame = myFrame;
		pdfReg = new PdfReg();
		formato = new Formato();
		proyReg = new ProyectoReg();
		initContent();
		myFrame.getContentPane().repaint();
		myFrame.getContentPane().revalidate();
	}

	private void initContent() {
		initLabels();
		initLabelNombre();
		initLabelDescripcion();
		initLabelUrl();
		initLabelProy();
		initButtonBack();
	}

	private void initLabels() {
		JLabel text = new JLabel("AGREGAR");
		text.setBounds((int) (WIDTH * 0.095), (int) (HEIGHT * 0.085), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(text, 1, (float) (HEIGHT * 0.055));
		text.setForeground(new Color(255, 102, 196));
		add(text);

		JLabel text2 = new JLabel("PDF");
		text2.setBounds((int) (text.getX()+text.getWidth()/2 - WIDTH*0.05), (int) (text.getY()+text.getHeight()+HEIGHT*0.005), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(text2, 1, (float) (HEIGHT * 0.055));
		text2.setForeground(new Color(255, 102, 196));
		add(text2);
	}

	private void initLabelNombre() {
		JLabel labelNombre = new JLabel("NOMBRE DEL PDF:");
		labelNombre.setBounds((int) (WIDTH * 0.075), (int) (HEIGHT * 0.275), (int) ((int) (WIDTH * 0.45)),
				(int) (HEIGHT * 0.055));
		formato.formato(labelNombre, 1, (float) (HEIGHT * 0.045));
		add(labelNombre);

		fieldNombre = new JTextField();
		fieldNombre.setBounds((int) (labelNombre.getX() + WIDTH * 0.025),
				(int) (labelNombre.getY() + labelNombre.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.35),
				(int) (labelNombre.getHeight()));
		formato.formato(fieldNombre, 0, (float) (HEIGHT * 0.035));
		fieldNombre.setEditable(true);
		fieldNombre.setFocusable(true);
		fieldNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fieldNombre.setEditable(true);
				fieldNombre.setFocusable(true);
			}
		});
		add(fieldNombre);

		JLabel contorno = new JLabel();
		contorno.setBounds((int) (fieldNombre.getX() - WIDTH * 0.004), (int) (fieldNombre.getY() - WIDTH * 0.004),
				(int) (fieldNombre.getWidth() + WIDTH * 0.008), (int) (fieldNombre.getHeight() + WIDTH * 0.008));
		contorno.setOpaque(false);
		contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		add(contorno);
	}

	private void initLabelDescripcion() {
		JLabel descripcionLabel = new JLabel("DESCRIPCION:");
		descripcionLabel.setBounds((int) (WIDTH * 0.075),
				(int) (fieldNombre.getY() + fieldNombre.getHeight() + HEIGHT * 0.05), (int) ((int) (WIDTH * 0.45)),
				(int) (HEIGHT * 0.055));
		formato.formato(descripcionLabel, 1, (float) (HEIGHT * 0.045));
		add(descripcionLabel);

		descripcionArea = new JTextArea();
		descripcionArea.setBounds((int) (descripcionLabel.getX() + WIDTH * 0.025),
				(int) (descripcionLabel.getY() + descripcionLabel.getHeight() + HEIGHT * 0.025),
				(int) (fieldNombre.getWidth()), (int) (4.25 * fieldNombre.getHeight()));
		formato.formato(descripcionArea, 0, (float) (HEIGHT * 0.035));
		descripcionArea.setEditable(true);
		descripcionArea.setFocusable(true);
		descripcionArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				descripcionArea.setEditable(true);
				descripcionArea.setFocusable(true);
			}
		});
		add(descripcionArea);

		JScrollPane descripcionScroll = new JScrollPane(descripcionArea);
		descripcionScroll.setBounds(descripcionArea.getX(), descripcionArea.getY(), descripcionArea.getWidth(),
				descripcionArea.getHeight());
		add(descripcionScroll);

		JLabel contorno = new JLabel();
		contorno.setBounds((int) (descripcionArea.getX() - WIDTH * 0.004),
				(int) (descripcionArea.getY() - WIDTH * 0.004), (int) (descripcionArea.getWidth() + WIDTH * 0.008),
				(int) (descripcionArea.getHeight() + WIDTH * 0.008));
		contorno.setOpaque(false);
		contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		add(contorno);
	}

	private void initLabelUrl() {
		JLabel urlLabel = new JLabel("URL:");
		urlLabel.setBounds((int) (WIDTH * 0.55), (int) (HEIGHT * 0.085), (int) (WIDTH * 0.45), (int) (HEIGHT * 0.055));
		formato.formato(urlLabel, 1, (float) (HEIGHT * 0.045));
		add(urlLabel);

		urlField = new JTextField();
		urlField.setBounds((int) (urlLabel.getX() + WIDTH * 0.025),
				(int) (urlLabel.getY() + urlLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.35),
				(int) (urlLabel.getHeight()));
		formato.formato(urlField, 0, (float) (HEIGHT * 0.035));
		urlField.setEditable(true);
		urlField.setFocusable(true);
		urlField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				urlField.setEditable(true);
				urlField.setFocusable(true);
			}
		});
		add(urlField);

		JLabel contorno = new JLabel();
		contorno.setBounds((int) (urlField.getX() - WIDTH * 0.004), (int) (urlField.getY() - WIDTH * 0.004),
				(int) (urlField.getWidth() + WIDTH * 0.008), (int) (urlField.getHeight() + WIDTH * 0.008));
		contorno.setOpaque(false);
		contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		add(contorno);

		CustomButton cargarImagenBtn = new CustomButton();
		cargarImagenBtn.setText("CARGAR PDF");
		cargarImagenBtn.setBounds((int) (urlField.getX() + urlField.getWidth() * 0.1), (int) (HEIGHT * 0.275),
				(int) (urlField.getWidth() * 0.8), (int) (urlField.getHeight() * 1.75));
		formato.formatButton(cargarImagenBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		cargarImagenBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser buscador = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos MP4", "mp4");
				buscador.setFileFilter(filter);

				int result = buscador.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = buscador.getSelectedFile();
					urlField.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		add(cargarImagenBtn);
	}

	private void initLabelProy() {
		JLabel idProyLabel = new JLabel("ID DEL PROYECTO:");
		idProyLabel.setBounds((int) (WIDTH * 0.55), (int) (fieldNombre.getY() + fieldNombre.getHeight() + HEIGHT * 0.05), (int) (WIDTH * 0.4),
				(int) (HEIGHT * 0.055));
		formato.formato(idProyLabel, 1, (float) (HEIGHT * 0.045));
		add(idProyLabel);

		ArrayList<Proyecto> proys = proyReg.extraerProyectos();
		proy = proys.get(0);
		String[] opciones = new String[proys.size()];
		for (int i = 0; i < opciones.length; i++) {
			opciones[i] = proys.get(i).getNomPyto();
		}
		comboBox = new JComboBox<>(opciones);
		comboBox.setBounds((int) (idProyLabel.getX() + WIDTH * 0.025),
				(int) (idProyLabel.getY() + (int) (HEIGHT * 0.055) + HEIGHT * 0.025), (int) (WIDTH * 0.35),
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

		add(comboBox);
		CustomButton guardarBtn = new CustomButton();
		guardarBtn.setText("GUARDAR");
		guardarBtn.setBounds((int) (comboBox.getX() + comboBox.getWidth() * 0.1),
				(int) (descripcionArea.getY() + descripcionArea.getHeight() / 2), (int) (idProyLabel.getWidth() * 0.7),
				(int) (idProyLabel.getHeight() * 1.75));
		formato.formatButton(guardarBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		guardarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = fieldNombre.getText().toUpperCase();
				String descripcion = descripcionArea.getText().toUpperCase();
				String url = urlField.getText();
				String idProy = "" + proy.getCodPyto();
				try {
					Integer.parseInt(idProy);
				} catch (Exception ex) {
					idProy = "";
				}
				if (!nombre.isEmpty() && !descripcion.isEmpty() && !url.isEmpty() && !idProy.isEmpty()) {
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
					Pdf p1 = new Pdf(0, nombre, descripcion, Integer.parseInt(idProy), 0, url, 1);

					int opt = JOptionPane.showConfirmDialog(null, mensaje.toString(), "Insert",
							JOptionPane.YES_NO_OPTION);
					if (opt == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Archivo insertado con exito!", "Ingreso",
								JOptionPane.INFORMATION_MESSAGE);
						pdfReg.agregar(p1);
						resetFrame();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe llenar todas las areas correctamente!", "Ingreso",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(guardarBtn);

	}

	private void resetFrame() {
		removeAll();
		initContent();
		repaint();
		revalidate();
	}

	private void initButtonBack() {
		CustomButton buttonBack = new CustomButton();
		buttonBack.setText("VOLVER");
		buttonBack.setBounds((int) (WIDTH * 0.5 - descripcionArea.getWidth() * 0.35),
				(int) (descripcionArea.getY() + descripcionArea.getHeight() + HEIGHT * 0.05),
				(int) (descripcionArea.getWidth() * 0.7), (int) ((int) (HEIGHT * 0.055) * 1.75));
		formato.formatButton(buttonBack, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		buttonBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new PantallaCrudPdf(myFrame));
				myFrame.revalidate();
			}
		});
		add(buttonBack);
	}
}
