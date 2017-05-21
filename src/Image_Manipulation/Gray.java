package Image_Manipulation;

import GUI.ImagePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Gray {
    private ImagePanel ipanel = new ImagePanel();
    private Image circles;
    private BufferedImage gray;

    public Gray() {
        circles = ipanel.getImage();

        gray = new BufferedImage(circles.getWidth(null), circles.getHeight(null), BufferedImage.TYPE_BYTE_GRAY);

        Graphics2D g2d = gray.createGraphics();
        g2d.drawImage(circles, 0, 0, null);
        g2d.dispose();
    }

    public BufferedImage getGrayScale() {
        return gray;
    }
}
