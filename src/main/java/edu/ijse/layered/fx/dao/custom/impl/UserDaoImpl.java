package edu.ijse.layered.fx.dao.custom.impl;

import edu.ijse.layered.fx.dao.CrudUtil;
import edu.ijse.layered.fx.dao.custom.UserDao;
import edu.ijse.layered.fx.entity.UserEntity;

import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) throws Exception {
        String sql = "SELECT * FROM user WHERE user_name=? AND password=?";
        ResultSet rs = CrudUtil.execute(sql, username, password);
        if (rs.next()) {
            return new UserEntity(
                    rs.getInt("id"),
                    rs.getString("user_name"),
                    rs.getString("password"),
                    rs.getString("role")
            );
        }
        return null;
    }
}
