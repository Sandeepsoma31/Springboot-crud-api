package com.manage.users.managment.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserServices services;
	
	
	@GetMapping("/users")
	public String displayUsers(Model model)
	{
		List<User> allUsers = services.getAllUsers();
		model.addAttribute("listOfUsers", allUsers);   //adding to model to use in html file
		
		return "users";
	}

}
