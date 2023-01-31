package com.rs.demo.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rs.demo.model.User;

@Repository
public class UserServiceImpl implements UserService {
	
	
	public List<User> findAllUsers(){
		
		 List<User>userlist=new ArrayList<User>();
		 userlist.add(new User(1,"Sudhansu",28,450000)); 
		 userlist.add(new User(2,"Umesh",28,250000)); 
		 userlist.add(new User(3,"Sudhansu",26,450000)); 
		
		return userlist;
		
		
		
	}
	
	public User findByid(int id) {
		
		
		
		return null;
		
		
		
	}

}
