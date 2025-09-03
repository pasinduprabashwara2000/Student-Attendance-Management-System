package edu.ijse.layered.fx.controller;

import edu.ijse.layered.fx.dto.ClassDto;
import edu.ijse.layered.fx.services.ServiceFactory;
import edu.ijse.layered.fx.services.custom.ClassService;

import java.util.ArrayList;

public class ClassController {

    private ClassService classesService = (ClassService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.CLASSES);

    public String addClasses(ClassDto classDto) throws Exception{
        return classesService.addClasses(classDto);
    }

    public String updateClasses(ClassDto classDto) throws Exception{
        return classesService.updateClasses(classDto);
    }

    public String deleteClasses(String id) throws Exception{
        return classesService.deleteClasses(id);
    }

    public ClassDto searchClasses(String id) throws Exception{
        return classesService.searchClasses(id);
    }

    public ArrayList <ClassDto> getAllClasses() throws Exception{
        return classesService.getAllClasses();
    }
}
