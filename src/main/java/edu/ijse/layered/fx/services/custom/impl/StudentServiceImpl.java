package edu.ijse.layered.fx.services.custom.impl;

import edu.ijse.layered.fx.dao.DaoFactory;
import edu.ijse.layered.fx.dao.custom.StudentDao;
import edu.ijse.layered.fx.dto.StudentDto;
import edu.ijse.layered.fx.entity.StudentEntity;
import edu.ijse.layered.fx.services.custom.StudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = (StudentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STUDENT);

    @Override
    public String addStudent(StudentDto studentDto) throws Exception {
        StudentEntity studentEntity = new StudentEntity(
                studentDto.getRegNum(),
                studentDto.getName(),
                studentDto.getContactDetails());

        return studentDao.save(studentEntity) ? "Student Added Successfully" : "Student Added Failed";
    }

    @Override
    public String updateStudent(StudentDto studentDto) throws Exception {
        StudentEntity studentEntity = new StudentEntity(
                studentDto.getRegNum(),
                studentDto.getName(),
                studentDto.getContactDetails());

        return studentDao.update(studentEntity) ? "Student Updated Successfully" : "Student Updated Failed";
    }

    @Override
    public String deleteStudent(String id) throws Exception {
        return studentDao.delete(id) ? "Student Deleted Successfully" : "Student Deleted Failed";
    }

    @Override
    public StudentDto searchStudent(String id) throws Exception {
        StudentEntity studentEntity = studentDao.select(id);
        if(studentEntity != null){
            return new StudentDto(
                    studentEntity.getRegNum(),
                    studentEntity.getName(),
                    studentEntity.getContactDetails()
            );
        }

        return null;
    }

    @Override
    public ArrayList<StudentDto> getAllStudents() throws Exception {

        ArrayList <StudentDto> studentDtos = new ArrayList<>();
        ArrayList <StudentEntity> studentEntities = studentDao.viewAll();

        for (StudentEntity studentEntity : studentEntities){
            studentDtos.add(new StudentDto(
               studentEntity.getRegNum(),
               studentEntity.getName(),
               studentEntity.getContactDetails()
            ));
        }

        return studentDtos;
    }
}
