package DAO;

import Model.UserModel;

import java.util.List;

public interface Database {
    List <UserModel> getAllUsers();
    boolean addUser(String ...properties);
}
