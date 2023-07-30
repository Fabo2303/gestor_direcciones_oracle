package application.utilidades;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CustomPanel {

	public static class ImagePanel extends JPanel {
		private BufferedImage image;

		public ImagePanel(String path) {
			setLayout(null);
			try {
				if (path.contains("https")) {
					URL urlPath = new URL(path);
					image = ImageIO.read(urlPath);
				} else {
					image = ImageIO.read(new File(path));
				}
			} catch (IOException e) {
				System.out.println("Tu imagen no existe.");
			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (image != null) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		}

	}

	public static class GradientPanel extends JPanel {
		private Color startColor;
		private Color endColor;

		public GradientPanel(Color startColor, Color endColor) {
			setLayout(null);
			this.startColor = startColor;
			this.endColor = endColor;
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
			g2.setPaint(gradient);
			g2.fillRect(0, 0, getWidth(), getHeight());
		}
	}
}
