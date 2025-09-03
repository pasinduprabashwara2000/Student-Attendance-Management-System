package edu.ijse.layered.fx.services.custom;

import edu.ijse.layered.fx.dto.StudentDto;
import edu.ijse.layered.fx.services.SuperService;

import java.util.ArrayList;

public interface StudentService extends SuperService {

    public String addStudent(StudentDto studentDto) throws Exception;
    public String updateStudent(StudentDto studentDto) throws Exception;
    public String deleteStudent(String id) throws Exception;
    public StudentDto searchStudent(String id) throws Exception;
    public ArrayList <StudentDto> getAllStudents () throws Exception;

}
