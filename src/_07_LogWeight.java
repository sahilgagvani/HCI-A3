import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class _07_LogWeight extends BaseUI {
    public _07_LogWeight() {
        super();
        // Change status bar text
        JLabel statusBar = (JLabel) frame.getContentPane().getComponent(0);
        statusBar.setText("Weight Management");
        statusBar.setForeground(Color.WHITE);

        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(249, 211, 224));

        // Image Placeholder
        JLabel imagePlaceholder = new JLabel();
        imagePlaceholder.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        imagePlaceholder.setBounds(50, 50, 300, 300);
        try {
            BufferedImage img = ImageIO.read(new File("resources/ui/scale.png"));
            Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imagePlaceholder.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(imagePlaceholder);

        // Text Labels
        JLabel label1 = new JLabel("Current Weight: 70.2 Kg", SwingConstants.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label1.setForeground(Color.BLACK);
        label1.setBounds(50, 360, 300, 30);
        frame.add(label1);

        JLabel label2 = new JLabel("Target Weight: 63.8 Kg", SwingConstants.CENTER);
        label2.setFont(new Font("Arial", Font.BOLD, 18));
        label2.setForeground(Color.BLACK);
        label2.setBounds(50, 400, 300, 30);
        frame.add(label2);

// Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        buttonPanel.setBounds(50, 450, 300, 40);
        buttonPanel.setOpaque(false);

        String[] buttonLabels = {"Log", "Reminders", "Trends", "Tips"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setOpaque(true);
            button.setFont(new Font("Arial", Font.BOLD, 12));
            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Set cursor to hand
            switch (label) {
                case "Log":
                    button.setBackground(new Color(255, 106, 0));
                    button.setForeground(Color.WHITE);
                    break;
                case "Reminders":
                    button.setBackground(new Color(58, 135, 254));
                    button.setForeground(Color.WHITE);
                    break;
                case "Trends":
                    button.setBackground(new Color(246, 206, 70));
                    button.setForeground(Color.BLACK);
                    break;
                case "Tips":
                    button.setBackground(new Color(100, 196, 102));
                    button.setForeground(Color.WHITE);
                    break;
                default:
                    button.setBackground(Color.BLACK);
                    button.setForeground(Color.WHITE);
                    break;
            }
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            button.addActionListener(e -> System.out.println(label + " button clicked"));
            buttonPanel.add(button);
        }
        frame.add(buttonPanel);

        // Additional Label
        JLabel additionalLabel = new JLabel("Current Target : -6.4 Kg in 123 days", SwingConstants.CENTER);
        additionalLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        additionalLabel.setForeground(Color.BLACK);
        additionalLabel.setBounds(50, 500, 300, 30);
        frame.add(additionalLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new _07_LogWeight().show());
    }
}