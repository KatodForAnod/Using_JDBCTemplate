package DAO;

import Model.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet resultSet, int i) throws SQLException {
        UserModel userModel = new UserModel();

        userModel.setID(resultSet.getInt("ID"));
        userModel.setName(resultSet.getString("name"));

        return userModel;
    }
}
