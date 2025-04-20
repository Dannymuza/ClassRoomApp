package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.GradeRecord;
import com.example.ApiClassRomm.repository.IGradeRecordRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class Graderecordservice {

    @Autowired
    IGradeRecordRepositorie Repositorie;

    public GradeRecord saveGradeRecords(GradeRecord dataGraderecordservice) throws Exception {
        try {
            return this.Repositorie.save(dataGraderecordservice);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public GradeRecord modifyGradeRecords(Integer id, GradeRecord dataGradeRecord) throws Exception {
        try {
            Optional<GradeRecord> gradeRecordSearch = this.Repositorie.findById(id);
            if (gradeRecordSearch.isPresent()) {
                GradeRecord existingRecord = gradeRecordSearch.get();
                // Actualizar campos del registro de notas
                existingRecord.setScore(dataGradeRecord.getScore());
                existingRecord.setEvaluationDate(dataGradeRecord.getEvaluationDate());
                // Actualizar relaciones si es necesario
                return this.Repositorie.save(existingRecord);
            } else {
                throw new Exception("REGISTRO DE NOTAS NO ENCONTRADO");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public GradeRecord searchGradeRecordsById(Integer id) throws Exception {
        try {
            Optional<GradeRecord> gradeRecordSearch = this.Repositorie.findById(id);
            if (gradeRecordSearch.isPresent()) {
                return gradeRecordSearch.get();
            } else {
                throw new Exception("Registro de notas no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Iterable<GradeRecord> searchAllGradeRecords() throws Exception {
        try {
            return this.Repositorie.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public String deleteGradeRecords(Integer id) throws Exception {
        try {
            Optional<GradeRecord> gradeRecordSearch = this.Repositorie.findById(id);
            if (gradeRecordSearch.isPresent()) {
                this.Repositorie.deleteById(id);
                return "REGISTRO DE NOTAS ELIMINADO EXITOSAMENTE";
            } else {
                throw new Exception("Registro de notas no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}