package edu.ijse.layered.fx.services.custom.impl;

import edu.ijse.layered.fx.dao.DaoFactory;
import edu.ijse.layered.fx.dao.custom.LecturerDao;
import edu.ijse.layered.fx.dto.LecturerDto;
import edu.ijse.layered.fx.entity.LecturerEntity;
import edu.ijse.layered.fx.services.custom.LectureService;

import java.util.ArrayList;

public class LecturerServiceImpl implements LectureService {

    private LecturerDao lecturerDao = (LecturerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.LECTURE);

    @Override
    public String addLecture(LecturerDto lecturerDto) throws Exception {
        LecturerEntity lecturerEntity = new LecturerEntity(
                lecturerDto.lectureId,
                lecturerDto.name,
                lecturerDto.contactDetails);

        return lecturerDao.save(lecturerEntity) ? "Lecture Inserted Successfully" : "Lecture Inserted Failed";
    }

    @Override
    public String updateLecture(LecturerDto lecturerDto) throws Exception {
        LecturerEntity lectureEntity = new LecturerEntity(
                lecturerDto.lectureId,
                lecturerDto.name,
                lecturerDto.contactDetails);

        return lecturerDao.update(lectureEntity) ? "Lecture Updated Successfully":"Lecture Updated Failed";
    }

    @Override
    public String deleteLecture(String id) throws Exception{
        return lecturerDao.delete(id) ? "Lecture Deleted Successfully" : "Lecture Deleted Failed";
    }

    @Override
    public LecturerDto searchLecture(String id) throws Exception {

        LecturerEntity lecturerEntity = lecturerDao.select(id);
        if(lecturerEntity != null){
            return new LecturerDto(
                lecturerEntity.getLectureId(),
                lecturerEntity.getName(),
                lecturerEntity.getContactDetails()
            );
        }

        return null;
    }

    @Override
    public ArrayList<LecturerDto> getAllLectures() throws Exception {

        ArrayList <LecturerDto> lecturerDtos = new ArrayList<>();
        ArrayList <LecturerEntity> lecturerEntities = lecturerDao.viewAll();

        for (LecturerEntity lecturerEntity : lecturerEntities){
            lecturerDtos.add(new LecturerDto(
               lecturerEntity.getLectureId(),
               lecturerEntity.getName(),
               lecturerEntity.getContactDetails()
            ));
        }

        return lecturerDtos;
    }
}
