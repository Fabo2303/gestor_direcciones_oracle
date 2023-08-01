package application.tabla;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import application.InterfazInicio;
import application.componentes.Video;
import application.mostrar.PantallaMostrarVideo;
import application.registros.VideoReg;
import application.utilidades.CustomButton;
import application.utilidades.CargaImagen;
import application.utilidades.Formato;
import application.utilidades.ImagePanel;

public class TablaVideo extends ImagePanel{
	private JFrame myFrame;
	private JLabel codigoLabel, nombreLabel, seleccionadoLabel;
	private JTextField seleccionadoField;
	private CustomButton verDetalleBtn, botonRegresar;
	private Formato formato;
	private DefaultTableModel tableModel;
	private JComboBox<String> comboBox;
	private VideoReg videoReg;
	private Video video;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	List<Video> listaRegistros = new ArrayList<>();
	private String[][] m; // Cambiar el 15 por el tamaño de datos
	JScrollPane scrollPane;

	public TablaVideo(JFrame myFrame) {
		super("C:\\Users\\fabia\\IdeaProjects\\gestor_direcciones_oracle\\imagenes\\fondo.png");
		setLayout(null);
		this.myFrame = myFrame;
		this.formato = new Formato();
		this.videoReg = new VideoReg();
		initComponentes();
		myFrame.getContentPane().repaint();
		myFrame.getContentPane().revalidate();
	}

