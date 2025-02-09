package Frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UserInputWindow implements ActionListener, ItemListener {
    
    JFrame frame;

    JPanel panel;

    JLabel jtextTitle;
    JTextField textInput; // For Continuous data
    JComboBox dropDownBox; // For Categorical data
    JButton nextButton;

    UserInputWindow nextPage;

    public UserInputWindow(String programTitle, String textTitle, String fieldText, String buttonText) {
        // Constructor for Field input
        prepareWindow(programTitle);

        // Set Components
        setTextFieldComponents(textTitle, fieldText, buttonText);

        // Show Frame
        frame.setVisible(true);
    }

    public UserInputWindow(String programTitle, String textTitle, String[] dropDownList, String buttonText) {
        // Constructor for Category input
        prepareWindow(programTitle);

        // Set Components
        setDropDownComponents(textTitle, dropDownList, buttonText);

        // Show Frame
        frame.setVisible(true); 
    }

    private void prepareWindow(String programTitle) {
        frame = new JFrame(programTitle);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        setPanel();
    }

    private void setPanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setContentPane(panel);
    }

    private void setTextFieldComponents(String textTitle, String fieldText, String buttonText) {
        // Set components for Field input

        // textTitle of the page
        jtextTitle = new JLabel(textTitle);
        jtextTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(jtextTitle);

        // Text field
        textInput = new JTextField(fieldText);
        textInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(textInput);

        // Next Button
        nextButton = new JButton(buttonText);
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(nextButton);
    }

    private void setDropDownComponents(String textTitle, String[] dropDownList, String buttonText) {
        // Set components for Field input

        // textTitle of the page
        jtextTitle = new JLabel(textTitle);
        jtextTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(jtextTitle);

        // Dropdown Box
        dropDownBox = new JComboBox<>(dropDownList);
        dropDownBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(dropDownBox);

        // Next Button
        nextButton = new JButton(buttonText);
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(nextButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Button Clicked
        
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        // For Categorical data
        
    }

}
