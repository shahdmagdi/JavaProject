/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseproject;

/**
 *
 * @author abdelrahman
 */
class OnsiteCourse extends CourseProject {
    private String location;

    public OnsiteCourse(String courseName, int duration, double fee, String location) {
        super(courseName, duration, fee);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Overriding the base class method (Polymorphism)
    @Override
    public String getCourseDetails() {
        return super.getCourseDetails() + "\nLocation: " + location;
    }
}
