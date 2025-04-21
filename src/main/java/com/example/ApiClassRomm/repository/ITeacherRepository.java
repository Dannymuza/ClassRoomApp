
package com.example.ApiClassRomm.repository;

import com.example.ApiClassRomm.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository <Teacher,Integer>{


}
