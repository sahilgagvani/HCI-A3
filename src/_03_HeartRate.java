import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class _03_HeartRate extends BaseUI {
    public _03_HeartRate() {
        super();
        // change status bar text
        JLabel statusBar = (JLabel) frame.getContentPane().getComponent(0);
        statusBar.setText("Heart Rate");
        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(255, 99, 71)); // Light red background

        // Image Placeholder
        JLabel imagePlaceholder = new JLabel();
        imagePlaceholder.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagePlaceholder.setBounds(50, 50, 300, 300); // Adjust the size to match the image resolution
        try {
            BufferedImage img = ImageIO.read(new File("resources/ui/heart.png"));
            Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imagePlaceholder.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(imagePlaceholder);

// Big Font Text
        JLabel bigFontText = new JLabel("<html><span style='font-size:48px;'>78</span><span style='font-size:24px;'> bpm</span></html>", SwingConstants.CENTER);
        bigFontText.setFont(new Font("Verdana", Font.BOLD, 24));
        bigFontText.setForeground(Color.WHITE);
        bigFontText.setBounds(50, 400, 200, 70);
        frame.add(bigFontText);

        // Button 1
        JButton button1 = new JButton("Start");
        button1.setBounds(270, 400, 80, 40);
        button1.setOpaque(true);
        button1.setContentAreaFilled(true);
        button1.setBackground(new Color(70, 130, 180)); // Steel blue button
        button1.addActionListener(e -> System.out.println("Start button clicked"));
        frame.add(button1);

        // Button 2
        JButton button2 = new JButton("Stop");
        button2.setBounds(270, 450, 80, 40);
        button2.setOpaque(true);
        button2.setContentAreaFilled(true);
        button2.setBackground(new Color(144, 238, 144)); // Light green button
        button2.addActionListener(e -> System.out.println("Stop button clicked"));
        frame.add(button2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new _03_HeartRate().show());
    }
}