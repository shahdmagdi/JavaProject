/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseproject;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author g
 */




import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author shahd
 */

public class studentManagement {
    private List<Student> students;

    public studentManagement() {
        students = new ArrayList<>();
        createStudentHomeScreen();
    }

    private void createStudentHomeScreen() {
        JFrame frame = new JFrame("Student Management System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Menu Bar with Exit Option
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));  // Exit the application
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 63, 65));
        JLabel titleLabel = new JLabel("Student Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton addStudentButton = new JButton("Add Student");
        JButton displayStudentsButton = new JButton("Display Students");
        JButton editStudentButton = new JButton("Edit Student");

        styleButton(addStudentButton);
        styleButton(displayStudentsButton);
        styleButton(editStudentButton);

        addStudentButton.addActionListener(e -> openAddStudentScreen());
        displayStudentsButton.addActionListener(e -> displayStudents());
        editStudentButton.addActionListener(e -> openEditStudentScreen());

        buttonPanel.add(addStudentButton);
        buttonPanel.add(displayStudentsButton);
        buttonPanel.add(editStudentButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(60, 63, 65));
        JLabel footerLabel = new JLabel("© 2024 Student Management System");
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
        //button.setSize(20, 20);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(40, 40, 40), 2),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void openAddStudentScreen() {
        JFrame addFrame = new JFrame("Add Student");
        addFrame.setSize(400, 500);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();
        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
         JLabel GPALabel = new JLabel("GPA:");
        JTextField  GPAField = new JTextField();
        
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            int id = Integer.parseInt(idField.getText());
            double GPA = Double.parseDouble(GPAField.getText() );
            students.add(new Student(id, name, age,GPA));
            JOptionPane.showMessageDialog(addFrame, "Student Added Successfully!");
            addFrame.dispose();
        });

        cancelButton.addActionListener(e -> addFrame.dispose());

        addFrame.add(nameLabel);
        addFrame.add(nameField);
        addFrame.add(ageLabel);
        addFrame.add(ageField);
        addFrame.add(idLabel);
        addFrame.add(idField);
        addFrame.add(GPALabel);
        addFrame.add(GPAField);
        
        
        addFrame.add(addButton);
        addFrame.add(cancelButton);

        addFrame.setVisible(true);
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
            sb.append("Students:\n");
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
        editFrame.setSize(300, 400);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.setLayout(new GridLayout(8, 2, 10, 10));
        
        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("New Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("New Age:");
        JTextField ageField = new JTextField();
         JLabel GPALabel = new JLabel("New GPA:");
        JTextField GPAField = new JTextField();

        JButton editButton = new JButton("Edit");
        JButton cancelButton = new JButton("Cancel");

        editButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String newName = nameField.getText();
            int newAge = Integer.parseInt(ageField.getText());
            double newGPA = Double.parseDouble(GPAField.getText());

            boolean studentFound = false;
            for (Student student : students) {
                if (student.getId() == id) {
                    student.setName(newName);
                    student.setAge(newAge);
                    student.setGPA(newGPA);
                    studentFound = true;
                    JOptionPane.showMessageDialog(editFrame, "Student Updated Successfully!");
                    break;
                }
            }

            if (!studentFound) {
                JOptionPane.showMessageDialog(editFrame, "Student with ID " + id + " not found.");
            }
            editFrame.dispose();
        });

        cancelButton.addActionListener(e -> editFrame.dispose());

        editFrame.add(idLabel);
        editFrame.add(idField);
        editFrame.add(nameLabel);
        editFrame.add(nameField);
        editFrame.add(ageLabel);
        editFrame.add(ageField);
        editFrame.add(GPALabel);
        editFrame.add(GPAField);
        editFrame.add(editButton);
        editFrame.add(cancelButton);

        editFrame.setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(studentManagement::new);
    }
}

   





   



   