import GUI.Screen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();
        SwingUtilities.invokeLater(screen::launch);
    }
}
