package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextfieldInputWindow extends UserInputWindow {

    JTextField textInput; // For Continuous data

    public TextfieldInputWindow(String programTitle, String textTitle, String fieldText, String buttonText) {
        // Constructor for Field input
        prepareWindow(programTitle);

        // Set Components
        setTextFieldComponents(textTitle, fieldText, buttonText);

        // Show Frame
        frame.setVisible(true);
    }

    protected void setTextFieldComponents(String textTitle, String fieldText, String buttonText) {
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

    @Override
    public void actionPerformed(ActionEvent e) {

        // Go to next window
        super.actionPerformed(e);
    }
    
}