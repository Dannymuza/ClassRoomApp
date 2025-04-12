package com.example.ApiClassRomm.Service;
import com.example.ApiClassRomm.models.Attendance;
import com.example.ApiClassRomm.Service.Attendanceservice;
import com.example.ApiClassRomm.repository.IAttendanceRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class Attendanceservice {
    @Autowired
    IAttendanceRepositorie Repositorie;
    public Attendance saveAttendance (Attendance dataAttendance) throws Exception{
        try {
            return this.Repositorie.save(dataAttendance);
        } catch ( Exception error ){
            throw new Exception(error.getMessage());
        }


    }
}
