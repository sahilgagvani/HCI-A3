import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class _05_SummaryPage extends BaseUI {
    public _05_SummaryPage() {
        super();
        // Change status bar text
        JLabel statusBar = (JLabel) frame.getContentPane().getComponent(0);
        statusBar.setText("Weekly Summary");
        statusBar.setForeground(Color.BLACK);

        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(235, 235, 235));

        // Weekly Summary Label
        JLabel summaryLabel = new JLabel("Weekly Summary: Dec 24 - Dec 31", SwingConstants.CENTER);
        summaryLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Reduced font size
        summaryLabel.setForeground(Color.RED);
        summaryLabel.setBounds(50, 40, 300, 20); // Adjusted bounds to fit in one line
        frame.add(summaryLabel);

        // Image Placeholder
        JLabel imagePlaceholder = new JLabel();
        imagePlaceholder.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        imagePlaceholder.setBounds(50, 90, 300, 300);
        try {
            BufferedImage img = ImageIO.read(new File("resources/ui/summary.png"));
            Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imagePlaceholder.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(imagePlaceholder);

        // Text Panel
        JPanel textPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        textPanel.setBounds(30, 400, 340, 60);
        textPanel.setOpaque(false);

        JLabel leftLabel = new JLabel("<html>Sleep Score:<br>79%</html>", SwingConstants.CENTER);
        leftLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Increased font size
        leftLabel.setForeground(Color.RED);
        textPanel.add(leftLabel);

        JLabel rightLabel = new JLabel("<html>Tips:<br>Try consuming a lighter meal before bed.</html>", SwingConstants.RIGHT);
        rightLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        rightLabel.setForeground(Color.BLACK);
        rightLabel.setPreferredSize(new Dimension(150, 40)); // Ensure it holds more text
        textPanel.add(rightLabel);

        frame.add(textPanel);

        // Button
        JButton button = new JButton("View Detailed Summary");
        button.setBounds(100, 500, 200, 40);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setOpaque(true);
        button.setBackground(new Color(58, 135, 254));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> System.out.println("View Detailed Summary button clicked"));
        frame.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new _05_SummaryPage().show());
    }
}