package edu.ijse.layered.fx.services.custom;

import edu.ijse.layered.fx.dto.UserDto;
import edu.ijse.layered.fx.entity.UserEntity;

public interface UserService {

    boolean login(UserDto userDto) throws Exception;

}
