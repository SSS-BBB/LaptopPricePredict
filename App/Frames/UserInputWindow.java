package Frames;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

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
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Color.LIGHT_GRAY));
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
        // Middle
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 255, 255)); // White Background
        frame.setContentPane(panel);
    }

    private void addTextLabel(String textTitle) {
        jtextTitle = new JLabel(textTitle);
        jtextTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        jtextTitle.setFont(new Font("Tahoma", Font.BOLD, 50));
        jtextTitle.setForeground(Color.BLACK);
        panel.add(jtextTitle);
    }

    private void addButton(String buttonText) {
        nextButton = new JButton(buttonText);
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextButton.setPreferredSize(new Dimension(120, 60));
        nextButton.setMaximumSize(nextButton.getPreferredSize());
        nextButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        nextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        nextButton.setFocusPainted(false);
        nextButton.setBackground(Color.BLUE);
        nextButton.setForeground(Color.WHITE);
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(nextButton);
    }

    private void setTextFieldComponents(String textTitle, String fieldText, String buttonText) {
        // Set components for Field input

        // Create Top Blank Space
        panel.add(Box.createVerticalGlue());

        // TextTitle of the page
        addTextLabel(textTitle);

        // Padding
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Text field
        textInput = new JTextField(fieldText);
        textInput.setAlignmentX(Component.CENTER_ALIGNMENT);
        textInput.setPreferredSize(new Dimension(600, 40));
        textInput.setMaximumSize(textInput.getPreferredSize());
        textInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textInput.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        textInput.setForeground(Color.BLACK);
        panel.add(textInput);

        // Padding
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Next Button
        addButton(buttonText);

        // Create Bottom Blank Space
        panel.add(Box.createVerticalGlue());
    }

    private void setDropDownComponents(String textTitle, String[] dropDownList, String buttonText) {
        // Set components for Field input

        // Create Top Blank Space
        panel.add(Box.createVerticalGlue());

        // textTitle of the page
        addTextLabel(textTitle);

        // Padding
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Dropdown Box
        dropDownBox = new JComboBox<>(dropDownList);
        dropDownBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        dropDownBox.setPreferredSize(new Dimension(500, 40));
        dropDownBox.setMaximumSize(dropDownBox.getPreferredSize());
        dropDownBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        dropDownBox.setBackground(Color.WHITE);
        dropDownBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        dropDownBox.setForeground(Color.BLACK);
        panel.add(dropDownBox);

        // Padding
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Next Button
        addButton(buttonText);

        // Create Bottom Blank Space
        panel.add(Box.createVerticalGlue());
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
