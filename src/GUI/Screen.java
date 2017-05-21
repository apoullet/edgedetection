package GUI;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private JPanel ipanel, gpanel, spanel, hpanel;

    public void launch() {
        ipanel = new ImagePanel();
        gpanel = new GrayPanel();
        spanel = new SobelPanel();
        hpanel = new HoughPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));
        setResizable(false);

        add(ipanel);
        add(gpanel);
        add(spanel);
        add(hpanel);

        pack();
        setVisible(true);
    }
}
