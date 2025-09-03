package edu.ijse.layered.fx.dao.custom.impl;

import edu.ijse.layered.fx.dao.CrudUtil;
import edu.ijse.layered.fx.dao.custom.LecturerDao;
import edu.ijse.layered.fx.entity.LecturerEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class LecturerDaoImpl implements LecturerDao {

    @Override
    public boolean save(LecturerEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO lecture VALUES(?,?,?)",
                t.getLectureId(),
                t.getName(),
                t.getContactDetails());
    }

    @Override
    public boolean update(LecturerEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE lecture SET name = ?, contact_details = ? WHERE lecture_id = ?",
                t.getName(),
                t.getContactDetails(),
                t.getLectureId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM lecture WHERE lecture_id = ?",id);
    }

    @Override
    public LecturerEntity select(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM lecture");

        if(rst.next()){
            return new LecturerEntity(
              rst.getString("Lecture_id"),
              rst.getString("name"),
              rst.getString("contact_details")
            );

        }
        return null;
    }

    @Override
    public ArrayList<LecturerEntity> viewAll() throws Exception {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM lecture");
        ArrayList <LecturerEntity> lecturerEntities = new ArrayList<>();

        while (rst.next()){
            lecturerEntities.add(new LecturerEntity(
               rst.getString("lecture_id"),
               rst.getString("name"),
               rst.getString("contact_details")
            ));
        }

        return lecturerEntities;
    }
}
