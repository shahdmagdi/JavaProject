/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author g
 */

    

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mohamed
 */

public class studentControl {
    private List<Student> students;
    private List<CourseProject> courses;

    public studentControl() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        createHomeScreen();
        initializeData();
    }

    private void createHomeScreen() {
        JFrame frame = new JFrame("Student Control System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Menu Bar with Exit Option
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 63, 65));
        JLabel titleLabel = new JLabel("Student Control System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton displayStudentsButton = new JButton("Display Students");
        JButton editStudentButton = new JButton("Edit Student");
        JButton displayCoursesButton = new JButton("Display Courses");

        styleButton(displayStudentsButton);
        styleButton(editStudentButton);
        styleButton(displayCoursesButton);

        displayStudentsButton.addActionListener(e -> displayStudents());
        editStudentButton.addActionListener(e -> openEditStudentScreen());
        displayCoursesButton.addActionListener(e -> displayCourses());

        buttonPanel.add(displayStudentsButton);
        buttonPanel.add(editStudentButton);
        buttonPanel.add(displayCoursesButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(60, 63, 65));
        JLabel footerLabel = new JLabel("© 2024 Student Control System");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 15));
        button.setBackground(new Color(60, 63, 65));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(40, 40, 40), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void displayStudents() {
        JFrame displayFrame = new JFrame("All Students");
        displayFrame.setSize(400, 300);
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder sb = new StringBuilder();
        if (students.isEmpty()) {
            sb.append("No students available.");
        } else {
            for (Student student : students) {
                sb.append("ID: ").append(student.getId()).append("\n")
                        .append("Name: ").append(student.getName()).append("\n")
                        .append("Age: ").append(student.getAge()).append("\n")
                        .append("GPA: ").append(student.getGPA()).append("\n")
                        .append("-----------------------\n");
            }
        }

        textArea.setText(sb.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        displayFrame.add(scrollPane, BorderLayout.CENTER);

        displayFrame.setVisible(true);
    }

   private void openEditStudentScreen() {
    JFrame editFrame = new JFrame("Edit Student");
    editFrame.setSize(300, 300);
    editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    editFrame.setLayout(new GridLayout(7, 2, 10, 10));

    JLabel idLabel = new JLabel("Student ID:");
    JTextField idField = new JTextField();
    JLabel currentNameLabel = new JLabel("Current Name:");
    JLabel currentNameDisplay = new JLabel(""); // This will show the current name
    JLabel nameLabel = new JLabel("New Name:");
    JTextField nameField = new JTextField();

    JButton editButton = new JButton("Edit");
    JButton cancelButton = new JButton("Cancel");

    // When the student ID field is changed, update the current name label
    idField.addCaretListener(e -> {
        String idText = idField.getText();
        if (!idText.isEmpty()) {
            try {
                int id = Integer.parseInt(idText);
                Student studentToEdit = null;
                // Find the student with the given ID
                for (Student student : students) {
                    if (student.getId() == id) {
                        studentToEdit = student;
                        break;
                    }
                }
                if (studentToEdit != null) {
                    currentNameDisplay.setText(studentToEdit.getName());
                    nameField.setText(""); // Clear new name field
                } else {
                    currentNameDisplay.setText("Student not found!");
                    nameField.setText(""); // Clear new name field if student is not found
                }
            } catch (NumberFormatException ex) {
                currentNameDisplay.setText("Invalid ID format!");
            }
        }
    });

    // Action to update the student name
    editButton.addActionListener(e -> {
        String idText = idField.getText();
        String newName = nameField.getText();

        if (!idText.isEmpty() && !newName.isEmpty()) {
            try {
                int id = Integer.parseInt(idText);
                boolean studentFound = false;
                for (Student student : students) {
                    if (student.getId() == id) {
                        student.setName(newName);  // Update name
                        studentFound = true;
                        JOptionPane.showMessageDialog(editFrame, "Student name updated successfully!");
                        break;
                    }
                }
                if (!studentFound) {
                    JOptionPane.showMessageDialog(editFrame, "Student with ID " + id + " not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(editFrame, "Invalid ID format.");
            }
        } else {
            JOptionPane.showMessageDialog(editFrame, "Please enter a valid ID and new name.");
        }
        editFrame.dispose(); // Close the window after editing
    });

    cancelButton.addActionListener(e -> editFrame.dispose()); // Close without editing

    // Adding components to the frame
    editFrame.add(idLabel);
    editFrame.add(idField);
    editFrame.add(currentNameLabel);
    editFrame.add(currentNameDisplay);  // Display current name
    editFrame.add(nameLabel);
    editFrame.add(nameField);
    editFrame.add(editButton);
    editFrame.add(cancelButton);

    editFrame.setVisible(true);
}



    private void displayCourses() {
        JFrame displayFrame = new JFrame("All Courses");
        displayFrame.setSize(400, 300);
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder sb = new StringBuilder();
        if (courses.isEmpty()) {
            sb.append("No courses available.");
        } else {
            for (CourseProject course : courses) {
                sb.append(course.getCourseDetails()).append("\n-----------------------\n");
            }
        }

        textArea.setText(sb.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        displayFrame.add(scrollPane, BorderLayout.CENTER);

        displayFrame.setVisible(true);
    }
     private void initializeData() {
        // Predefined students
        students.add(new Student(1, "John Doe", 20, 3.5));
       

        // Predefined courses
        courses.add(new CourseProject("Math",12, 150.00));
        courses.add(new CourseProject("History", 10, 120.00));
        courses.add(new CourseProject("Computer-Science", 14, 200.00));

      
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(studentControl::new);
    }

}
  
