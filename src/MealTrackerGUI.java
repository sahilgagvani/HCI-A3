import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MealTrackerGUI extends BaseUI {
    public MealTrackerGUI() {
        super("#1 - Meal Selection");
        // Set the background color of the frame
        frame.getContentPane().setBackground(new Color(205, 232, 181));

        // Create a panel to hold the text field and the icon
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBounds(50, 40, 300, 30);

        // Create the text field
        JTextField searchField = new JTextField("ADD MEAL");
        searchPanel.add(searchField, BorderLayout.CENTER);

        try {
            BufferedImage originalIcon = ImageIO.read(new File("resources/ui/glass.jpg"));
            Image scaledIcon = originalIcon.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JLabel searchIcon = new JLabel(new ImageIcon(scaledIcon));
            searchIcon.setPreferredSize(new Dimension(30, 30));
            searchPanel.add(searchIcon, BorderLayout.EAST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add the panel to the frame
        frame.add(searchPanel);

        // Meal Name
        JLabel mealLabel = new JLabel("Grilled Chicken Salad", SwingConstants.CENTER);
        mealLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        mealLabel.setBounds(50, 80, 300, 30);
        frame.add(mealLabel);

        // Image Placeholder
        JLabel mealImage = new JLabel();
        mealImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mealImage.setBounds(50, 120, 100, 80);
        try {
            BufferedImage mealImg = ImageIO.read(new File("resources/ui/1-salad.jpg"));
            Image scaledMealImg = mealImg.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
            mealImage.setIcon(new ImageIcon(scaledMealImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(mealImage);


        // Nutrition Facts Placeholder
        JTextArea nutritionFacts = new JTextArea("Nutrition Facts\nCalories: 302\nProtein: 31g\nCarbs: 7.6g\nFat: 17g");
        nutritionFacts.setEditable(false);
        nutritionFacts.setBounds(180, 120, 170, 80);
        frame.add(nutritionFacts);

        // Portion Size
        JLabel portionLabel = new JLabel("Enter Portion Size:");
        portionLabel.setBounds(50, 220, 150, 30);
        frame.add(portionLabel);

        JTextField portionField = new JTextField();
        portionField.setBounds(200, 220, 100, 30);
        frame.add(portionField);

        // Daily Goals
        JLabel dailyGoalsLabel = new JLabel("Your Daily Goals:");
        dailyGoalsLabel.setBounds(50, 270, 150, 30);
        frame.add(dailyGoalsLabel);

        JTextArea dailyGoals = new JTextArea("Protein: 45%\nCarbs: 38%\nFat: 42%");
        dailyGoals.setEditable(false);
        dailyGoals.setBounds(200, 270, 100, 60);
        frame.add(dailyGoals);

        // Buttons
        JButton deleteMealButton = new JButton("DELETE MEAL");
        deleteMealButton.setBounds(50, 350, 120, 40);
        deleteMealButton.setBackground(Color.RED);
        frame.add(deleteMealButton);

        JButton saveMealButton = new JButton("SAVE MEAL");
        saveMealButton.setBounds(200, 350, 120, 40);
        saveMealButton.setBackground(Color.GREEN);
        frame.add(saveMealButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MealTrackerGUI().show());
    }
}