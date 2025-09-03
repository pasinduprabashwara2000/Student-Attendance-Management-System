package edu.ijse.layered.fx.services.custom;

import edu.ijse.layered.fx.dto.LecturerDto;
import edu.ijse.layered.fx.services.SuperService;

import java.util.ArrayList;

public interface LectureService extends SuperService {

    public String addLecture(LecturerDto lecturerDto) throws Exception;
    public String updateLecture(LecturerDto lecturerDto) throws Exception;
    public String deleteLecture(String id) throws Exception;
    public LecturerDto searchLecture(String id) throws Exception;
    public ArrayList <LecturerDto> getAllLectures () throws Exception;
}
