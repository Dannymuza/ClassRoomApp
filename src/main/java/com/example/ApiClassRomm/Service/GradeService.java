package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.Grade;
import com.example.ApiClassRomm.repository.IGradeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    IGradeRecordRepository Repository;

    public Grade saveGradeRecords(Grade dataGraderecordservice) throws Exception {
        try {
            return this.Repository.save(dataGraderecordservice);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Grade modifyGradeRecords(Integer id, Grade dataGradeRecord) throws Exception {
        try {
            Optional<Grade> gradeRecordSearch = this.Repository.findById(id);
            if (gradeRecordSearch.isPresent()) {
                Grade existingRecord = gradeRecordSearch.get();
                // Actualizar campos del registro de notas
                existingRecord.setScore(dataGradeRecord.getScore());
                existingRecord.setEvaluationDate(dataGradeRecord.getEvaluationDate());
                // Actualizar relaciones si es necesario
                return this.Repository.save(existingRecord);
            } else {
                throw new Exception("REGISTRO DE NOTAS NO ENCONTRADO");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Grade searchGradeRecordsById(Integer id) throws Exception {
        try {
            Optional<Grade> gradeRecordSearch = this.Repository.findById(id);
            if (gradeRecordSearch.isPresent()) {
                return gradeRecordSearch.get();
            } else {
                throw new Exception("Registro de notas no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Iterable<Grade> searchAllGradeRecords() throws Exception {
        try {
            return this.Repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public String deleteGradeRecords(Integer id) throws Exception {
        try {
            Optional<Grade> gradeRecordSearch = this.Repository.findById(id);
            if (gradeRecordSearch.isPresent()) {
                this.Repository.deleteById(id);
                return "REGISTRO DE NOTAS ELIMINADO EXITOSAMENTE";
            } else {
                throw new Exception("Registro de notas no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}