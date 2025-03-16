import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class _06_LogSleep extends BaseUI {
    public _06_LogSleep() {
        super();
        // Change status bar text
        JLabel statusBar = (JLabel) frame.getContentPane().getComponent(0);
        statusBar.setText("Sleep Tracker");
        statusBar.setForeground(Color.WHITE);

        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(0, 66, 169));

        // Image Placeholder
        JLabel imagePlaceholder = new JLabel();
        imagePlaceholder.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        imagePlaceholder.setBounds(50, 50, 300, 300);
        try {
            BufferedImage img = ImageIO.read(new File("resources/ui/moon.png"));
            Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imagePlaceholder.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(imagePlaceholder);

        // Label below the image
        JLabel belowImageLabel = new JLabel("Wearable device successfully connected ✅", SwingConstants.CENTER);
        belowImageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        belowImageLabel.setForeground(Color.WHITE);
        belowImageLabel.setBounds(50, 360, 300, 30);
        frame.add(belowImageLabel);

        // Buttons
        JButton button1 = new JButton("TRENDS");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setBackground(new Color(108, 227, 207));
        button1.setForeground(Color.WHITE);
        button1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button1.setBounds(50, 400, 300, 40);
        button1.addActionListener(e -> System.out.println("Log Sleep button clicked"));
        button1.setOpaque(true);
        frame.add(button1);

        JButton button2 = new JButton("TAP TO END SLEEP TRACKING");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setBackground(new Color(234, 77, 61));
        button2.setForeground(Color.WHITE);
        button2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button2.setBounds(50, 450, 300, 40);
        button2.addActionListener(e -> System.out.println("View Trends button clicked"));
        button2.setOpaque(true);
        frame.add(button2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new _06_LogSleep().show());
    }
}