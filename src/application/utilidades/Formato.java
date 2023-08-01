package application.utilidades;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class Formato {
	
	FuentePersonalizada fuente;

	public Formato() {
		fuente = new FuentePersonalizada();
	}

	public void formato(JLabel l, int estilo, float tamanio) {
		l.setFont(fuente.MyFont(estilo, tamanio));
		l.setOpaque(false);
		l.setBorder(BorderFactory.createEmptyBorder());
		l.setForeground(Color.cyan);
	}

	public void formato(JTextField t, int estilo, float tamanio) {
		t.setFont(fuente.MyFont(estilo, tamanio));
		t.setEditable(false);
		t.setFocusable(false);
		t.setOpaque(true);
		t.setBorder(BorderFactory.createEmptyBorder());
		t.setForeground(Color.black);
	}
	
	public void formato(JComboBox<String> b, int estilo, float tamanio) {
		b.setFont(fuente.MyFont(estilo, tamanio));
		b.setOpaque(false);
		b.setBorder(BorderFactory.createEmptyBorder());
		b.setForeground(new Color(0, 0, 0));
	}
	
	public void formato(JTextArea ta, int estilo, float tamanio) {
		ta.setFont(fuente.MyFont(estilo, tamanio));
		ta.setEditable(false);
		ta.setLineWrap(true);
		ta.setOpaque(true);
		ta.setFocusable(false);
		ta.setBorder(BorderFactory.createEmptyBorder());
		ta.setForeground(new Color(0, 0, 0));
	}

	public void formatButton(CustomButton button, int style, float font_size, int radius, int grosor){
		button.setFont(fuente.MyFont(style, font_size));
		button.configGradient(radius, Color.black, new Color(81, 112, 255), new Color(255, 102, 196), grosor);
	}
	
	public void formato(Boton b, int estilo, float tamanio, int radius, int grosor) {
		b.setFont(fuente.MyFont(estilo, tamanio));
		b.setRadius(radius);
		b.setGradienteColor(true);
		b.setGradient(new Color(81, 112, 255), new Color(255, 102, 196));
		b.setGradientOver(new Color(81, 112, 255, 150), new Color(255, 102, 196,150));
		b.setGradientClick(new Color(81, 112, 255, 200), new Color(255, 102, 196, 200));
		b.setBorderColor(new Color(0,0,0));
		b.setGrosor(grosor);
	}
	
	public void formato(JTable tabla, int estilo, float tamanio) {
		tabla.setFont(fuente.MyFont(estilo, tamanio));
		tabla.getTableHeader().setFont(fuente.MyFont(estilo, (float)(tamanio*0.65)));
		
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            private javax.swing.border.Border border = BorderFactory.createEmptyBorder(1, 1, 1, 1);

            @Override
            public javax.swing.border.Border getBorder() {
                return border;
            }
        };
       
        tabla.setDefaultRenderer(Object.class, renderer);
        tabla.setGridColor(Color.decode("#000000"));
		tabla.setOpaque(true);
		tabla.setBorder(BorderFactory.createEmptyBorder());
		tabla.setForeground(new Color(0, 0, 0));

	}
}