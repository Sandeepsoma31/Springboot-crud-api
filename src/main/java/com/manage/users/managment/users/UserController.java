package com.manage.users.managment.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/users/adduser")
	public String createNewUser(Model model)
	{
		model.addAttribute("newuser", new User()); //adding new user
		return "new_userform";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user, RedirectAttributes r)
	{
		services.save(user);
		r.addFlashAttribute("message", "The User has been saved sucessfully");
		return "redirect:/users";
	}
	
	@GetMapping("/users/update/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes r)
	{
		try {
			
			User user = services.get(id);
			model.addAttribute("newuser", user);
			return "new_userform";
		}catch(UserNotFoundException e)
		{
			r.addFlashAttribute("message", e.getMessage());
			return "redirect:/users";
		}
		
	}
	
	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model, RedirectAttributes r)
	{
		try {
			
			services.delete(id);
			r.addFlashAttribute("message", "User with Id "+id+" has been deleted sucessfully");
		}catch(UserNotFoundException e)
		{
			r.addFlashAttribute("message", e.getMessage());
		}
		
		return "redirect:/users";
		
	}

}
