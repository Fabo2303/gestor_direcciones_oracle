package application.utilidades;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Reproductor {

	public static void AbrirDOC(String path) {
		// Crear una instancia de Desktop
		path = path.replace("\\", "/");
		Desktop desktop = Desktop.getDesktop();
		// URI url = new URI(path);
		String myURL = path.replace(" ", "");
		try {
			URL url = new URL(myURL);
			String nullFragment = null;
			URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);
			desktop.browse(uri);
		} catch (MalformedURLException e) {
			System.out.println("URL " + myURL + " is a malformed URL");
		} catch (URISyntaxException e) {
			System.out.println("URI " + myURL + " is a malformed URL");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void AbrirVideo(String path) {
		try {
			// Ruta del archivo multimedia que deseas reproducir

			// Comando para ejecutar el reproductor de Windows (Windows Media Player)
			String command = "cmd /c start wmplayer \"" + path + "\"";

			// Ejecutar el comando en un proceso
			Process process = Runtime.getRuntime().exec(command);

			// Esperar a que el reproductor de Windows se cierre
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void AbrirEnVLC(String path) {
		try {
			String os = System.getProperty("os.name").toLowerCase();

			// Comando para ejecutar VLC Media Player según el sistema operativo
			String command;
			if (os.contains("win")) {
				// Para Windows
				command = "C:\\Program Files\\VideoLAN\\VLC\\vlc.exe";
			} else if (os.contains("mac")) {
				// Para macOS
				command = "/Applications/VLC.app/Contents/MacOS/VLC";
			} else if (os.contains("nix") || os.contains("nux") || os.contains("bsd")) {
				// Para Linux/Unix/BSD
				command = "vlc";
			} else {
				System.out.println("Sistema operativo no compatible");
				return;
			}

			// Comando completo con la ruta del video
			String fullCommand = command + " " + path;

			// Ejecutar el comando en un proceso
			Process process = Runtime.getRuntime().exec(fullCommand);

			// Esperar a que VLC Media Player se cierre
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
