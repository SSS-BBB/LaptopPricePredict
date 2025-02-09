package Frames;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DropdownInputWindow extends UserInputWindow {

    JComboBox dropDownBox; // For Categorical data

    public DropdownInputWindow(String programTitle, String textTitle, String[] dropDownList, String buttonText) {
        // Constructor for Category input
        prepareWindow(programTitle);

        // Set Components
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Color.LIGHT_GRAY));
        setDropDownComponents(textTitle, dropDownList, buttonText);

        // Show Frame
        frame.setVisible(true); 
    }

    protected void setDropDownComponents(String textTitle, String[] dropDownList, String buttonText) {
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
        // Add Data
        if (e.getSource() == nextButton) {
            dataHandler.addData(handler.currentPage, dropDownBox.getSelectedItem().toString());
        }

        // Go to next window
        super.actionPerformed(e);
    }
}
