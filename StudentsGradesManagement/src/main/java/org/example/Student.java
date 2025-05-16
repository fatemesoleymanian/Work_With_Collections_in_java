package org.example;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private Map<Course, Double> grades = new HashMap<>();

    public Student(String id, String name, Map<Course, Double> grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Course, Double> getGrades() {
        return grades;
    }

    public void setGrades(Map<Course, Double> grades) {
        this.grades = grades;
    }
    public void addGrade(Course course, double grade){
        grades.put(course,grade);
    }
    public double getAverage(){
        if (grades.isEmpty()) return 0;
        return grades.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
