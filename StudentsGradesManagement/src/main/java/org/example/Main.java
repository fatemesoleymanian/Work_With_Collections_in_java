package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press e/E if you want to exit.");
        System.out.println("Create courses as many as you want.");

        while (true) {
            System.out.println("Course id:");
            String id = scanner.nextLine();
            if (id.equalsIgnoreCase("e")) break;

            System.out.println("Course name:");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("e")) break;

            System.out.println("Course units:");
            int units = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Course course = new Course(id, name, units);
            courses.add(course);
        }

        System.out.println("Courses created:");
        System.out.println(courses);

        System.out.println("Now create students with their grades in courses.");

        while (true) {
            System.out.println("Student id:");
            String id = scanner.nextLine();
            if (id.equalsIgnoreCase("e")) break;

            System.out.println("Student name:");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("e")) break;

            Map<Course, Double> grades = new HashMap<>();
            for (Course course : courses) {
                System.out.print("Grade in " + course.getName() + ": ");
                double grade = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                grades.put(course, grade);
            }

            Student student = new Student(id, name, grades);
            students.add(student);

            System.out.println("Added successfully:");
            System.out.println(students);
        }
    }
}
