package com.example.ApiClassRomm.models;

import com.example.ApiClassRomm.helpers.Grade;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;
    @JoinColumn(name = "idStudent", nullable = false)

    private String name;
    @JoinColumn(name = "id_user", nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private String address;
    @Column(nullable = false, length = 255)
    @Enumerated(EnumType.STRING)
    private Grade grade;


    public Student()

    {}

    public Student(Integer idStudent, String name, Date birthDate, String address, Grade grade) {
        this.idStudent = idStudent;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.grade = grade;
    }

    public Integer getIdStudent() { return idStudent; }
    public void setIdStudent(Integer idStudent) { this.idStudent = idStudent; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
}
