package com.example.student_manager.models;

public class Student {
    private int id;
    private String name;
    private String email;
    private Classroom classroom;

    public Student(int id, String name, String email, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.classroom = classroom;
    }

    public Student(String name, String email, Classroom classroom) {
        this.name = name;
        this.email = email;
        this.classroom = classroom;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
