package com.example.ApiClassRomm.repository;

import com.example.ApiClassRomm.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepositorie extends JpaRepository <Course,Integer> {
}
