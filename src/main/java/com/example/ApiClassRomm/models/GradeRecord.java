package com.example.ApiClassRomm.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class GradeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGradeRecord;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student; // Cambiado el tipo a la entidad Student

    @Column(nullable = false, precision = 5, scale = 2)
    @Temporal(TemporalType.DATE)
    private Date evaluationDate;

    private Double score; //agregue esta linea

    public GradeRecord() {}

    public GradeRecord(Integer idGradeRecord, Student student, Double score, Date evaluationDate) { // Agregado Student al constructor
        this.idGradeRecord = idGradeRecord;
        this.student = student;
        this.score = score;
        this.evaluationDate = evaluationDate;
    }

    public Integer getIdGradeRecord() {
        return idGradeRecord;
    }
    public void setIdGradeRecord(Integer idGradeRecord) {
        this.idGradeRecord = idGradeRecord;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public Date getEvaluationDate() {
        return evaluationDate;
    }
    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
