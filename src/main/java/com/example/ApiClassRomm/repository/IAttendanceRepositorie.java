package com.example.ApiClassRomm.repository;

import com.example.ApiClassRomm.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAttendanceRepositorie extends JpaRepository<Attendance,Integer > {
}
