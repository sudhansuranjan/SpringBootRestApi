package com.rs.demo.model.service;

import java.util.List;

import com.rs.demo.model.User;

public interface UserService {
	
	public List<User> findAllUsers();
	
	public User findByid(int id);

}
