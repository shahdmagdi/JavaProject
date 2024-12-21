/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseproject;

/**
 *
 * @author shahd, abdelrahman(gui)
 */

    class onlineCourse extends CourseProject {
    private String platform;

    public onlineCourse(String courseName, int duration, double fee, String platform) {
        super(courseName, duration, fee);
       
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
     @Override
    public String getCourseDetails() {
        return super.getCourseDetails() + "\nPlatform: " + platform;
    }
    }

