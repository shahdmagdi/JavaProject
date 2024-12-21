/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseproject;
import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author menna(gui), mohamed
 */


public class systemManagement {
    private List<CourseProject> courses;

    public systemManagement() {
        courses = new ArrayList<>();
        createHomeScreen();
    }

    private void createHomeScreen() {
        JFrame frame = new JFrame("Course Management System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 63, 65));
        JLabel titleLabel = new JLabel("Course Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton addCourseButton = new JButton("Add Course");
        JButton displayCoursesButton = new JButton("Display Courses");
        JButton exitButton = new JButton("Exit");

        styleButton(addCourseButton);
        styleButton(displayCoursesButton);
        styleButton(exitButton);

        addCourseButton.addActionListener(e -> openAddCourseScreen());
        displayCoursesButton.addActionListener(e -> displayCourses());
        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(addCourseButton);
        buttonPanel.add(displayCoursesButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(60, 63, 65));
        JLabel footerLabel = new JLabel("© 2024 Course Management System");
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

    private void openAddCourseScreen() {
        JFrame addFrame = new JFrame("Add Course");
        addFrame.setSize(400, 300);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel nameLabel = new JLabel("Course Name:");
        JTextField nameField = new JTextField();
        JLabel durationLabel = new JLabel("Duration (weeks):");
        JTextField durationField = new JTextField();
        JLabel feeLabel = new JLabel("Fee:");
        JTextField feeField = new JTextField();
        JLabel typeLabel = new JLabel("Course Type:");
        JComboBox<String> typeBox = new JComboBox<>(new String[]{"Online", "Onsite"});
        JLabel extraLabel = new JLabel("Platform/Location:");
        JTextField extraField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            int duration = Integer.parseInt(durationField.getText());
            double fee = Double.parseDouble(feeField.getText());
            String type = (String) typeBox.getSelectedItem();
            String extra = extraField.getText();

            if ("Online".equals(type)) {
                courses.add(new onlineCourse(name, duration, fee, extra));
            } else {
                courses.add(new OnsiteCourse(name, duration, fee, extra));
            }
            JOptionPane.showMessageDialog(addFrame, "Course Added Successfully!");
            addFrame.dispose();
        });

        cancelButton.addActionListener(e -> addFrame.dispose());

        addFrame.add(nameLabel);
        addFrame.add(nameField);
        addFrame.add(durationLabel);
        addFrame.add(durationField);
        addFrame.add(feeLabel);
        addFrame.add(feeField);
        addFrame.add(typeLabel);
        addFrame.add(typeBox);
        addFrame.add(extraLabel);
        addFrame.add(extraField);
        addFrame.add(addButton);
        addFrame.add(cancelButton);

        addFrame.setVisible(true);
    }

    private void displayCourses() {
        JFrame displayFrame = new JFrame("All Courses");
        displayFrame.setSize(400, 300);
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        if (courses.isEmpty()) {
            textArea.setText("No courses available.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (CourseProject course : courses) {
                sb.append(course.getCourseDetails()).append("\n\n");
            }
            textArea.setText(sb.toString());
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        displayFrame.add(scrollPane, BorderLayout.CENTER);

        displayFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(systemManagement::new);
    }
}
  /*  private void createGUI() {
        frame = new JFrame("Course Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Course Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 10, 10));

        JButton addOnlineCourseButton = new JButton("Add Online Course");
        JButton addOnsiteCourseButton = new JButton("Add Onsite Course");
        JButton displayCoursesButton = new JButton("Display Courses");
        JButton updateFeeButton = new JButton("Update Fee");

        buttonPanel.add(addOnlineCourseButton);
        buttonPanel.add(addOnsiteCourseButton);
        buttonPanel.add(displayCoursesButton);
        buttonPanel.add(updateFeeButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Action Listeners
        addOnlineCourseButton.addActionListener(e -> addOnlineCourse());
        addOnsiteCourseButton.addActionListener(e -> addOnsiteCourse());
        displayCoursesButton.addActionListener(e -> displayCourses());
        updateFeeButton.addActionListener(e -> updateFee());

        // Show the frame
        frame.setVisible(true);
    }

    private void addOnlineCourse() {
        JTextField courseNameField = new JTextField();
        JTextField durationField = new JTextField();
        JTextField feeField = new JTextField();
        JTextField platformField = new JTextField();

        Object[] message = {
                "Course Name:", courseNameField,
                "Duration (weeks):", durationField,
                "Fee ($):", feeField,
                "Platform:", platformField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Add Online Course", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String courseName = courseNameField.getText();
            int duration = Integer.parseInt(durationField.getText());
            double fee = Double.parseDouble(feeField.getText());
            String platform = platformField.getText();

            courses.add(new onlineCourse(courseName, duration, fee, platform));
            JOptionPane.showMessageDialog(frame, "Online Course Added Successfully!");
        }
    }

    private void addOnsiteCourse() {
        JTextField courseNameField = new JTextField();
        JTextField durationField = new JTextField();
        JTextField feeField = new JTextField();
        JTextField locationField = new JTextField();

        Object[] message = {
                "Course Name:", courseNameField,
                "Duration (weeks):", durationField,
                "Fee ($):", feeField,
                "Location:", locationField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Add Onsite Course", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String courseName = courseNameField.getText();
            int duration = Integer.parseInt(durationField.getText());
            double fee = Double.parseDouble(feeField.getText());
            String location = locationField.getText();

            courses.add(new OnsiteCourse(courseName, duration, fee, location));
            JOptionPane.showMessageDialog(frame, "Onsite Course Added Successfully!");
        }
    }

    private void displayCourses() {
        if (courses.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No courses available.");
        } else {
            StringBuilder courseList = new StringBuilder();
            for (CourseProject course : courses) {
                courseList.append(course.getCourseDetails()).append("\n\n");
            }
            JTextArea textArea = new JTextArea(courseList.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(frame, scrollPane, "All Courses", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateFee() {
        JTextField courseNameField = new JTextField();
        JTextField newFeeField = new JTextField();

        Object[] message = {
                "Course Name:", courseNameField,
                "New Fee ($):", newFeeField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Update Course Fee", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String courseName = courseNameField.getText();
            double newFee = Double.parseDouble(newFeeField.getText());
            boolean courseFound = false;

            for (CourseProject course : courses) {
                if (course.getCourseName().equalsIgnoreCase(courseName)) {
                    course.setFee(newFee);
                    courseFound = true;
                    JOptionPane.showMessageDialog(frame, "Course fee updated successfully!");
                    break;
                }
            }

            if (!courseFound) {
                JOptionPane.showMessageDialog(frame, "Course not found.");
            }
        }
    }}
*/
