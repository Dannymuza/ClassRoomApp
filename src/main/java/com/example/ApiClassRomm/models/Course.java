package com.example.ApiClassRomm.models;
import com.example.ApiClassRomm.Service.CourseService;
import com.example.ApiClassRomm.repository.ICourseRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)  // Nombre consistente
    @JsonBackReference
    private Teacher teacher;

    public Course() {}

    public Course(Integer id, String name, Teacher teacher) {  // Añadido teacher
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    // Getters y setters COMPLETOS
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}


