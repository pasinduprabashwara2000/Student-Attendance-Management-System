package edu.ijse.layered.fx.dao.custom.impl;

import edu.ijse.layered.fx.dao.CrudUtil;
import edu.ijse.layered.fx.dao.custom.SubjectDao;
import edu.ijse.layered.fx.entity.SubjectEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SubjectDaoImpl implements SubjectDao {

    @Override
    public boolean save(SubjectEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO subject VALUES (?,?,?)",
                t.getSubjectId(),
                t.getCourseId(),
                t.getName());
    }

    @Override
    public boolean update(SubjectEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE subject SET name = ?, course_id = ? WHERE subject_id = ?",
                t.getName(),
                t.getCourseId(),
                t.getSubjectId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM subject WHERE sub_id", id);
    }

    @Override
    public SubjectEntity select(String id) throws Exception {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM subject WHERE sub_id",id);
        if(rst.next()) {
            return new SubjectEntity(
                rst.getString("subject_id"),
                rst.getString("name"),
                rst.getString("course_id")
            );
        }

            return null;
    }

    @Override
    public ArrayList<SubjectEntity> viewAll() throws Exception {

       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM subject");
       ArrayList <SubjectEntity> subjectEntities = new ArrayList<>();

       while (rst.next()){
           subjectEntities.add(
                   new SubjectEntity(
                           rst.getString("subject_id"),
                           rst.getString("course_id"),
                           rst.getString("subject_name")
                   ));
       }

        return subjectEntities;
    }
}
