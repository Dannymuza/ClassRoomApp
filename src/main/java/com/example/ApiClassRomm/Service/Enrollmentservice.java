package com.example.ApiClassRomm.Service;
import com.example.ApiClassRomm.models.Enrollment;
import com.example.ApiClassRomm.repository.IEnrollmentRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class Enrollmentservice {
    @Autowired
    IEnrollmentRepositorie Repositorie;
    public Enrollment  saveEnrollment (Enrollment dataEnrollment)throws  Exception{
        try {
            return this.Repositorie.save(dataEnrollment);
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
