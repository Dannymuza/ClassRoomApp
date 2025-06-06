package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.Enrollment;
import com.example.ApiClassRomm.repository.IEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    IEnrollmentRepository Repository;

    public Enrollment saveEnrollment(Enrollment dataEnrollment) throws Exception {
        try {
            return this.Repository.save(dataEnrollment);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Enrollment modifyEnrollment(Integer id, Enrollment dataEnrollment) throws Exception {
        try {
            Optional<Enrollment> enrollmentSearch = this.Repository.findById(id);
            if (enrollmentSearch.isPresent()) {
                Enrollment existingEnrollment = enrollmentSearch.get();
                // Actualizar campos de la matrícula
                existingEnrollment.setEnrollmentDate(dataEnrollment.getEnrollmentDate());
                return this.Repository.save(existingEnrollment);
            } else {
                throw new Exception("MATRÍCULA NO ENCONTRADA");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Enrollment searchEnrollmentById(Integer id) throws Exception {
        try {
            Optional<Enrollment> enrollmentSearch = this.Repository.findById(id);
            if (enrollmentSearch.isPresent()) {
                return enrollmentSearch.get();
            } else {
                throw new Exception("Matrícula no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Iterable<Enrollment> searchAllEnrollments() throws Exception {
        try {
            return this.Repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public String deleteEnrollment(Integer id) throws Exception {
        try {
            Optional<Enrollment> enrollmentSearch = this.Repository.findById(id);
            if (enrollmentSearch.isPresent()) {
                this.Repository.deleteById(id);
                return "MATRÍCULA ELIMINADA EXITOSAMENTE";
            } else {
                throw new Exception("Matrícula no encontrada para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
