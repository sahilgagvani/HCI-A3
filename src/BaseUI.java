import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Abstract base class for UI components
abstract class BaseUI {
    protected JFrame frame;
    protected int width = 400;
    protected int height = 600;

    public BaseUI(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLayout(null);

        // Status Bar
        JLabel statusBar = new JLabel("Status Bar", SwingConstants.CENTER);
        statusBar.setOpaque(true);
        statusBar.setBackground(Color.LIGHT_GRAY);
        statusBar.setBounds(0, 0, width, 30);
        frame.add(statusBar);

        // Thin Line Separator
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 30, width, 1);
        frame.add(separator);
    }

    public void show() {
        frame.setVisible(true);
    }

}

