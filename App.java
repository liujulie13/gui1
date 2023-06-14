package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JTextField textField;
    private JLabel resultLabel;

    public App() {
        // Main panel
        setTitle("Integer Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 120);
        setLocationRelativeTo(null);
        setBackground(new Color(240,200,205));
        setLayout(new FlowLayout());

        // Create the components
        textField = new JTextField(10);
        JButton verifyButton = new JButton("Verify");
        JButton cancelButton = new JButton("Quit");
        resultLabel = new JLabel();

        // Add event listeners
        verifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                try {
                    int value = Integer.parseInt(input);
                    resultLabel.setText("Valid integer!");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Not a valid integer!");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Add components to the frame
        add(textField);
        add(verifyButton);
        add(cancelButton);
        add(resultLabel);

        // Show the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}
