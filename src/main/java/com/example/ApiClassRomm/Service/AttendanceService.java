package com.example.ApiClassRomm.Service;

import com.example.ApiClassRomm.models.Attendance;
import com.example.ApiClassRomm.repository.IAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    IAttendanceRepository Repository;

    public Attendance saveAttendance(Attendance dataAttendance) throws Exception {
        try {
            return this.Repository.save(dataAttendance);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Attendance modifyAttendance(Integer id, Attendance dataAttendance) throws Exception {
        try {
            Optional<Attendance> attendanceSearch = this.Repository.findById(id);
            if (attendanceSearch.isPresent()) {
                Attendance existingAttendance = attendanceSearch.get();
                return this.Repository.save(existingAttendance);
            } else {
                throw new Exception("ASISTENCIA NO ENCONTRADA");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Attendance searchAttendanceById(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceSearch = this.Repository.findById(id);
            if (attendanceSearch.isPresent()) {
                return attendanceSearch.get();
            } else {
                throw new Exception("Asistencia no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Iterable<Attendance> searchAllAttendances() throws Exception {
        try {
            return this.Repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public String deleteAttendance(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceSearch = this.Repository.findById(id);
            if (attendanceSearch.isPresent()) {
                this.Repository.deleteById(id);
                return "ASISTENCIA ELIMINADA EXITOSAMENTE";
            } else {
                throw new Exception("Asistencia no encontrada para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
