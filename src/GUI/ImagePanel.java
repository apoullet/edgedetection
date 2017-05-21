package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("/Users/antoinepoullet/OneDrive/IntelliJ/Space_Cadets/Edge_Detection/pool.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }

        image = scaleImage((BufferedImage) image, 450);

        setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
    }

    private Image scaleImage(BufferedImage startImage, int scale) {
        double x, y;

        if (startImage.getWidth(null) > startImage.getHeight(null)) {
            x = scale;
            y = scale * ((double) startImage.getHeight(null) / (double) startImage.getWidth(null));
        } else {
            x = scale * ((double) startImage.getWidth(null) / (double) startImage.getHeight(null));
            y = scale;
        }

        Image endImage = startImage.getScaledInstance((int) x, (int) y, Image.SCALE_SMOOTH);

        return endImage;
    }

    public Image getImage() {
        return image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(image, 0, 0, null);
    }
}
