package edu.ijse.layered.fx.controller;

import edu.ijse.layered.fx.dto.EnrollDto;
import edu.ijse.layered.fx.services.ServiceFactory;
import edu.ijse.layered.fx.services.custom.EnrollService;

import java.util.ArrayList;

public class EnrollController {

    private EnrollService enrollservice = (EnrollService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.ENROLL);

    public String addEnroll(EnrollDto enrollDto) throws Exception{
        return enrollservice.addEnroll(enrollDto);
    }

    public String updateEnroll(EnrollDto enrollDto) throws Exception{
        return enrollservice.updateEnroll(enrollDto);
    }

    public String deleteEnroll(String id) throws Exception{
        return enrollservice.deleteEnroll(id);
    }

    public EnrollDto searchEnroll(String id) throws Exception{
        return enrollservice.selectEnroll(id);
    }

    public ArrayList <EnrollDto> getAllEnroll() throws Exception{
        return enrollservice.getAllEnroll();
    }

}
