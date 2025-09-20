package iuh.fit.se.dao;

import iuh.fit.se.entity.User;

import java.util.ArrayList;

public interface UserDAO {
    public void addUser(User user);
    public ArrayList<User> getAllUsers();
}
