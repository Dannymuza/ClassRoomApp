package com.example.ApiClassRomm.repository;

import com.example.ApiClassRomm.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepositorie extends JpaRepository<Subject,Integer> {
}
