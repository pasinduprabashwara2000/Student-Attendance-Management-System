package edu.ijse.layered.fx.dao.custom.impl;

import edu.ijse.layered.fx.dao.CrudUtil;
import edu.ijse.layered.fx.dao.custom.AttendanceDao;
import edu.ijse.layered.fx.entity.AttendanceEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AttendanceDaoImpl implements AttendanceDao {

    @Override
    public boolean save(AttendanceEntity t) throws Exception {
        return CrudUtil.executeUpdate(
                "INSERT INTO attendance(attendance_id, date, lecture_id, student_name, course_name, subject_name, status) VALUES (?,?,?,?,?,?,?)",
                t.getAttendance_id(),
                t.getDate(),
                t.getLecture_id(),
                t.getStudent_name(),
                t.getCourse_name(),
                t.getSubject_name(),
                t.getStatus()
        );
    }

    @Override
    public boolean update(AttendanceEntity t) throws Exception {
        return CrudUtil.executeUpdate(
                "UPDATE attendance SET lecture_id = ?, student_name = ?, course_name = ?, subject_name = ?, status = ? WHERE attendance_id = ?",
                t.getLecture_id(),
                t.getStudent_name(),
                t.getCourse_name(),
                t.getSubject_name(),
                t.getStatus(),
                t.getAttendance_id()
        );
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate(
                "DELETE FROM attendance WHERE date = ?",
                s
        );
    }

    @Override
    public AttendanceEntity select(String s) throws Exception {
        ResultSet rst = CrudUtil.executeQuery(
                "SELECT * FROM attendance WHERE date = ?",
                s
        );

        if (rst.next()) {
            return new AttendanceEntity(
                    rst.getInt("attendance_id"),
                    rst.getDate("date").toLocalDate(),
                    rst.getString("lecture_id"),
                    rst.getString("student_name"),
                    rst.getString("course_name"),
                    rst.getString("subject_name"),
                    rst.getString("status")
            );
        }
        return null;
    }

    @Override
    public ArrayList<AttendanceEntity> viewAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM attendance");
        ArrayList<AttendanceEntity> attendanceEntities = new ArrayList<>();

        while (rst.next()) {
            attendanceEntities.add(new AttendanceEntity(
                    rst.getInt("attendance_id"),
                    rst.getDate("date").toLocalDate(),
                    rst.getString("lecture_id"),
                    rst.getString("student_name"),
                    rst.getString("course_name"),
                    rst.getString("subject_name"),
                    rst.getString("status")
            ));
        }

        return attendanceEntities;
    }
}
