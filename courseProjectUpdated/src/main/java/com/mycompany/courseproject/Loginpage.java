/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseproject;

/**
 *
 * @author ahmed
 */

    import javax.swing.*;
import java.awt.*;

public class Loginpage  {

    public Loginpage () {
        createHomeScreen();
    }

    private void createHomeScreen() {
        JFrame frame = new JFrame("Home - Login Page");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 63, 65));
        JLabel titleLabel = new JLabel("Welcome to the Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton studentLoginButton = new JButton("Login as Student");
        JButton instructorLoginButton = new JButton("Login as Instructor");
        JButton adminLoginButton = new JButton("Login as Administrator");

        styleButton(studentLoginButton);
        styleButton(instructorLoginButton);
        styleButton(adminLoginButton);

        // Button Actions
        studentLoginButton.addActionListener(e -> {
            frame.dispose();
           // SwingUtilities.invokeLater(systemManagement::new);
             SwingUtilities.invokeLater(studentControl::new);
             
        });

        instructorLoginButton.addActionListener(e -> {
            frame.dispose();
            SwingUtilities.invokeLater(instructorControl::new);
          
        });

        adminLoginButton.addActionListener(e -> {
            frame.dispose();
            SwingUtilities.invokeLater(() -> new Home()); // Assuming AdministratorGUI exists
        });

        buttonPanel.add(studentLoginButton);
        buttonPanel.add(instructorLoginButton);
        buttonPanel.add(adminLoginButton);

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
        button.setFont(new Font("Arial", Font.PLAIN, 18));
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
        SwingUtilities.invokeLater(Loginpage::new);
    }
}


