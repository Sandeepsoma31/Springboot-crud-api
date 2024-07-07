package com.manage.users.managment.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> getAllUsers(){
		
		return (List<User>) repo.findAll();
	}

}
