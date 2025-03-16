import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class _04_WorkoutTracker extends BaseUI {
    public _04_WorkoutTracker() {
        super();
        // Change status bar text
        JLabel statusBar = (JLabel) frame.getContentPane().getComponent(0);
        statusBar.setText("Log Workout");
        statusBar.setForeground(Color.WHITE);

        // Set the background color of the frame
        frame.getContentPane().setBackground(Color.BLACK);

        // Image Placeholder
        JLabel imagePlaceholder = new JLabel();
        imagePlaceholder.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        imagePlaceholder.setBounds(50, 50, 300, 300);
        try {
            BufferedImage img = ImageIO.read(new File("resources/ui/cycle.jpg"));
            Image scaledImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imagePlaceholder.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(imagePlaceholder);

        // Text Label
        JLabel textLabel = new JLabel("Workout Summary", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial",Font.ROMAN_BASELINE, 24));
        textLabel.setForeground(Color.WHITE);
        textLabel.setBounds(50, 360, 300, 30);
        frame.add(textLabel);


        // 3x2 Table with different labels for each cell
        JPanel tablePanel = new JPanel(new GridLayout(3, 2, 10, 10));
        tablePanel.setBounds(50, 400, 300, 100);
        String[] cellLabels = {"Time : 29:45", "Avg HR : 113 bpm", "Distance : 9.8 Km", "Avg Speed : 21.5 Km/h", "Calories : 381 Kcal", "Fitness Score : 93%"};
        for (String label : cellLabels) {
            JLabel cellLabel = new JLabel(label, SwingConstants.CENTER);
            cellLabel.setOpaque(true);
            cellLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            tablePanel.add(cellLabel);
        }
        tablePanel.setOpaque(false);
        frame.add(tablePanel);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setBounds(50, 520, 300, 40);
        buttonPanel.setOpaque(false);

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setOpaque(true);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 12));
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(new Color(245, 58, 66));
        deleteButton.setBorder(BorderFactory.createLineBorder(new Color(230, 58, 28), 2));
        deleteButton.addActionListener(e -> System.out.println("deleteButton clicked"));
        buttonPanel.add(deleteButton);


        JButton trendsButton = new JButton("TRENDS");
        trendsButton.setOpaque(true);
        trendsButton.setFont(new Font("Arial", Font.BOLD, 12));
        trendsButton.setBackground(Color.BLACK);
        trendsButton.setForeground(new Color(42, 206, 209));
        trendsButton.setBorder(BorderFactory.createLineBorder(new Color(42, 206, 209), 2));
        trendsButton.addActionListener(e -> System.out.println("trendsButton clicked"));
        buttonPanel.add(trendsButton);



        JButton saveButton = new JButton("SAVE");
        saveButton.setOpaque(true);
        saveButton.setFont(new Font("Arial", Font.BOLD, 12));
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(new Color(14, 237, 25));
        saveButton.setBorder(BorderFactory.createLineBorder(new Color(14, 237, 25), 2));
        saveButton.addActionListener(e -> System.out.println("saveButton clicked"));
        buttonPanel.add(saveButton);
        frame.add(buttonPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new _04_WorkoutTracker().show());
    }
}