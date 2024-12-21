package com.mycompany.courseproject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Path;
/**
 *
 * @author bahaa
 */
public class Instructor extends personInfo {
    static final Path FILE_NAME = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "com", "mycompany", "courseproject", "instructors.txt");
    private String course;

    public Instructor(String name, String course, int id) {
        super(id, name, 30);
        this.course = course;
    }

    public Instructor(String name, String course, int id, int age) {
        super(id, name, age);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return getName() + " (" + getCourse() + ", ID: " + getId() + ")";
    }

    public static List<Instructor> readFromFile() {
        List<Instructor> instructors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String[] nameCourse = parts[0].split("-");
                    if (nameCourse.length == 2) {
                        String name = nameCourse[0].trim();
                        String course = nameCourse[1].trim();
                        try {
                            int id = Integer.parseInt(parts[1].trim());
                            instructors.add(new Instructor(name, course, id, 30));
                        } catch (NumberFormatException e) {
                            System.out.println("Skipping invalid data: " + line);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instructors;
    }

    public static List<Instructor> searchInFile(String query) {
        List<Instructor> matchingInstructors = new ArrayList<>();
        List<Instructor> instructors = readFromFile();
        for (Instructor instructor : instructors) {
            if (instructor.getName().toLowerCase().contains(query.toLowerCase()) ||
                instructor.getCourse().toLowerCase().contains(query.toLowerCase()) ||
                String.valueOf(instructor.getId()).contains(query)) {
                matchingInstructors.add(instructor);
            }
        }
        return matchingInstructors;
    }

    public static void writeToFile(Instructor instructor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME.toFile(), true))) {
            bw.write(instructor.getName() + "-" + instructor.getCourse() + ", " + instructor.getId());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateInFile(int lineNumber, String newData) {
        List<Instructor> instructors = readFromFile();
        if (lineNumber >= 0 && lineNumber < instructors.size()) {
            String[] parts = newData.split(",");
            if (parts.length == 2) {
                String[] nameCourse = parts[0].split("-");
                if (nameCourse.length == 2) {
                    String name = nameCourse[0].trim();
                    String course = nameCourse[1].trim();
                    try {
                        int id = Integer.parseInt(parts[1].trim());
                        instructors.set(lineNumber, new Instructor(name, course, id, 30));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid data: " + newData);
                    }
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME.toFile()))) {
                for (Instructor instructor : instructors) {
                    bw.write(instructor.getName() + "-" + instructor.getCourse() + ", " + instructor.getId());
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid line number.");
        }
    }

    public static void deleteFromFile(int lineNumber) {
        List<Instructor> instructors = readFromFile();
        if (lineNumber >= 0 && lineNumber < instructors.size()) {
            instructors.remove(lineNumber);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME.toFile()))) {
                for (Instructor instructor : instructors) {
                    bw.write(instructor.getName() + "-" + instructor.getCourse() + ", " + instructor.getId());
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid line number.");
        }
    }
}
