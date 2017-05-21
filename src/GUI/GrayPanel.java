package GUI;

import Image_Manipulation.Gray;

import javax.swing.*;
import java.awt.*;

public class GrayPanel extends JPanel {
    private Gray gray;

    public GrayPanel() {
        gray = new Gray();

        setPreferredSize(new Dimension(gray.getGrayScale().getWidth(null), gray.getGrayScale().getHeight(null)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(gray.getGrayScale(), 0, 0, null);
    }
}
