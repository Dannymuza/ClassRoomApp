package com.example.ApiClassRomm.models;

import jakarta.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTeacher;
    private String name;
    private String specialty;

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
