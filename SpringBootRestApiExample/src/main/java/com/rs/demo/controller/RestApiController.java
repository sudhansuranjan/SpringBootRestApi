package com.rs.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rs.demo.model.User;
import com.rs.demo.model.service.UserService;
import com.rs.demo.util.CustomErrorType;

@RestController
@RequestMapping("/")
public class RestApiController {
	
 public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
 
 @Autowired
 private UserService userservice;
 

 static {
	 List<User>userlist=new ArrayList<User>();
	 userlist.add(new User(1,"Sudhansu",28,450000)); 
	 userlist.add(new User(2,"Umesh",28,250000)); 
	 userlist.add(new User(3,"Sudhansu",26,450000)); 
 
 }
 
 @RequestMapping(value = "/user/",method = RequestMethod.GET)
 public ResponseEntity<List<User>>listAllUsers(){
	 
	 List<User>users=userservice.findAllUsers();
	 
	 if(users.isEmpty()) {
		
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 
	 return new ResponseEntity<List<User>>(users,HttpStatus.OK);
 }
 
 @RequestMapping(value="/user/{id}",method = RequestMethod.GET)
 public ResponseEntity<?>getUser(@PathVariable("id") int id){
	 
	 logger.info("Fetching User with id {}", id);
	 User users=userservice.findByid(id);
	 
	 if(users==null) {
		 logger.error("User with id {} not found.", id);
		 return new ResponseEntity(new CustomErrorType("User with id not found"+id),HttpStatus.NO_CONTENT);
	 }
	 
	 return new ResponseEntity<User>(users,HttpStatus.OK);
     }
 
 
 
 
	

}
