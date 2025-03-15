import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Abstract base class for UI components
abstract class BaseUI {
    protected JFrame frame;
    protected int width = 400;
    protected int height = 600;

    public BaseUI() {
        frame = new JFrame("Sahil's Health App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLayout(null);

        // Status Bar
        JLabel statusBar = new JLabel("Base Status", SwingConstants.CENTER);
        statusBar.setOpaque(true);
        statusBar.setBackground(new Color(180, 150, 200));//red color =
        statusBar.setBounds(0, 0, width, 30);
        frame.add(statusBar);

        // Add back icon to the status bar
        try {
            BufferedImage backIcon = ImageIO.read(new File("resources/ui/backbutton.jpg"));
            Image scaledBackIcon = backIcon.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JLabel backIconLabel = new JLabel(new ImageIcon(scaledBackIcon));
            backIconLabel.setBounds(5, 0, 30, 30);
            backIconLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            backIconLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Handle the click event here
                    System.out.println("Back icon clicked");
                }
            });
            statusBar.add(backIconLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Thin Line Separator
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 30, width, 1);
        frame.add(separator);
    }

    public void show() {
        frame.setVisible(true);
    }
}