/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ahmed
 */

public class Home {
    public Home() {
        createHomeScreen();
    }

    private void createHomeScreen() {
        JFrame frame = new JFrame("Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 63, 65));
        JLabel titleLabel = new JLabel("Welcome to Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton studentButton = new JButton("Student Management");
        JButton courseButton = new JButton("Course Management");
        JButton instructorButton = new JButton("Instructor Management");

        styleButton(studentButton);
        styleButton(courseButton);
        styleButton(instructorButton);

        // Event Listeners for buttons
        studentButton.addActionListener(e -> {
            frame.dispose(); // Close the Home screen
            SwingUtilities.invokeLater(studentManagement::new);
        });

        courseButton.addActionListener(e -> {
            frame.dispose(); // Close the Home screen
            SwingUtilities.invokeLater(systemManagement::new);
        });

instructorButton.addActionListener(e -> {
    frame.dispose(); // Close the Home screen
    instructorManagement.getInstance().setVisible(true); // Use setVisible(true) instead of show()
});


        buttonPanel.add(studentButton);
        buttonPanel.add(courseButton);
        buttonPanel.add(instructorButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(60, 63, 65));
        JLabel footerLabel = new JLabel("© 2024 Management System");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(60, 63, 65));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(40, 40, 40), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Home::new);
    }
}


 


    
