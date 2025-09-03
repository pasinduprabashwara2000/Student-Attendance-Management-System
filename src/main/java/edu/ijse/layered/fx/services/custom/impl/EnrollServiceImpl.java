package edu.ijse.layered.fx.services.custom.impl;

import edu.ijse.layered.fx.dao.DaoFactory;
import edu.ijse.layered.fx.dao.custom.EnrollDao;
import edu.ijse.layered.fx.dto.EnrollDto;
import edu.ijse.layered.fx.entity.EnrollEntity;
import edu.ijse.layered.fx.services.custom.EnrollService;

import java.util.ArrayList;

public class EnrollServiceImpl implements EnrollService {

    private EnrollDao enrollDao = (EnrollDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ENROLL);

    @Override
    public String addEnroll(EnrollDto enrollDto) throws Exception {

        EnrollEntity enrollEntity = new EnrollEntity(
                enrollDto.regNum,
                enrollDto.courseId
        );

        return enrollDao.save(enrollEntity) ? "Enroll Added" : "Enroll Failed";
    }

    @Override
    public String updateEnroll(EnrollDto enrollDto) throws Exception {

        EnrollEntity enrollEntity = new EnrollEntity(
                enrollDto.regNum,
                enrollDto.courseId
        );

        return enrollDao.update(enrollEntity) ? "Enroll Updated Successfully" : "Enroll Updated Failed";
    }

    @Override
    public String deleteEnroll(String id) throws Exception {
        return enrollDao.delete(id) ? "Enroll Details Deleted" : "Enroll Details Deleted Failed";
    }

    @Override
    public EnrollDto selectEnroll(String id) throws Exception {

        EnrollEntity enrollEntity = enrollDao.select(id);

        if(enrollEntity != null){
            return new EnrollDto(
              enrollEntity.getRegNum(),
              enrollEntity.getCourseId()
            );
        }

        return null;
    }

    @Override
    public ArrayList<EnrollDto> getAllEnroll() throws Exception {

        ArrayList <EnrollDto> enrollDtos = new ArrayList<>();
        ArrayList <EnrollEntity> enrollEntities = enrollDao.viewAll();

        for (EnrollEntity enrollEntity : enrollEntities){
            enrollDtos.add(new EnrollDto(
                enrollEntity.getRegNum(),
                enrollEntity.getCourseId()
            ));
        }

        return enrollDtos;

    }
}
