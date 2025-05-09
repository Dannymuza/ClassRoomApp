package com.example.ApiClassRomm.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Cambiado de String name a User user

    private String specialty;

    @OneToMany(mappedBy = "teacher") // Corregido "docent" a "teacher"
    @JsonManagedReference
    private List<Course> courses;

    public Teacher() {}

    public Teacher(Integer id, User user, String specialty) { // Cambiado el constructor
        this.id = id;
        this.user = user;  // Actualizado para usar la entidad User
        this.specialty = specialty;
    }

    public Integer getIdTeacher() { return id; }
    public void setIdTeacher(Integer idTeacher) { this.id = idTeacher; }

    public User getUser() { return user; }  // Cambiado el tipo de retorno
    public void setUser(User user) { this.user = user; }  // Cambiado el tipo del parámetro

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}
