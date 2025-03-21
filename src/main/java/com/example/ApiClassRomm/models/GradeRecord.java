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
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Double score;

    @Column(nullable = false, precision = 5, scale = 2)
    private Date evaluationDate;


    public GradeRecord()
    {}

    public GradeRecord(Integer idGradeRecord, Double score, Date evaluationDate) {
        this.idGradeRecord = idGradeRecord;
        this.score = score;
        this.evaluationDate = evaluationDate;
    }

    public Integer getIdGradeRecord() { return idGradeRecord; }
    public void setIdGradeRecord(Integer idGradeRecord) { this.idGradeRecord = idGradeRecord; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public Date getEvaluationDate() { return evaluationDate; }
    public void setEvaluationDate(Date evaluationDate) { this.evaluationDate = evaluationDate; }
}

