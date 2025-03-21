package com.example.ApiClassRomm.models;

import jakarta.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubject;
    @Column(nullable = false, length = 100)
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private String name;

    public Subject() {}

    public Subject(Integer idSubject, String name) {
        this.idSubject = idSubject;
        this.name = name;
    }

    public Integer getIdSubject() { return idSubject; }
    public void setIdSubject(Integer idSubject) { this.idSubject = idSubject; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
