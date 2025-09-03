package edu.ijse.layered.fx.dao.custom;

import edu.ijse.layered.fx.entity.UserEntity;
import java.util.Optional;

public interface UserDao {

    UserEntity findByUsernameAndPassword(String username, String password) throws Exception;

}

