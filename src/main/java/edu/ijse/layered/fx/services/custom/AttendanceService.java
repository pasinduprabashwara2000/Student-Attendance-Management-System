package edu.ijse.layered.fx.services.custom;

import edu.ijse.layered.fx.dto.AttendanceDto;
import net.sf.jasperreports.engine.export.ExcelAbstractExporter;

import java.util.ArrayList;

public interface AttendanceService {

    public String saveAttendance(AttendanceDto attendanceDto) throws Exception;
    public String updateAttendance(AttendanceDto attendanceDto) throws Exception;
    public String deleteAttendance(String date) throws Exception;
    public AttendanceDto searchAttendance(String date) throws Exception;
    public ArrayList<AttendanceDto> getAllAttendance() throws Exception;

}
