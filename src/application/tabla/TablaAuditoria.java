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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import application.InterfazInicio;
import application.componentes.Auditoria;
import application.componentes.Video;
import application.registros.AuditoriaReg;
import application.utilidades.CustomButton;
import application.utilidades.CargaImagen;
import application.utilidades.Formato;
import application.utilidades.ImagePanel;

public class TablaAuditoria extends ImagePanel {
	private JFrame myFrame;
	private JLabel codigoLabel, nombreLabel, seleccionadoLabel;
	private JTextField seleccionadoField;
	private CustomButton botonRegresar;
	private Formato formato;
	private DefaultTableModel tableModel;
	private JComboBox<String> comboBox;
	private AuditoriaReg auditoriaReg;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	List<Auditoria> listaRegistros = new ArrayList<>();
	private String[][] m; // Cambiar el 15 por el tamaño de datos
	JScrollPane scrollPane;

	public TablaAuditoria(JFrame myFrame) {
		super("C:\\Users\\fabia\\IdeaProjects\\gestor_direcciones_oracle\\imagenes\\fondo.png");
		setLayout(null);
		this.myFrame = myFrame;
		this.formato = new Formato();
		this.auditoriaReg = new AuditoriaReg();
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
		codigoLabel = new JLabel("LISTADO DE AUDITORIAS");
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

	private void botonBack() {
		botonRegresar = new CustomButton();
		formato = new Formato();
		botonRegresar.setBounds((WIDTH * 2 / 17) / 2, (int) (HEIGHT * 0.70), (int) (WIDTH * 5 / 17),
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
		listaRegistros = auditoriaReg.extraerRegistros("todos_todos");
		initLabelPeliculaSeleccionada();
		initLabelTitulo();
		initTabla();
		initSeleccionada();
		funcionarComboBox();
		botonBack();
	}

	private void initTabla() {
		m = new String[listaRegistros.size()][4];
		int ind = 0;
		for (Auditoria c : listaRegistros) {
			m[ind][0] = Integer.toString(c.getId());
			m[ind][1] = c.getOrigen();
			m[ind][2] = c.getFecha();
			m[ind][3] = c.getAccion();
			ind++;
		}

		String[] cabecera = { "ID","ORIGEN" ,"FECHA", "ACCION" };
		tableModel = new DefaultTableModel(m, cabecera);
		JTable table = new JTable(tableModel);
		for (int i = 0; i < cabecera.length; i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setEnabled(false);
		table.getTableHeader().setBackground(Color.decode("#09599B"));
		table.setRowHeight(40);
		table.setBackground(Color.decode("#1B7ECF"));
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);

		formato.formato(table, 1, (float) (HEIGHT * 0.025));

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(520, 100, 700, 500);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = table.getSelectedRow();
				// Verificar si se hizo clic en una fila válida
				if (filaSeleccionada != -1) {
					mostrarNombreDePelicula(filaSeleccionada, m);
				}
			}
		});
		add(scrollPane);

	}

	private void mostrarTodos(String where) {
		listaRegistros = auditoriaReg.extraerRegistros(where);
		m = new String[listaRegistros.size()][4];
		int ind = 0;
		for (Auditoria c : listaRegistros) {
			m[ind][0] = Integer.toString(c.getId());
			m[ind][1] = c.getOrigen();
			m[ind][2] = c.getFecha();
			m[ind][3] = c.getAccion();
			ind++;
		}

		String[] cabecera = { "ID","ORIGEN",  "FECHA", "ACCION" };
		tableModel.setDataVector(m, cabecera);
		tableModel.fireTableDataChanged();
		JTable table = new JTable(tableModel);
		for (int i = 0; i < cabecera.length; i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setEnabled(false);
		table.getTableHeader().setBackground(Color.decode("#C2B221"));
		table.setRowHeight(40);
		table.setBackground(Color.decode("#C2B221"));
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.setFont(table.getFont().deriveFont(18f));
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(520, 100, 700, 500);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = table.getSelectedRow();
				// Verificar si se hizo clic en una fila válida
				if (filaSeleccionada != -1) {
					mostrarNombreDePelicula(filaSeleccionada, m);
				}
			}
		});
		add(scrollPane);

	}

	private void funcionarComboBox() {
		String[] opciones = {"Todos_Todos", "INSERT_Todos", "UPDATE_Todos",
                 "Todos_Video", "INSERT_Video", "UPDATE_Video",
                   "Todos_Pdf",   "INSERT_Pdf",   "UPDATE_Pdf",
                "Todos_Imagen","INSERT_Imagen","UPDATE_Imagen"};
		comboBox = new JComboBox<>(opciones);
		comboBox.setBackground(Color.decode("#6688D4"));
		comboBox.setBounds(70, 160, 400, 50);
		comboBox.setBackground(Color.decode("#09599B"));
		formato.formato(comboBox, 1, (float) (HEIGHT * 0.040));
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opcionSeleccionada = comboBox.getSelectedItem().toString();
				// tableModel.setRowCount(0);
				// Realizar acciones según la opción seleccionada{
		            mostrarTodos(opcionSeleccionada.toLowerCase()); 
			}

		});

		add(comboBox);
	}

	private void mostrarNombreDePelicula(int tupla, String[][] m) {
		seleccionadoField.setText("");
		seleccionadoField.setText(m[tupla][1]);
	}
}