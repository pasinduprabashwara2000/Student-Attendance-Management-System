package edu.ijse.layered.fx.services.custom.impl;

import edu.ijse.layered.fx.dao.custom.UserDao;
import edu.ijse.layered.fx.dao.custom.impl.UserDaoImpl;
import edu.ijse.layered.fx.dto.UserDto;
import edu.ijse.layered.fx.entity.UserEntity;
import edu.ijse.layered.fx.services.custom.UserService;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean login(UserDto userDto) throws Exception {
        UserEntity user = userDao.findByUsernameAndPassword(
                userDto.getUsername(),
                userDto.getPassword()
        );
        return user != null;
    }
}
