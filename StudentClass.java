/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentclass;

/**
 *
 * @author Ard Al Jood
 */
public class StudentClass {
private String name;
    private String id;
    private String year;
    private String grade;
    private String course;

    // Constructor
    public StudentClass(String name, String id, String year, String grade, String course) {
        this.name = name;
        this.id = id;
        this.year = year;
        this.grade = grade;
        this.course = course;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", grade='" + grade + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
    
    public static void main(String[] args) {
        // Launch the GUI (StGUI)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StGUI().setVisible(true);  // This will launch your StGUI JFrame
            }
        });
    }
}
