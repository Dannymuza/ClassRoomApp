package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.Subject;
import com.example.ApiClassRomm.repository.ISubjectRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class Subjectservice {

    @Autowired
    ISubjectRepositorie Repository;

    public Subject saveSubjects(Subject dataSubjets) throws Exception {
        try {
            return this.Repository.save(dataSubjets);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Subject modifySubjects(Integer id, Subject dataSubjects) throws Exception {
        try {
            Optional<Subject> subjectSearch = this.Repository.findById(id);
            if (subjectSearch.isPresent()) {
                subjectSearch.get().setName(dataSubjects.getName());
                // Agrega aquí otros campos que necesites actualizar
                return this.Repository.save(subjectSearch.get());
            } else {
                throw new Exception("ASIGNATURA NO ENCONTRADA");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Subject searchSubjectsById(Integer id) throws Exception {
        try {
            Optional<Subject> subjectSearch = this.Repository.findById(id);
            if (subjectSearch.isPresent()) {
                return subjectSearch.get();
            } else {
                throw new Exception("Asignatura no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Iterable<Subject> searchAllSubjects() throws Exception {
        try {
            return this.Repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public String deleteSubjects(Integer id) throws Exception {
        try {
            Optional<Subject> subjectSearch = this.Repository.findById(id);
            if (subjectSearch.isPresent()) {
                this.Repository.deleteById(id);
                return "ASIGNATURA ELIMINADA EXITOSAMENTE";
            } else {
                throw new Exception("Asignatura no encontrada para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}