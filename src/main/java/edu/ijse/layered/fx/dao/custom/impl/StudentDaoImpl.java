package edu.ijse.layered.fx.dao.custom.impl;

import edu.ijse.layered.fx.dao.CrudUtil;
import edu.ijse.layered.fx.dao.custom.StudentDao;
import edu.ijse.layered.fx.entity.StudentEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {

    public boolean save(StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO student VALUES (?,?,?)",
                t.getRegNum(),
                t.getName(),
                t.getContactDetails());
    }

    public boolean update(StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE student SET name = ? , contact_details = ? WHERE reg_number = ?",
                t.getName(),
                t.getContactDetails(),
                t.getRegNum());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM student WHERE reg_number = ?",id);
    }

    @Override
    public StudentEntity select(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM student WHERE reg_number = ?",id);

        if(rst.next()){
            return new StudentEntity(
              rst.getInt("reg_number"),
              rst.getString("name"),
              rst.getString("contact_details")
            );
        }

        return null;

    }

    @Override
    public ArrayList<StudentEntity> viewAll() throws Exception {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM student");
        ArrayList <StudentEntity> studentEntities = new ArrayList<>();

        while (rst.next()) {
            studentEntities.add(new StudentEntity(
                    rst.getInt("reg_number"),
                    rst.getString("name"),
                    rst.getString("contact_details")
            ));
        }

        return studentEntities;
    }

}
