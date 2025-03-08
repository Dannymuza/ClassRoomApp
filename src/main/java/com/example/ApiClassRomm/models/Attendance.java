package com.example.ApiClassRomm.models;

import com.example.ApiClassRomm.helpers.AttendanceStatus;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAttendance;
    private Date date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    public Attendance() {}

    public Attendance(Integer idAttendance, Date date, AttendanceStatus status) {
        this.idAttendance = idAttendance;
        this.date = date;
        this.status = status;
    }

    public Integer getIdAttendance() { return idAttendance; }
    public void setIdAttendance(Integer idAttendance) { this.idAttendance = idAttendance; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public AttendanceStatus getStatus() { return status; }
    public void setStatus(AttendanceStatus status) { this.status = status; }
}
