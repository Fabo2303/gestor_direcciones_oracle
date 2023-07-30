package application.utilidades;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class CargaImagen {

	public static void setImagen(JLabel auxLabel, String cad) {
		String dir = System.getProperty("user.dir").replace("\\", "\\\\") + "\\imagenes\\";
		ImageIcon a = new ImageIcon(dir + cad);
		auxLabel.setIcon(
				new ImageIcon(
						a.getImage().getScaledInstance(auxLabel.getWidth(), auxLabel.getHeight(), Image.SCALE_SMOOTH)));
	}

	public static void setImagen(JLabel auxLabel, String cad, int n) {
		String dir = System.getProperty("user.dir").replace("\\", "\\\\") + "\\logos\\";
		ImageIcon a = new ImageIcon(dir + cad);
		auxLabel.setIcon(
				new ImageIcon(
						a.getImage().getScaledInstance(auxLabel.getWidth(), auxLabel.getHeight(), Image.SCALE_SMOOTH)));
	}

	public static ImageIcon retornarImagen(String cad) {
		String dir = System.getProperty("user.dir").replace("\\", "\\\\") + "\\logos\\";
		// File file = new File(dir + cad);
		ImageIcon imagen = null;
		imagen = new ImageIcon(dir + cad);
		return imagen;
	}

	public static ImageIcon retornarImagenExterna(String cad) {
		ImageIcon imagen = null;
		imagen = new ImageIcon(cad);
		return imagen;
	}

	public static void setLogo(JLabel auxLabel, ImageIcon img, int n) {
		ImageIcon a = img;
		auxLabel.setIcon(new ImageIcon(
				a.getImage().getScaledInstance(auxLabel.getWidth(), auxLabel.getHeight(), Image.SCALE_SMOOTH)));
	}

}
