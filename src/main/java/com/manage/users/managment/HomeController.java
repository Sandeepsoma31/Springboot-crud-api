package com.manage.users.managment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("")
	public String displayHomePage() {
		
		return "index";
	}

}
