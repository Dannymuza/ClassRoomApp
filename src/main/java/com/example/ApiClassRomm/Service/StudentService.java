package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.Student;
import com.example.ApiClassRomm.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
    public class StudentService {

    @Autowired // inyección de dependencias
    IStudentRepository Repository;

    // guardar
    public Student saveStudent(Student dataStudent)throws Exception {
        try {
            return this.Repository.save(dataStudent);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

            // modificar
    public Student modifyStudent(Integer id, Student dataStudent) throws Exception {
        try {
            Optional<Student> studentSearch = this.Repository.findById(id);

            if (studentSearch.isPresent()) {
                studentSearch.get().setGrade(dataStudent.getGrade()); // modificando un campo viejo
                return this.Repository.save(studentSearch.get());
            } else {
                throw new Exception("estudiante no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // buscar por id
    public Student searchStudentById(Integer id) throws Exception {
        try {
            Optional<Student> studentSearch = this.Repository.findById(id);
            if (studentSearch.isPresent()) {
                return studentSearch.get();
            } else {
                throw new Exception("estudiante no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // buscar todos
    public Iterable<Student> searchAllStudents() throws Exception {
        try {
            return this.Repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar
    public String deleteStudent(Integer id) throws Exception {
        try {
            Optional<Student> studentSearch = this.Repository.findById(id);
            if (studentSearch.isPresent()) {
                this.Repository.deleteById(id);
                return "Estudiante eliminado correctamente";
            } else {
                throw new Exception("estudiante no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}