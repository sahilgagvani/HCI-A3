import javax.swing.*;
import java.awt.*;

public class Main extends BaseUI {
    public Main() {
        super();
        // Change status bar text
        JLabel statusBar = (JLabel) frame.getContentPane().getComponent(0);
        statusBar.setText("Menu");
        statusBar.setForeground(Color.WHITE);

        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(0, 0, 0)); // Royal Blue

        // Create a label above the buttons panel
        JLabel titleLabel = new JLabel("Good Morning, Sahil", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(50, 20, 300, 30);
        frame.add(titleLabel);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1, 10, 10));
        buttonPanel.setBounds(50, 60, 300, 400);
        buttonPanel.setOpaque(false);

        // Create buttons with labels and custom colors
        String[] buttonLabels = {"Meal Tracker", "Log Hydration", "Track Heart Rate", "Log Workouts", "View Weekly Summary", "Sleep Tracking", "Weight Management"};
        //Color[] buttonColors = {new Color(255, 99, 71), new Color(60, 179, 113), new Color(30, 144, 255), new Color(255, 215, 0), new Color(138, 43, 226), new Color(255, 69, 0), new Color(34, 139, 34)};
        Color[] labelColors = {
                new Color(255, 69, 58),   // Fiery Red (Motivating)
                new Color(200, 200, 200), // Ice Silver (Neutral & Clean)
                new Color(50, 205, 50),   // Neon Green (Refreshing)
                new Color(255, 140, 0),   // Burnt Orange (Active & Warm)
                new Color(0, 150, 255),   // Electric Blue (Futuristic)
                new Color(255, 215, 0),   // Golden Yellow (Bright & Inviting)
                new Color(0, 255, 127)    // Cyber Lime (Fresh & Vibrant)
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setBackground(Color.BLACK); // Keep background black
            button.setForeground(labelColors[i]); // Set text color
            button.setOpaque(true);

            // Set border color same as text color
            button.setBorder(BorderFactory.createLineBorder(labelColors[i], 2));

            button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            buttonPanel.add(button);


            // Add action listeners to buttons
            switch (buttonLabels[i]) {
                case "Meal Tracker":
                    button.addActionListener(e -> {
                        frame.dispose(); // Close the current frame
                        new _01_MealTracker().show(); // Open the _01_MealTracker frame
                    });
                    break;
                case "Log Hydration":
                    button.addActionListener(e -> {
                        frame.dispose(); // Close the current frame
                        new _02_Hydration().show(); // Open the _02_Hydration frame
                    });
                    break;
                case "Track Heart Rate":
                    button.addActionListener(e -> {
                        frame.dispose(); // Close the current frame
                        new _03_HeartRate().show(); // Open the _03_HeartRate frame
                    });
                    break;
                case "Log Workouts":
                    button.addActionListener(e -> {
                        frame.dispose(); // Close the current frame
                        new _04_WorkoutTracker().show(); // Open the _04_WorkoutTracker frame
                    });
                    break;
                case "View Weekly Summary":
                    button.addActionListener(e -> {
                        frame.dispose(); // Close the current frame
                        new _05_SummaryPage().show(); // Open the _05_SummaryPage frame
                    });
                    break;
                case "Sleep Tracking":
                    button.addActionListener(e -> {
                        frame.dispose(); // Close the current frame
                        new _06_LogSleep().show(); // Open the _06_LogSleep frame
                    });
                    break;
                case "Weight Management":
                    button.addActionListener(e -> {
                        frame.dispose(); // Close the current frame
                        new _07_LogWeight().show(); // Open the _07_LogWeight frame
                    });
                    break;
            }
        }

        // Add the panel to the frame
        frame.add(buttonPanel);

        // Create the "Wearable Device Settings" button
        JButton settingsButton = new JButton("Wearable Device Settings");
        settingsButton.setFont(new Font("Arial", Font.BOLD, 14));
        settingsButton.setBackground(new Color(255, 165, 0)); // Orange color
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        settingsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settingsButton.setBounds(50, 480, 300, 40); // Wider button
        settingsButton.addActionListener(e -> System.out.println("Wearable Device Settings button clicked"));
        frame.add(settingsButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().show());
    }
}