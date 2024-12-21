package com.mycompany.courseproject;
/**
 *
 * @author menna
 */

public class personInfo {
    private String name;
    private int age;
    private int id;  // New field for id

    // Updated constructor to include id
    public personInfo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Updated toString method to include id
    @Override
    public String toString() {
        return "personInfo{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
}
