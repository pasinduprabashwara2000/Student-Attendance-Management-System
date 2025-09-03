package edu.ijse.layered.fx.controller;

import edu.ijse.layered.fx.dto.LecturerDto;
import edu.ijse.layered.fx.services.ServiceFactory;
import edu.ijse.layered.fx.services.custom.LectureService;

import java.util.ArrayList;

public class LectureController {

    private LectureService lectureService = (LectureService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.LECTURE);

        public String addLecture(LecturerDto lecturerDto) throws Exception {
            return lectureService.addLecture(lecturerDto);
        }

        public String updateLecture(LecturerDto lecturerDto) throws Exception {
            return lectureService.updateLecture(lecturerDto);
        }

        public String deleteLecture(String id) throws Exception{
            return lectureService.deleteLecture(id);
        }

        public LecturerDto searchLecture(String id) throws Exception{
            return lectureService.searchLecture(id);
        }

        public ArrayList <LecturerDto> getAllLectures() throws Exception{
            return lectureService.getAllLectures();
        }
}

