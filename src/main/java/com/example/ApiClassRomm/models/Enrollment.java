package com.example.ApiClassRomm.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnrollment;
    private Date enrollmentDate;

    public Enrollment() {}

    public Enrollment(Integer idEnrollment, Date enrollmentDate) {
        this.idEnrollment = idEnrollment;
        this.enrollmentDate = enrollmentDate;
    }

    public Integer getIdEnrollment() { return idEnrollment; }
    public void setIdEnrollment(Integer idEnrollment) { this.idEnrollment = idEnrollment; }

    public Date getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(Date enrollmentDate) { this.enrollmentDate = enrollmentDate; }
}
