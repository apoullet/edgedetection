package Image_Manipulation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sobel {
    private BufferedImage sobel;
    private int width, height;
    private int[][] kernelx, kernely;
    private double[] image;

    public Sobel() {
        Gray gray = new Gray();
        sobel = gray.getGrayScale();

        width = sobel.getWidth();
        height = sobel.getHeight();

        kernelx = new int[][]{{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
        kernely = new int[][]{{-1, -2, -1}, {0, 0, 0}, {1, 2, 1}};

        image = new double[width * height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image[x + y * width] = sobel.getRaster().getSampleDouble(x, y, 0);
            }
        }

        sobel = applySobel();
    }

    private double getMag(int[][] kernel, int x, int y) {
        double mag = 0.0;

        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                int xn = x + a - 1;
                int yn = y + b - 1;

                int index = xn + yn * width;
                mag += image[index] * kernel[a][b];
            }
        }

        return mag;
    }

    private int threshold = 120;

    private BufferedImage applySobel() {
        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                double endMag = Math.sqrt((Math.pow(getMag(kernelx, x, y), 2) + Math.pow(getMag(kernely, x, y), 2)));

                if (endMag < threshold) {
                    sobel.setRGB(x, y, Color.BLACK.getRGB());
                } else {
                    sobel.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }

        return sobel;
    }

    public BufferedImage getSobel() {
        return sobel;
    }
}
