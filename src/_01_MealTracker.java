import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class _01_MealTracker extends BaseUI {
    public _01_MealTracker() {
        super();
        // change status bar text
        JLabel statusBar = (JLabel) frame.getContentPane().getComponent(0);
        statusBar.setText("Meal Tracker");
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
            searchIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            searchIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Handle the click event here
                    System.out.println("Search icon clicked");
                }
            });
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
        nutritionFacts.setFocusable(false);
        frame.add(nutritionFacts);

        // Portion Size
        JLabel portionLabel = new JLabel("Enter Portion Size: (in g)");
        portionLabel.setBounds(50, 220, 150, 30);
        frame.add(portionLabel);

        JTextField portionField = new JTextField();
        portionField.setBounds(200, 220, 100, 30);
        frame.add(portionField);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(310, 220, 80, 30);
        frame.add(submitButton);

        // Daily Goals
        JLabel dailyGoalsLabel = new JLabel("Your Daily Goals:");
        dailyGoalsLabel.setBounds(50, 270, 150, 30);
        frame.add(dailyGoalsLabel);

        JTextArea dailyGoals = new JTextArea("Protein: 45%\nCarbs: 38%\nFat: 42%");
        dailyGoals.setEditable(false);
        dailyGoals.setBounds(200, 270, 100, 60);
        dailyGoals.setFocusable(false);
        frame.add(dailyGoals);

        // Buttons
        JButton deleteMealButton = new JButton("DELETE MEAL");
        deleteMealButton.setBounds(50, 350, 140, 40);
        deleteMealButton.setBackground(Color.RED);
        deleteMealButton.setOpaque(true);
        deleteMealButton.setBorderPainted(false);
        frame.add(deleteMealButton);

        JButton saveMealButton = new JButton("SAVE MEAL");
        saveMealButton.setBounds(200, 350, 140, 40);
        saveMealButton.setBackground(Color.GREEN);
        saveMealButton.setOpaque(true);
        saveMealButton.setBorderPainted(false);
        frame.add(saveMealButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new _01_MealTracker().show());
    }
}