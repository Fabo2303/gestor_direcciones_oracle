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
import application.componentes.Pdf;
import application.mostrar.PantallaMostrarPdf;
import application.registros.PdfReg;
import application.utilidades.Boton;
import application.utilidades.CargaImagen;
import application.utilidades.Formato;

public class TablaPDF {
	private JFrame ventana;
	private JPanel panelFondo;
	private JLabel imagenFondo, codigoLabel, nombreLabel, seleccionadoLabel;
	private JTextField seleccionadoField;
	private Boton verDetalleBtn, botonRegresar;
	private Formato formato;
	private DefaultTableModel tableModel;
	private JComboBox<String> comboBox;
	private PdfReg pdfReg;
	private Pdf pdf;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	List<Pdf> listaRegistros = new ArrayList<>();
	private String[][] m; //Cambiar el 15 por el tamaño de datos
	JScrollPane scrollPane;

	public TablaPDF(JFrame ventana_) {
		this.ventana = ventana_;
		this.panelFondo = new JPanel();
		this.formato = new Formato();
		this.pdfReg = new PdfReg();
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
	
	private void initLabelTitulo() {
		nombreLabel = new JLabel("ELIGE");
		nombreLabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.15), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(nombreLabel, 1, (float) (HEIGHT * 0.040));
		panelFondo.add(nombreLabel);
	}
	
	private void initLabelPeliculaSeleccionada() {
		codigoLabel = new JLabel("LISTADO DE PDF");
		codigoLabel.setBounds((int) (WIDTH * 0.30), (int) (HEIGHT * 0.05), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(codigoLabel, 1, (float) (HEIGHT * 0.045));
		panelFondo.add(codigoLabel);
	}
	
	private void initSeleccionada() {
		seleccionadoLabel = new JLabel("SELECCIONADA");
		seleccionadoLabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.40), (int) (WIDTH * 0.45),
				(int) (HEIGHT * 0.055));
		formato.formato(seleccionadoLabel, 1, (float) (HEIGHT * 0.040));
		panelFondo.add(seleccionadoLabel);
		