	private void initLabelTitulo() {
		nombreLabel = new JLabel("ELIGE");
		nombreLabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.15), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(nombreLabel, 1, (float) (HEIGHT * 0.040));
		add(nombreLabel);
	}

	private void initLabelPeliculaSeleccionada() {
		codigoLabel = new JLabel("LISTADO DE VIDEOS");
		codigoLabel.setBounds((int) (WIDTH * 0.30), (int) (HEIGHT * 0.05), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(codigoLabel, 1, (float) (HEIGHT * 0.045));
		add(codigoLabel);
	}

	private void initSeleccionada() {
		seleccionadoLabel = new JLabel("SELECCIONADA");
		seleccionadoLabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.40), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(seleccionadoLabel, 1, (float) (HEIGHT * 0.040));
		add(seleccionadoLabel);

		seleccionadoField = new JTextField();
		seleccionadoField.setBounds((int) (seleccionadoLabel.getX() + WIDTH * 0.025),
				(int) (seleccionadoLabel.getY() + seleccionadoLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (seleccionadoLabel.getHeight()));
		formato.formato(seleccionadoField, 0, (float) (HEIGHT * 0.035));
		add(seleccionadoField);
	}

	private void botonVerDeTalle() {
		verDetalleBtn = new CustomButton();
		formato = new Formato();
		verDetalleBtn.setBounds((WIDTH * 2 / 17) / 2, (int) (HEIGHT * 0.60), (int) (WIDTH * 5 / 17),
				(int) (HEIGHT * 7 / 72));
		formato.formatButton(verDetalleBtn, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		verDetalleBtn.setText("VER DETALLE");
		verDetalleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new PantallaMostrarVideo(myFrame, video));
				myFrame.revalidate();
			}
		});
		add(verDetalleBtn);
	}
	
	private void botonRegresar() {
		botonRegresar = new CustomButton();
		formato = new Formato();
		botonRegresar.setBounds((WIDTH * 2 / 17) / 2, (int) (HEIGHT * 0.75), (int) (WIDTH * 5 / 17),
				(int) (HEIGHT * 7 / 72));
		formato.formatButton(botonRegresar, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		botonRegresar.setText("REGRESAR");
		botonRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myFrame.setContentPane(new InterfazInicio(myFrame));
				myFrame.revalidate();
			}
		});
		add(botonRegresar);
	}

	private void initComponentes() {
		cargarDatos();
		initLabelPeliculaSeleccionada();
		initLabelTitulo();
		initTabla();
		initSeleccionada();
		funcionarComboBox();
		botonVerDeTalle();
		botonRegresar();
	}
	
	private void cargarDatos() {
		listaRegistros = videoReg.extraerRegistros();
	}

	private void initTabla() {
		m = new String[listaRegistros.size()][5];
		int ind = 0;
		for (Video c : listaRegistros) {
			m[ind][0] = Integer.toString(c.getId());
			m[ind][1] = c.getTitulo();
			m[ind][2] = Integer.toString(c.getId_proy());
			m[ind][3] = c.getUrl();
			m[ind][4] = Integer.toString(c.getVisualizacion());
			ind++;
		}

		String[] cabecera = { "ID", "TÍTULO", "ID_PROY", "URL", "VISUALIZACION" };
		tableModel = new DefaultTableModel(m, cabecera);
		JTable table = new JTable(tableModel);
		for (int i = 0; i < cabecera.length; i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}

		formato.formato(nombreLabel, 1, (float) (HEIGHT * 0.040));

		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setEnabled(false);
		table.getTableHeader().setBackground(Color.decode("#09599B"));
		table.setRowHeight(40);
		table.setBackground(Color.decode("#1B7ECF"));
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);

		formato.formato(table, 1, (float) (HEIGHT * 0.025));

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(520, 100, 700, 500);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = table.getSelectedRow();
				// Verificar si se hizo clic en una fila válida
				if (filaSeleccionada != -1) {
					for(Video i: listaRegistros) {
						if(i.getId() == Integer.valueOf(m[filaSeleccionada][0])) {
							video = i;
							break;
						}
					}
					mostrarNombreDePelicula(filaSeleccionada, m);
				}
			}
		});
		add(scrollPane);

	}

	private void mostrarTodos() {
		// tableModel.setRowCount(0);
		m = new String[listaRegistros.size()][5];
		int ind = 0;
		for (Video c : listaRegistros) {
			m[ind][0] = Integer.toString(c.getId());
			m[ind][1] = c.getTitulo();
			m[ind][2] = Integer.toString(c.getId_proy());
			m[ind][3] = c.getUrl();
			m[ind][4] = Integer.toString(c.getVisualizacion());
			ind++;
		}


		String[] cabecera = { "ID", "TÍTULO", "ID_PROY", "URL", "VISUALIZACION" };
		tableModel.setDataVector(m, cabecera);
		tableModel.fireTableDataChanged();
		JTable table = new JTable(tableModel);
		for (int i = 0; i < cabecera.length; i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}

		formato.formato(nombreLabel, 1, (float) (HEIGHT * 0.040));

		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setEnabled(false);
		table.getTableHeader().setBackground(Color.decode("#09599B"));
		table.setRowHeight(40);
		table.setBackground(Color.decode("#1B7ECF"));
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);

		formato.formato(table, 1, (float) (HEIGHT * 0.025));

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(520, 100, 700, 500);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = table.getSelectedRow();
				if (filaSeleccionada != -1) {
					mostrarNombreDePelicula(filaSeleccionada, m);
				}
			}
		});
		add(scrollPane);

	}

	private void funcionarComboBox() {
		String[] opciones = { "Todos", "Solo disponibles", "Solo no disponibles" };
		comboBox = new JComboBox<>(opciones);
		comboBox.setBounds(70, 160, 400, 50);
		comboBox.setBackground(Color.decode("#09599B"));
		formato.formato(comboBox, 1, (float) (HEIGHT * 0.040));
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opcionSeleccionada = comboBox.getSelectedItem().toString();
				if (opcionSeleccionada.equals("Todos")) {
					listaRegistros = videoReg.extraerRegistros();
					mostrarTodos();
				} else if (opcionSeleccionada.equals("Solo disponibles")) {
					listaRegistros = videoReg.extraerVisualizables();
					mostrarTodos();
				} else if (opcionSeleccionada.equals("Solo no disponibles")) {
					listaRegistros = videoReg.extraerNoVisualizables();
					mostrarTodos();
				}
			}

		});
		add(comboBox);
	}

	private void mostrarNombreDePelicula(int tupla, String[][] m) {
		seleccionadoField.setText("");
		seleccionadoField.setText(m[tupla][1]);
	}
}
