package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.Teacher;
import com.example.ApiClassRomm.repository.IteacherRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Teacherservice {
    @Autowired //inyeccion de dependencias
    IteacherRepositorie repositorie;
    //en el servicio Implementamos  los metodos  que necesitemos para ofrecer
    //GUARDAR

        public Teacher saveTeacher(Teacher dataTeacher)throws Exception{
            try{
                return this.repositorie.save(dataTeacher);
            }catch(Exception mistake){
                throw new Exception(mistake.getMessage());
}
        //MODIFICAR
        //BUSCAR POR ID
        //BUSCAR TODOS
        //ELIMINAR
    }
}
