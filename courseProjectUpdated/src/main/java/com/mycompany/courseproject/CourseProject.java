/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.courseproject;


import javax.swing.SwingUtilities;

/**
 *
 * @author mohamed(gui), abdelrahman
 */



  

// Base Class (Encapsulation and Inheritance)
class CourseProject {
    private String courseName;
    private int duration; // in weeks
    private double fee;

    public CourseProject(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Getters and Setters for encapsulation
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    // Method to get details of the course
    public String getCourseDetails() {
        return "Course: " + courseName + "\nDuration: " + duration + " weeks\nFee: $" + fee;
    }
     public static void main(String[] args) {
   SwingUtilities.invokeLater(Loginpage::new);
   //SwingUtilities.invokeLater(Home::new);
  
   //SwingUtilities.invokeLater(systemManagement::new); 
   //SwingUtilities.invokeLater(studentManagement::new);
    //SwingUtilities.invokeLater(instructorManagement::new);
    }}



