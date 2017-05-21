package Image_Manipulation;

import GUI.ImagePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hough {
    private BufferedImage hough, image;
    private int width, height, bestX, bestY, bestR;


    public Hough() {
        Sobel sobel = new Sobel();
        hough = sobel.getSobel();

        ImagePanel ipanel = new ImagePanel();

        image = new BufferedImage(ipanel.getImage().getWidth(null), ipanel.getImage().getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(ipanel.getImage(), 0, 0, null);
        g2d.dispose();

        width = hough.getWidth();
        height = hough.getHeight();

        image = applyHough(50, 75);
    }

    private BufferedImage applyHough(int minRadius, int maxRadius) {
        int maxCount = 0;

        for (int r = minRadius; r <= maxRadius; r++) {
            int[][] pixels = new int[width][height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (hough.getRGB(x, y) == Color.WHITE.getRGB()) {
                        for (double theta = 0; theta < 2 * Math.PI; theta += 0.01) {
                            int rx = (int) Math.round(x + r * Math.sin(theta));
                            int ry = (int) Math.round(y + r * Math.cos(theta));

                            if (rx > 0 && rx < width && ry > 0 && ry < height) {
                                pixels[rx][ry]++;

                                if (maxCount < pixels[rx][ry]) {
                                    maxCount = pixels[rx][ry];
                                    bestX = rx;
                                    bestY = ry;
                                    bestR = r;
                                }
                            }
                        }
                    }
                }
            }
        }

        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.setColor(Color.MAGENTA);
        g2d.drawOval(bestX - bestR, bestY - bestR, bestR * 2, bestR * 2);
        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File("hough.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    public Image getHough() {
        return image;
    }
}
