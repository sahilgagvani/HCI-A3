import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class _02_Hydration extends BaseUI {
    private JProgressBar progressBar;
    private JLabel dailyTargetLabel;
    private JLabel percentageLabel;
    private int dailyTarget = 3500; // Default daily target in mL
    private int currentIntake = 2100; // Example current intake

    public _02_Hydration() {
        super();
        // change status bar text
        JLabel statusBar = (JLabel) frame.getContentPane().getComponent(0);
        statusBar.setText("Hydration Tracker");
        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(204, 229, 255));

        // Water Image
        JLabel waterImage = new JLabel();
        waterImage.setBounds(120, 90, 150, 150);
        try {
            BufferedImage img = ImageIO.read(new File("resources/ui/water.jpg"));
            Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            waterImage.setIcon(new ImageIcon(scaledImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(waterImage);

        // Daily Target Label
        JLabel dailyTargetText = new JLabel("DAILY TARGET:");
        dailyTargetText.setFont(new Font("Arial", Font.BOLD, 14));
        dailyTargetText.setBounds(150, 250, 150, 20);
        frame.add(dailyTargetText);

        dailyTargetLabel = new JLabel(dailyTarget + " mL", SwingConstants.CENTER);
        dailyTargetLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        dailyTargetLabel.setBounds(150, 270, 100, 20);
        frame.add(dailyTargetLabel);

        // Edit Target Button
        JButton editTargetButton = new JButton("TAP TO EDIT");
        editTargetButton.setBounds(90, 300, 170, 30);
        editTargetButton.setBackground(new Color(255, 87, 87)); // Red button
        editTargetButton.setForeground(Color.BLACK);
        editTargetButton.setBorderPainted(false);
        editTargetButton.addActionListener(e -> editDailyTarget());
        frame.add(editTargetButton);

        // Target Achieved Label
        JLabel targetAchievedLabel = new JLabel("TARGET ACHIEVED:");
        targetAchievedLabel.setFont(new Font("Arial", Font.BOLD, 14));
        targetAchievedLabel.setBounds(130, 340, 200, 20);
        frame.add(targetAchievedLabel);

        // Progress Bar
        progressBar = new JProgressBar(0, dailyTarget);
        progressBar.setBounds(100, 370, 200, 30);
        progressBar.setValue(currentIntake);
        progressBar.setStringPainted(false);
        progressBar.setForeground(new Color(0, 150, 0)); // Green progress
        frame.add(progressBar);

        // Percentage Label
        percentageLabel = new JLabel();
        percentageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        percentageLabel.setBounds(150, 410, 100, 20);
        frame.add(percentageLabel);
        updateProgressBar();

        // Log Water Button
        JButton logWaterButton = new JButton("TAP TO LOG WATER");
        logWaterButton.setBounds(100, 440, 200, 40);
        logWaterButton.setBackground(new Color(66, 165, 245)); // Blue button
        logWaterButton.setForeground(Color.BLACK);
        logWaterButton.setBorderPainted(false);
        logWaterButton.addActionListener(e -> logWaterIntake());
        frame.add(logWaterButton);

        // Reminder Message
        JLabel reminderLabel = new JLabel("Next reminder will be sent at 3 PM to drink water", SwingConstants.CENTER);
        reminderLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        reminderLabel.setBounds(50, 490, 300, 20);
        frame.add(reminderLabel);

        JButton newButton = new JButton("Change Reminders");
        newButton.setBounds(120, 520, 150, 30);
        frame.add(newButton);
    }

    private void editDailyTarget() {
        String input = JOptionPane.showInputDialog(frame, "Enter new daily target (mL):", dailyTarget);
        if (input != null && !input.isEmpty()) {
            try {
                dailyTarget = Integer.parseInt(input);
                dailyTargetLabel.setText(dailyTarget + " mL");
                progressBar.setMaximum(dailyTarget);
                updateProgressBar();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        }
    }

    private void logWaterIntake() {
        String input = JOptionPane.showInputDialog(frame, "Enter amount of water (mL):", "250");
        if (input != null && !input.isEmpty()) {
            try {
                int amount = Integer.parseInt(input);
                currentIntake += amount;
                updateProgressBar();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        }
    }

    private void updateProgressBar() {
        progressBar.setValue(currentIntake);
        int percentage = (int) (((double) currentIntake / dailyTarget) * 100);
        percentageLabel.setText(percentage + "%");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new _02_Hydration().show());
    }
}