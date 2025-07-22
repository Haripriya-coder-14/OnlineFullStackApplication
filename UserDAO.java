package com.tap.DAO;

import java.util.List;

import com.tap.Model.User;

public interface UserDAO {

	List<User> getAllUsers();

	User getUser(int id);

	int addUser(User user);

	int updateUser(User user);

	int deleteUser(int id);

}
