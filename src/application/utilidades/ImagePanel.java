package application.utilidades;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImagePanel extends JPanel {
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
