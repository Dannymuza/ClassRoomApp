package com.example.ApiClassRomm.models;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false)
    private Course Course;

    public Subject(){}

    public Subject(Integer id, String name, Course course){
        this.id = id;
        this.name = name;
        this.Course = course;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return Course;
    }
    public void setCourse(Course course) {
        this.Course = course;
    }
}