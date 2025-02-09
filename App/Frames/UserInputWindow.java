package Frames;
import javax.swing.*;
import java.awt.*;

public class UserInputWindow extends JFrame {
    
    JPanel panel;

    JLabel jTitle;
    JTextField textInput;
    JButton nextButton;

    UserInputWindow nextPage;

    public UserInputWindow(String title, String fieldText, String buttonText) {
        // Constructor for Field input
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        setPanel();

        setComponents(title, fieldText, buttonText);

        setVisible(true);
    }

    private void setPanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setContentPane(panel);
    }

    private void setComponents(String title, String fieldText, String buttonText) {
        // Set components for Field input

        // Title of the page
        jTitle = new JLabel(title);
        jTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(jTitle);

        // Text field
        textInput = new JTextField(fieldText);
        textInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(textInput);

        // Next Button
        nextButton = new JButton(buttonText);
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(nextButton);
    }

}
