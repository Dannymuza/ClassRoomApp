package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.Student;
import com.example.ApiClassRomm.repository.IStudentRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
    public class Studentservice {

    @Autowired // inyección de dependencias
    IStudentRepositorie Repositorie;

    // guardar
    public Student saveStudent(Student dataStudent)throws Exception {
        try {
            return this.Repositorie.save(dataStudent);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

            // modificar
    public Student modifyStudent(Integer id, Student dataStudent) throws Exception {
        try {
            Optional<Student> studentSearch = this.Repositorie.findById(id);

            if (studentSearch.isPresent()) {
                studentSearch.get().setGrade(dataStudent.getGrade()); // modificando un campo viejo
                return this.Repositorie.save(studentSearch.get());
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
            Optional<Student> studentSearch = this.Repositorie.findById(id);
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
            return this.Repositorie.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar
    public String deleteStudent(Integer id) throws Exception {
        try {
            Optional<Student> studentSearch = this.Repositorie.findById(id);
            if (studentSearch.isPresent()) {
                this.Repositorie.deleteById(id);
                return "Estudiante eliminado correctamente";
            } else {
                throw new Exception("estudiante no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}