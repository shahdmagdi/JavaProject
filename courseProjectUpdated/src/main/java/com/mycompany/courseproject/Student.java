package com.mycompany.courseproject;

/**
 *
 * @author shahd
 */
public class Student extends personInfo {

    private double GPA;

    // Constructor for Student class
    public Student(int id, String name, int age, double GPA) {
        super(id, name, age);  // Pass id, name, and age to the parent constructor
        this.GPA = GPA;
    }

    // Getter and Setter for GPA
    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +  // Use the inherited id field
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", GPA=" + GPA +
                '}';
    }
}
