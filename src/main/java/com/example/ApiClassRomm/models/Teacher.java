package com.example.ApiClassRomm.models;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTeacher;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private String name;
    private String specialty;
    @OneToMany (mappedBy = "docent")
    @JsonManagedReference
    private List <Course> courses;
    public Teacher() {}

    public Teacher(Integer idTeacher, String name, String specialty) {
        this.idTeacher = idTeacher;
        this.name = name;
        this.specialty = specialty;
    }

    public Integer getIdTeacher() { return idTeacher; }
    public void setIdTeacher(Integer idTeacher) { this.idTeacher = idTeacher; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}
