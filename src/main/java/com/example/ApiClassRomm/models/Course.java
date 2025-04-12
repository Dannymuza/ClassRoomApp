package com.example.ApiClassRomm.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourse;
    private String name;
    @Column(nullable = false, length = 100)
    @ManyToOne
    @JoinColumn ( name = "fk_docent",referencedColumnName = "id")
    @JsonBackReference
    Teacher teacher;
    public Course() {}

    public Course(Integer idCourse, String name) {
        this.idCourse = idCourse;
        this.name = name;
    }

    public Integer getIdCourse() { return idCourse; }
    public void setIdCourse(Integer idCourse) { this.idCourse = idCourse; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

