package edu.ijse.layered.fx.controller;

import edu.ijse.layered.fx.dto.LecturerDto;
import edu.ijse.layered.fx.dto.StudentDto;
import edu.ijse.layered.fx.services.ServiceFactory;
import edu.ijse.layered.fx.services.custom.StudentService;

import java.util.ArrayList;

public class StudentsController {

    private StudentService studentService = (StudentService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.STUDENT);

    public String addStudent(StudentDto studentDto) throws Exception{
        return studentService.addStudent(studentDto);
    }

    public String updateStudents(StudentDto studentDto) throws Exception{
        return studentService.updateStudent(studentDto);
    }

    public String deleteStudent(String id) throws Exception{
        return studentService.deleteStudent(id);
    }

    public StudentDto searchStudent(String id) throws Exception{
        return studentService.searchStudent(id);
    }

    public ArrayList <StudentDto> getAllStudent() throws Exception{
        return studentService.getAllStudents();
    }
}
