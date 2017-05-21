package GUI;

import Image_Manipulation.Sobel;

import javax.swing.*;
import java.awt.*;

public class SobelPanel extends JPanel {
    private Sobel sobel;

    public SobelPanel() {
        sobel = new Sobel();

        setPreferredSize(new Dimension(sobel.getSobel().getWidth(null), sobel.getSobel().getHeight(null)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(sobel.getSobel(), 0, 0, null);
    }
}
