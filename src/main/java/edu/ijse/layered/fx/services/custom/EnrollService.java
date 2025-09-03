package edu.ijse.layered.fx.services.custom;

import edu.ijse.layered.fx.dto.EnrollDto;
import edu.ijse.layered.fx.services.SuperService;

import java.util.ArrayList;

public interface EnrollService extends SuperService {

    public String addEnroll(EnrollDto enrollDto) throws Exception;
    public String updateEnroll(EnrollDto enrollDto) throws Exception;
    public String deleteEnroll(String id) throws Exception;
    public EnrollDto selectEnroll(String id) throws Exception;
    public ArrayList <EnrollDto> getAllEnroll() throws Exception;

}
