package com.example.ApiClassRomm.Service;
import com.example.ApiClassRomm.models.Subject;
import com.example.ApiClassRomm.repository.ISubjectRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Subjectservice {

    @Autowired
    ISubjectRepositorie Repositorie;

    public Subject saveSubjects( Subject dataSubjets) throws Exception{
        try {
            return this.Repositorie.save(dataSubjets);
        } catch ( Exception error){

            throw new Exception(error.getMessage());
        }

        }
    }


