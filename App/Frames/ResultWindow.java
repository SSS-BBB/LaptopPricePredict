package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Handler.WindowHandler;

public class ResultWindow implements ActionListener {
    
    JFrame frame;

    JPanel panel;

    JLabel textTitle;
    JLabel textResult;
    JButton newButton;

    WindowHandler handler;

    public ResultWindow(WindowHandler handler) {
        this.handler = handler;

        // Frame
        frame = new JFrame("Result");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // Panel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 255, 255)); // White Background
        frame.setContentPane(panel);

        // Create Top Blank Space
        panel.add(Box.createVerticalGlue());

        // Create Top Blank Space
        panel.add(Box.createVerticalGlue());

        // textTitle of the page
        addTextLabel("Result from the model");

        // Padding
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Show Result
        addTextResult("500");

        // Padding
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // New Button
        addButton("New Laptop");

        // Create Bottom Blank Space
        panel.add(Box.createVerticalGlue());

        frame.setVisible(true);
    }

    protected void addTextLabel(String title) {
        textTitle = new JLabel(title);
        textTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        textTitle.setFont(new Font("Tahoma", Font.BOLD, 50));
        textTitle.setForeground(Color.BLACK);
        panel.add(textTitle);
    }

    protected void addTextResult(String result) {
        textResult = new JLabel(result);
        textResult.setAlignmentX(Component.CENTER_ALIGNMENT);
        textResult.setFont(new Font("Tahoma", Font.BOLD, 50));
        textResult.setForeground(Color.GREEN);
        panel.add(textResult);
    }

    protected void addButton(String buttonText) {
        newButton = new JButton(buttonText);
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newButton.setPreferredSize(new Dimension(200, 60));
        newButton.setMaximumSize(newButton.getPreferredSize());
        newButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        newButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        newButton.setFocusPainted(false);
        newButton.setBackground(Color.BLUE);
        newButton.setForeground(Color.WHITE);
        newButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        newButton.addActionListener(this);
        panel.add(newButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newButton) {
            frame.dispose();
            handler.start();
        }
    }

}
