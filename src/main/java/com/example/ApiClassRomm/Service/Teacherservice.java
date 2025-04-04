package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.Teacher;
import com.example.ApiClassRomm.repository.IteacherRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Teacherservice {
    @Autowired //inyeccion de dependencias
    IteacherRepositorie repositorie;
    //en el servicio Implementamos  los metodos  que necesitemos para ofrecer
    //GUARDAR

        public Teacher saveTeacher(Teacher dataTeacher)throws Exception {
            try {
                return this.repositorie.save(dataTeacher);
            } catch (Exception error) {
                throw new Exception(error.getMessage());
            }
        }
            //MODIFICAR
             public Teacher modifyTeacher (Integer user_id, Teacher dataTeacher ) throws Exception {

                try {
                    Optional<Teacher> searchTeacher = this.repositorie.findById(user_id);

                    if ( searchTeacher.isPresent()){
                        searchTeacher.get().setSpecialty (dataTeacher.getSpecialty());
                        return this.repositorie.save(searchTeacher.get());

                    }
                        else{
                            throw new Exception("no encontro el usuario por id");
                        }
                } catch (Exception error){
                    throw new Exception(error.getMessage());}

            }
        //BUSCAR POR ID
        //BUSCAR TODOS
        //ELIMINAR
    }

