package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

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
        if (e.getSource() == nextButton) {
            // Check empty
            if (textInput.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please Enter a Number", "Enter a number", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if input is valid (number) from https://www.baeldung.com/java-check-string-number
            Pattern numPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

            if (!numPattern.matcher(textInput.getText()).matches()) {
                JOptionPane.showMessageDialog(frame, "Please Enter a Number", "Enter a number", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Add Data
            dataHandler.addData(handler.currentPage, textInput.getText());
        }

        // Go to next window
        super.actionPerformed(e);
    }
    
}