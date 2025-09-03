package edu.ijse.layered.fx.services.custom.impl;

import edu.ijse.layered.fx.dao.DaoFactory;
import edu.ijse.layered.fx.dao.custom.SubjectDao;
import edu.ijse.layered.fx.dto.SubjectDto;
import edu.ijse.layered.fx.entity.SubjectEntity;
import edu.ijse.layered.fx.services.custom.SubjectService;

import java.util.ArrayList;

public class SubjectServiceImpl implements SubjectService {

    private SubjectDao subjectDao = (SubjectDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.SUBJECT);

    @Override
    public String addSubject(SubjectDto subjectDto) throws Exception {

        SubjectEntity subjectEntity = new SubjectEntity(
                subjectDto.subjectId,
                subjectDto.name,
                subjectDto.courseId);

        return subjectDao.save(subjectEntity) ? "Subject Added Successfully" : "Subject Added Failed";
    }

    @Override
    public String updateSubject(SubjectDto subjectDto) throws Exception {

        SubjectEntity subjectEntity = new SubjectEntity(
                subjectDto.subjectId,
                subjectDto.name,
                subjectDto.courseId);

        return subjectDao.update(subjectEntity) ? "Subject Updated Successfully" : "Subject Update Failed";
    }

    @Override
    public String deleteSubject(String id) throws Exception {
        return subjectDao.delete(id) ? "Subject Delete Successfully" :"Subject Deleted Failed";
    }

    @Override
    public SubjectDto searchSubject(String id) throws Exception {

        SubjectEntity subjectEntity = subjectDao.select(id);

        if(subjectEntity != null){
            return new SubjectDto(
                    subjectEntity.getSubjectId(),
                    subjectEntity.getName(),
                    subjectEntity.getCourseId()
            );
        }

        return null;
    }

    @Override
    public ArrayList<SubjectDto> getAllSubject() throws Exception {

        ArrayList <SubjectDto> subjectDtos = new ArrayList<>();
        ArrayList <SubjectEntity> subjectEntities = subjectDao.viewAll();

        for (SubjectEntity subjectEntity : subjectEntities){
            subjectDtos.add(new SubjectDto(
               subjectEntity.getSubjectId(),
               subjectEntity.getName(),
               subjectEntity.getCourseId()
            ));
        }

        return subjectDtos;
    }
}