		seleccionadoField = new JTextField();
		seleccionadoField.setBounds((int) (seleccionadoLabel.getX() + WIDTH * 0.025),
				(int) (seleccionadoLabel.getY() + seleccionadoLabel.getHeight() + HEIGHT * 0.025), (int) (WIDTH * 0.30),
				(int) (seleccionadoLabel.getHeight()));
		formato.formato(seleccionadoField, 0, (float) (HEIGHT * 0.035));
		panelFondo.add(seleccionadoField);
	}
	
	private void botonVerDeTalle() {
		verDetalleBtn = new Boton();
		formato = new Formato();
		verDetalleBtn.setBounds((WIDTH*2/17)/2, (int)(HEIGHT*0.60), (int)(WIDTH*5/17), (int)(HEIGHT*7/72));
		formato.formato(verDetalleBtn, 0, (float)(HEIGHT*0.03), (int)(WIDTH*0.05), (int)(WIDTH*0.0017));
		verDetalleBtn.setText("VER DETALLE");
		verDetalleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.remove(panelFondo);
				PantallaMostrarPdf pai = new PantallaMostrarPdf(ventana, pdf);
			}
		});
		panelFondo.add(verDetalleBtn);
	}
	
	private void botonRegresar() {
		botonRegresar = new Boton();
		formato = new Formato();
		botonRegresar.setBounds((WIDTH * 2 / 17) / 2, (int) (HEIGHT * 0.75), (int) (WIDTH * 5 / 17),
				(int) (HEIGHT * 7 / 72));
		formato.formato(botonRegresar, 0, (float) (HEIGHT * 0.03), (int) (WIDTH * 0.05), (int) (WIDTH * 0.0017));
		botonRegresar.setText("REGRESAR");
		botonRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.remove(panelFondo);
				InterfazInicio inicio = new InterfazInicio(ventana);
			}
		});
		panelFondo.add(botonRegresar);
	}

	private void pintarFondo() {
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
		CargaImagen.setImagen(imagenFondo, "fondo.png");
		panelFondo.add(imagenFondo);
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
		pintarFondo();
	}
	
	private void cargarDatos() {
		listaRegistros = pdfReg.extraerRegistros();
	}
	
	private void initTabla() {
		m = new String[listaRegistros.size()][5];
		int ind=0;
		for(Pdf c : listaRegistros) {
			m[ind][0]=Integer.toString(c.getId());
			m[ind][1]=c.getTitulo();
			m[ind][2]=Integer.toString(c.getId_proy());
			m[ind][3]=c.getUrl();
			m[ind][4]=Integer.toString(c.getVisualizacion());
			ind++;
		}
		
        String[] cabecera = {"ID", "TÍTULO", "ID_PROY", "URL", "VISUALIZACION"};
        tableModel = new DefaultTableModel(m, cabecera);
        JTable table = new JTable(tableModel);
        for(int i = 0; i<cabecera.length; i++){
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        table.setDefaultEditor(Object.class, null);
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
                	for(Pdf i: listaRegistros) {
						if(i.getId() == Integer.valueOf(m[filaSeleccionada][0])) {
							pdf = i;
							break;
						}
					}
                	mostrarNombreDePelicula(filaSeleccionada, m);
                }
            }
        });
        panelFondo.add(scrollPane);

	}
	
	
	private void mostrarTodos() {
		//tableModel.setRowCount(0);
	    m = new String[listaRegistros.size()][5];
	    int ind=0;
	    for(Pdf c : listaRegistros) {
	    	m[ind][0]=Integer.toString(c.getId());
	    	m[ind][1]=c.getTitulo();
	    	m[ind][2]=Integer.toString(c.getId_proy());
	    	m[ind][3]=c.getUrl();
	    	m[ind][4]=Integer.toString(c.getVisualizacion());
			ind++;
	    }
	    
	    String[] cabecera = {"ID", "TÍTULO", "ID_PROY", "URL", "VISUALIZACION"};
	    tableModel.setDataVector(m, cabecera);
	    tableModel.fireTableDataChanged();
        JTable table = new JTable(tableModel);
        for(int i = 0; i<cabecera.length; i++){
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        table.setDefaultEditor(Object.class, null);
        table.getTableHeader().setEnabled(false);
        table.setRowHeight(40);
        table.setBackground(Color.cyan);
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
        panelFondo.add(scrollPane);
	    
	}
	
	private void funcionarComboBox() {
		String[] opciones = {"Todos", "Solo disponibles", "Solo no disponibles"};
		comboBox = new JComboBox<>(opciones);
		comboBox.setBounds(70, 160, 400, 50);
		comboBox.setBackground(Color.decode("#09599B"));
		formato.formato(comboBox, 1, (float) (HEIGHT * 0.040));
		comboBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String opcionSeleccionada = comboBox.getSelectedItem().toString();
		        //tableModel.setRowCount(0);
		        // Realizar acciones según la opción seleccionada
		        if (opcionSeleccionada.equals("Todos")) {
		        	listaRegistros = pdfReg.extraerRegistros();
		            mostrarTodos();
		        } else if (opcionSeleccionada.equals("Solo disponibles")) {
		        	listaRegistros = pdfReg.extraerVisualizables();
		            mostrarTodos();
		        } else if (opcionSeleccionada.equals("Solo no disponibles")) {
		        	listaRegistros = pdfReg.extraerNoVisualizables();
		        	mostrarTodos();
		        }
		    }

		});

		panelFondo.add(comboBox);
	}
	
	private void mostrarNombreDePelicula(int tupla, String[][] m) {
		seleccionadoField.setText("");
		seleccionadoField.setText(m[tupla][1]);
	}

}
