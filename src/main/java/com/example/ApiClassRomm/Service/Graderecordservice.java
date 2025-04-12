package com.example.ApiClassRomm.Service;
import  com.example.ApiClassRomm.models.GradeRecord;
import  com.example.ApiClassRomm.repository.IGradeRecordRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.Optional;

@Service

public class Graderecordservice {
    @Autowired
    IGradeRecordRepositorie Repositorie;
    public GradeRecord saveGradeRecords(GradeRecord dataGraderecordservice)throws  Exception {

        try {
            return this.Repositorie.save(dataGraderecordservice);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}