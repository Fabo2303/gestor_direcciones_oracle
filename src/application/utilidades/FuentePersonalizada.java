package application.utilidades;

import java.awt.Font;
import java.io.InputStream;

public class FuentePersonalizada {

	private Font font = null;

	public FuentePersonalizada() {
		String fontName = "LibreBaskerville-Regular.ttf";
		try {
			// Se carga la fuente
			InputStream is = getClass().getResourceAsStream(fontName);
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (Exception ex) {
			// Si existe un error se carga fuente por defecto ARIAL
			System.err.println(fontName + " No se cargo la fuente");
			font = new Font("Arial", Font.PLAIN, 40);
		}
	}

	public Font MyFont(int estilo, float tamanio) {
		Font tfont = font.deriveFont(estilo, tamanio);
		return tfont;
	}

}