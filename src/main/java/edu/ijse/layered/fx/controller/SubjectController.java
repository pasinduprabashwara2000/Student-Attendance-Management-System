package edu.ijse.layered.fx.controller;

import edu.ijse.layered.fx.dto.SubjectDto;
import edu.ijse.layered.fx.services.ServiceFactory;
import edu.ijse.layered.fx.services.custom.SubjectService;

import java.util.ArrayList;

public class SubjectController {

    private SubjectService subjectService = (SubjectService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.SUBJECT);

    public String addSubject(SubjectDto subjectDto) throws Exception{
        return subjectService.addSubject(subjectDto);
    }

    public String updateSubject(SubjectDto subjectDto) throws Exception{
        return subjectService.updateSubject(subjectDto);
    }

    public String deleteSubject(String id) throws Exception{
        return subjectService.deleteSubject(id);
    }

    public SubjectDto searchSubject(String id) throws Exception{
        return subjectService.searchSubject(id);
    }

    public ArrayList <SubjectDto> getAllSubject () throws Exception{
        return subjectService.getAllSubject();
    }

}
