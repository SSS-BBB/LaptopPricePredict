package Frames;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import Handler.DataHandler;
import Handler.WindowHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UserInputWindow implements ActionListener {
    
    protected JFrame frame;

    protected JPanel panel;

    protected JLabel jtextTitle;
    protected JButton nextButton;

    protected WindowHandler handler;
    protected DataHandler dataHandler;

    protected void prepareWindow(String programTitle) {
        frame = new JFrame(programTitle);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        setPanel();
    }

    public void setHandler(WindowHandler handler, DataHandler dataHandler) {
        this.handler = handler;
        this.dataHandler = dataHandler;
    }

    protected void setPanel() {
        // Middle
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 255, 255)); // White Background
        frame.setContentPane(panel);
    }

    protected void addTextLabel(String textTitle) {
        jtextTitle = new JLabel(textTitle);
        jtextTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        jtextTitle.setFont(new Font("Tahoma", Font.BOLD, 50));
        jtextTitle.setForeground(Color.BLACK);
        panel.add(jtextTitle);
    }

    protected void addButton(String buttonText) {
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
        nextButton.addActionListener(this);
        panel.add(nextButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Next window
        if (e.getSource() == nextButton) {
            frame.dispose();
            handler.nextPage();
        }
    }

}
