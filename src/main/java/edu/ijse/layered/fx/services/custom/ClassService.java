package edu.ijse.layered.fx.services.custom;

import edu.ijse.layered.fx.dto.ClassDto;
import edu.ijse.layered.fx.services.SuperService;

import java.util.ArrayList;

public interface ClassService extends SuperService {

    public String addClasses(ClassDto classesDto) throws Exception;
    public String updateClasses(ClassDto classesDto) throws Exception;
    public String deleteClasses(String id) throws Exception;
    public ClassDto searchClasses(String id) throws Exception;
    public ArrayList <ClassDto> getAllClasses () throws Exception;

}
