package com.example.ApiClassRomm.models;

import jakarta.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubject;

    @ManyToOne(fetch = FetchType.LAZY) // Usar FetchType.LAZY para mejor rendimiento
    @JoinColumn(name = "course_id", nullable = false) // Especifica la columna de la clave foránea
    private Course course; // La propiedad ahora es del tipo Course, representando la relación

    @Column(name = "subject_name", nullable = false, length = 100)
    private String name;

    public Subject() {}

    public Subject(Integer idSubject, Course course, String name) {
        this.idSubject = idSubject;
        this.course = course;
        this.name = name;
    }

    public Integer getIdSubject() { return idSubject; }
    public void setIdSubject(Integer idSubject) { this.idSubject = idSubject; }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}