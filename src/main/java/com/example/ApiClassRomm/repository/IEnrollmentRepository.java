package com.example.ApiClassRomm.repository;

import com.example.ApiClassRomm.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrollmentRepository extends JpaRepository<Enrollment,Integer> {
}
