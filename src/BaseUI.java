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
        statusBar.setBackground(new Color(180, 150, 200));
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
                    frame.dispose(); // Close the current frame
                    new Main().show(); // Open the Main frame
                }
            });
            statusBar.add(backIconLabel);

            // Add battery icon to the status bar
            BufferedImage batteryIcon = ImageIO.read(new File("resources/ui/battery.png"));
            Image scaledBatteryIcon = batteryIcon.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JLabel batteryIconLabel = new JLabel(new ImageIcon(scaledBatteryIcon));
            batteryIconLabel.setBounds(320, 0, 80, 30);
            statusBar.add(batteryIconLabel);

            // Add watch icon to the status bar
            BufferedImage watchIcon = ImageIO.read(new File("resources/ui/watch.png"));
            Image scaledWatchIcon = watchIcon.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JLabel watchIconLabel = new JLabel(new ImageIcon(scaledWatchIcon));
            watchIconLabel.setBounds(290, 0, 30, 30);
            statusBar.add(watchIconLabel);
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