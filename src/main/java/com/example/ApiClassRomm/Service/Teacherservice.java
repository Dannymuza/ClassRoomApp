package com.example.ApiClassRomm.Service;
import com.example.ApiClassRomm.models.Teacher;
import com.example.ApiClassRomm.repository.ITeacherRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Teacherservice {
    @Autowired
    ITeacherRepositorie Repositorie;
    public Teacher saveTeacher ( Teacher dataTeacher) throws Exception{
        try {
            return this.Repositorie.save(dataTeacher);
        } catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }
}
