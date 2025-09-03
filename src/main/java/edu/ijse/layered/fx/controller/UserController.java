package edu.ijse.layered.fx.controller;

import edu.ijse.layered.fx.dto.UserDto;
import edu.ijse.layered.fx.services.custom.UserService;
import edu.ijse.layered.fx.services.custom.impl.UserServiceImpl;

public class UserController {

    private UserService userService = new UserServiceImpl();

    public boolean login(UserDto userDto) throws Exception{
        return userService.login(userDto);
    }

}
