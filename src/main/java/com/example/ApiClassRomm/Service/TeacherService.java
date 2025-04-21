package com.example.ApiClassRomm.Service;
import com.example.ApiClassRomm.models.Teacher;
import com.example.ApiClassRomm.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    ITeacherRepository Repository;

    public Teacher saveTeacher(Teacher dataTeacher) throws Exception {
        try {
            return this.Repository.save(dataTeacher);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    public Teacher modifyTeacher(Integer id, Teacher dataTeacher) throws Exception {
        try {
            Optional<Teacher> teacherSearch = this.Repository.findById(id);
            if (teacherSearch.isPresent()) {
                teacherSearch.get().setSpecialty(dataTeacher.getSpecialty());
                this.Repository.save(teacherSearch.get());
                return teacherSearch.get(); // Faltaba retornar el profesor modificado
            } else {
                throw new Exception("USUARIO NO ENCONTRADO");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Teacher searchTeacherById(Integer id) throws Exception {
        try {
            Optional<Teacher> teacherSearch = this.Repository.findById(id);
            if (teacherSearch.isPresent()) {
                return teacherSearch.get();
            } else {
                throw new Exception("Docente no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Iterable<Teacher> searchAllTeacher() throws Exception {
        try {
            return this.Repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public String deleteTeacher(Integer id) throws Exception {
        try {
            Optional<Teacher> teacherSearch = this.Repository.findById(id);
            if (teacherSearch.isPresent()) {
                this.Repository.deleteById(id);
                return "DOCENTE ELIMINADO EXITOSAMENTE";
            } else {
                throw new Exception("Docente no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}


