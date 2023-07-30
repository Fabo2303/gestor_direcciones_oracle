package application.utilidades;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Boton extends JButton {

	private boolean over;
	private Color color;
	private Color colorOver;
	private Color colorClick;
	private Color borderColor;
	private boolean isGradienteColor;
	private GradientPaint gradient;
	private GradientPaint gradientExited;
	private GradientPaint gradientOver;
	private GradientPaint gradientClick;
	private BasicStroke grosor;

	private int radius = 0;

	public Boton() {
    	super();
    	this.isGradienteColor = false;
    	setFocusable(false);
    	setBorderPainted(false);
        setContentAreaFilled(false);
        //  Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
            	if(isGradienteColor)
            		gradient = gradientOver;
            	else
            		setBackground(colorOver);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
            	if(isGradienteColor)
            		gradient = gradientExited;
                else
                	setBackground(color);
                over = false;

            }

            @Override
            public void mousePressed(MouseEvent me) {
            	if(isGradienteColor)
            		gradient = gradientClick;
                else
                	setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                	if(isGradienteColor) {
                		gradient = gradientOver;
                	}else {
                		setBackground(colorOver);
                	}
                } else {
                	if(isGradienteColor) {
                		gradient = gradientExited;
                	}
                	else {
                		setBackground(color);
                	}
                }
                    
            }
        });
    }

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		setBackground(color);
	}

	public Color getColorOver() {
		return colorOver;
	}

	public void setColorOver(Color colorOver) {
		this.colorOver = colorOver;
	}

	public Color getColorClick() {
		return colorClick;
	}

	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public boolean isGradienteColor() {
		return isGradienteColor;
	}

	public void setGradienteColor(boolean isGradienteColor) {
		this.isGradienteColor = isGradienteColor;
	}
	
	public GradientPaint getGradient() {
		return gradientExited;
	}

	public void setGradient(Color a, Color b) {
		this.gradientExited = new GradientPaint(0, 0, a, getWidth(), getHeight(), b);
		this.gradient = gradientExited;
	}

	public GradientPaint getGradientOver() {
		return gradientOver;
	}

	public void setGradientOver(Color a, Color b) {
		this.gradientOver = new GradientPaint(0, 0, a, getWidth(), getHeight(), b);
	}

	public GradientPaint getGradientClick() {
		return gradientClick;
	}

	public void setGradientClick(Color a, Color b) {
		this.gradientClick = new GradientPaint(0, 0, a, getWidth(), getHeight(), b);
	}
	
	public BasicStroke getGrosor() {
		return grosor;
	}

	public void setGrosor(int grosor) {
		this.grosor = new BasicStroke(grosor);
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Paint Border
		g2.setColor(borderColor);
		g2.setStroke(grosor);
		g2.drawRoundRect(0, 0, getWidth()-2, getHeight()-2, radius, radius);

		if (isGradienteColor) {
			// Crear el objeto GradientPaint para el degradado

			// Establecer el GradientPaint como el color de fondo
			g2.setPaint(gradient);
			
			// Dibujar un rectángulo con el degradado
			g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, radius, radius);
		} else {
			g2.setColor(getBackground());
			// Border set 2 Pix
			g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, radius, radius);
		}
		super.paintComponent(grphcs);
	}
}
