package edu.ijse.layered.fx.services.custom;

import edu.ijse.layered.fx.dto.SubjectDto;
import edu.ijse.layered.fx.services.SuperService;

import java.util.ArrayList;

public interface SubjectService extends SuperService {

    public String addSubject(SubjectDto subjectDto) throws Exception;
    public String updateSubject(SubjectDto subjectDto) throws Exception;
    public String deleteSubject(String id) throws Exception;
    public SubjectDto searchSubject(String id) throws Exception;
    public ArrayList <SubjectDto> getAllSubject() throws Exception;
}
