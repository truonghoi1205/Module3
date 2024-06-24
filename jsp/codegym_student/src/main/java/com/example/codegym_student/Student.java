package com.example.codegym_student;

public class Student {
    private int id;
    private String name;
    private String gender;
    private double point;

    public Student(int id, String name, String gender, double point) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getGrade() {
        if (point >= 90) return "Giỏi";
        if (point >= 80) return "Khá";
        if (point >= 60) return "Trung bình";
        return "Yếu";
    }
}
