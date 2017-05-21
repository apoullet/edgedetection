package GUI;

import Image_Manipulation.Hough;

import javax.swing.*;
import java.awt.*;

public class HoughPanel extends JPanel {
    private Hough hough;

    public HoughPanel() {
        hough = new Hough();

        setPreferredSize(new Dimension(hough.getHough().getWidth(null), hough.getHough().getHeight(null)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(hough.getHough(), 0, 0, null);
    }
}
