package edu.ijse.layered.fx.dao.custom.impl;

import edu.ijse.layered.fx.dao.CrudUtil;
import edu.ijse.layered.fx.dao.custom.AttendanceReportDao;
import edu.ijse.layered.fx.entity.AttendanceEntity;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AttendanceReportDaoImpl implements AttendanceReportDao {

    @Override
    public boolean save(AttendanceEntity attendanceEntity) throws Exception {
        return false;
    }

    @Override
    public boolean update(AttendanceEntity attendanceEntity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public AttendanceEntity select(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<AttendanceEntity> viewAll() throws Exception {
        return null;
    }

}
