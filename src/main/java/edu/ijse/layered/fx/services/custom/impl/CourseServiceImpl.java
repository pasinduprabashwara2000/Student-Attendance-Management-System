package edu.ijse.layered.fx.services.custom.impl;

import edu.ijse.layered.fx.dao.DaoFactory;
import edu.ijse.layered.fx.dao.custom.CourseDao;
import edu.ijse.layered.fx.dto.CourseDto;
import edu.ijse.layered.fx.dto.LecturerDto;
import edu.ijse.layered.fx.entity.ClassEntity;
import edu.ijse.layered.fx.entity.CourseEntity;
import edu.ijse.layered.fx.entity.LecturerEntity;
import edu.ijse.layered.fx.services.custom.CourseService;

import java.util.ArrayList;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao = (CourseDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.COURSE);

    @Override
    public String addCourse(CourseDto courseDto) throws Exception {

        CourseEntity courseEntity = new CourseEntity(
               courseDto.courseId,
               courseDto.name);

        return courseDao.save(courseEntity) ? "Course Added Successfully" : "Course Added Failed";
    }

    @Override
    public String updateCourse(CourseDto courseDto) throws Exception {

        CourseEntity courseEntity = new CourseEntity(
                courseDto.courseId,
                courseDto.name
        );

        return courseDao.update(courseEntity) ? "Course Updated Successfully" : "Course Updated Failed";
    }

    @Override
    public String deleteCourse(String id) throws Exception {
        return courseDao.delete(id) ? "Course Deleted Successfully" : "Course Deleted Failed";
    }

    @Override
    public CourseDto searchCourse(String id) throws Exception {

        CourseEntity courseEntity = courseDao.select(id);

        if(courseEntity != null){
            return new CourseDto(
                    courseEntity.getCourseId(),
                    courseEntity.getName()
            );
        }

        return null;
    }

    @Override
    public ArrayList<CourseDto> getAllCourses() throws Exception {

        ArrayList <CourseDto> courseDtos = new ArrayList<>();
        ArrayList <CourseEntity> courseEntities = courseDao.viewAll();

        for (CourseEntity courseEntity : courseEntities){
            courseDtos.add(new CourseDto(
               courseEntity.getCourseId(),
               courseEntity.getName()
            ));
        }

        return courseDtos;
    }


}
