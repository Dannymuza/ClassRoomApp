package com.example.ApiClassRomm.repository;

import com.example.ApiClassRomm.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeRecordRepository extends JpaRepository<Grade,Integer> {
}
